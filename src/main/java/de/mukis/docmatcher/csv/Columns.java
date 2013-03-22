package de.mukis.docmatcher.csv;

import java.util.Arrays;
import java.util.Objects;

import de.mukis.docmatcher.csv.matcher.CsvMatcher;

public class Columns {

    private final int[] columns;

    private Columns(int[] columns) {
        this.columns = columns;
    }

    public static Columns columns(int first, int second, int... columns) {
        int[] cols = new int[2 + columns.length];
        cols[0] = first;
        cols[1] = second;
        System.arraycopy(columns, 0, cols, 2, columns.length);
        return new Columns(cols);
    }

    public static Columns column(int col) {
        return new Columns(new int[] { col });
    }

    public CsvMatcher are(CsvMatcher matcher) {
        matcher.setColumns(this);
        return matcher;
    }

    public CsvMatcher is(CsvMatcher matcher) {
        return are(matcher);
    }

    public int[] get() {
        return columns;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Arrays.hashCode(columns);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Columns other = (Columns) obj;
        return Objects.deepEquals(columns, other.columns);
    }

}
