import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String path = "C://test/file.txt";
        AmigoOutputStream amigoOutputStream = new QuestionOutputStream(path);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите что-нибудь");
        String str = scanner.nextLine();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes());
        while (byteArrayInputStream.available() > 0){
            amigoOutputStream.write(byteArrayInputStream.readAllBytes());
        }
        amigoOutputStream.close();
    }
}