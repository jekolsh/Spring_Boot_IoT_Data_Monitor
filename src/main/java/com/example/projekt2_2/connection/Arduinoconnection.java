package com.example.projekt2_2.connection;


import com.example.projekt2_2.database.Tempsensor;
import com.example.projekt2_2.datarepo.Datarepo;
import com.fazecast.jSerialComm.SerialPort;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Arduinoconnection {
    String humi;
    String tem;
    Scanner data;

    private final Datarepo dr;

    public Arduinoconnection(Datarepo dr) {
        this.dr = dr;
    }

    public void connection(){
        SerialPort port= SerialPort.getCommPort("COM8");  //to communicate with the port
        if(!port.openPort()){
            System.out.println("Unable to open port.");
        }
        port.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING,0,0);// to read data from port without hampering code execution

        data=new Scanner(port.getInputStream()); //reading data from port

        while(data.hasNextLine()){
            LocalDateTime localdate=LocalDateTime.now(); //take the current time
            DateTimeFormatter formatter= DateTimeFormatter.ofPattern("dd-MM-yyy HH:mm:ss"); //formatting style
            Tempsensor temp= new Tempsensor();

            String text=data.nextLine().trim();
            String date=localdate.format(formatter);

            String[] message=text.split("/"); //separating the string

            //Checking there is only 2 values in the array
            if(message.length==2){
                humi=message[0];
                tem=message[1];
            }
            temp.setTemperature(tem);
            temp.setHumidity(humi);
            temp.setDate_time(date);
            dr.save(temp);
        }

    }
}

