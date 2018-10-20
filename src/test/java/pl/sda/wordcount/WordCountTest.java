package pl.sda.wordcount;

import org.junit.Assert;
import org.junit.Test;

public class WordCountTest {

    @Test
    public void shouldCountReturnZeroForNewObject(){
        //given
        String word = "test";

        //when
        int result = new WordCount().count(word);

        //then


        Assert.assertEquals(0, result);
    }

    @Test
    public void shouldAddAddNewWordToObject(){
        //given
        String word = "test";

        //when
        WordCount result = new WordCount();
        result.add(word);

        //then
        Assert.assertEquals(1,result.wordMap.size());
    }
}
