package pl.sda.wordcount;

import java.util.HashMap;
import java.util.Map;

public class WordCount {
    private Map<String,Integer> wordMap = new HashMap<>();

    public int getSize() {
        return wordMap.size();
    }

    public int count(String word){
        if(!wordMap.containsKey(word)) {
            return 0;
        }
        return -1;
    }

    public void add(String word) {


    }
}
