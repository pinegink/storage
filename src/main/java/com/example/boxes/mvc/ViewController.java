package com.example.boxes.mvc;

import com.example.boxes.entity.DTO;
import com.example.boxes.entity.Storage;
import com.example.boxes.service.Parser;
import com.example.boxes.service.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.xml.bind.JAXBException;
import java.util.List;

@Controller
public class ViewController {
    private Parser parser;
    @Autowired
    ViewController (Parser parser){
        this.parser = parser;
    }

    @GetMapping("/")
    public String mainpage (Model model){
        model.addAttribute("dto",new DTO());
        return "mainpage";
    }
    @PostMapping("/")
    public String recievexml (@ModelAttribute("dto") DTO dto, Model model){
        try {
            Storage storage = parser.parse(dto.xml);
            Search search = new Search();
            List<Integer> result = search.findItems(storage, dto.box, dto.color);
            model.addAttribute("result", result);
        } catch (JAXBException e) {
            e.printStackTrace();
            model.addAttribute("result", "invalid XML input");
        }catch (IllegalArgumentException e){
            e.printStackTrace();
            model.addAttribute("result", e.getMessage());
        }
        return "mainpage";
    }
}
