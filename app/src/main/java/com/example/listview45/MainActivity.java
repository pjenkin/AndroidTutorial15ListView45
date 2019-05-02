package com.example.listview45;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // https://developer.android.com/guide/topics/ui/layout/recyclerview#java
    // declare vars to do with RecyclerView
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private String[] foodData = {"Chips","Fish (battered)","Peas","Vinegar","Salt","Screeds",
            "Tommy Tucker", "Reluctant Salad", "Pickled Onions", "Buttered Bread"};
    // simple form of list data, starting with plain strings - need to be turned into list items
    // adapter to turn array members to list items

//    private PNJRowItem[] foodItems = {"Chips","Fish (battered)","Mushy Peas","Vinegar","Salt","Screeds",
//            "Tommy Tucker", "Reluctant Salad", "Pickled Onions", "Buttered Bread"};

    private PNJRowItem[] foodItems = {new PNJRowItem("Chips",R.drawable.chips),
            new PNJRowItem("Chips",R.drawable.wave_ship_boat_wallpaper),
            new PNJRowItem("Fish (battered)",R.drawable.fish_battered),
            new PNJRowItem("Mushy Peas",R.drawable.mushy_peas),
            new PNJRowItem("Vinegar",R.drawable.vinegar),
            new PNJRowItem("Salt",R.drawable.salt),
            new PNJRowItem("Reluctant Salad",R.drawable.reluctant_salad),
            new PNJRowItem("Pickled Onions",R.drawable.pickled_onions),
            new PNJRowItem("Buttered Breads",R.drawable.buttered_bread),
            new PNJRowItem("Screeds",R.drawable.screeds),
            new PNJRowItem("Tommy Tucker",R.drawable.tommy_tucker)
            };


    // listener setup (4)
    View.OnClickListener onItemClickListener = new View.OnClickListener()
    {
        /**
         * Called when a view has been clicked.
         *
         * @param v The view that was clicked.
         */
        @Override
        public void onClick(View v) {
            PNJRecyclerAdapter.PNJViewHolder viewHolder = (PNJRecyclerAdapter.PNJViewHolder) v.getTag();
            // tag was, in ViewHolder constructor, set to instance of the Adapter
            int position = viewHolder.getAdapterPosition();     // get 'cursor' index of where clicked
//            Toast.makeText(MainActivity.this, "You clicked on: " + foodData[position], Toast.LENGTH_LONG).show();
            Toast.makeText(MainActivity.this, "You clicked on: " + foodItems[position].getText(), Toast.LENGTH_LONG).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


//        String[] foods = {"Chips","Fish (battered)","Peas","Vinegar","Salt","Screeds",
//                "Tommy Tucker", "Reluctant Salad", "Pickled Onions", "Buttered Bread"};
//        // simple form of list data, starting with plain strings - need to be turned into list items
//        // adapter to turn array members to list items

        recyclerView = (RecyclerView) findViewById(R.id.pnjRecyclerView);

        // performance improvment if RecyclerView known to not vary in size
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager (huh?)
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter
//        PNJRecyclerAdapter mAdapter = new PNJRecyclerAdapter(foodData);       // specify also a set of data
        PNJRecyclerAdapter mAdapter = new PNJRecyclerAdapter(foodItems);       // specify also a set of data
        recyclerView.setAdapter(mAdapter);

        // listener setup (5)
        mAdapter.setOnItemClickListener(onItemClickListener);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // could not define RecyclerView.Adapter class nested/inner here ...
    // ... as static members not allowed in inner classes (therefore, in separate file)
}
