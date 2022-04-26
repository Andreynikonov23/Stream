import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class AmigoOutputStream extends FileOutputStream {
    public AmigoOutputStream(String name) throws FileNotFoundException {
        super(name);
    }
    @Override
    public void close() throws IOException {
        flush();
        String str = "\nJavaRush © 2012-2013 All rights reserved.";
        ByteArrayInputStream bytes = new ByteArrayInputStream(str.getBytes());
        while (bytes.available() > 0){
            write(bytes.readAllBytes());
        }
        super.close();
    }
}
