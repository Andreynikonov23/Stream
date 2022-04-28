package nick.pack;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Main {
    /*
    Программа запускается с одним из следующих наборов параметров:
        -e fileName fileOutputName
        -d fileName fileOutputName
    где
    fileName - имя файла, который необходимо зашифровать/расшифровать
    fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
    -e - ключ указывает, что необходимо зашифровать данные
    -d - ключ указывает, что необходимо расшифровать данные
     */
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.print("C:\\Users\\xxxkeep\\IdeaProjects\\untitled\\src\\nick\\pack\\Main.class\\:  ");
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("exit"))
                break;

            executeCommand(command);
        }
    }
    public static void executeCommand(String command) throws IOException {
        while (true){
            if (command.lastIndexOf(" ") == command.length() - 1){
                command = command.substring(0, command.length() - 1);
            } else break;
        }
        int lastSpace = command.lastIndexOf(" ");
        String com = command.substring(0, 2);
        String file = command.substring(3, lastSpace);
        String ex = command.substring(lastSpace + 1);
        FileInputStream inputStream = new FileInputStream(file);
        int available = inputStream.available();
        byte[] bytes = new byte[available];
        while (inputStream.available() > 0){
            inputStream.read(bytes);
        }
        inputStream.close();
        if (com.equalsIgnoreCase("-e")){
            if (ex.equalsIgnoreCase("FileInputStream")){
                String str = new String(encoding(bytes), StandardCharsets.UTF_8);
                System.out.println(str);
            }
            if (ex.equalsIgnoreCase("FileOutputStream")){
                FileOutputStream outputStream = new FileOutputStream(file);
                outputStream.write(encoding(bytes));
                outputStream.close();
            }
        }
        if (com.equalsIgnoreCase("-d")){
            if(ex.equalsIgnoreCase("FileInputStream")){
                String str = new String(decoding(bytes), StandardCharsets.UTF_8);
                System.out.println(str);
            }
            if (ex.equalsIgnoreCase("FileOutputStream")){
                FileOutputStream outputStream = new FileOutputStream(file);
                outputStream.write(decoding(bytes));
                outputStream.close();
            }
        }
    }
    public static byte[] encoding(byte[] bytes){
        byte[] encodingBytes = bytes;
        for (int i = 0; i < encodingBytes.length; i++) {
            encodingBytes[i] = (byte) (encodingBytes[i] + 5);
        }
        return encodingBytes;
    }
    public static byte[] decoding(byte[] bytes){
        byte[] decodingBytes = bytes;
        for (int i = 0; i < decodingBytes.length; i++) {
            decodingBytes[i] = (byte) (decodingBytes[i] -5);
        }
        return decodingBytes;
    }
}
