package nick.pack;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ProductFabric implements CRUD{
    private ArrayList<Product> products = new ArrayList<>();


    public ProductFabric(ArrayList<Product> products){
        this.products = products;
    }
    @Override
    public void create() {


        try(FileOutputStream outputStream = new FileOutputStream(Main.PATH)){
            for (int i = 0; i < products.size(); i++) {
                outputStream.write(products.get(i).getBytes());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }
}
