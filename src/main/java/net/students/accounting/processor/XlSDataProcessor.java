package net.students.accounting.processor;

import java.util.Map;

public interface XlSDataProcessor {
    byte[] process(Map<String, Object[]> dataMap);
    void saveXls(String path);
}
