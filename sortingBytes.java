package nick.pack;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

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
        Collections.sort(bytes);
        int j = 1;
        for (int i = 0; i < bytes.size(); i++) {
            for (; j < bytes.size();) {
                if (bytes.get(i) == bytes.get(j)){
                    bytes.remove(j);
                } else{
                    j++;
                    break;
                }
            }
        }
        System.out.println(bytes);
    }
}
