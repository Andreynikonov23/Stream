package nick.pack;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main{
    /*
    Ввести с консоли имя файла
    Найти максимальный байт в файле, вывести его на экран.
    Закрыть поток ввода-вывода
     */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path = reader.readLine();
        ArrayList<Integer> bytes = new ArrayList<>();
        try(FileInputStream fileInputStream = new FileInputStream(path)) {
            while (fileInputStream.available() > 0){
                bytes.add(fileInputStream.read());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(bytes);
        int max = 0;
        for (int i = 0; i < bytes.size(); i++) {
            if (bytes.get(i) > max){
                max = bytes.get(i);
            }
        }
        System.out.println(max);
    }
}
