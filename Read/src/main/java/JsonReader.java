import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.nio.file.Paths;
import java.util.List;

public class JsonReader implements Reader {
    @Override
    public Person read(File file) {

        try {
            // create object mapper instance
            ObjectMapper mapper = new ObjectMapper();

            // convert JSON string to Person object
            Person person = mapper.readValue((file), Person.class);

            // print book
            System.out.println(person.toString());

            return person;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;

    }

//
//    @Override
//    public Person read(File file) {
//        return null;
//    }

    @Override
    public List<Person> readList(File file) {
        try {
            // create object mapper instance
            ObjectMapper mapper = new ObjectMapper();

            // convert JSON string to Person object
            //  Person person = mapper.readValue(file, Person.class);
            List<Person> person = mapper.readValue(file, new TypeReference<List<Person>>() {
            });


            //System.out.println(person.toString());
            return person;


        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
