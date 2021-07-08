import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.List;

public class XmlWriter implements Writer {
    @Override
    public void write(Person person,File file) {
        try
        {
            //Create JAXB Context
            JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);

            //Create Marshaller
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            //Required formatting??
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            //Writes XML file to file-system
            jaxbMarshaller.marshal(person,(file));
        }
        catch (JAXBException e)
        {
            e.printStackTrace();
        }

    }



    @Override
    public void WriteList(List<Person>persons, File file) {
        try
        {
            PersonList pList = new PersonList();
                        //Create JAXB Context
            pList.setPersonList(persons);
            JAXBContext jaxbContext = JAXBContext.newInstance(PersonList.class);

            //Create Marshaller
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            //Required formatting??
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            //Writes XML file to file-system
            jaxbMarshaller.marshal(pList, file);
        }
        catch (JAXBException e)
        {
            e.printStackTrace();
        }

    }


    }

