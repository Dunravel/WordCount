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
        TestScenario testScenario = new TestScenario();

        BDDMockito.given(authorAccess.hasPrivileges(ArgumentMatchers.any(Author.class))).willReturn(true);
        Author author = new Author();

        //when
        testSuite.add(testScenario, author);

        //then
        Assert.assertTrue(testScenarios.containsKey(author));
        Assert.assertTrue(testScenarios.containsValue(testScenario));
    }
    @Test
    public void shouldNotAddTestScenarioWhenAuthorHasNoPrivileges() {
        //given

        //given correct test scenario
        TestScenarioValidator validator = Mockito.mock(TestScenarioValidator.class);
        BDDMockito.given(validator.isCorrect(ArgumentMatchers.any(TestScenario.class))).willReturn(true);
        TestScenario testScenario = new TestScenario();

        //given author with privileges
        AuthorAccess authorAccess = Mockito.mock(AuthorAccess.class);
        BDDMockito.given(authorAccess.hasPrivileges(ArgumentMatchers.any(Author.class))).willReturn(false);
        Author author = new Author();

        Map<Author,TestScenario> testScenarios = new HashMap<>();

        //given test suite
        TestSuite testSuite = new TestSuite(validator,authorAccess,testScenarios);

        //when
        testSuite.add(testScenario, author);

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
