import com.sun.org.apache.xerces.internal.xs.StringList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextParser {

    Person person = new Person();

    public Person getPerson(String line) {
        person.setName(getName(line));
        person.setId(Long.parseLong(getId(line)));
        List<String> job = new ArrayList<>();
        job.add(getJob(line));
        person.setJobs(job);
        person.setAge(Integer.parseInt(getAge(line)));
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getId(String line) {

        List<String> patterns = new ArrayList<>(); // Create an ArrayList object
        patterns.add("(?i)id\\s+is\\s+(\\d+)");
        patterns.add("(?i)with\\s+id\\s+(\\d+)");

        for (String pattern : patterns) {
            Pattern r = Pattern.compile(pattern);
            Matcher m = r.matcher(line);

            if (m.find()) {
                return m.group(1);
            }

        }
        return null;


    }

    public String getJob(String line) {


        List<String> patterns = new ArrayList<>(); // Create an ArrayList object
        patterns.add("(?i)am\\s+a\\s+([a-zA-Z]+)");
        patterns.add("(?i)\\s+as\\s+a\\s+([a-zA-Z]+)");
        patterns.add("(?i)job\\s+is\\s+([a-zA-Z]+)");

        for (String pattern : patterns) {
            Pattern r = Pattern.compile(pattern);
            Matcher m = r.matcher(line);

            if (m.find()) {
                return m.group(1);
            }

        }
        return null;


    }

    public String getAge(String line) {

        List<String> patterns = new ArrayList<>(); // Create an ArrayList object
        patterns.add("(?i)\\s+age\\s+(\\d+)");
        patterns.add("(?i)(\\d+)\\s+years\\s+old");

        for (String pattern : patterns) {
            Pattern r = Pattern.compile(pattern);
            Matcher m = r.matcher(line);

            if (m.find()) {
                return m.group(1);
            }

        }
        return null;


    }

    public String getName(String line) {
        List<String> patterns = new ArrayList<>(); // Create an ArrayList object
        patterns.add("(?i)(?:i\\s+am\\s+([a-zA-Z]{3,}))");
        patterns.add("(?i)name\\s+([a-zA-Z]{3,})");
        patterns.add("(?i)name\\s+is\\s+([a-zA-Z]+)");

        for (String pattern : patterns) {
            Pattern r = Pattern.compile(pattern);
            Matcher m = r.matcher(line);

            if (m.find()) {
                return m.group(1);
            }

        }
        return null;
    }
}
