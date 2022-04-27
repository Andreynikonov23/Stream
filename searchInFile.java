package nick.pack;


import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    /*
    1. Считать с консоли имя файла
    2. Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
    3. Программа запускается с одним параметром: id (int)
    4. Закрыть потоки. Не использовать try-with-resources
    В файле данные разделены пробелом и хранятся в следующей последовательности:
    id productName price quantity
    где id - int
    productName - название товара, может содержать пробелы, String
    price - цена, double
    quantity - количество, int
    Информация по каждому товару хранится в отдельной строке
     */
    public static void main(String[] args) throws IOException {
        String file1 = "C:/test/file.txt";
        FileInputStream inputStream = new FileInputStream(file1);
        byte[] bytes = new byte[inputStream.available()];
        while (inputStream.available() > 0){
            inputStream.read(bytes);
        }
        inputStream.close();
        String str = new String(bytes, StandardCharsets.UTF_8);
        ArrayList<String> arrayList = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(str);
        while (tokenizer.hasMoreTokens()){
            arrayList.add(tokenizer.nextToken("\n"));
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id");
        int id = Integer.parseInt(scanner.nextLine());
        String strId = String.valueOf(id);
        boolean isFalse = false;
        for (int i = 0; i < arrayList.size(); i++) {
            int firstSpace = arrayList.get(i).indexOf(" ");
            String idStr = arrayList.get(i).substring(0, firstSpace);
            String value = arrayList.get(i).substring(firstSpace + 1);
            if (strId.equals(idStr)){
                System.out.println(value);
                isFalse = true;
            }
        }
        if (isFalse == false){
            System.out.println("Ничего не найдено");
        }
    }
}
