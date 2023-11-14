package com.example.lifecycles;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    private ArrayList<ItemData> itemValues;
    private RecyclerView recyclerView;
    private ItemAdapter itemAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        recyclerView=findViewById(R.id.recycler_view);
        itemValues=new ArrayList<>();
        for(int i=1;i<=10;i++){
            ItemData item=new ItemData();
            item.itemTitle="Title Data "+i;
            item.itemSubtitle="Subtitle Data "+i;
            itemValues.add(item);
        }
        itemAdapter=new ItemAdapter(this, itemValues);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(itemAdapter);
    }
    public void addData(View view) {
        ItemData item=new ItemData();
        item.itemTitle="Title Data Update";
        item.itemSubtitle="SubTitle Data Update";
        itemValues.add(item);
        itemAdapter.notifyDataSetChanged();
    }
}