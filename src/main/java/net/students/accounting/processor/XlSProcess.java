package net.students.accounting.processor;

import net.students.accounting.dao.StudentRepository;
import net.students.accounting.mapper.StudentDataMapper;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.annotation.Resource;
import java.nio.file.Path;

public class XlSProcess implements XlSDataProcessor {

    StudentDataMapper mapper;
    StudentRepository repository;
    XSSFWorkbook workbook;
    XSSFSheet spreadsheet;
    XSSFRow row;

    @Override
    public byte[] process() {
        workbook = new XSSFWorkbook();
        spreadsheet = workbook.createSheet(" Student Data ");

        return new byte[0];
    }

    @Override
    public void saveXls(Path path) {

    }

    @Resource(name = "studentRepository")
    public void setRepository(StudentRepository repository) {
        this.repository = repository;
    }
}
