package es.tudir.horario.ui.fragmentos;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import es.tudir.horario.R;
import es.tudir.horario.modelo.Meta;
import es.tudir.horario.tools.Constantes;
import es.tudir.horario.web.VolleySingleton;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


/**
 * Fragmento con formulario para actualizar la meta
 */
public class UpdateFragment extends Fragment {
    /*
    Etiqueta de depuración
     */
    private static final String TAG = UpdateFragment.class.getSimpleName();

    /*
    Controles
    */
    private EditText evento_input;
    private EditText descripcion_input;
    private TextView fecha_text;
    private Spinner modulo_spinner;

    /*
    Valor del argumento extra
     */
    private String id_evento;

    /**
     * Es la meta obtenida como respuesta de la petición HTTP
     */
    private Meta metaOriginal;

    /**
     * Instancia Gson para el parsing Json
     */
    private Gson gson = new Gson();


    public UpdateFragment() {
    }

    /**
     * Crea un nuevo fragmento basado en un argumento
     *
     * @param extra Argumento de entrada
     * @return Nuevo fragmento
     */
    public static Fragment createInstance(String extra) {
        UpdateFragment detailFragment = new UpdateFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Constantes.EXTRA_ID, extra);
        detailFragment.setArguments(bundle);
        return detailFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflando layout del fragmento
        View v = inflater.inflate(R.layout.fragment_form, container, false);

        // Obtención de instancias controles
        evento_input = (EditText) v.findViewById(R.id.evento_input);
        descripcion_input = (EditText) v.findViewById(R.id.descripcion_input);
        fecha_text = (TextView) v.findViewById(R.id.fecha_ejemplo_text);
        modulo_spinner = (Spinner) v.findViewById(R.id.modulo_spinner);

