import java.io.*;

public class Main {
    public static void main(String[] args) {
        Human human = new Human(1, "Bob");
        Human human1 = new Human(2, "Mike");
        Human human2 = new Human();
        Human human3 = new Human();

       try(FileOutputStream outputStream = new FileOutputStream("file.txt")) {
           ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
           objectOutputStream.writeObject(human);
           objectOutputStream.writeObject(human1);
           objectOutputStream.close();
       } catch (IOException e) {
           throw new RuntimeException(e);
       }
       try(FileInputStream inputStream = new FileInputStream("file.txt")) {
           ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
           human2 = (Human) objectInputStream.readObject();
           human3 = (Human) objectInputStream.readObject();
           objectInputStream.close();
       } catch (IOException e) {
           throw new RuntimeException(e);
       } catch (ClassNotFoundException e) {
           throw new RuntimeException(e);
       }
        System.out.println(human2);
        System.out.println(human3);
    }
}