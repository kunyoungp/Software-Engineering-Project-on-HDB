package com.example.jaguarapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HDBDetail extends AppCompatActivity {

    private Button mBackBtn;
    private Button mMapBtn;
    String passString;

    TextView monthDetail,townDetail,flat_typeDetail,blockDetail,street_nameDetail,storey_rangeDetail,floor_area_sqmDetail,flat_modelDetail,lease_commence_dateDetail,remaining_leaseDetail,resale_priceDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hdb_detail);
        mBackBtn = findViewById(R.id.detailBack);
        mMapBtn = findViewById((R.id.toMapButton));

        monthDetail=findViewById(R.id.monthDetail);
        townDetail=findViewById(R.id.townDetail);
        flat_typeDetail=findViewById(R.id.flat_typeDetail);
        blockDetail=findViewById(R.id.blockDetail);
        street_nameDetail=findViewById(R.id.street_nameDetail);
        storey_rangeDetail=findViewById(R.id.storey_rangeDetail);
        floor_area_sqmDetail=findViewById(R.id.floor_area_sqmDetail);
        flat_modelDetail=findViewById(R.id.flat_modelDetail);
        lease_commence_dateDetail=findViewById(R.id.lease_commence_dateDetail);
        remaining_leaseDetail=findViewById(R.id.remaining_leaseDetail);
        resale_priceDetail=findViewById(R.id.resale_priceDetail);

        monthDetail.setText(""+getIntent().getStringExtra("month"));
        townDetail.setText(getIntent().getStringExtra("town"));
        flat_typeDetail.setText("Type: "+getIntent().getStringExtra("flat_type"));
        blockDetail.setText("Blk "+getIntent().getStringExtra("block"));
        street_nameDetail.setText("Address:"+getIntent().getStringExtra("street_name"));
        storey_rangeDetail.setText("Storeys"+getIntent().getStringExtra("storey_range"));
        floor_area_sqmDetail.setText("Floor Area:"+getIntent().getStringExtra("floor_area_sqm"));
        flat_modelDetail.setText("Flat mode: "+getIntent().getStringExtra("flat_model"));
        lease_commence_dateDetail.setText("Built: "+getIntent().getStringExtra("lease_commence_date"));
        remaining_leaseDetail.setText("Remaining lease: "+getIntent().getStringExtra("remaining_lease"));
        resale_priceDetail.setText("Price: SGD "+getIntent().getStringExtra("resale_price"));

        mBackBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),HDB_List.class));
            }
        });

        passString = getIntent().getStringExtra("street_name");

        mMapBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),HDB_Map.class));

                Intent intentMap = new Intent(HDBDetail.this, HDB_Map.class);
                intentMap.putExtra("passString", passString);
                startActivity(intentMap);
            }
        });

    }

}
