package nick.pack;


import java.io.FileInputStream;
import java.io.IOException;

public class Main {
    /*
    1. Считать с консоли 2 имени файла: файл1, файл2.
    2. Записать в файл2 все байты из файл1, но в обратном порядке
    3. Закрыть потоки. Не использовать try-with-resources
     */
    public static void main(String[] args) throws IOException {
        String file1 = "C:/test/file.txt";
        FileInputStream inputStream = new FileInputStream(file1);
        if (inputStream.available() < 1000){
            inputStream.close();
            try {
                throw new DownloadException("the file is less than 1000 bytes");
            } catch (DownloadException e) {
                e.printStackTrace();
            }
        } else
            System.out.println("File correct!");

    }
}
