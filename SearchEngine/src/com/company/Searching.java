import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Searching {

    private HashMap<Integer,HashMap<Integer, ArrayList<Integer>>> invertedIndex=new HashMap<>();
    private HashMap<String,Integer> wordID;
    ObjectMapper om=new ObjectMapper();



    public void readLexicon() {

        try {
            JSONObject obj = (JSONObject) parser.parse(new FileReader("D:\\SearchEngineM\\Lexicons.json"));
            wordID=om.readValue(String.valueOf(obj),new TypeReference<HashMap<String, Integer>>(){});
            System.out.println("Lexicon hashmap created!");

        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

    public void readInvertedIndex() {

        try {

            JSONObject obj = (JSONObject) parser.parse(new FileReader("D:\\SearchEngineM\\reverseIndex.json"));
            invertedIndex=om.readValue(String.valueOf(obj),new TypeReference<HashMap<Integer,HashMap<Integer, ArrayList<Integer>>>>(){});
            System.out.println("Inverted Index hashmap created!");
        }
        catch(Exception e){
            e.printStackTrace();
        }


        public Stack<Integer> sortByFrequency(HashMap<Integer, ArrayList<Integer>> h1)
    {
        Stack<Integer> dispdoc = new Stack<>();//stack which displays documents in correct order (order of freq)

        for (Map.Entry<Integer, ArrayList<Integer>> entry : h1.entrySet()) //for each document and its list
        {

            Integer docnum = entry.getKey(); //document number
            Stack<Integer> temp = new Stack<>();
            int freq = h1.get(docnum).get(0); //freq of word in this doc
            if (!dispdoc.isEmpty()) //sort doc in ascending order of freq and push in stack
            {
                while (!dispdoc.isEmpty() && h1.get(dispdoc.peek()).get(0) > freq) //compare freq of topmost doc in stack with freq of current doc
                    temp.push(dispdoc.pop());
                dispdoc.push(docnum);
                while (!temp.isEmpty())
                    dispdoc.push(temp.pop());
            }
            else
                dispdoc.push(docnum);

        }//end foreach loop
        System.out.println(dispdoc);

        return dispdoc;
    }

    public void oneWord(String word) throws IOException {
        //add condition if word does not exist
        int key = wordID.get(word); //load from lexicon file
        System.out.println(key);
        HashMap<Integer, ArrayList<Integer>>  docwithlist=new HashMap<>();
        docwithlist = invertedIndex.get(key);// hashamp contains doc against list (freq,pos), loaded from file
        System.out.println(docwithlist);
        Stack<Integer> dispdoc = new Stack<>();//stack which displays documents in correct order (order of freq)
        dispdoc=sortByFrequency(docwithlist);
        System.out.println(dispdoc);

    }

    /*public void twoWord(String w1,String w2) throws IOException {
        Stack<Integer> s1=oneWord(w1);
        Stack<Integer> temp=s1;
        Stack<Integer> s2=oneWord(w2);
        Stack<Integer> dispdoc;
        temp.retainAll(s2); //contains common docs

    }*/

}
