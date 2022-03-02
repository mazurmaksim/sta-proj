package net.students.accounting.processor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class XlSProcess implements XlSDataProcessor {
    private static final Logger LOGGER = LogManager.getLogger(XlSProcess.class);

    HSSFWorkbook workbook;
    HSSFSheet spreadsheet;
    HSSFRow row;

    @Override
    public byte[] process(Map<String, Object[]> dataMap) {
        workbook = new HSSFWorkbook();
        spreadsheet = workbook.createSheet(" Student Data ");
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        Set<String> keyid = dataMap.keySet();
        int rowid = 0;
        for (String key : keyid) {
            row = spreadsheet.createRow(rowid++);
            Object[] objectArr = dataMap.get(key);
            int cellid = 0;
            for (Object obj : objectArr) {
                Cell cell = row.createCell(cellid++);
                cell.setCellValue(obj.toString());
            }
        }
        try {
            workbook.write(byteArray);
        } catch (IOException e) {
            LOGGER.error("Can't write data to byte array", e);
        }
        return byteArray.toByteArray();
    }

    @Override
    public void saveXls(String fileName) {
        try {
            FileOutputStream out = new FileOutputStream(
                    fileName);
            workbook.write(out);
            out.close();
        } catch (Exception e) {
            LOGGER.error("Can't write XLS file", e);
        }
    }
}
