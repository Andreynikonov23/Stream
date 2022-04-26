package nick.pack;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    /*
    1. Считать с консоли 2 имени файла: файл1, файл2.
    2. Записать в файл2 все байты из файл1, но в обратном порядке
    3. Закрыть потоки. Не использовать try-with-resources
     */
    public static void main(String[] args) throws IOException {
        String file1 = "C:/test/file.txt";
        String file2 = "C:/test/file2.txt";
        ArrayList<Integer> bytes = new ArrayList<>();
        FileInputStream inputStream = new FileInputStream(file1);
        FileOutputStream outputStream = new FileOutputStream(file2);
        while (inputStream.available() > 0){
            bytes.add(inputStream.read());
        }
        Collections.reverse(bytes);
        for (int i = 0; i < bytes.size(); i++) {
            outputStream.write(bytes.get(i));
        }
        inputStream.close();
        outputStream.close();
    }
}
