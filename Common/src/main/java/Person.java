import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Arrays;
import java.util.Random;

@XmlRootElement
public class Person {
    //@XmlElement(name = "personId")
    private long id;
    private String name;
    private int age;
    private List<String> jobs;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getJobs() {
        return jobs;
    }

    public void setJobs(List<String> jobs) {
        this.jobs = jobs;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", jobs=" + jobs +
                '}';
    }

    public String printFormated() {

        Random r = new Random();
        int index= r.nextInt(5);


        List<String> format=new ArrayList<>();
        format.add("I am "+name+", I am a "+jobs.get(0)+" of age "+age+", My ID is "+id+"\n");
        format.add("The person with id "+id+" have a name "+name+" is working as a "+jobs.get(0)+", he is "+age+" years old.\n");
        format.add("My name is "+name+", My ID is "+id+", I am a "+jobs.get(0)+" of "+age+" years old \n");
        format.add("I am "+name+" with age "+age+", my job is "+jobs.get(0)+" with id "+id+"\n");
        format.add("My ID is "+id+", I am "+name+", I am "+age+" years old,  I am working as a "+jobs.get(0)+"\n");

        return format.get(index);
    }
}
