import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        FileOutputStream stream = new FileOutputStream("C://test/file.txt");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert values:");
        String str = scanner.nextLine();
        AmigoStringWriter amigoStringWriter = new AdapterOutputStream(stream);
        amigoStringWriter.write(str);
        stream.close();
    }
}
