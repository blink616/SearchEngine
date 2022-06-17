
package com.company;
import java.util.ArrayList;
import java.util.HashMap;

public class Words {
  
    private HashMap<Integer, ArrayList<Integer>> wordList=new HashMap<Integer, ArrayList<Integer>>();//HashMap for Word,Count
    private int frequency;

    int position=0;//Position of word In document
    ArrayList<Integer> list=new ArrayList<Integer>();// ArrayList to store position and frequency
    Words(){
        this.frequency=1;
    }


    public void setHash(Integer words){

        position++;
        if(!wordList.containsKey(words))//If hashmap doesn't contain word , it will add into hashmap
        {
            frequency=1;
            list=new ArrayList<Integer>();
            list.add(position);
            list.add(0,frequency);
            wordList.put(words,list);
        }
        else
        {

           list=wordList.get(words);
           frequency=list.get(0);
           list.add(position);
            list.set(0,++frequency);
            wordList.put(words,list);//If hashmap already contains then it will simply increment the frequency
        }
    }
    public HashMap<Integer, ArrayList<Integer>> getHash(){//Returns the hashmap

    return wordList;
  }
}