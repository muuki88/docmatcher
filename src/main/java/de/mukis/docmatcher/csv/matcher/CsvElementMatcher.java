package de.mukis.docmatcher.csv.matcher;

import java.io.IOException;

import de.mukis.docmatcher.csv.CsvDocument;

public abstract class CsvElementMatcher extends CsvMatcher {

    @Override
    protected boolean matchesSafely(CsvDocument doc) {
        try {
            String[] line = doc.readNext();
            int row = 0;
            while ((line = doc.readNext()) != null) {
                for (Integer col : columns().get()) {
                    if (!matchesSafelyToElement(line[col])) {
                        setError(row, col, line[col]);
                        return false;
                    }
                }
                row++;
            }
            return true;
        } catch (IOException e) {
            throw new RuntimeException("Cannot match due to IO error.", e);
        }
    }

    abstract protected boolean matchesSafelyToElement(String element);

}
