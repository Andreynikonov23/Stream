package nick.pack;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    /*
    1. В метод main первым параметром приходит имя файла.
    2. Посчитать количество букв английского алфавита, которое есть в этом файле.
    3. Вывести на экран число (количество букв)
    4. Закрыть потоки. Не использовать try-with-resources
     */
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь к файлу");
        String file1 = scanner.nextLine();
        ArrayList<Integer> bytes = new ArrayList<>();
        FileInputStream inputStream = new FileInputStream(file1);
        while (inputStream.available() > 0) {
            bytes.add(inputStream.read());
        }
        int count = 0;
        for (int i = 0; i < bytes.size(); i++){
            if (bytes.get(i) == 32){
                count++;
            }
        }
        System.out.println(count);
        double result = (double) count / bytes.size() * 100;
        String str = String.format("%.2f", result);
        System.out.println(str);
        inputStream.close();
    }
}
