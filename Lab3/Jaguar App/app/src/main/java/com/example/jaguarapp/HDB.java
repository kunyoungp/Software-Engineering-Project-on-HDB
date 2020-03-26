package com.example.jaguarapp;

public class HDB {
    private String month;
    private String town;
    private String flat_type;
    private String block;
    private String street_name;
    private String storey_range;
    private String floor_area_sqm;
    private String flat_model;
    private String lease_commence_date;
    private String remaining_lease;
    private String resale_price;

    public HDB() {
    }

    public HDB(String month, String town, String flat_type, String block, String street_name, String storey_range, String floor_area_sqm, String flat_model, String lease_commence_date, String remaining_lease, String resale_price) {
        this.month = month;
        this.town = town;
        this.flat_type = flat_type;
        this.block = block;
        this.street_name = street_name;
        this.storey_range = storey_range;
        this.floor_area_sqm = floor_area_sqm;
        this.flat_model = flat_model;
        this.lease_commence_date = lease_commence_date;
        this.remaining_lease = remaining_lease;
        this.resale_price = resale_price;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getFlat_type() {
        return flat_type;
    }

    public void setFlat_type(String flat_type) {
        this.flat_type = flat_type;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public String getStreet_name() {
        return street_name;
    }

    public void setStreet_name(String street_name) {
        this.street_name = street_name;
    }

    public String getStorey_range() {
        return storey_range;
    }

    public void setStorey_range(String storey_range) {
        this.storey_range = storey_range;
    }

    public String getFloor_area_sqm() {
        return floor_area_sqm;
    }

    public void setFloor_area_sqm(String floor_area_sqm) {
        this.floor_area_sqm = floor_area_sqm;
    }

    public String getFlat_model() {
        return flat_model;
    }

    public void setFlat_model(String flat_model) {
        this.flat_model = flat_model;
    }

    public String getLease_commence_date() {
        return lease_commence_date;
    }

    public void setLease_commence_date(String lease_commence_date) {
        this.lease_commence_date = lease_commence_date;
    }

    public String getRemaining_lease() {
        return remaining_lease;
    }

    public void setRemaining_lease(String remaining_lease) {
        this.remaining_lease = remaining_lease;
    }

    public String getResale_price() {
        return resale_price;
    }

    public void setResale_price(String resale_price) {
        this.resale_price = resale_price;
    }
}
