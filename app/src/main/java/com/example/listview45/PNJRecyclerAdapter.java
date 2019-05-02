package com.example.listview45;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

// class defined in separate file because static members cannot exist in inner/nested classes
// https://stackoverflow.com/a/31957978/11365317
// also, some people d'prefer each class to have its own file, where possible
// class consumed in MainActivity for intended app

public class PNJRecyclerAdapter extends RecyclerView.Adapter<PNJRecyclerAdapter.PNJViewHolder>
{
    private String[] mDataset;

    // Listener pattern used: https://hackernoon.com/android-recyclerview-onitemclicklistener-getadapterposition-a-better-way-3c789baab4db
    // setup listener (1)
    private View.OnClickListener mOnItemClickListener;  // NB capital case

    public PNJRecyclerAdapter(String[] pnjDataset)
    {
        mDataset = pnjDataset;
    }

    // for news views (this invoked by the layout manager in code)
    // Alt+Insert + overrides...
    @NonNull
    @Override
    public PNJViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
//            return null;
//        TextView textView = (TextView) LayoutInflater.from(viewGroup.getContext())
//                .inflate(R.layout.pnj_text_view, viewGroup, false);
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pnj_custom_row, viewGroup, false);
//        PNJViewHolder viewHolder = new PNJViewHolder(textView);
        PNJViewHolder viewHolder = new PNJViewHolder(itemView);
        return viewHolder;
    }

    // Alt+Insert again - used by layout manager automatically
    @Override
    //public void onBindViewHolder(@NonNull PNJViewHolder holder, int position, @NonNull List<Object> payloads) {
    // NB this boilerplate signature with 3 parameters will cause an error with implementing ...
    // ... RecyclerView Adapter, ... which d'require onBindViewHolder to have 2 parameters only

    public void onBindViewHolder(@NonNull PNJViewHolder holder, int position) {
        //super.onBindViewHolder(holder, position, payloads);
//        holder.textView.setText(mDataset[position]);
        ImageView custom_row_imageview = (ImageView) holder.view.findViewById(R.id.custom_row_imageview);
        custom_row_imageview.setImageResource(R.drawable.wave_ship_boat_wallpaper);


        TextView custom_row_text = (TextView) holder.view.findViewById(R.id.custom_row_text);
        custom_row_text.setText(mDataset[position]);
        // cf cellForRowAt in iOS/Swift
    }

    @Override
    public int getItemCount() {
        // return 0;
        return mDataset.length;
        // cf NumRows or similar in iOS/Swift
    }

    // setup listener (2)
    public void setOnItemClickListener(View.OnClickListener itemClickListener)
    {
        mOnItemClickListener = itemClickListener;
    }

    // reference to view(s) for each data item
    public class PNJViewHolder extends RecyclerView.ViewHolder
    {
        // where data items are: strings
//        public TextView textView;
        public View view;

//        public PNJViewHolder(TextView v)
        public PNJViewHolder(View v)
        {
            super(v);       // in constructor - do what TextView d'do
//            textView = v;
            view = v;

            // listener setup (3) set tag to reference to adapter
            v.setTag(this);
            v.setOnClickListener(mOnItemClickListener);
        }
    }

}
