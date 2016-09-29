package es.tudir.horario;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * {@link android.widget.BaseAdapter} personalizado para el gridview
 */
public class AdaptadorCaja extends BaseAdapter {

    private final Context mContext;
    private final Modulo[] items;

    public AdaptadorCaja(Context c, Modulo[] items) {
        mContext = c;
        this.items = items;
    }

    @Override
    public int getCount() {
        // Decremento en 1, para no contar el header view
        return items.length - 1;
    }

    @Override
    public Modulo getItem(int position) {
        return items[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.grid_item, viewGroup, false);
        }

        Modulo item = getItem(position);

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
