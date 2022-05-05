import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        Считать с консоли 2 имени файла.
        Первый Файл содержит текст.
        Удалить все знаки пунктуации, вывести во второй файл.
         */
        File file = new File("C://test/file.txt");
        File file2 = new File("C://test/file2.txt");

        FileInputStream inputStream = new FileInputStream(file);
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes);
        inputStream.close();
        String str = new String(bytes, StandardCharsets.UTF_8);
        char[] chars = str.toCharArray();
        ArrayList<Character> characters = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            characters.add(chars[i]);
        }
        FileWriter writer = new FileWriter(file2);
        for(int i = 0; i < characters.size(); i++){
            if (characters.get(i) != '.' && characters.get(i) != ',' && characters.get(i) != ':'&&
            characters.get(i) != ';' && characters.get(i) != '!' && characters.get(i) != '?' && characters.get(i) != '-'){
                writer.write(characters.get(i));
            }
        }
        writer.close();
        Scanner scanner = new Scanner(file2);
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            System.out.println(line);
        }
    }
}
