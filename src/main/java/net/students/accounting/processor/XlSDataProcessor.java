package net.students.accounting.processor;

import java.nio.file.Path;

public interface XlSDataProcessor {
    byte[] process();
    void saveXls(Path path);
}
