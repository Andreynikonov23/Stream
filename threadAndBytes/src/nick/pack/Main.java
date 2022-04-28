package nick.pack;

public class Main {

    public static void main(String[] args) {
        ReadThread readThread = new ReadThread();
        Thread thread = new Thread(readThread);
        thread.start();
    }
}
