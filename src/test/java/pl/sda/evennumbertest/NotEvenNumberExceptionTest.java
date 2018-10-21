package pl.sda.evennumbertest;

import org.junit.Assert;
import org.junit.Test;

public class NotEvenNumberExceptionTest {
    @Test
    public void shouldReturnMessageNumber() {
        //given
        int number = 17;

        //when
        String message =  new NotEvenNumberException(number).getMessage();


        //then
        Assert.assertEquals("Given number is not even: 17",message);
    }
}