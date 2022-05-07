package nick.pack;


import java.io.*;
import java.util.*;

public class Main {
    /*
    В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
    Реализуйте логику записи в файл и чтения из файла для карты properties.
     */
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert path:");
        File path = new File(scanner.nextLine());
        Properties properties = fillInPropertiesMap(String.valueOf(path));
        System.out.println("===============================" + path.getName() + "==========================================");
        for (Map.Entry entry : properties.entrySet()){
            String key = String.valueOf(entry.getKey());
            String value = String.valueOf(entry.getValue());
            System.out.println(key + "=" + value);
        }
        System.out.println();
        System.out.println();
        while (true){
            System.out.println("Insert name property: ");
            String key = scanner.nextLine();
            if (key.equalsIgnoreCase("exit")){
                break;
            }
            System.out.println("Insert value: ");
            String value = scanner.nextLine();
            if (value.equalsIgnoreCase("exit")){
                break;
            }
            properties.put(key, value);
        }
        properties.store(new FileWriter(path), "com");
        System.out.println("===============================" + path.getName() + "==========================================");
        for (Map.Entry entry : properties.entrySet()){
            String key = String.valueOf(entry.getKey());
            String value = String.valueOf(entry.getValue());
            System.out.println(key + "=" + value);
        }
        System.out.println();
        System.out.println();
    }
    public static Properties fillInPropertiesMap(String file) throws IOException {
        Properties properties = new Properties();
        FileInputStream inputStream = new FileInputStream(file);
        properties.load(inputStream);
        inputStream.close();
        return properties;
    }
}
