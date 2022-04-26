import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class QuestionOutputStream extends AmigoOutputStream{
    public QuestionOutputStream(String name) throws FileNotFoundException {
        super(name);
    }
    @Override
    public void close() throws IOException {
        System.out.println("Вы действительно хотите закрыть поток? Д/Н");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        if (str.equalsIgnoreCase("Д")){
            super.close();
            System.out.println("Поток закрыт");
        } else if (str.equalsIgnoreCase("Н")) {
            System.out.println("Поток не закрыт");
            return;
        }
    }
}
