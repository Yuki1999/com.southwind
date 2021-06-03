package com.southwind.entity;

import lombok.Data;

@Data
public class Menu {
    private long id;
    private Location location;
    private double price;
    private String flavor;
    private Type type;
}
