package pl.sda.testsuite;

import java.util.Map;

class TestSuite {
    private final Map<Author,TestScenario> testScenarios;
    private final AuthorAccess authorAccess;

    TestSuite(TestScenarioValidator validator, AuthorAccess authorAccess, Map<Author, TestScenario> testScenarios){
        this.authorAccess = authorAccess;
        this.testScenarios = testScenarios;
    }

    void add(TestScenario testScenario, Author author) {
        if(authorAccess.hasPrivileges(author)) {
            testScenarios.put(author, testScenario);
        }
    }
}
