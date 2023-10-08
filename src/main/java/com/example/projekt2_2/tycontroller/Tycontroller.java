package com.example.projekt2_2.tycontroller;


import com.example.projekt2_2.database.Tempsensor;
import com.example.projekt2_2.datarepo.Datarepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller

public class Tycontroller {


    private final Datarepo dr;

    public Tycontroller(Datarepo dr) {
        this.dr = dr;
    }

    @GetMapping
    public String dashboard(){
        return"dashboard";
    }

    @GetMapping("/humidity")
    public String showHumidity(Model model) {
        List<Tempsensor> sensors = dr.findAll();
        model.addAttribute("sensors", sensors);
        return "Humidity";
    }


    @GetMapping("/temperature")
    public String showtemparature(Model model) {
        List<Tempsensor> sensors = dr.findAll();
        model.addAttribute("sensors", sensors);
        return "temperature";
    }

    @GetMapping("alldata")
    public String alldata(Model model) {
        List<Tempsensor> sensors = dr.findAll();
        model.addAttribute("sensors", sensors);
        return "alldata";
    }

    @GetMapping("/lastdata")
    public String lastdata(Model model) {
        Tempsensor sensor = dr.findTopByOrderByIdDesc();
        model.addAttribute("sensor", sensor);
        return "Lastdata";
    }


}


