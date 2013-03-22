package de.mukis.docmatcher.csv;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;

import au.com.bytecode.opencsv.CSVReader;

public class CsvDocument {

    private CSVReader csvReader;
    private final Path csv;
    private final Charset cs;

    public CsvDocument(Path csv, char sep, Charset cs) throws IOException {
        this.csv = csv;
        this.cs = cs;
        checkArgument(Files.exists(checkNotNull(csv, "csv cannot be null")), "File does not exists");
        csvReader = new CSVReader(Files.newBufferedReader(csv, cs), sep);
    }

    /**
     * Reads with the system default charset and ; as separator
     * 
     * @param csv
     * @throws IOException
     */
    public CsvDocument(Path csv) throws IOException {
        this(csv, ';', Charset.defaultCharset());
    }

    /**
     * 
     * @return next line or null if EOF is reached
     * @throws IOException
     */
    public String[] readNext() throws IOException {
        return csvReader.readNext();
    }

    /**
     * Resets the csv document to read from the beginning
     * 
     * @throws IOException
     */
    public void reset() throws IOException {
        close();
        csvReader = new CSVReader(Files.newBufferedReader(csv, cs));
    }

    public void close() throws IOException {
        csvReader.close();
    }

}
