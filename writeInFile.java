package nick.pack;


import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    /*
    1. Прочесть с консоли имя файла.
    2. Считывать строки с консоли, пока пользователь не введет строку "exit".
    3. Вывести все строки в файл, каждую строчку с новой стороки.
     */
    public static void main(String[] args) throws IOException {
        System.out.println("Insert URL");
        Scanner scanner = new Scanner(System.in);
        Path path = Path.of("C:/test/test.txt");
        ArrayList<String> list = new ArrayList<>();
        while (true){
            String str = scanner.nextLine();
            if (str.equalsIgnoreCase("exit")){
                break;
            } else {
                list.add(str);
            }
        }
        try(Writer stream = new FileWriter(String.valueOf(path))){
            for (String str : list){
                stream.write(str + "\n");
            }
        }
    }
}
