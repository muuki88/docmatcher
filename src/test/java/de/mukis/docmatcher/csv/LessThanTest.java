package de.mukis.docmatcher.csv;

import static de.mukis.docmatcher.csv.Columns.column;
import static de.mukis.docmatcher.csv.Columns.columns;
import static de.mukis.docmatcher.csv.matcher.LessThan.lessThan;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Rule;
import org.junit.Test;

import de.mukis.docmatcher.csv.CsvRule;

public class LessThanTest {

    @Rule
    public CsvRule csv = new CsvRule("lessthan.csv", ';');

    @Test
    public void testLessThanOneColumn() {
        assertThat(csv.get(), column(0).is(lessThan(4.0)));
    }

    @Test
    public void testLessThanOneColumn2() {
        assertThat(csv.get(), column(1).is(lessThan(0.0)));
    }

    @Test
    public void testLessThanTwoColumn() {
        assertThat(csv.get(), columns(0, 1).are(lessThan(4.0)));
    }

    @Test
    public void testNotLessThanOneColumn() {
        assertThat(csv.get(), not(column(0).is(lessThan(0.0))));
    }

    @Test
    public void testNotLessThanTwoColumn() {
        assertThat(csv.get(), not(columns(0, 1).are(lessThan(1.0))));
    }

}
