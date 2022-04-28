package nick.pack;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
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
        while (true) {
            String file = scanner.nextLine();
            if (file.equals("exit")){
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
                for (int i = 0; i < bytes.size(); i++) {
                    for (int j = i + 1; j < bytes.size();) {
                        if (bytes.get(i) == bytes.get(j)){
                            count++;
                            bytes.remove(j);
                        } else
                            j++;
                    }
                    counts.add(count);
                    count = 1;
                }
                int max = 0;
                int value = 0;
                for (int i = 0; i < counts.size(); i++) {
                    if (max < counts.get(i)){
                        max = counts.get(i);
                        value = bytes.get(i);
                    }
                }
                System.out.println(bytes);
                System.out.println(counts);
                resultMap.put(file + ".txt", value);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(resultMap);
    }
}