package nick.pack;


import java.io.*;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("C:\\Users\\Андрей\\Pictures\\test\\test.txt");
        try(FileOutputStream output = new FileOutputStream(String.valueOf(path))){
            output.write(23);
        }
        try(FileInputStream input = new FileInputStream(String.valueOf(path))){
            System.out.println(input.read());
        }
    }
}


