import java.io.*;

public class Main {
    public static void main(String[] args) {
        Solution savedObject = new Solution("Hello");
        Solution loadedObject = new Solution();

        try(FileOutputStream outputStream = new FileOutputStream("file.bin")) {
            ObjectOutputStream out = new ObjectOutputStream(outputStream);
            out.writeObject(savedObject);
            out.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try(FileInputStream inputStream = new FileInputStream("file.bin")) {
            ObjectInputStream in = new ObjectInputStream(inputStream);
            loadedObject = (Solution) in.readObject();
            in.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println(savedObject.toString().equals(loadedObject.toString()));
    }
}