import java.io.*;

public class Main {
    public static void main(String[] args) {
        Apartment apartment = new Apartment("п. Сосновское, ул. Ленина, д.60", 35, 40);
        Apartment apartment1 = new Apartment();

        try(FileOutputStream outputStream = new FileOutputStream("file.txt")) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            apartment.writeExternal(objectOutputStream);
            objectOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try(FileInputStream inputStream = new FileInputStream("file.txt")) {
            ObjectInputStream in = new ObjectInputStream(inputStream);
            apartment1.readExternal(in);
            in.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println(apartment1);
    }
}