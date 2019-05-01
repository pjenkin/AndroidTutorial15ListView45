package com.example.listview45;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

// class defined in separate file because static members cannot exist in inner/nested classes
// https://stackoverflow.com/a/31957978/11365317
// also, some people d'prefer each class to have its own file, where possible
// class consumed in MainActivity for intended app

public class PNJRecyclerAdapter extends RecyclerView.Adapter<PNJRecyclerAdapter.PNJViewHolder>
{
    private String[] mDataset;

    // Listener pattern used: https://hackernoon.com/android-recyclerview-onitemclicklistener-getadapterposition-a-better-way-3c789baab4db
    // setup listener
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
        TextView textView = (TextView) LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.pnj_text_view, viewGroup, false);
        PNJViewHolder viewHolder = new PNJViewHolder(textView);
        return viewHolder;
    }

    // Alt+Insert again - used by layout manager automatically
    @Override
    //public void onBindViewHolder(@NonNull PNJViewHolder holder, int position, @NonNull List<Object> payloads) {
    // NB this boilerplate signature with 3 parameters will cause an error with implementing ...
    // ... RecyclerView Adapter, ... which d'require onBindViewHolder to have 2 parameters only

    public void onBindViewHolder(@NonNull PNJViewHolder holder, int position) {
        //super.onBindViewHolder(holder, position, payloads);
        holder.textView.setText(mDataset[position]);
        // cf cellForRowAt in iOS/Swift
    }

    @Override
    public int getItemCount() {
        // return 0;
        return mDataset.length;
        // cf NumRows or similar in iOS/Swift
    }

    public void setOnItemClickListener(View.OnClickListener itemClickListener)
    {
        mOnItemClickListener = itemClickListener;
    }

    // reference to view(s) for each data item
    public class PNJViewHolder extends RecyclerView.ViewHolder
    {
        // where data items are: strings
        public TextView textView;

        public PNJViewHolder(TextView v)
        {
            super(v);       // in constructor - do what TextView d'do
            textView = v;

            // listener setup
            v.setTag(this);
            v.setOnClickListener(mOnItemClickListener);
        }
    }

}
