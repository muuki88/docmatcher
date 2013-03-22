package de.mukis.docmatcher.csv;

import static de.mukis.docmatcher.csv.Columns.columns;
import static de.mukis.docmatcher.csv.matcher.GreaterThan.greaterThan;
import static de.mukis.docmatcher.csv.matcher.LessThan.lessThan;
import static de.mukis.docmatcher.csv.matcher.Sum.sum;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;

public class SumTest {

    @Rule
    public CsvRule csv = new CsvRule("sum.csv", ';');

    @Test
    public void testSumLessThan() {
        assertThat(csv.get(), columns(0, 1).are(sum(lessThan(10.0))));
    }

    @Test
    public void testSumNotLessThan() {
        assertThat(csv.get(), not(columns(0, 1).are(sum(lessThan(2.0)))));
    }

    @Test
    public void testSumGreaterThan() {
        assertThat(csv.get(), columns(0, 1).are(sum(greaterThan(0.0))));
    }

    @Test
    public void testSumNotGreaterThan() {
        assertThat(csv.get(), not(columns(0, 1).are(sum(greaterThan(10.0)))));
    }

    @Test
    @Ignore("Not implemented yet")
    public void testSumEqualsTo() {
        assertThat(csv.get(), columns(0, 1).are(sum()));
    }
}
