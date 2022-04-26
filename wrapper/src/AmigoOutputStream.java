import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class AmigoOutputStream extends FileOutputStream {
    public AmigoOutputStream(String name) throws FileNotFoundException {
        super(name);
    }
}
