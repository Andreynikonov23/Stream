package nick.pack;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    /*
    1. Считать с консоли 3 имени файла
    2. Записать в первый файл содержимого второго файла,
        а потом дописать содержимое третьего файла
    3. Закрыть потоки. Не использовать try-with-resources
     */
    public static void main(String[] args) throws IOException {
        String file1 = "C://test/file.txt";
        String file2 = "C://test/file2.txt";
        ArrayList<Integer> arrayList = new ArrayList<>();
        FileInputStream fileInputStream = new FileInputStream(file1);
        while (fileInputStream.available() > 0){
            arrayList.add(fileInputStream.read());
        }
        fileInputStream.close();
        System.out.println(arrayList);
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) == 46){
                int j = i;
                for (; j < arrayList.size();) {
                    if (arrayList.get(j) != 10){
                        arrayList.remove(j);
                    } else if (arrayList.get(j) == 10) {
                        
                        break;
                    }
                }
            }
        }
        System.out.println(arrayList);
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        for (int i = 0; i < arrayList.size(); i++) {
            fileOutputStream.write(arrayList.get(i));
        }
        fileOutputStream.close();
    }
}
