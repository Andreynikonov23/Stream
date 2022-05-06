import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        Считать в консоли 2 имени файла - file1, file2.
        Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
        Нужно создать объединенную версию строк, записать их в список lines
        Пример:
        [Файл 1]
        строка1
        строка2
        строка3

        [Файл 2]
        строка1
        строка3
        строка4

        [Результат - список lines]
        SAME строка1
        REMOVED строка2
        SAME строка3
        ADDED строка4
         */
        File file = new File("C://test/file.txt");
        File file2 = new File("C://test/file2.txt");
        ArrayList<String> dataFile1 = new ArrayList<>();
        ArrayList<String> dataFile2 = new ArrayList<>();
        Scanner scanner1 = new Scanner(file);
        Scanner scanner2 = new Scanner(file2);
        while (scanner1.hasNext()){
            String str1 = scanner1.next();
            dataFile1.add(str1);
        }
        while (scanner2.hasNext()){
            String str2 = scanner2.next();
            dataFile2.add(str2);
        }
        String[] arr = new String[dataFile2.size()];
        for (int i = 0; i < dataFile2.size(); i++) {
            for (int j = 0; j < dataFile1.size(); j++) {
                if (dataFile2.get(i).equals(dataFile1.get(j))){
                    String str = "SOME " + dataFile2.get(i);
                    arr[i] = str;
                }
            }
            if (!(dataFile1.contains(dataFile2.get(i)))){
                String str = "ADD " + dataFile2.get(i);
                arr[i] = str;
            }
        }
        ArrayList<String> removed = new ArrayList<>();
        for (int i = 0; i < dataFile1.size(); i++) {
            if (!(dataFile2.contains(dataFile1.get(i)))){
                removed.add("REMOVE " + dataFile1.get(i));
            }
        }
        ArrayList<String> result = new ArrayList<>();
        result.addAll(List.of(arr));
        result.addAll(removed);
        System.out.println(result);
    }
}
