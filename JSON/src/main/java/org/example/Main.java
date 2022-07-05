package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) throws IOException {
        First first = new First("John", 23, 70);
        StringWriter writer = new StringWriter();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(writer, first);
        System.out.println(writer);
        String str;
        try(FileInputStream inputStream = new FileInputStream("C:/test/file.txt")){
            byte[] bytes = new byte[inputStream.available()];
            inputStream.read(bytes);
            str = new String(bytes, StandardCharsets.UTF_16);
        }
        StringReader reader = new StringReader(str);
        First newFirst = mapper.readValue(reader, First.class);
        System.out.println(newFirst);
    }
}