import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        В метод main первым параметром приходит имя файла.
        В этом файле каждая строка имеет следующий вид:
        имя значение
        где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

        Для каждого имени посчитать сумму всех его значений
        Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени.
        Закрыть потоки. Не использовать try-with-resources
         */
        File file = new File("C://test/file.txt");
        FileInputStream inputStream = new FileInputStream(file);
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes);
        inputStream.close();
        ArrayList<String> values = new ArrayList<>();
        String data = new String(bytes, StandardCharsets.UTF_8);
        Scanner scanner = new Scanner(data);
        while (scanner.hasNextLine()){
            String str = scanner.nextLine();
            values.add(str);
        }
        System.out.println(values);
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < values.size(); i++) {
            Scanner sub = new Scanner(values.get(i));
            String name = sub.next();
            String name2;
            double d2;
            double d = Double.parseDouble(sub.next());
            for (int j = i + 1; j < values.size(); j++) {
                Scanner sub2 = new Scanner(values.get(j));
                name2 = sub2.next();
                d2 = Double.parseDouble(sub2.next());
                if (name.equals(name2)) {
                    d = d+d2;
                    values.remove(j);
                    j--;
                }
            }
            result.add(name + " " + d);
        }
        System.out.println(result);
    }
}
