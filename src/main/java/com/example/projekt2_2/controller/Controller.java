package com.example.projekt2_2.controller;

import com.example.projekt2_2.datarepo.Datarepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class Controller {
    private final Datarepo dr;


    public Controller(Datarepo dr) {
        this.dr = dr;
    }


    @GetMapping("/hum")
    public List<String> humdata() {
        List<String> humi = dr.findAllHumidityValues();

        return humi;
    }

    @GetMapping("/temp")
    public List<String> tempdata() {
        List<String> temp = dr.findAllTempdata();

        return temp;
    }
}
