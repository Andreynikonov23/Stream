package nick.pack;


import java.io.*;
import java.util.*;

public class Main {
    /*
    Считать с консоли 2 имени файла.
    Вывести во второй файл все байты с четным индексом.
     */
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("first file:");
        File file = new File(scanner.nextLine());
        System.out.println("second file");
        File file2 = new File(scanner.nextLine());
        ArrayList<Integer> list = new ArrayList<>();
        try(FileReader reader = new FileReader(file)){
            while (reader.ready()){
                list.add(reader.read());
            }
        }
        try(FileWriter writer = new FileWriter(file2)){
            for (int i = 0; i < list.size(); i++) {
                if (i%2 == 0){
                    writer.write(list.get(i));
                }
            }
        }
    }
}
