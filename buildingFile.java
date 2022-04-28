package nick.pack;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class Main {
    /*
    Собираем файл из кусочков
    Считывать с консоли имена файлов
    Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
    Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
    В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
    В него переписать все байты из файлов-частей используя буфер.
    Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
    Закрыть потоки. Не использовать try-with-resources
     */
    public static void main(String[] args) throws IOException {
        String build = "C://test/task10/lion.txt";
        HashMap<Integer, byte[]> map = new HashMap<>();
        FileInputStream inputStream = null;
        FileOutputStream outputStream = new FileOutputStream(build);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя файла");
        while (true) {
            String file = scanner.nextLine();
            if (file.equalsIgnoreCase("exit")) {
                break;
            }
            String path = "C://test/task10/" + file + ".txt";
            int part = Integer.parseInt(file.substring(file.length() - 1));
            inputStream = new FileInputStream(path);
            byte[] bytes = new byte[inputStream.available()];
            while (inputStream.available() > 0){
                inputStream.read(bytes);
            }
            map.put(part, bytes);
        }
        TreeMap<Integer, byte[]> treeMap = new TreeMap<>(map);
        for (Map.Entry<Integer, byte[]> entry : treeMap.entrySet()){
            outputStream.write(entry.getValue());
        }
    }
}
