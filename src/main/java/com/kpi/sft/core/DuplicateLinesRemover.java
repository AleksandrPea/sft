package com.kpi.sft.core;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Collection;

import static org.apache.commons.io.FileUtils.readLines;
import static org.apache.commons.io.FileUtils.writeLines;

public class DuplicateLinesRemover {

    private CollectionsComplementor<String> complementor;

    private DuplicateLinesRemover(CollectionsComplementor<String> complementor) {
        this.complementor = complementor;
    }

    public static DuplicateLinesRemover createRemoverWithBaseFile(String baseFilePath) throws IOException {
        File baseFile = new File(baseFilePath);
        CollectionsComplementor<String> complementor =
            new CollectionsComplementor<String>(readLines(baseFile, Charset.defaultCharset()));
        return new DuplicateLinesRemover(complementor);
    }

    public Collection<String> refine(String filePath) throws IOException {
        File file = new File(filePath);
        return complementor.findComplementFor(readLines(file, Charset.defaultCharset()));
    }

    public void writeLinesTo(String filePath, Collection<String> lines, boolean append) throws IOException {
        File file = new File(filePath);
        writeLines(file, lines, append);
    }
}
