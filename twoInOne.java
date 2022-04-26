package nick.pack;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    /*
    1. Считать с консоли 3 имени файла
    2. Записать в первый файл содержимого второго файла,
        а потом дописать содержимое третьего файла
    3. Закрыть потоки. Не использовать try-with-resources
     */
    public static void main(String[] args) throws IOException {
        String file1 = "C://test/file.txt";
        String file2 = "C://test/file2.txt";
        String file3 = "C://test/file3.txt";
        FileOutputStream outputStream = new FileOutputStream(file1);
        FileInputStream file2InputStream = new FileInputStream(file2);
        FileInputStream file3InputStream = new FileInputStream(file3);
        while (file2InputStream.available() > 0){
            outputStream.write(file2InputStream.read());
        }
        file2InputStream.close();
        while (file3InputStream.available() > 0){
            outputStream.write(file3InputStream.read());
        }
        file3InputStream.close();
    }
}
