package de.mukis.docmatcher.csv.matcher;

import org.hamcrest.Description;
import org.hamcrest.Factory;

public class LessThan extends CsvElementMatcher {

    private final double value;

    private LessThan(double value) {
        this.value = value;
    }

    @Override
    protected boolean matchesSafelyToElement(String element) {
        return Double.valueOf(element) < value;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("less than ").appendValue(value);
    }

    @Factory
    public static CsvElementMatcher lessThan(double value) {
        return new LessThan(value);
    }

}
