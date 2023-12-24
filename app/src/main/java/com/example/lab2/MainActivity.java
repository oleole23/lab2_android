package com.example.lab2;

import com.example.lab2.adapter.Adapter;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {
    private Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView myRecyclerView = findViewById(R.id.ShoppingList);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        myRecyclerView.setLayoutManager(manager);

        adapter = new Adapter(new ArrayList<>());
        myRecyclerView.setAdapter(adapter);
    }

    public void save(View view) {
        EditText etItemName= findViewById(R.id.itemName);
        String name = etItemName.getText().toString();
        etItemName.setText("");

        EditText etItemNum = findViewById(R.id.itemNumber);
        String number= etItemNum.getText().toString();
        etItemNum.setText("");

        adapter.save(name, number);
    }

    public void clear(View view) {
        adapter.clearAll();
    }

}
