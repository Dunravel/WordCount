package pl.sda.wordcount;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WordCountTest {

    private static final String TEST_WORD = "test";
    private WordCount wordCount;

    @Before
    public void setUp() {

        wordCount = new WordCount();
    }

    @Test
    public void shouldCountReturnZeroForNewObject(){
        //given

        //when
        int result = wordCount.count(TEST_WORD);

        //then


        Assert.assertEquals(0, result);
    }

    @Test
    public void shouldAddAddNewWordToObject(){
        //given

        //when
        wordCount.add(TEST_WORD);

        //then
        Assert.assertEquals(1,wordCount.getSize());
    }

    @Test
    public void sholuldChceck() {
    }
}
