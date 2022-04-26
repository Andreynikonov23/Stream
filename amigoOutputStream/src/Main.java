import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String path = "C://test/file.txt";
        AmigoOutputStream outputStream = new AmigoOutputStream(path);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите что-нибудь");
        String str = scanner.nextLine();
        ByteArrayInputStream bytes = new ByteArrayInputStream(str.getBytes());
        while (bytes.available() > 0){
            outputStream.write(bytes.readAllBytes());
        }
        outputStream.close();
    }
}
