package pl.sda.testsuite;

//funkcjonalności:
// void Add(Test Scenario, Author)
// 1) Sprawdzić poprawność scenariusza
// 2) Sprawdzić czy autor ma prawa do dodania scenariusza
// 3) Jeżeli jeden i dwa są ok, dodać scenariusz
// 4) Co zrobić jak nie dodam?


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;

public class TestsSuiteTest {

    private static final TestScenario TEST_SCENARIO = new TestScenario();
    private static final Author AUTHOR = new Author();
    private TestScenarioValidator validator;
    private AuthorAccess authorAccess;
    private Map<Author, TestScenario> testScenarios;
    private TestSuite testSuite;

    @Before
    public void setUp(){

        validator = Mockito.mock(TestScenarioValidator.class);
        authorAccess = Mockito.mock(AuthorAccess.class);
        testScenarios = new HashMap<>();
        testSuite = new TestSuite(validator, authorAccess, testScenarios);
    }

    @Test
    public void shouldAddTestScenario() {
        //given

        BDDMockito.given(validator.isCorrect(ArgumentMatchers.any(TestScenario.class))).willReturn(true);

        BDDMockito.given(authorAccess.hasPrivileges(ArgumentMatchers.any(Author.class))).willReturn(true);

        //when
        testSuite.add(TEST_SCENARIO, AUTHOR);

        //then
        Assert.assertTrue(testScenarios.containsKey(AUTHOR));
        Assert.assertTrue(testScenarios.containsValue(TEST_SCENARIO));
    }
    @Test
    public void shouldNotAddTestScenarioWhenAuthorHasNoPrivileges() {
        //given

        //given correct test scenario
        BDDMockito.given(validator.isCorrect(ArgumentMatchers.any(TestScenario.class))).willReturn(true);

        //given author with privileges
        BDDMockito.given(authorAccess.hasPrivileges(ArgumentMatchers.any(Author.class))).willReturn(false);


        //given test suite
        TestSuite testSuite = new TestSuite(validator,authorAccess,testScenarios);

        //when
        testSuite.add(TEST_SCENARIO, AUTHOR);

        //then
        Assert.assertTrue(testScenarios.isEmpty());
    }


//    private TestScenario givenTestScenarioIsCorrect() {
//        TestScenarioValidator validator = Mockito.mock(TestScenarioValidator.class);
//        BDDMockito.given(validator.isCorrect(ArgumentMatchers.any(TestScenario.class))).willReturn(true);
//
//        return new TestScenario();
//    }
}
