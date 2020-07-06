package com.example.boxes.service;

import com.example.boxes.entity.Box;
import com.example.boxes.entity.Item;
import com.example.boxes.entity.Storage;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

public class Parser {
    public Storage parse (String xml) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Item.class, Box.class, Storage.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (Storage) unmarshaller.unmarshal(new StringReader(xml));
    }
}
