package es.tudir.horario.ui.actividades;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;

import es.tudir.horario.R;
import es.tudir.horario.tools.Constantes;
import es.tudir.horario.ui.fragmentos.ConfirmDialogFragment;
import es.tudir.horario.ui.fragmentos.DatePickerFragment;
import es.tudir.horario.ui.fragmentos.UpdateFragment;


public class UpdateActivity extends AppCompatActivity
        implements DatePickerFragment.OnDateSelectedListener,
        ConfirmDialogFragment.ConfirmDialogListener {



    /**
     * Etiqueta del valor extra del dialogo
     */
    private static final String EXTRA_NOMBRE = "NOMBRE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_ver_eventos);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        String extra = getIntent().getStringExtra(Constantes.EXTRA_ID);

        if (getSupportActionBar() != null)
           getSupportActionBar().setHomeAsUpIndicator(R.mipmap.ic_done);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, UpdateFragment.createInstance(extra), "UpdateFragment")
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_form, menu);
        return true;
    }

    @Override
    public void onDateSelected(int year, int month, int day) {
        UpdateFragment updateFragment = (UpdateFragment)
                getSupportFragmentManager().findFragmentByTag("UpdateFragment");

        if (updateFragment != null) {
            updateFragment.actualizarFecha(year, month, day);
        }
    }

    @Override
    public void onDialogPositiveClick(DialogFragment dialog) {
        UpdateFragment fragment = (UpdateFragment)
                getSupportFragmentManager().findFragmentByTag("UpdateFragment");

        if (fragment != null) {
            String extra = dialog.getArguments().getString(EXTRA_NOMBRE);
            String msg = getResources().
                    getString(R.string.dialog_delete_msg);

            if (extra.compareTo(msg) == 0) {
                fragment.eliminarMeta(); // Eliminar la tarea
            } else {
                finish();
            }

        }
    }

    @Override
    public void onDialogNegativeClick(DialogFragment dialog) {
        UpdateFragment fragment = (UpdateFragment)
                getSupportFragmentManager().findFragmentByTag("UpdateFragment");

        if (fragment != null) {
            // Nada por el momento
        }
    }
}
