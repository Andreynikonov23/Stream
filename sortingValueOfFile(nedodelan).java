package nick.pack;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;

public class Main{
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Character> list = new ArrayList<>();
        Path path = Path.of("C:/test/test.txt");
        try (InputStream reader = new FileInputStream(String.valueOf(path))) {
            while (reader.available() > 0) {
                list.add((char) reader.read());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == '\n' ) {
                list.remove(list.get(i));
            }
        }
        Collections.sort(list);
        System.out.println(list);
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            strings.add(String.valueOf(list.get(i)));
        }
        System.out.println(strings);
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < strings.size(); i++) {
            integers.add(Integer.valueOf(strings.get(i)));
        }
        System.out.println(integers);
        for (int i = 0; i < integers.size(); i++) {
            if (integers.get(i)%2 == 0){
                System.out.print(integers.get(i) + " ");
            }
        }
    }
}
