package com.mycompany.cd_store;

import java.io.Serializable;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Student
 */
public class CD implements Serializable {

    private String id;
    private String collection;
    private String type;
    private String title;
    private double price;
    private int yearOfRelease;

    public CD(String id, String collection, String type, String title, double price, int yearOfRelease) {
        this.id = id;
        this.collection = collection;
        this.type = type;
        this.title = title;
        this.price = price;
        this.yearOfRelease = yearOfRelease;
    }

    public CD(String collection, String type, String title) {
        this.collection = collection;
        this.type = type;
        this.title = title;
    }

    public CD() {
    }


    public String getId() {
        return id;
    }

    public String getCollection() {
        return collection;
    }

    public String getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public void print() {
        System.out.println("ID: " + id + " Collection: " + collection + " Type: " + type + " Title: " + title
                + " Price: " + price + " Release year: " + yearOfRelease);
    }
}

