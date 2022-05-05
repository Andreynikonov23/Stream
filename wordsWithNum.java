package nick.pack;


import java.io.*;
import java.util.*;

public class Main {
    /*
    В метод main первым параметром приходит имя файла1, вторым - файла2.
    Файл1 содержит слова, разделенные пробелом.
    Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d Закрыть потоки. Не использовать try-with-resources
     */
    public static void main(String[] args) throws IOException {
        File file = new File("C://test/file3.txt");
        File file2 = new File("C://test/file2.txt");
        FileWriter writer = new FileWriter(file2);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()){
            String str = scanner.next();
            for (int i = 0; i < 10; i++) {
                String c = String.valueOf(i);
                if (str.contains(c)){
                    writer.write(str + " ");
                    break;
                }
            }
        }
        writer.close();
    }
}
