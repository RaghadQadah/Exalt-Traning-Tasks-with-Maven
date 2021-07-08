import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.nio.file.Paths;
import java.util.List;

public class JsonWriter implements Writer {

    @Override
    public void write(Person person, File file) {
        try {

            // create object mapper instance
            ObjectMapper mapper = new ObjectMapper();

            // convert object to JSON file

            mapper.writeValue((file), person);

        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }

    @Override
    public void WriteList(List<Person> persons, File file) {

        try {
            // create object mapper instance
            ObjectMapper mapper = new ObjectMapper();

            // convert object to JSON file
            mapper.writeValue(file,persons);

        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }

}