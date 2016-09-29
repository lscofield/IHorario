package es.tudir.horario.ui;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import es.tudir.horario.R;
import es.tudir.horario.modelo.Meta;
import es.tudir.horario.ui.actividades.DetailActivity;

/**
 * Adaptador del recycler view
 */
public class MetaAdapter extends RecyclerView.Adapter<MetaAdapter.MetaViewHolder>
        implements ItemClickListener {

    /**
     * Lista de objetos {@link Meta} que representan la fuente de datos
     * de inflado
     */
    private List<Meta> items;

    /*
    Contexto donde actua el recycler view
     */
    private Context context;


    public MetaAdapter(List<Meta> items, Context context) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public MetaViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_list, viewGroup, false);
        return new MetaViewHolder(v, this);
    }

    @Override
    public void onBindViewHolder(MetaViewHolder viewHolder, int i) {
        viewHolder.evento.setText(items.get(i).getEvento());
        viewHolder.fecha.setText(items.get(i).getFecha());
        viewHolder.modulo.setText(items.get(i).getModulo());
    }

    /**
     * Sobrescritura del método de la interfaz {@link ItemClickListener}
     *
     * @param view     item actual
     * @param position posición del item actual
     */
    @Override
    public void onItemClick(View view, int position) {
        DetailActivity.launch(
                (Activity) context, items.get(position).getId_evento());
    }


    public static class MetaViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {
        // Campos respectivos de un item
        public TextView evento;
        public TextView fecha;
        public TextView modulo;
        public ItemClickListener listener;

        public MetaViewHolder(View v, ItemClickListener listener) {
            super(v);
            evento = (TextView) v.findViewById(R.id.evento);
            fecha = (TextView) v.findViewById(R.id.fecha);
            modulo = (TextView) v.findViewById(R.id.modulo);
            this.listener = listener;
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listener.onItemClick(v, getAdapterPosition());
        }
    }
}


interface ItemClickListener {
    void onItemClick(View view, int position);
}
