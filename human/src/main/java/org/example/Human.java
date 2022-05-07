package org.example;

import java.io.*;
import java.util.Scanner;

public class Human {
    private String name;




    public Human(String name){
        this.name = name;
    }
    public Human(){

    }
    public String getName() {
        return name;
    }

    public void save(FileWriter writer) throws IOException {
        writer.write(name + "\n");
    }
    public void load(Scanner inputStream) throws IOException {
        name = inputStream.nextLine();
    }
    @Override
    public String toString(){
        return name;
    }
}
