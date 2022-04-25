package nick.pack;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    /*
    1. С консоли считать имя файла
    2. Посчитать в файле количество символов ',', количество вывести на консоль
    3. Закрыть потоки. Не использовать try-with-resources
     */
    public static void main(String[] args) throws IOException {
        String file1 = "C:/test/file.txt";
        String file2 = "C:/test/file2.txt";
        String file3 = "C:/test/file3.txt";
        FileInputStream inputStream = new FileInputStream(file1);
        FileOutputStream file2Stream = new FileOutputStream(file2);
        FileOutputStream file3Stream = new FileOutputStream(file3);
        int c = 0;
        if (inputStream.available()%2 == 0){
            c = inputStream.available() / 2;
        } else {
            c = inputStream.available() / 2 + 1;
        }
        for (int i = 1; i <= c + c - 1; i++) {
            if (i <= c){
                file2Stream.write(inputStream.read());
            } else {
                file3Stream.write(inputStream.read());
            }
        }
        inputStream.close();
        file2Stream.close();
        file3Stream.close();
    }
}
