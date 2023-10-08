package com.example.projekt2_2.database;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Tempsensor {

    @Id
    @GeneratedValue
    private Long id;
    private String humidity;
    private String temperature;
    private String date_time;

}