package nick.pack;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    /*
    1. Ввести с консоли имя файла
    2. Считать все байты из файла.
    3. Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
    4. Вывести на экран
    5. Закрыть поток ввода-вывода
     */
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert path:");
        String path = scanner.nextLine();
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
