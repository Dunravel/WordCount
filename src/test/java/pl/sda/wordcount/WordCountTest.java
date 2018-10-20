package pl.sda.wordcount;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WordCountTest {

    private static final String TEST_WORD = "test";
    private static final String DOG_WORD = "dog";
    private WordCount wordCount;

    @Before
    public void setUp() {

        wordCount = new WordCount();
    }

    @Test
    public void shouldCountReturnZeroForNewObject() {
        //given

        //when
        int result = wordCount.count(TEST_WORD);

        //then
        Assert.assertEquals(0, result);
    }

    @Test
    public void shouldAddAddNewWordToObject() {
        //given

        //when
        wordCount.add(TEST_WORD);

        //then
        Assert.assertEquals(1, wordCount.count(TEST_WORD));
    }

    @Test
    public void shouldCountReturnTwoWhenAddedSameWordTwice() {
        //given

        //when
        wordCount.add(TEST_WORD);
        wordCount.add(TEST_WORD);

        //then
        Assert.assertEquals(2, wordCount.count(TEST_WORD));

    }

    @Test
    public void shouldCountReturn1WhenAddedTwoDifferentWords() {
        //given

        //when
        wordCount.add(TEST_WORD);
        wordCount.add(DOG_WORD);

        //then
        Assert.assertEquals(1, wordCount.count(TEST_WORD));
    }

    @Test
    public void shouldCountReturnTwoWhenAddedTwoSameAndOneDifferentWords() {
        //given

        //when
        wordCount.add(TEST_WORD);
        wordCount.add(DOG_WORD);
        wordCount.add(TEST_WORD);

        //then
        Assert.assertEquals(2, wordCount.count(TEST_WORD));
        Assert.assertEquals(1,wordCount.count(DOG_WORD));
    }

    @Test
    public void shouldCountReturn0WhenAddedEmptyString(){
        //given

        //when
        wordCount.add("");

        //then
        Assert.assertEquals(0, wordCount.count(""));
    }
}
