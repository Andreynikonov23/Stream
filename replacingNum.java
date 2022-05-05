package nick.pack;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Main {
    /*
    1. В статическом блоке инициализировать словарь map парами [число-слово] от 0 до 12 включительно
        Например, 0 - "ноль", 1 - "один", 2 - "два"
    2. Считать с консоли имя файла
    3. Заменить все числа на слова используя словарь map
    4. Результат вывести на экран
    5. Закрыть потоки. Не использовать try-with-resources
     */
    public static void main(String[] args) throws IOException {
        File file = new File("C://test/file2.txt");
        HashMap<String, Integer> map = new HashMap<>();
        map.put("ноль", 0);
        map.put("один", 1);
        map.put("два", 2);
        map.put("три", 3);
        map.put("четыре", 4);
        map.put("пять", 5);
        map.put("шесть", 6);
        map.put("семь", 7);
        map.put("восемь", 8);
        map.put("девять", 9);
        map.put("десять", 10);
        map.put("одинадцать", 11);
        map.put("двенадцать",12);
        FileInputStream inputStream = new FileInputStream(file);
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes);
        inputStream.close();
        String data = new String(bytes, StandardCharsets.UTF_8);
        data = data.replaceAll("\\.", " .");
        data = data.replaceAll(",", " ,");
        data = data.replaceAll("!", " !");
        FileWriter writer = new FileWriter(file);
        Scanner scanner = new Scanner(data);
        while (scanner.hasNext()) {
            String str = scanner.next();
            for (Map.Entry entry : map.entrySet()){
                String key = String.valueOf(entry.getKey());
                int value = (int) entry.getValue();
                if (str.equals(String.valueOf(value))){
                    str = key;
                }
            }
            writer.write(str + " ");
        }
        writer.close();
    }
}
