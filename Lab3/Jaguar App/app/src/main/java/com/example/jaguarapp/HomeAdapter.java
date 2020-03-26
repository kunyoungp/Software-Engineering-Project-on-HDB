package com.example.jaguarapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class HomeAdapter extends AppCompatActivity {

    String[] SelectedString = new String[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        SelectedString = intent.getStringArrayExtra("SelectedItems");

        Intent intent1 = new Intent(HomeAdapter.this, HDB_List.class);
        intent1.putExtra("SelectedItems", SelectedString);
        startActivity(intent1);

    }


}
