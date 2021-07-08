import com.sun.org.apache.xerces.internal.xs.StringList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextParser {

    Person person=new Person();

    public Person getPerson(String line) {
        person.setName(getName(line));
        person.setId(Long.parseLong(getId(line)));
        List <String >job =new ArrayList<String>();
        job.add(getJob(line));
        person.setJobs(job);
        person.setAge(Integer.parseInt(getAge(line)));
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public  String getId(String line) {
        String pattern = "(?i)id\\s+is\\s+(\\d+)";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(line);

        String pattern1 = "(?i)with\\s+id\\s+(\\d+)";
        Pattern r1 = Pattern.compile(pattern1);
        Matcher m1 = r1.matcher(line);


        if (m.find()) {
            return m.group(1);
        }
        if (m1.find()) {
            return m1.group(1);
        }


        return null;
    }

    public  String getJob(String line) {
        String pattern = "(?i)am\\s+a\\s+([a-zA-Z]+)";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(line);

        String pattern1 = "(?i)\\s+as\\s+a\\s+([a-zA-Z]+)";
        Pattern r1 = Pattern.compile(pattern1);
        Matcher m1 = r1.matcher(line);

        String pattern2 = "(?i)job\\s+is\\s+([a-zA-Z]+)";
        Pattern r2 = Pattern.compile(pattern2);
        Matcher m2 = r2.matcher(line);

        if (m.find()) {
            return m.group(1);
        }
        if (m1.find()) {
            return m1.group();
        }
        if (m2.find()) {
            return m2.group(1);
        }

        return null;
    }

    public String getAge(String line) {
        String pattern = "(?i)age\\s+(\\d+)";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(line);

        String pattern1 = "(?i)(\\d+)\\s+years\\s+old";
        Pattern r1 = Pattern.compile(pattern1);
        Matcher m1 = r1.matcher(line);


        if (m.find()) {
            return m.group(1);
        }
        if (m1.find()) {
            return m1.group(1);
        }

        return null;
    }

    public String getName(String line) {
        String pattern = "(?i)(?:i\\s+am\\s+([a-zA-Z]{3,}))";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(line);

        String pattern1 = "(?i)name\\s+([a-zA-Z]{3,})";
        Pattern r1 = Pattern.compile(pattern1);
        Matcher m1 = r1.matcher(line);

        String pattern2 = "(?i)name\\s+is\\s+([a-zA-Z]+)";
        Pattern r2 = Pattern.compile(pattern2);
        Matcher m2 = r2.matcher(line);


        if (m.find()) {
            return m.group(1);
        }
        if (m1.find()) {
            return m1.group(1);
        }
        if (m2.find()) {
            return m2.group(1);
        }


        return null;
    }
}
