[![Build Status](https://travis-ci.org/muuki88/docmatcher.png?branch=master)](https://travis-ci.org/muuki88/docmatcher)
## Document Matcher

This project aims to provide some easy-to-use [Hamcrest Matchers](https://code.google.com/p/hamcrest/wiki/Tutorial)
for a set of file types including

* CSV
* Excel
* JSON
* XML

## Getting Started

Take a look at all the test. They are basically the _HowTo_ use.
However you get a taste of what it looks like.

```csv
col1;col2;col3
1;-1;0
2;-2;0
3;-3;0
```

To test this file in various ways we can do this

```java
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
```

## Note

The csv rule is only able to run through the csv document once. This will
change in the next versions. A better way to configure the read options
for documents will be added, too.

