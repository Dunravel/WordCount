package pl.sda.wordcount;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WordCountTest {

    public static final String TEST_WORD = "test";
    private WordCount wordCount;

    @Before
    public void setUp() {

        wordCount = new WordCount();
    }

    @Test
    public void shouldCountReturnZeroForNewObject(){
        //given
        String word = TEST_WORD;

        //when
        int result = wordCount.count(word);

        //then


        Assert.assertEquals(0, result);
    }

    @Test
    public void shouldAddAddNewWordToObject(){
        //given
        String word = TEST_WORD;

        //when
        wordCount.add(word);

        //then
        Assert.assertEquals(1,wordCount.getSize());
    }
}
