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
public class CmFragment extends Fragment {


    public CmFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_cm, container, false);

        final Button mainCm1 = (Button) rootView.findViewById(R.id.btnCm1);
        final Button mainCm0 = (Button) rootView.findViewById(R.id.mainCm0);
        final Button mainCm2 = (Button) rootView.findViewById(R.id.btnCm2);

        AdView mAdView = (AdView) rootView.findViewById(R.id.adView4);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mainCm1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getActivity(), getString(R.string.avisoSinHorario), Toast.LENGTH_LONG).show();

            }
        });

        mainCm0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getActivity(), getString(R.string.avisoPrinc), Toast.LENGTH_SHORT).show();
            }
        });

        mainCm2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getActivity(), getString(R.string.avisoSinHorario), Toast.LENGTH_LONG).show();
            }
        });
        // Inflate the layout for this fragment
        return rootView;
    }
}
