import java.io.File;
import java.util.List;

public interface Writer {
    void write(Person person, File file);
    void WriteList(List<Person> persons, File file);

}
