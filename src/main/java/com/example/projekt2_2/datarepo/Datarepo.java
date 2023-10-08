package com.example.projekt2_2.datarepo;

import com.example.projekt2_2.database.Tempsensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Datarepo extends JpaRepository<Tempsensor, Long> {

        Tempsensor findTopByOrderByIdDesc();
        @Query("SELECT t.humidity from Tempsensor t") // injecting query for find all humidity value from the database
        List<String> findAllHumidityValues();

        @Query("select t.temperature from Tempsensor t") // injecting query for find all temperature value from the database
        List<String> findAllTempdata();



}
