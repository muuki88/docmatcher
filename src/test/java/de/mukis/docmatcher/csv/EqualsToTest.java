package de.mukis.docmatcher.csv;

import static de.mukis.docmatcher.csv.Columns.column;
import static de.mukis.docmatcher.csv.Columns.columns;
import static de.mukis.docmatcher.csv.matcher.EqualsTo.equalsTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Rule;
import org.junit.Test;

import de.mukis.docmatcher.csv.CsvRule;

public class EqualsToTest {

    @Rule
    public CsvRule csv = new CsvRule("equals.csv", ';');

    @Test
    public void testEqualsOneIntColumn() {
        assertThat(csv.get(), column(0).is(equalsTo("1")));
    }

    @Test
    public void testEqualsStringOneColumn() {
        assertThat(csv.get(), column(2).is(equalsTo("text")));
    }

    @Test
    public void testEqualsMultiColumn() {
        assertThat(csv.get(), columns(0, 1).are(equalsTo("1")));
    }

    @Test
    public void testNotEqualsOneColumn() {
        assertThat(csv.get(), not(column(0).is(equalsTo("2"))));
    }

    @Test
    public void testNotEqualsMultipleColumn() {
        assertThat(csv.get(), not(columns(1, 2).are(equalsTo("1"))));
    }
}
