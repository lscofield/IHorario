package es.tudir.horario;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import in.srain.cube.views.GridViewWithHeaderAndFooter;

/**
 * Un fragmento que contiene una grilla de productos
 */
public class CajaFragment extends Fragment {
    /**
     * Argumento que representa el número sección al que pertenece
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    /**
     * Creación prefabricada de un {@link CajaFragment}
     */
    public static CajaFragment newInstance(int sectionNumber) {
        CajaFragment fragment = new CajaFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public CajaFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);


        // Obtención del grid view
        GridViewWithHeaderAndFooter grid =
                (GridViewWithHeaderAndFooter) rootView.findViewById(R.id.gridview);

        // Inicializar el grid view
        setUpGridView(grid);

        return rootView;
    }

    /**
     * Infla el grid view del fragmento dependiendo de la sección
     *
     * @param grid Instancia del grid view
     */
    private void setUpGridView(GridViewWithHeaderAndFooter grid) {
        int section_number = getArguments().getInt(ARG_SECTION_NUMBER);
        switch (section_number) {
            case 1:
                grid.addHeaderView(createHeaderView(6, Dias.getLunes()));
                grid.setAdapter(new AdaptadorCaja(getActivity(), Dias.getLunes()));
                break;
            case 2:
                grid.addHeaderView(createHeaderView(6, Dias.getMartes()));
                grid.setAdapter(new AdaptadorCaja(getActivity(), Dias.getMartes()));
                break;
            case 3:
                grid.addHeaderView(createHeaderView(6, Dias.getMiercoles()));
                grid.setAdapter(new AdaptadorCaja(getActivity(), Dias.getMiercoles()));
                break;
            case 4:
                grid.addHeaderView((createHeaderView(6, Dias.getJueves())));
                grid.setAdapter(new AdaptadorCaja(getActivity(), Dias.getJueves()));
                break;
            case 5:
                grid.addHeaderView((createHeaderView(6, Dias.getViernes())));
                grid.setAdapter(new AdaptadorCaja(getActivity(), Dias.getViernes()));
                break;
        }
    }

    /**
     * Crea un view de cabecera para mostrarlo en el principio del grid view.
     *
     * @param position Posición del item que sera el grid view dentro de {@code items}
     * @param items    Array de productos
     * @return Header View
     */
    private View createHeaderView(int position, Modulo[] items) {

        View view;

        LayoutInflater inflater = getActivity().getLayoutInflater();
        view = inflater.inflate(R.layout.grid_header, null, false);

        Modulo item = items[position];

        // Seteando Imagen
        ImageView image = (ImageView) view.findViewById(R.id.imagen);
        Glide.with(image.getContext()).load(item.getIdThumbnail()).into(image);

        // Seteando Nombre
        TextView name = (TextView) view.findViewById(R.id.nModulo);
        name.setText(item.getnModulo());

        // Seteando Precio
        TextView precio = (TextView) view.findViewById(R.id.hora);
        precio.setText(item.getHora());

        return view;
    }
}
