import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextReader implements Reader {


    @Override
    public Person read(File file) {
        return null;
    }

    @Override
    public List<Person> readList(File file) {
        try
        {

            List<Person>PList=new ArrayList<Person>();
            FileReader fr=new FileReader(file);   //reads the file
            BufferedReader br=new BufferedReader(fr);  //creates a buffering character input stream
            StringBuffer sb=new StringBuffer();    //constructs a string buffer with no characters
            String line;
            while((line=br.readLine())!=null)
            {
                TextParser textParser=new TextParser();
                PList.add(textParser.getPerson(line));

            }

            fr.close();    //closes the stream and release the resources

            return PList;

        }



        catch(IOException e)
        {
            e.printStackTrace();
        }


        return null;
    }







}