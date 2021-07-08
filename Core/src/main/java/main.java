import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class main {

    public static void main(String[] args) {
        Person person = new Person();
        person.setAge(22);
        person.setId(2);
        person.setName("RaghadBQ");
        person.setJobs(Arrays.asList("Student"));


        Person person1 = new Person();
        person1.setAge(11);
        person1.setId(1);
        person1.setName("RBQ");
        person1.setJobs(Arrays.asList("Student"));

        List<Person>PList=new ArrayList<Person>();
        PList.add(person);
        PList.add(person1);


//
WriteFactory writerFactory=new WriteFactory();
        Writer writer =writerFactory.getwriter("JSON");
        writer.write(person,new File("output.json"));

//
        ReadFactory readerFactory=new ReadFactory();
        Reader reader =readerFactory.getReader("JSON");
        reader.read(new File("output.json"));



       Writer writer11 =writerFactory.getwriter("XML");
       writer11.write(person,new File("output.xml"));
       Reader reader1 =readerFactory.getReader("XML");
       reader1.read(new File("output.xml"));


        System.out.println("\nList Read & Write \n");



        Writer listWriter =writerFactory.getwriter("JSON");
        Reader listReader =readerFactory.getReader("JSON");
        listWriter.WriteList(PList,new File("output.json"));
        System.out.println(listReader.readList(new File("output.json")));




        Reader listReader1 =readerFactory.getReader("XML");
        Writer listWriter1 =writerFactory.getwriter("XML");
        listWriter1.WriteList(PList,new File("output.xml"));
        System.out.println(listReader1.readList(new File("output.xml")));
//
        System.out.println("\nText Read & Write \n");

        Writer listWriter2 =writerFactory.getwriter("TEXT");
        listWriter2.WriteList(PList,new File("input.txt"));

        Reader listReader2 =readerFactory.getReader("TEXT");
        System.out.println(listReader2.readList(new File("input.txt")));



    }
}
