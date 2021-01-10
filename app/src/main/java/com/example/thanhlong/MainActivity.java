package com.example.thanhlong;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    String s1[],s2[];
    int image[]={R.drawable.chopug,R.drawable.chopoodle,R.drawable.chopitbull,R.drawable.chohusky, R.drawable.chobeagle};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        s1=getResources().getStringArray(R.array.name);
        s2=getResources().getStringArray(R.array.price);

        MyAdapter myAdapter =new MyAdapter(this,s1,s2,image);

        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}