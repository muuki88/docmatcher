package de.mukis.docmatcher.csv;

import static de.mukis.docmatcher.csv.Columns.column;
import static de.mukis.docmatcher.csv.Columns.columns;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import de.mukis.docmatcher.csv.Columns;

public class ColumnsTest {

    @Test
    public void testColumns() {
        Columns columns = Columns.columns(3, 4);
        assertArrayEquals(new int[] { 3, 4 }, columns.get());

        columns = Columns.columns(3, 4, 5, 6, 7);
        assertArrayEquals(new int[] { 3, 4, 5, 6, 7 }, columns.get());
    }

    @Test
    public void testColumn() {
        Columns column = Columns.column(1);
        assertArrayEquals(new int[] { 1 }, column.get());
    }

    @Test
    public void testEquals() {
        assertEquals(column(3), column(3));
        assertEquals(columns(3, 4), columns(3, 4));
        assertEquals(columns(3, 4, 5), columns(3, 4, 5));

    }

    @Test
    public void testNotEquals() {
        assertNotEquals(column(0), column(1));
        assertNotEquals(columns(3, 4, 5), columns(3, 4));
        assertNotEquals(columns(3, 4, 5), columns(3, 4, 5, 6));
    }
}
