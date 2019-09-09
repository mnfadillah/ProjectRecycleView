package com.example.wayangrecycleview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvWayang;
    private ArrayList<Wayang> list = new ArrayList<>();
    private String title = "Mode List";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setActionBarTitle(title);

        rvWayang = findViewById(R.id.rv_wayang);
        rvWayang.setHasFixedSize(true);

        list.addAll(WayangData.getListData());
        showRecycleList();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);

    }
        public void setMode(int selectedMode){
            switch (selectedMode) {
                case R.id.action_list:
                    title = "Mode list";
                    showRecycleList();
                    break;
                case R.id.action_grid:
                    title = "Mode Grid";
                    showRecyclerGrid();
                    break;
                case R.id.action_cardview:
                    title = "Mode CardView";
                    showRecyclerCardView();
                    break;
            }
        }

    private void showRecycleList() {
        rvWayang.setLayoutManager(new LinearLayoutManager(this));
        ListWayangAdapter listWayangAdapter = new ListWayangAdapter(list);
        rvWayang.setAdapter(listWayangAdapter);

        listWayangAdapter.setOnItemClickCallback(new ListWayangAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Wayang data) {
                showSelectedWayang(data);
            }
        });
    }
    private void showRecyclerGrid() {
        rvWayang.setLayoutManager(new GridLayoutManager(this,2));
        GridWayangAdapter gridWayangAdapter = new GridWayangAdapter(list);
        rvWayang.setAdapter(gridWayangAdapter);

        gridWayangAdapter.setOnItemClickCallback(new ListWayangAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Wayang data) {
                showSelectedWayang(data);
            }
        });
    }
    private void showRecyclerCardView(){
        rvWayang.setLayoutManager(new LinearLayoutManager(this));
        CardViewWayangAdapter cardViewHeroAdapter = new CardViewWayangAdapter(list);
        rvWayang.setAdapter(cardViewHeroAdapter);

    }

    private void setActionBarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }

    }
    private void showSelectedWayang(Wayang wayang) {
        Toast.makeText(this, "Kamu memilih " + wayang.getName(), Toast.LENGTH_SHORT).show();
    }
    }
