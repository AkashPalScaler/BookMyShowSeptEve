package com.scaler.BookMyShowSeptEve.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Theatre extends BaseModel{
    private String name;
    private String address;
    // Theatre M:1 Region
    @ManyToOne
    private Region region;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }
}

// Inheritance: Pen [id, name, price]  \ BallPen : [id, radius, pen_id]

// ORM -> Object Relation Mapping
// { dataValues: { name: "pvr", "address": "mumbai", ...}}
// PhonePe -> BankAPIInterface <- YesBankApi

// Springboot -> Spring Data JPA (Contract) create, read <- Hibernate needs to have
// Creating -> Object -> save to db -> convert object to db record
// Reading -> Db record -> to read -> convert the record to Object


// Theatre (M-1) Region
//Theatre Table : id | Name | Region ID
//Region Table: id | city | Region getRegionById(id) ( select * from region where id='given_id') ((select * from theatre where region_id=region_id_val))
// Fetch the region -> it will get region ID -> (select * from theatre where region_id=region_id_val)

// Everytime you fetch region do you need a list of theatres?
// If not needed every single time , then we can have a repo function like : getTheatreListByRegionId(region_id)

// HW: Finishing all the models
// Give them Entity annotation
// Add all the cardinality mapping annotations
// How are enums annotated
// Run postgresql/mysql locally

// Break till : 8:45 PM
