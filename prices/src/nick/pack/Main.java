package nick.pack;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("-----------------------------------------C:/test/file.txt/--------------------------------------");
        String path = "C://test/file.txt";
        ArrayList<Product> products = new ArrayList<>();
        FileInputStream inputStream = new FileInputStream(path);
        byte[] bytes = new byte[inputStream.available()];
        while (inputStream.available() > 0){
            inputStream.read(bytes);
        }
        String strData = new String(bytes, StandardCharsets.UTF_8);
        System.out.println(Arrays.toString(bytes));
        ArrayList<String> lines = new ArrayList<>(splitting(strData));
        Scanner scanner = new Scanner(System.in);
        System.out.print("C://test/file.txt~:  ");
        String command = scanner.nextLine();
    }
    public static ArrayList<String> splitting(String str){
        ArrayList<String> line = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(str, "\n");
        while (tokenizer.hasMoreTokens()){
           String elem = tokenizer.nextToken();
            elem = elem.trim();
            line.add(elem);
        }
        return line;
    }
    public static ArrayList<Product> conversion(ArrayList<String> lines){
        ArrayList<Product> products = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
            String id = lines.get(i).substring(0, 8);
            String name = lines.get(i).substring(8, 39);
            String price = lines.get(i).substring(39, 46);
            String quantity = lines.get(i).substring(46);
            Product product = new Product(id, name, price, quantity);
            products.add(product);
        }
        return products;
    }
    public static void execute(String command){

    }
}
