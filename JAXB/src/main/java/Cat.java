import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlType
@XmlRootElement
public class Cat {
    @XmlAttribute
    public String name;
    @XmlAttribute
    public int age;
    @XmlAttribute
    public int weight;


    public Cat(){}



    @Override
    public String toString(){
        return String.format("name=%s, age=%d, weight=%d", name, age, weight);
    }
}
