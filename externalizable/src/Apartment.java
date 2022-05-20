import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Apartment implements Externalizable {
    private String address;
    private int height;
    private int weight;


    public Apartment(String address, int height, int weight){
        this.address = address;
        this.height = height;
        this.weight = weight;
    }
    public Apartment(){}

    @Override
    public String toString(){
        return address + " " + height + "x" + weight;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(address);
        out.writeInt(height);
        out.writeInt(weight);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        address = (String) in.readObject();
        height = in.readInt();
        weight = in.readInt();
    }
}
