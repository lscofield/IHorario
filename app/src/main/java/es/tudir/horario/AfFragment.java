package es.tudir.horario;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


/**
 * A simple {@link Fragment} subclass.
 */
public class AfFragment extends Fragment {


    public AfFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_af, container, false);

        final Button mainAf1 = (Button) rootView.findViewById(R.id.btnAf1);
        final Button mainAf0 = (Button) rootView.findViewById(R.id.mainAf0);
        final Button mainAf2 = (Button) rootView.findViewById(R.id.btnAf2);

        AdView mAdView = (AdView) rootView.findViewById(R.id.adView2);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mainAf1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getActivity(), getString(R.string.avisoSinHorario), Toast.LENGTH_LONG).show();

            }
        });

        mainAf0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getActivity(), getString(R.string.avisoPrinc), Toast.LENGTH_SHORT).show();
            }
        });

        mainAf2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getActivity(), getString(R.string.avisoSinHorario), Toast.LENGTH_LONG).show();
            }
        });
        // Inflate the layout for this fragment
        return rootView;
    }

}