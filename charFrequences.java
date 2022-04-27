package nick.pack;


import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Main {
    /*
    1. Программа запускается с одним параметром - именем файла, который содержит английский текст.
    2. Посчитать частоту встречи каждого символа.
    3. Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
    4. Вывести на консоль отсортированный результат:
        [символ1] частота1
        [символ2] частота2
    5. Закрыть потоки. Не использовать try-with-resources
     */
    public static void main(String[] args) throws IOException {
        String file1 = "C:/test/file.txt";
        FileInputStream inputStream = new FileInputStream(file1);
        byte[] bytes = new byte[inputStream.available()];
        while (inputStream.available() > 0){
            inputStream.read(bytes);
        }
        inputStream.close();
        for (int i = 0; i < bytes.length; i++) {
            for (int j = 0; j < bytes.length; j++) {
                if (bytes[i] < bytes[j]){
                    byte temp = bytes[i];
                    bytes[i] = bytes[j];
                    bytes[j] = temp;
                }
            }
        }
        String str = new String(bytes, StandardCharsets.UTF_8);
        char[] chars = str.toCharArray();
        ArrayList<String> list = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars.length; j++) {
                if (chars[i] == chars[j]){
                    count++;
                }
            }
            double result = (double) count / chars.length * 100;
            String format = String.format("%.0f", result);
            list.add(chars[i] + " " + format);
            count = 0;
        }
        for (int i = 0; i < list.size(); i++) {
            int j = i + 1;
            for (; j < list.size(); ) {
                if (list.get(i).equals(list.get(j))) {
                    list.remove(j);
                } else {

                    break;
                }
            }
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
