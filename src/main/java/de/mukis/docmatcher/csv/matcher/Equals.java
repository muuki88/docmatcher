package de.mukis.docmatcher.csv.matcher;

import org.hamcrest.Description;
import org.hamcrest.Factory;

import de.mukis.docmatcher.csv.CsvDocument;

public class Equals extends CsvRowMatcher {

    private String watchedValue;

    private Equals() {
    }

    @Override
    protected boolean matchesSafelyToRow(String[] line, int row) {
        // Cannot compare less than two lines
        // TODO create warning here
        if (columns().get().length <= 1) {
            return true;
        }

        int[] cols = columns().get();
        for (int col : cols) {
            watchedValue = line[col];
            for (int col2 : cols) {
                if (!watchedValue.equals(line[col2])) {
                    setError(row, col, line[col2]);
                    return false;
                }
            }
        }

        return true;
    }

    @Override
    public void describeTo(Description description) {
        description.appendValue(watchedValue);
    }

    @Override
    protected void describeMismatchSafely(CsvDocument item, Description mismatchDescription) {
        super.describeMismatchSafely(item, mismatchDescription);
    }

    @Factory
    public static CsvRowMatcher equal() {
        return new Equals();
    }

}
