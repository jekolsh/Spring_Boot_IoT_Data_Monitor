package com.example.projekt2_2;

import com.example.projekt2_2.connection.Arduinoconnection;
import com.example.projekt2_2.datarepo.Datarepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Projekt22Application {

    public static void main(String[] args) {
        SpringApplication.run(Projekt22Application.class, args);

    }
    @Bean
    public CommandLineRunner demo(Datarepo dr){
        return args->{
            Arduinoconnection ac=new Arduinoconnection(dr);
            ac.connection();
        };
    }

}
