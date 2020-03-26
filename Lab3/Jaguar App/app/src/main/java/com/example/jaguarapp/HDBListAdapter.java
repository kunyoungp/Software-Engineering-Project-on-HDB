package com.example.jaguarapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HDBListAdapter extends RecyclerView.Adapter<HDBListAdapter.HDBViewHolder> {

    private Context mCtx;
    private List<HDB> HDBList;

    public HDBListAdapter(Context mCtx, List<HDB> HDBList) {
        this.mCtx = mCtx;
        this.HDBList = HDBList;
    }

    @NonNull
    @Override
    public HDBViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.hdb_row,null);
        HDBViewHolder holder = new HDBViewHolder(view);
        return new HDBViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HDBViewHolder holder, int position) {

        HDB hdb = HDBList.get(position);

        final String month = hdb.getMonth();
        final String town = hdb.getTown();
        final String flat_type = hdb.getFlat_type();
        final String block = hdb.getBlock();
        final String street_name = hdb.getStreet_name();
        final String storey_range = hdb.getStorey_range();
        final String floor_area_sqm = hdb.getFloor_area_sqm();
        final String flat_model = hdb.getFlat_model();
        final String lease_commence_date = hdb.getLease_commence_date();
        final String remaining_lease = hdb.getRemaining_lease();
        final String resale_price = hdb.getResale_price();
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentDetail=new Intent(mCtx.getApplicationContext(),HDBDetail.class);
                intentDetail.putExtra("month",""+month);
                intentDetail.putExtra("town",""+town);
                intentDetail.putExtra("flat_type",""+flat_type);
                intentDetail.putExtra("block",""+block);
                intentDetail.putExtra("street_name",""+street_name);
                intentDetail.putExtra("storey_range",""+storey_range);
                intentDetail.putExtra("floor_area_sqm",""+floor_area_sqm);
                intentDetail.putExtra("flat_model",""+flat_model);
                intentDetail.putExtra("lease_commence_date",""+lease_commence_date);
                intentDetail.putExtra("remaining_lease",""+remaining_lease);
                intentDetail.putExtra("resale_price",""+resale_price);
                mCtx.startActivity(intentDetail);
            }
        });


        holder.txtTown.setText(hdb.getTown());
        holder.txtAddress.setText("Address: "+hdb.getStreet_name());
        holder.txtType.setText("Flat Type: "+hdb.getFlat_type());
        holder.txtSqft.setText("Floor Area: " + hdb.getFloor_area_sqm());
        holder.txtPrice.setText("Price: SGD " + hdb.getResale_price());
    }




    @Override
    public int getItemCount() {
        return HDBList.size();
    }

    class HDBViewHolder extends RecyclerView.ViewHolder{

        TextView txtTown, txtAddress, txtType, txtSqft, txtPrice;

        public HDBViewHolder(View itemView){
            super(itemView);
            txtTown = itemView.findViewById(R.id.town_name);
            txtAddress = itemView.findViewById(R.id.address_name);
            txtType = itemView.findViewById(R.id.type_name);
            txtSqft = itemView.findViewById(R.id.sqft_name);
            txtPrice = itemView.findViewById(R.id.price_name);
        }
    }
}
