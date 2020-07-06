package com.example.boxes.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.LinkedList;
import java.util.List;
@XmlRootElement (name = "Storage")
public class Storage {
    @XmlElement(name = "Box")
    public List<Box> boxes;

    public Storage() {
        this.boxes = new LinkedList<>();
    }
}
