import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        FileInputStream stream = new FileInputStream("C://test/file.txt");
        byte[] bytes = new byte[stream.available()];
        stream.read(bytes);
        String str = new String(bytes, StandardCharsets.UTF_8);
        Scanner scanner = new Scanner(str);
        PersonalScanner personalScanner = new PersonalScannerAdapter(scanner);
        personalScanner.read();
    }
}