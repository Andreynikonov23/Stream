package nick.pack;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    /*
    1. Читайте с консоли имена файлов
    2. Если файла не существует (передано неправильное имя файла), то
        перехватить исключение FileNotFoundException, вывести в консоль переданное неправильное имя файла и завершить работу программы
    3. Закрыть потоки. Не использовать try-with-resources
    4. Не используйте System.exit()
     */
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь к файлу");

        while (true){
            String path = scanner.nextLine();
            if (path.equalsIgnoreCase("exit")){
                break;
            }
            int slash = path.lastIndexOf("/") + 1;
            String file = path.substring(slash);
            FileInputStream inputStream = null;
            try{
                inputStream = new FileInputStream(path);
                ArrayList<Integer> bytes = new ArrayList<>();
                while (inputStream.available() > 0){
                    bytes.add(inputStream.read());
                }
                System.out.println(bytes);
                inputStream.close();
            } catch (FileNotFoundException e){
                System.err.println("Файл " + file + " не найден");
            }
        }
    }
}
