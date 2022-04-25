package nick.pack;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    /*
    1. Ввести с консоли имя файла
    2. Найти байт или байты с минимальным количеством повторов
    3. Вывести их на экран через пробел
    4. Закрыть поток ввода-вывода
     */
    public static void main(String[] args){
        String path = "C:/test/file.txt";
        ArrayList<Integer> bytes = new ArrayList<>();
        try(FileInputStream inputStream = new FileInputStream(path)){
            while (inputStream.available() > 0){
                bytes.add(inputStream.read());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(bytes + " -- size: " + bytes.size());
        int count = 1;
        ArrayList<Integer> counts = new ArrayList<>();
        ArrayList<Integer> repeatByte = new ArrayList<>();
        for (int i = 0; i < bytes.size(); i++) {
            for (int j = 0; j < bytes.size(); j++) {
                if (bytes.get(i) == (bytes.get(j)) && i != j) {
                    count++;
                }
                if (j == bytes.size() -1){
                    counts.add(count);
                    repeatByte.add(bytes.get(i));
                    count = 1;
                }
            }
        }

        for (int i = 0; i < repeatByte.size(); i++) {
            for (int j = 1; j < repeatByte.size(); j++) {
                if (repeatByte.get(i) == repeatByte.get(j)){
                    repeatByte.remove(j);
                    counts.remove(j);
                }
            }
        }
        System.out.println(counts);
        System.out.println(repeatByte);
        ArrayList<Integer> integers = new ArrayList<>();
        int minCount = repeatByte.get(0);
        for (int i = 0; i < counts.size(); i++) {
            if (counts.get(i) < minCount){
                minCount = counts.get(i);
            }
        }
        for (int i = 0; i < repeatByte.size(); i++) {
            if (counts.get(i) == minCount){
                System.out.println("Byte: " + repeatByte.get(i) + ", repeating - " + counts.get(i));
            }
        }

    }
}
