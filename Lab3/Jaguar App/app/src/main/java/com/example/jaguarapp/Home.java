package com.example.jaguarapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;

import com.google.firebase.auth.FirebaseAuth;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {

    String[] SelectedString = new String[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button mSearchBtn = (Button) findViewById(R.id.SearchBtn);

        Spinner mySpinner3 = (Spinner) findViewById(R.id.spinner3);
        Spinner mySpinner1 = (Spinner) findViewById(R.id.spinner1);
        Spinner mySpinner2 = (Spinner) findViewById(R.id.spinner2);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(Home.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Areas));
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner3.setAdapter(adapter1);

        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(Home.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Price_Range));
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner2.setAdapter(adapter3);


        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(Home.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Types));
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner1.setAdapter(adapter2);


        mySpinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                SelectedString[0] = parent.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                SelectedString[0] = parent.getSelectedItem().toString();
            }
        });

        mySpinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                SelectedString[1] = parent.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                SelectedString[1] = parent.getSelectedItem().toString();
            }
        });

        mySpinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                SelectedString[2] = parent.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                SelectedString[2] = parent.getSelectedItem().toString();
            }
        });


        mSearchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Home.this, HomeAdapter.class);
                intent1.putExtra("SelectedItems", SelectedString);
                startActivity(intent1);
            }
        });

    }

    public void Logout(View view) {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(),Login.class));
        finish();
    }

}
