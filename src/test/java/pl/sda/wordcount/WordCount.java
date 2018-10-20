package pl.sda.wordcount;

import java.util.HashMap;
import java.util.Map;

class WordCount {
    private Map<String, Integer> wordMap = new HashMap<>();


    int count(String word) {
        if (wordMap.containsKey(word)) {
            return wordMap.get(word);
        }
        return 0;
    }

    void add(String word) {
        if (wordMap.containsKey(word)) {
            wordMap.put(word, wordMap.get(word) + 1);
        } else {
            wordMap.put(word, 1);
        }
    }
}
