package nick.pack;


import java.io.*;
import java.util.*;

public class Main {
    /*
    Считать с консоли 2 имени файла.
    Первый Файл содержит текст.
    Заменить все точки "." на знак "!", вывести во второй файл.
    Закрыть потоки. Не использовать try-with-resources.
     */
    public static void main(String[] args) throws IOException {
        File file = new File("C://test/file3.txt");
        File file2 = new File("C://test/file2.txt");
        FileInputStream inputStream = new FileInputStream(file);
        char[] chars = new char[inputStream.available()];
        inputStream.close();
        FileReader reader = new FileReader(file);
        reader.read(chars);
        reader.close();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '.'){
                chars[i] = '!';
            }
        }
        FileWriter writer = new FileWriter(file2);
        writer.write(chars);
        writer.close();
    }
}
