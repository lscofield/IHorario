package es.tudir.horario;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

/**
 * A simple {@link Fragment} subclass.
 */
public class AsirFragment extends Fragment {


    public AsirFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_asir, container, false);

        final Button mainAsir1 = (Button) rootView.findViewById(R.id.btnAsir1);
        final Button mainAsir0 = (Button) rootView.findViewById(R.id.mainAsir0);
        final Button mainAsir2 = (Button) rootView.findViewById(R.id.btnAsir2);

        AdView mAdView = (AdView) rootView.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mainAsir1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), getString(R.string.avisoSinHorario), Toast.LENGTH_LONG).show();
            }
        });

       mainAsir0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getActivity(), getString(R.string.avisoPrinc), Toast.LENGTH_SHORT).show();
            }
        });

        mainAsir2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getActivity(), MainActivity.class);
                startActivity(i);

            }
        });
        // Inflate the layout for this fragment
        return rootView;
    }

        public void dialogo(final Intent i){

        // Rescatamos el layout creado para el prompt
        LayoutInflater li = LayoutInflater.from(getActivity());
        View prompt = li.inflate(R.layout.prompt, null);

        // Creamos un constructor de Alert Dialog y le añadimos nuestro layout al cuadro de dialogo
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
        alertDialogBuilder.setView(prompt);

        final EditText nombreUsuario = (EditText) prompt.findViewById(R.id.nombre_usuario);

        // Mostramos el mensaje del cuadro de dialogo
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                int clave = 0;

                // Rescatamos el nombre del EditText y lo mostramos por pantalla
                try {
                    clave = Integer.parseInt(nombreUsuario.getText().toString());
                    if (clave == 254) {
                        startActivity(i);
                    } else {
                        Toast.makeText(getActivity(), getString(R.string.clavInCorr), Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    Toast.makeText(getActivity(), getString(R.string.toast), Toast.LENGTH_SHORT).show();
                }
            }

               //ultima linea de onclick
        });
        alertDialogBuilder.setNegativeButton(getString(R.string.cancelar), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // Cancelamos el cuadro de dialogo
                dialog.cancel();
            }
        });

        // Creamos un AlertDialog y lo mostramos

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
}