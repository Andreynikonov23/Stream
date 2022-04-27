import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class ReadThread implements Runnable{
    private final HashMap<String, Integer> resultMap = new HashMap<>();
    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> counts = new ArrayList<>();
        System.out.println("Введите имена файлов:");
        FileInputStream inputStream = null;
        while (true){
            String file = scanner.nextLine();
            if (file.equalsIgnoreCase("exit")){
                break;
            }
            String path = "C://test/" + file + ".txt";
            try {
                inputStream = new FileInputStream(path);
                ArrayList<Integer> bytes = new ArrayList<>();
                while (inputStream.available() > 0){
                    bytes.add(inputStream.read());
                }
                inputStream.close();
                int count = 1;
                ArrayList<Byte> temp = new ArrayList<>();
                for (int i = 0; i < bytes.size(); i++) {
                    for (int j = i + 1; j < bytes.size(); j++) {
                        if (bytes.get(i) == bytes.get(j)){
                            count++;
                        }
                    }
                    counts.add(count);
                    count = 1;
                }
                System.out.println(bytes);
                System.out.println(counts);
                int max = 0;
                int value = 0;
                for (int i = 0; i < counts.size(); i++) {
                    if (counts.get(i) > max){
                        max = counts.get(i);
                    }
                }
                for (int i = 0; i < bytes.size(); i++) {
                    for (int j = 0; j < bytes.size(); j++) {
                        if (bytes.get(i) == bytes.get(j) && i != j){
                            bytes.remove(j);
                            counts.remove(j);
                        }
                    }
                }
                System.out.println(bytes);
                System.out.println(counts);
                System.out.println(max);
                System.out.println(value);
                resultMap.put(file, value);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(resultMap);
    }
}
