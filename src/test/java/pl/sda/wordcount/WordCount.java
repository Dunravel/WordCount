package pl.sda.wordcount;

import java.util.HashMap;
import java.util.Map;

public class WordCount {
    private Map<String,Integer> wordMap = new HashMap<>();


    public int count(String word){
        if(wordMap.containsKey(word)) {
            return wordMap.get(word);
        }
        return 0;
    }

    public void add(String word) {
        if(wordMap.containsKey(word)){
            wordMap.put(word,wordMap.get(word) + 1);
        }else {
            wordMap.put(word, 1);
        }


    }
}
