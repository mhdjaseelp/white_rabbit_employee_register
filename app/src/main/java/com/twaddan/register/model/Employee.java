package com.twaddan.register.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.twaddan.register.room.AddressConverter;
import com.twaddan.register.room.CompanyConverter;

@Entity
public class Employee {

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "id")
    private Integer id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "username")
    private String username;

    @ColumnInfo(name = "profile_image")
    private String profile_image;

    @ColumnInfo(name = "email")
    private String email;

    @ColumnInfo(name = "address")
    @TypeConverters({AddressConverter.class})
    private Address address;

    @ColumnInfo(name = "phone")
    private String phone;

    @ColumnInfo(name = "website")
    private String website;

    @ColumnInfo(name = "company")
    @TypeConverters({CompanyConverter.class})
    private Company company;

    public Employee(int id, String name, String username, String profile_image, String email, Address address, String phone, String website, Company company) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.profile_image = profile_image;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.website = website;
        this.company = company;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(String profile_image) {
        this.profile_image = profile_image;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
