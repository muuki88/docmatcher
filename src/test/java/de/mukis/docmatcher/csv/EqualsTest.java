package de.mukis.docmatcher.csv;

import static de.mukis.docmatcher.csv.Columns.columns;
import static de.mukis.docmatcher.csv.matcher.Equals.equal;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Rule;
import org.junit.Test;

public class EqualsTest {

    @Rule
    public CsvRule csv = new CsvRule("equals.csv", ';');

    @Test
    public void testEqualsMultiColumn() {
        assertThat(csv.get(), columns(0, 1).are(equal()));
    }

    @Test
    public void testNotEqualsMultipleColumn() {
        assertThat(csv.get(), not(columns(1, 2).are(equal())));
    }

    @Test
    public void testNotEqualsMultipleColumnFail() {
        assertThat(csv.get(), not(columns(0, 2).are(equal())));
    }
}
