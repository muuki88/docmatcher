package de.mukis.docmatcher.csv;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import au.com.bytecode.opencsv.CSVReader;

public class CSVReaderTest {

    private CSVReader csvReader;

    @Before
    public void before() throws Exception {
        csvReader = new CSVReader(new InputStreamReader(getClass().getResourceAsStream("/csvreader.csv")), ';');
    }

    @After
    public void after() throws Exception {
        csvReader.close();
    }

    @Test
    public void testReadAll() throws IOException {
        List<String[]> lines = csvReader.readAll();
        assertEquals(3, lines.size());

        String[] heading = lines.get(0);
        assertEquals(heading[0], "col1");
        assertEquals(heading[1], "col2");
        assertEquals(heading[2], "col3");

        String[] row = lines.get(1);
        assertEquals(row[0], "1");
        assertEquals(row[1], "texty");
        assertEquals(row[2], "01-text");

        row = lines.get(2);
        assertEquals(row[0], "3");
        assertEquals(row[1], "tee");
        assertEquals(row[2], "02_text");
    }

    @Test
    public void testReadNext() throws IOException {
        String[] line = null;
        while ((line = csvReader.readNext()) != null) {
            assertTrue(line.length == 3);
        }
    }
}
