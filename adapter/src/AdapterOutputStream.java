import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class AdapterOutputStream implements AmigoStringWriter {
    private FileOutputStream stream;



    public AdapterOutputStream(FileOutputStream stream){
        this.stream = stream;
    }
    @Override
    public void write(String str) throws IOException {
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        stream.write(bytes);
    }
}
