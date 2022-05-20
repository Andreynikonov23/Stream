import java.io.InputStream;
import java.io.Serializable;

public class Solution implements Serializable {
    private String info;
    transient private InputStream in = System.in;



    public Solution(String info){
        this.info = info;
    }
    public Solution(){

    }

    @Override
    public String toString(){
        return info;
    }
}
