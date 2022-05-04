package nick.pack;


import java.io.*;
import java.util.*;

public class Main {
    /*
    Считать с консоли имя файла.
    Файл содержит слова, разделенные знаками препинания.
    Вывести в консоль количество слов "world", которые встречаются в файле.
     */
    public static void main(String[] args) throws IOException {
       File file = new File("C://test/file3.txt");
       Scanner scanner = new Scanner(file);
       int count = 0;
       while (scanner.hasNext()){
           String next = scanner.next();
           System.out.println(next);
           if (next.contains("world") || next.contains("World")){
               count++;
           }
       }
        System.out.println("Слово 'World' встречается: " + count + " раз");
    }
}
