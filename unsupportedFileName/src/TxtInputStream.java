import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TxtInputStream {
    public TxtInputStream(String path){
        StringBuilder builder = new StringBuilder(path);
        int end = path.length();
        int start = builder.lastIndexOf(".");
        String file = builder.substring(start, end);

        if (file.equals(".txt")){
            try(FileInputStream fileInputStream = new FileInputStream(path)) {
                while (fileInputStream.available() > 0){
                    System.out.print(fileInputStream.read());
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else
            try {
                throw new unsupportedFileName("unsupportedFileName");
            } catch (unsupportedFileName e) {
                e.printStackTrace();
            }
    }
}
