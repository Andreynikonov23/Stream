import java.io.Serializable;

public class Human implements Serializable {
    private int id;
    private String name;

    public Human(int id, String name){
        this.id = id;
        this.name = name;
    }
    public Human(){}

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        return id + ": " + name;
    }
}
