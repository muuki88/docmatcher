package de.mukis.docmatcher.csv.matcher;

import org.hamcrest.Description;
import org.hamcrest.Factory;

public class EqualsTo extends CsvElementMatcher {

    private final String value;

    private EqualsTo(String value) {
        this.value = value;
    }

    @Override
    protected boolean matchesSafelyToElement(String element) {
        return element.equals(value);
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("equals to ").appendValue(value);
    }

    @Factory
    public static CsvElementMatcher equalsTo(String value) {
        return new EqualsTo(value);
    }

}
