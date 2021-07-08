import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class TextWriter implements Writer{
    @Override
    public void write(Person person, File file) {

    }

    @Override
    public void WriteList(List<Person> persons, File file) {

        try {
            FileWriter myWriter = new FileWriter(file.getPath());
            String s="";
            for (Person temp : persons) {
              s=s+temp.printFormated();
            }
            myWriter.write(s);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
}
