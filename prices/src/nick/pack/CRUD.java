package nick.pack;

import java.io.FileNotFoundException;

public interface CRUD {
    void create() throws FileNotFoundException;
    void update();
    void delete();
}
