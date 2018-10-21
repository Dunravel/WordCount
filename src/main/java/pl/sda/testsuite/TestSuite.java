package pl.sda.testsuite;

import java.util.Map;

class TestSuite {
    private final Map<Author,TestScenario> testScenarios;
    private final AuthorAccess authorAccess;
    private final TestScenarioValidator validator;

    TestSuite(TestScenarioValidator validator, AuthorAccess authorAccess, Map<Author, TestScenario> testScenarios){
        this.validator = validator;
        this.authorAccess = authorAccess;
        this.testScenarios = testScenarios;

    }

    void add(TestScenario testScenario, Author author) {
        if(authorAccess.hasPrivileges(author) && validator.isCorrect(testScenario)) {
            testScenarios.put(author, testScenario);
        }
    }
}
