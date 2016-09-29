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
public class CaeFragment extends Fragment {


    public CaeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_cae, container, false);

        final Button mainCae1 = (Button) rootView.findViewById(R.id.btnCae1);
        final Button mainCae0 = (Button) rootView.findViewById(R.id.mainCae0);
        final Button mainCae2 = (Button) rootView.findViewById(R.id.btnCae2);

        AdView mAdView = (AdView) rootView.findViewById(R.id.adView3);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mainCae1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getActivity(), getString(R.string.avisoSinHorario), Toast.LENGTH_LONG).show();

            }
        });

        mainCae0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getActivity(), getString(R.string.avisoPrinc), Toast.LENGTH_SHORT).show();
            }
        });

        mainCae2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getActivity(), getString(R.string.avisoSinHorario), Toast.LENGTH_LONG).show();
            }
        });
        // Inflate the layout for this fragment
        return rootView;
    }
}
