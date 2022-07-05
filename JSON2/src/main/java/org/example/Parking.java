package org.example;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.ArrayList;
import java.util.List;


@JsonAutoDetect
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "className")
public class Parking {
    private String name;
    private String city;
    @JsonDeserialize(as=ArrayList.class)
    private List<Auto> autos = new ArrayList<>();



    public Parking(){}

    public Parking(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public Parking(String name, String city, List<Auto> autos) {
        this.name = name;
        this.city = city;
        this.autos = autos;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Auto> getAutos() {
        return autos;
    }

    public void setAutos(List<Auto> autos) {
        this.autos = autos;
    }
    public void addAuto(Auto auto){
        autos.add(auto);
    }
}
