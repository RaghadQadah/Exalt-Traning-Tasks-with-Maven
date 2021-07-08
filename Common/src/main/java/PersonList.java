import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;
@XmlRootElement
public class PersonList  {
    List<Person> PersonList;

    public List<Person> getPersonList() {
        return PersonList;
    }

    @XmlElement(name = "person")
    public void setPersonList(List<Person> personList) {
        this.PersonList = personList;
    }

    public void add(Person person) {
        if (this.PersonList == null) {
            this.PersonList = new ArrayList<Person>();
        }
        this.PersonList.add(person);
    }
}