package nick.pack;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Path in file");
        String file = scanner.nextLine();
        System.out.println("seek");
        String seekStr = scanner.nextLine();
        System.out.println("text");
        String text = scanner.nextLine();
        int seek = Integer.parseInt(seekStr);
        try(RandomAccessFile raf = new RandomAccessFile(file, "rw");){
            if (raf.length() > seek){
                raf.seek(seek);
                raf.writeBytes(text);
            } else {
                raf.seek(raf.length() - 1);
                raf.writeBytes(text);
            }
        }catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
