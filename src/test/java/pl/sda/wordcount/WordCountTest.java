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
}
