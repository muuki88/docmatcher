package de.mukis.docmatcher.csv;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.rules.ExternalResource;

public class CsvRule extends ExternalResource {

    private final String file;
    private final char sep;

    private CsvDocument csv;

    public CsvRule(String file, char sep) {
        this.file = file;
        this.sep = sep;
    }

    @Override
    protected void before() throws Throwable {
        Path path = Paths.get(getClass().getClassLoader().getResource(file).toURI());
        csv = new CsvDocument(path, sep, Charset.defaultCharset());
    }

    @Override
    protected void after() {
        try {
            csv.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not close CsvReader.", e);
        }
    }

    public CsvDocument get() {
        return csv;
    }

}
