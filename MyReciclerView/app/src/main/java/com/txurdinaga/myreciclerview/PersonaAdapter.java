package com.txurdinaga.myreciclerview;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class PersonaAdapter extends RecyclerView.Adapter<PersonaAdapter.PersonaBasicViewHolder> {

    public static class PersonaBasicViewHolder extends RecyclerView.ViewHolder{
        public TextView tvNombre;
        public TextView tvApellidos;




        //constructor for holder, creating views (for layouts) and giving
        // data to them (when binding -> onBindViewHolder)
        public PersonaBasicViewHolder (View itemView){

            super(itemView);


            tvNombre=itemView.findViewById(R.id.tvNombre);
            tvApellidos=itemView.findViewById(R.id.tvApellidos);


        }
    }
    public PersonaAdapter(){

    }


    @Override
    public PersonaBasicViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View itemView;

        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.items, parent, false);

        return new PersonaBasicViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonaBasicViewHolder holder, int position) {

        holder.tvNombre.setText(MainActivity.ciudadanos.get(position).getNombre());
        holder.tvApellidos.setText(MainActivity.ciudadanos.get(position).getApellidos());
    }

    @Override
    public int getItemCount() {
        return MainActivity.ciudadanos.size();
    }


}
