package de.mukis.docmatcher.csv.matcher;

import java.util.Arrays;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

import de.mukis.docmatcher.csv.Columns;
import de.mukis.docmatcher.csv.CsvDocument;

public abstract class CsvMatcher extends TypeSafeMatcher<CsvDocument> {

    private Columns columns;

    private int[] errorRows = {};
    private int[] errorCols = {};
    private String errorRowContent = "";

    @Override
    protected void describeMismatchSafely(CsvDocument item, Description mismatchDescription) {
        mismatchDescription.appendText("was ").appendValue(errorRowContent) //
                .appendText("\n on rows ") //
                .appendValue(Arrays.toString(errorRows)) //
                .appendText(" columns ") //
                .appendValue(Arrays.toString(errorCols));
    }

    /**
     * Use this to display more information on error
     * 
     * @param row
     * @param col
     * @param content - the wrong value
     */
    protected void setError(int[] row, int[] cols, String content) {
        errorRows = row;
        errorCols = cols;
        errorRowContent = content;
    }

    /**
     * Use this to display more information on error
     * 
     * @param row
     * @param col
     * @param content - the wrong value
     */
    protected void setError(int row, int col, String content) {
        setError(new int[] { row }, new int[] { col }, content);
    }

    protected void setError(int row, String[] content) {
        setError(new int[] { row }, new int[] {}, Arrays.toString(content));
    }

    public void setColumns(Columns columns) {
        this.columns = columns;
    }

    public Columns columns() {
        return columns;
    }

}
