import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

public class XmlReader implements Reader {
    @Override
    public Person read(File file) {

        // File xmlFile = new File(fileName);

        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(Person.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Person person = (Person) jaxbUnmarshaller.unmarshal((file));

            System.out.println(person.toString());
            return person;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public  List<Person> readList(File file) {
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(PersonList.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            PersonList pList = (PersonList) jaxbUnmarshaller.unmarshal(file);
            List<Person> p=pList.getPersonList();
            //System.out.println(pList.toString());
//            for (Person temp : p){
//                System.out.println(temp.toString());
//            }
            return p;

        } catch (JAXBException e) {
            e.printStackTrace();

        }
        return null;
    }
}