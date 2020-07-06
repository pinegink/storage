package com.example.boxes.entity;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "Item")
public class Item {
    @XmlAttribute(name = "id")
    private int id;
    @XmlAttribute(name = "color")
    private String color;

    public Item(int id, String color) {
        this.id = id;
        this.color = color;
    }

    public Item(int id) {
        this.id = id;
    }

    public Item() {
    }

    public int getId() {
        return id;
    }

    public String getColor() {
        return color;
    }
}
