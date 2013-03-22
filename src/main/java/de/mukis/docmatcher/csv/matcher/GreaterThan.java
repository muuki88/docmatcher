package de.mukis.docmatcher.csv.matcher;

import org.hamcrest.Description;
import org.hamcrest.Factory;

public class GreaterThan extends CsvElementMatcher {

    private final double value;

    private GreaterThan(double value) {
        this.value = value;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("greater than ").appendValue(value);
    }

    @Override
    protected boolean matchesSafelyToElement(String element) {
        return Double.valueOf(element) > value;
    }

    @Factory
    public static CsvElementMatcher greaterThan(double value) {
        return new GreaterThan(value);
    }

}
