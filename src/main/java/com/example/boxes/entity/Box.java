package com.example.boxes.entity;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.LinkedList;
import java.util.List;
@XmlType(name = "Box")
public class Box {
   @XmlAttribute (name = "id")
   private int id;
   @XmlElement(name = "Item")
   public List<Item> items;
   @XmlElement(name = "Box")
   public List<Box> innerBoxes;

   public Box() {
      this.items = new LinkedList<>();
      this.innerBoxes = new LinkedList<>();
   }

   public Box(int id) {
      this.id = id;
      this.items = new LinkedList<>();
      this.innerBoxes = new LinkedList<>();
   }

   public int getId() {
      return id;
   }
}
