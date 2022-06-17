
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, ParseException {


        System.out.println("Begin");
        //Engine SearchEngine=new Engine("D:\\SearchEngineM\\blogs");//Add the path here
        //SearchEngine.createForwardIndex();//Calling method
        //SearchEngine.createReverseIndex();//Calling method

        //System.out.println("Ended");
        long startTime = System.nanoTime();
        Searching s=new Searching();
        s.readLexicon();

        s.readInvertedIndex();

        s.oneWord("my");
        //s.oneWord("that");
        //s.twoWord("my","that");
        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println("Time: "+totalTime);
        //System.out.println("Searching done!");
    }
}
