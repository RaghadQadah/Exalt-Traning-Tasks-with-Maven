import java.io.File;
import java.util.List;

public interface Reader {
    Person read(File file);
    List<Person> readList(File file);
}
