package com.example.reciclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AnimeAdapter extends RecyclerView.Adapter<AnimeAdapter.AnimeBasicViewHolder> {

    private String[] mDataset;

    public AnimeAdapter() {

    }


    // Provide animeDetails reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for animeDetails data item in animeDetails view holder
    public static class AnimeBasicViewHolder extends RecyclerView.ViewHolder{
        public TextView tvName;
        public TextView tvDescription;
        public TextView tvRate;


        //constructor for holder, creating views (for layouts) and giving
        // data to them (when binding -> onBindViewHolder)
        public AnimeBasicViewHolder (View itemView){

            super(itemView);

            tvName=itemView.findViewById(R.id.tvName);
            tvDescription=itemView.findViewById(R.id.tvDescription);
            tvRate=itemView.findViewById(R.id.tvRate);

        }
    }

    // Provide animeDetails suitable constructor (depends on the kind of dataset)
    public AnimeAdapter(String[] myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public AnimeAdapter.AnimeBasicViewHolder onCreateViewHolder(ViewGroup parent,int viewType) {

        // create animeDetails new view
        TextView v = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.my_text_view, parent, false);

        AnimeBasicViewHolder vh = new AnimeBasicViewHolder(v);
        return vh;
    }

    // Replace the contents of animeDetails view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(AnimeBasicViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.tvName.setText(mDataset[position]);
        holder.tvName.setText(mDataset[position]);
        holder.tvDescription.setText(mDataset[position]);
        holder.tvRate.setText(mDataset[position]);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}
