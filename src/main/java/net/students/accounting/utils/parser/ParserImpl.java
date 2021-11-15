package net.students.accounting.utils.parser;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
public class ParserImpl implements Parser{

    File document = new File("/xls/Форма-1ДФ-4-кв-2021.xls");

    @Override
    public void parse() {
        try {
            FileInputStream fis = new FileInputStream(document);
            HSSFWorkbook wb = new HSSFWorkbook(fis);
            HSSFSheet sheet=wb.getSheetAt(0);

            for(Row row: sheet)     //iteration over row using for each loop
            {

            }

            } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