        fecha_text.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DialogFragment picker = new DatePickerFragment();
                        picker.show(getFragmentManager(), "datePicker");

                    }
                }
        );

        // Obtener valor extra
        id_evento = getArguments().getString(Constantes.EXTRA_ID);

        if (id_evento != null) {
            cargarDatos();
        }

        return v;
    }

    /**
     * Obtiene los datos desde el servidor
     */
    private void cargarDatos() {
        // Añadiendo idMeta como parámetro a la URL
        String newURL = Constantes.GET_BY_ID + "?id_evento=" + id_evento;

        // Consultar el detalle de la meta
        VolleySingleton.getInstance(getActivity()).addToRequestQueue(
                new JsonObjectRequest(
                        Request.Method.GET,
                        newURL,
                        null,
                        new Response.Listener<JSONObject>() {

                            @Override
                            public void onResponse(JSONObject response) {
                                // Procesa la respuesta GET_BY_ID
                                procesarRespuestaGet(response);
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Log.d(TAG, "Error Volley: " + error.getMessage());
                            }
                        }
                )
        );
    }

    /**
     * Procesa la respuesta de obtención obtenida desde el sevidor     *
     */
    private void procesarRespuestaGet(JSONObject response) {

        try {
            String estado = response.getString("estado");

            switch (estado) {
                case "1":
                    JSONObject examenes = response.getJSONObject("examenes");
                    // Guardar instancia
                    metaOriginal = gson.fromJson(examenes.toString(), Meta.class);
                    // Setear valores de la meta
                    cargarViews(metaOriginal);
                    break;

                case "2":
                    String mensaje = response.getString("mensaje");
                    // Mostrar mensaje
                    Toast.makeText(
                            getActivity(),
                            mensaje,
                            Toast.LENGTH_LONG).show();
                    // Enviar código de falla
                    getActivity().setResult(Activity.RESULT_CANCELED);
                    // Terminar actividad
                    getActivity().finish();
                    break;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * Carga los datos iniciales del formulario con los
     * atributos de un objeto {@link Meta}
     *
     * @param examenes Instancia
     */
    private void cargarViews(Meta examenes) {
        // Seteando valores de la respuesta
        evento_input.setText(examenes.getEvento());
        descripcion_input.setText(examenes.getDescripcion());
        fecha_text.setText(examenes.getFecha());


        // Obteniendo acceso a los array de strings para categorias y prioridades
        String[] modulos = getResources().getStringArray(R.array.entradas_categoria);

        // Obteniendo la posición del spinner categorias
        int posicion_modulo = 0;
        for (int i = 0; i < modulos.length; i++) {
            if (modulos[i].compareTo(examenes.getModulo()) == 0) {
                posicion_modulo = i;
                break;
            }
        }

        // Setear selección del Spinner de categorías
        modulo_spinner.setSelection(posicion_modulo);

    }

    /**
     * Compara los datos actuales con aquellos que se obtuvieron
     * por primera vez en la respuesta HTTP
     *
     * @return true si los datos no han cambiado, de lo contrario false
     */
    public boolean validarCambios() {
        return metaOriginal.compararCon(obtenederDatos());
    }

    /**
     * Retorna en una nueva meta creada a partir
     * de los datos del formulario actual
     *
     * @return Instancia {@link Meta}
     */
    private Meta obtenederDatos() {

        String evento = evento_input.getText().toString();
        String descripcion = descripcion_input.getText().toString();
        String fecha = fecha_text.getText().toString();
        String modulo = (String) modulo_spinner.getSelectedItem();

        return new Meta("0", evento, descripcion, fecha, modulo);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true); // Contribución a la AB
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case android.R.id.home:// CONFIRMAR
                if (!validarCambios())
                    guardarMeta();
                else
                    // Terminar actividad, ya que no hay cambios
                    getActivity().finish();
                return true;

            case R.id.action_delete:// ELIMINAR
                mostrarDialogo(R.string.dialog_delete_msg);
                break;

            case R.id.action_discard:// DESCARTAR
                if (!validarCambios()) {
                    mostrarDialogo(R.string.dialog_discard_msg);
                } else
                    // Terminar actividad, ya que no hay cambios
                    getActivity().finish();
                break;

        }
        ;

        return super.onOptionsItemSelected(item);
    }

    /**
     * Guarda los cambios de una meta editada.
     * <p>
     * Si está en modo inserción, entonces crea una nueva
     * meta en la base de datos
     */
    private void guardarMeta() {

        // Obtener valores actuales de los controles
        final String evento = evento_input.getText().toString();
        final String descripcion = descripcion_input.getText().toString();
        final String fecha = fecha_text.getText().toString();
        final String modulo = modulo_spinner.getSelectedItem().toString();

        HashMap<String, String> map = new HashMap<>();// Mapeo previo

        map.put("id_evento", id_evento);
        map.put("evento", evento);
        map.put("descripcion", fecha);
        map.put("fecha", descripcion);
        map.put("modulo", modulo);

        // Crear nuevo objeto Json basado en el mapa
        JSONObject jobject = new JSONObject(map);

        // Depurando objeto Json...
        Log.d(TAG, jobject.toString());

        // Actualizar datos en el servidor
        VolleySingleton.getInstance(getActivity()).addToRequestQueue(
                new JsonObjectRequest(
                        Request.Method.POST,
                        Constantes.UPDATE,
                        jobject,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                procesarRespuestaActualizar(response);
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Log.d(TAG, "Error Volley: " + error.getMessage());
                            }
                        }

                ) {
                    @Override
                    public Map<String, String> getHeaders() {
                        Map<String, String> headers = new HashMap<String, String>();
                        headers.put("Content-Type", "application/json; charset=utf-8");
                        headers.put("Accept", "application/json");
                        return headers;
                    }

                    @Override
                    public String getBodyContentType() {
                        return "application/json; charset=utf-8" + getParamsEncoding();
                    }
                }
        );

    }

    /**
     * Procesa todos las tareas para eliminar
     * una meta en la aplicación. Este método solo se usa
     * en la edición
     */
    public void eliminarMeta() {

        HashMap<String, String> map = new HashMap<>();// MAPEO

        map.put("id_evento", id_evento);// Identificador

        JSONObject jobject = new JSONObject(map);// Objeto Json

        // Eliminar datos en el servidor
        VolleySingleton.getInstance(getActivity()).addToRequestQueue(
                new JsonObjectRequest(
                        Request.Method.POST,
                        Constantes.DELETE,
                        jobject,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                // Procesar la respuesta
                                procesarRespuestaEliminar(response);

                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Log.d(TAG, "Error Volley: " + error.getMessage());
                            }
                        }

                ) {
                    @Override
                    public Map<String, String> getHeaders() {
                        Map<String, String> headers = new HashMap<String, String>();
                        headers.put("Content-Type", "application/json; charset=utf-8");
                        headers.put("Accept", "application/json");
                        return headers;
                    }

                    @Override
                    public String getBodyContentType() {
                        return "application/json; charset=utf-8" + getParamsEncoding();
                    }
                }
        );
    }

    /**
     * Procesa la respuesta de eliminación obtenida desde el sevidor
     */
    private void procesarRespuestaEliminar(JSONObject response) {

        try {
            // Obtener estado
            String estado = response.getString("estado");
            // Obtener mensaje
            String mensaje = response.getString("mensaje");

            switch (estado) {
                case "1":
                    // Mostrar mensaje
                    Toast.makeText(
                            getActivity(),
                            mensaje,
                            Toast.LENGTH_LONG).show();
                    // Enviar código de éxito
                    getActivity().setResult(203);
                    // Terminar actividad
                    getActivity().finish();
                    break;

                case "2":
                    // Mostrar mensaje
                    Toast.makeText(
                            getActivity(),
                            mensaje,
                            Toast.LENGTH_LONG).show();
                    // Enviar código de falla
                    getActivity().setResult(Activity.RESULT_CANCELED);
                    // Terminar actividad
                    getActivity().finish();
                    break;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    /**
     * Procesa la respuesta de actualización obtenida desde el sevidor
     */
    private void procesarRespuestaActualizar(JSONObject response) {

        try {
            // Obtener estado
            String estado = response.getString("estado");
            // Obtener mensaje
            String mensaje = response.getString("mensaje");

            switch (estado) {
                case "1":
                    // Mostrar mensaje
                    Toast.makeText(
                            getActivity(),
                            mensaje,
                            Toast.LENGTH_LONG).show();
                    // Enviar código de éxito
                    getActivity().setResult(Activity.RESULT_OK);
                    // Terminar actividad
                    getActivity().finish();
                    break;

                case "2":
                    // Mostrar mensaje
                    Toast.makeText(
                            getActivity(),
                            mensaje,
                            Toast.LENGTH_LONG).show();
                    // Enviar código de falla
                    getActivity().setResult(Activity.RESULT_CANCELED);
                    // Terminar actividad
                    getActivity().finish();
                    break;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    /**
     * Actualiza la fecha del campo {@link fecha_text}
     *
     * @param ano Año
     * @param mes Mes
     * @param dia Día
     */
    public void actualizarFecha(int ano, int mes, int dia) {
        // Setear en el textview la fecha
        fecha_text.setText(ano + "-" + (mes + 1) + "-" + dia);
    }

    /**
     * Muestra un diálogo de confirmación, cuyo mensaje esta
     * basado en el parámetro identificador de Strings
     *
     * @param id Parámetro
     */
    private void mostrarDialogo(int id) {
        DialogFragment dialogo = ConfirmDialogFragment.
                createInstance(
                        getResources().
                                getString(id));
        dialogo.show(getFragmentManager(), "ConfirmDialog");
    }

}
