package com.stratushunter.sample;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.stratushunter.recycleradapter.RecyclerAdapter;

import java.util.ArrayList;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        RecyclerAdapter adapter = new RecyclerAdapter<Model, ModelHolder>(new ModelHolder.ModelHolderFactory(), new RecyclerAdapter.OnRecyclerViewItemClickListener<Model>() {

            @Override
            public void onItemClick(View view, Model model) {

                Toast.makeText(view.getContext(), "Tapped " + model.text, Toast.LENGTH_SHORT).show();
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        ArrayList<Model> modelList = new ArrayList<Model>();
        modelList.add(new Model("first"));
        modelList.add(new Model("second"));
        modelList.add(new Model("third"));
        modelList.add(new Model("fourth"));
        modelList.add(new Model("fifth"));
        modelList.add(new Model("sixth"));
        modelList.add(new Model("seventh"));
        modelList.add(new Model("eigth"));

        adapter.setModelList(modelList);
    }
}
