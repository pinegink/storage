package com.example.boxes.service;

import com.example.boxes.entity.Box;
import com.example.boxes.entity.Item;
import com.example.boxes.entity.Storage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Search {
    private List<Item> items;
    private Box box;

    public Search() {
        this.items = new ArrayList<>();
    }

    public List<Integer> findItems(Storage storage, int boxId, String color) {
        findBox(storage, boxId);
        storeItems(this.box, color);
        return items.stream()
                .map((i) -> i.getId())
                .collect(Collectors.toList());
    }

    private void storeItems(Box box, String color) {
        for (Item item : box.items) {
            if (color.equals(item.getColor())) {
                this.items.add(item);
            }
        }
        for (Box innerBox : box.innerBoxes) {
            storeItems(innerBox, color);
        }
    }

    private void findBox(Storage storage, int boxId){
        if (storage.boxes.isEmpty()) {
            throw new IllegalArgumentException("Passed storage is empty");
        }
        for (Box box: storage.boxes){
            if (this.box == null){
                findBoxInBox(box, boxId);
            }else {
                return;
            }
        }
        if (this.box == null){
            throw new IllegalArgumentException("Box not found");
        }
    }
    private void findBoxInBox(Box box, int boxId){
        if (box.getId() == boxId){
            this.box = box;
            return;
        }
        for (Box innerBox : box.innerBoxes){
            findBoxInBox(innerBox, boxId);
        }
    }
}
