import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class PersonalScannerAdapter implements PersonalScanner {
    private Scanner scanner;


    public PersonalScannerAdapter(Scanner scanner){
        this.scanner = scanner;
    }
    @Override
    public void read() throws IOException {
        int i = 1;
        while (scanner.hasNext()){
            System.out.println(i + ": " + scanner.nextLine());
            i++;
        }
    }
}
