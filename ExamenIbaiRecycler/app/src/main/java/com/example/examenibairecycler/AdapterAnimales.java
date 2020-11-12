package com.example.examenibairecycler;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

//Clase para controlar el recicler view
public class AdapterAnimales extends RecyclerView.Adapter<AdapterAnimales.ViewHolderDatos>  implements View.OnClickListener{

    //creamos un arraylist para guardar los animales
    ArrayList<Animal> ar_animal = new ArrayList<>();
    private View.OnClickListener listener;

    //Varialble desde datosanimal.java
    private static int pValoracion = 0;
    private static String pNombre = "";


    public AdapterAnimales(ArrayList<Animal> ar_animales)
    {
        this.ar_animal=ar_animales;
    }

    //Recive el nombre y la valoracion del animal selecionado desde datosanimla.java y los hago una varaibla dentro del AdapterAnimal accesible
    public static void anyadirValoracion(String nombre, int valoracion)
    {

        pNombre = nombre;
        pValoracion= valoracion;
    }


    //On clik Listener
    @Override
    public void onClick(View v) {
        if(listener!=null){
            listener.onClick(v);
        }
    }

    public void setOnClickListener(View.OnClickListener listenerclick){

        this.listener=listenerclick;
    }

    @NonNull
    @Override
    public AdapterAnimales.ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //"inflamos" el items_recycler.xml
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.animales_recicler,null,false);

        //Para escuchar el evento de selecion
        view.setOnClickListener(this);

        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position)
    {

        holder.nombre.setText(ar_animal.get(position).getNombre());
        holder.imagen.setImageResource(ar_animal.get(position).getImg());


        //Compara el nombre que recibo de datosanimal.java con los del arraylist en cada posicion y añade el texto al textview
        if (ar_animal.get(position).getNombre().equals(pNombre))
        {
            holder.valoracion.setText(String.valueOf(pValoracion));
        }else
            {
            holder.valoracion.setText(R.string.txValoracion);
        }

    }

    @Override
    public int getItemCount() {
        //le decimos cuantos "animales devuleve"
        return ar_animal.size();
    }

    public static class ViewHolderDatos extends RecyclerView.ViewHolder
    {
        //creamos los "animales que tenemos en el animales_recicler.xml"
        TextView nombre, valoracion;
        ImageView imagen;

        public ViewHolderDatos(@NonNull View itemView)
        {
            super(itemView);
            //Cogemos los TextViews
            nombre = itemView.findViewById(R.id.tvNombre);
            imagen=itemView.findViewById(R.id.imageAnimal);
            valoracion= itemView.findViewById(R.id.valoracion);

        }
    }
}
