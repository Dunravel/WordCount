package pl.sda.testsuite;

import java.util.Map;

class TestSuite {
    private TestScenarioValidator validator;

    TestSuite(TestScenarioValidator validator, AuthorAccess authorAccess, Map<Author, TestScenario> testScenarios){
        this.validator = validator;
    }

    void add(TestScenario testScenario, Author author) {

    }
}
