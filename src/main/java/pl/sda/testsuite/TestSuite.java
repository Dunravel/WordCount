package pl.sda.testsuite;

import java.util.Map;

class TestSuite {
    private Map<Author,TestScenario> testScenarios;

    TestSuite(TestScenarioValidator validator, AuthorAccess authorAccess, Map<Author, TestScenario> testScenarios){
        this.testScenarios = testScenarios;
    }

    void add(TestScenario testScenario, Author author) {
        testScenarios.put(author,testScenario);
    }
}
