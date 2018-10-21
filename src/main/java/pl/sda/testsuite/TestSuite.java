package pl.sda.testsuite;

import java.util.Map;

class TestSuite {
    private final TestScenarioValidator validator;
    private AuthorAccess authorAccess;
    private Map<Author,TestScenario> testScenarios;

    TestSuite(TestScenarioValidator validator, AuthorAccess authorAccess, Map<Author, TestScenario> testScenarios){
        this.validator = validator;
        this.authorAccess = authorAccess;
        this.testScenarios = testScenarios;
    }

    void add(TestScenario testScenario, Author author) {
        testScenarios.put(author,testScenario);
    }
}
