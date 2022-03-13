package nick.pack;


import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        ArrayList<Character> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert URL");
        Path path = Path.of(scanner.nextLine());
        try(InputStream stream = new FileInputStream(String.valueOf(path))){
            System.out.println(path.getFileName());
            while (stream.available() > 0){
                list.add((char) stream.read());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (char c : list){
            System.out.print(c);
        }
    }
}
