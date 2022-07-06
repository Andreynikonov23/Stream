import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import java.io.StringWriter;

public class Main {
    public static void main(String[] args) throws JAXBException {
        Cat cat = new Cat();
        cat.name = "Murzik";
        cat.age = 3;
        cat.weight = 4;
        StringWriter writer = new StringWriter();

        JAXBContext context = JAXBContext.newInstance(Cat.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        marshaller.marshal(cat, writer);
        System.out.println(writer);
    }
}
