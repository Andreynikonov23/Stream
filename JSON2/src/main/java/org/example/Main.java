package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringWriter;

public class Main {
    /* Определение имени класса
НЕОБХОДИМО: подключенные библиотеки Jackson Core, Bind и Annotation версии 2.6.1
Расставьте Json аннотации так, чтобы результат выполнения метода main был следующий:
{
    "className" : ".Parking",
    "name" : "Super Parking",
    "city" : "Kyiv",
    "autos" : [ {
        "className" : "com.javarush.test.level33.lesson05.home05.RaceBike",
        "name" : "Simba",
        "owner" : "Peter",
        "age" : 2
    }, {
        "className" : "com.javarush.test.level33.lesson05.home05.Motorbike",
        "name" : "Manny",
        "owner" : null
    }, {
        "className" : "com.javarush.test.level33.lesson05.home05.Car"
    } ]
}
*/
    public static void main(String[] args) throws IOException {
        Car car = new Car("Nissan", "Alexey", 6);
        Motorbike motorbike = new Motorbike("Suzuki", "Andrey");
        RaceBike raceBike = new RaceBike();
        Parking parking = new Parking("SuperParking", "Moscow");
        parking.addAuto(car);
        parking.addAuto(motorbike);
        parking.addAuto(raceBike);


        StringWriter writer = new StringWriter();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(writer, parking);
        System.out.println(writer);
    }
}