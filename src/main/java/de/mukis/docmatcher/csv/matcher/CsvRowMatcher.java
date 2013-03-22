package de.mukis.docmatcher.csv.matcher;

import java.io.IOException;

import de.mukis.docmatcher.csv.CsvDocument;

public abstract class CsvRowMatcher extends CsvMatcher {

    @Override
    protected boolean matchesSafely(CsvDocument doc) {
        try {
            String[] line = doc.readNext();
            int row = 0;
            while ((line = doc.readNext()) != null) {
                if (!matchesSafelyToRow(line, row)) {
                    return false;
                }
                row++;
            }
            return true;
        } catch (IOException e) {
            throw new RuntimeException("Cannot match due to IO error.", e);
        }
    }

    /**
     * Clients must call the setError method to provide meaningful error
     * messages.
     * 
     * @param line - line content
     * @param row - current row
     * @return false on failure
     */
    abstract protected boolean matchesSafelyToRow(String[] line, int row);

}
