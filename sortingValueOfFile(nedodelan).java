package nick.pack;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;

public class Main{
    public static void main(String[] args) throws FileNotFoundException { 
        ArrayList<Character> list = new ArrayList<>();
        ArrayList<String> data = new ArrayList<>();
        Path path = Path.of("C:/test/test.txt");
        try (InputStream reader = new FileInputStream(String.valueOf(path))) {
            while (reader.available() > 0) {
                list.add((char) reader.read());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == '\n'){
                list.set(i, '-');
            }
        }
        System.out.println(list);
        ArrayList<String> temp = new ArrayList<>();
            for (int i = 0, j=1; i < list.size(); i++, j++) {
                if (list.get(i) != '-') {
                    if (list.get(j) != '-'){
                        data.add(String.valueOf(list.get(i)) + String.valueOf(list.get(j)));
                    } else data.add(String.valueOf(list.get(i)));
                }
            }
        System.out.println(data);
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            integers.add(Integer.valueOf(data.get(i)));
        }
        Collections.sort(integers);
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < integers.size(); i++) {
            if (integers.get(i) %2 == 0){
                result.add(integers.get(i));
            }
        }
        System.out.println(result);
    }
}
