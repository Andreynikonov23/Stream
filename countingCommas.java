package nick.pack;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    /*
    1. С консоли считать имя файла
    2. Посчитать в файле количество символов ',', количество вывести на консоль
    3. Закрыть потоки. Не использовать try-with-resources
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
        int count = 0;
        for (int i = 0; i < bytes.size(); i++) {
            if (bytes.get(i) == 44){
                count++;
            }
        }
        System.out.println("Запятых в файле: " + count);
    }
}
