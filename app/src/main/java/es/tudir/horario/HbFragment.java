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
public class HbFragment extends Fragment {


    public HbFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_hb, container, false);

        final Button mainHb1 = (Button) rootView.findViewById(R.id.btnHb1);
        final Button mainHb0 = (Button) rootView.findViewById(R.id.mainHb0);
        final Button mainHb2 = (Button) rootView.findViewById(R.id.btnHb2);

        AdView mAdView = (AdView) rootView.findViewById(R.id.adView7);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mainHb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getActivity(), getString(R.string.avisoSinHorario), Toast.LENGTH_LONG).show();
            }
        });

        mainHb0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getActivity(), getString(R.string.avisoPrinc), Toast.LENGTH_SHORT).show();
            }
        });

        mainHb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getActivity(), getString(R.string.avisoSinHorario), Toast.LENGTH_LONG).show();
            }
        });
        // Inflate the layout for this fragment
        return rootView;
    }

}
