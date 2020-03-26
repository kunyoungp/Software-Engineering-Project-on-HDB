package com.example.jaguarapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class HDB_List extends AppCompatActivity {

    private Button mBackBtn;
    private TextView mNodataTxt;
    private ProgressBar mLoading;

    private FirebaseRecyclerOptions<HDB> options;
    private HDBListAdapter adapter;
    private RecyclerView recyclerView;

    private List<HDB> mHDBList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hdb__list);

        Intent intent = getIntent();
        String[] SelectedString = intent.getStringArrayExtra("SelectedItems");
        //SelectedString[0/1/2] to use Area/Types/Price

        mHDBList = new ArrayList<>();

        mLoading = findViewById(R.id.recyclerviewLoading);
        mBackBtn = findViewById(R.id.recyclerviewBack);
        mNodataTxt = findViewById(R.id.recyclerviewNodata);
        mNodataTxt.setVisibility(GONE);

        recyclerView = findViewById(R.id.HDBRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new HDBListAdapter(this,mHDBList);
        recyclerView.setAdapter(adapter);

        Query ref = FirebaseDatabase.getInstance().getReference("HDB")
                .orderByChild("town_type_price").equalTo(SelectedString[0]+SelectedString[1]+SelectedString[2]).limitToFirst(20);

        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()){
                    HDB hdb = postSnapshot.getValue(HDB.class);
                    mHDBList.add(hdb);
                }
                mLoading.setVisibility(GONE);
                if (mHDBList.isEmpty()){
                    System.out.println("Empty");
                    mNodataTxt.setVisibility(VISIBLE);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

        mBackBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Home.class));
            }
        });
    }
}



