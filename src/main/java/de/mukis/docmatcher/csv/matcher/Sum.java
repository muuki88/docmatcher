package de.mukis.docmatcher.csv.matcher;

import org.hamcrest.Description;
import org.hamcrest.Factory;

public class Sum extends CsvRowMatcher {

    private final CsvElementMatcher decorator;

    private Sum(CsvElementMatcher decorator) {
        this.decorator = decorator;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("Sum of ");
        decorator.describeTo(description);
    }

    @Override
    protected boolean matchesSafelyToRow(String[] line, int row) {
        Double sum = 0.0;
        for (Integer col : columns().get()) {
            sum += Double.valueOf(line[col]);
        }
        // Matching
        if (!decorator.matchesSafelyToElement(sum.toString())) {
            setError(new int[] { row }, columns().get(), sum.toString());
            return false;
        }
        return true;
    }

    @Factory
    public static CsvRowMatcher sum() {
        return new Sum(null);
    }

    @Factory
    public static CsvRowMatcher sum(CsvElementMatcher matcher) {
        return new Sum(matcher);
    }
}
