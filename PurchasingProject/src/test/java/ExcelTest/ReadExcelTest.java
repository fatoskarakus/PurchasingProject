package ExcelTest;

import ExcelLibraries.ExcelLibraries;
import Utility.Log;
import org.testng.annotations.Test;
import java.io.IOException;

public class ReadExcelTest{
    String data;

    @Test
    public void ReadExcel() throws IOException {
        Log.startTestCase("ReadExcel");
        ExcelLibraries readExcel = new ExcelLibraries();
        data = readExcel.readOneData("Credentials", 1, 1);
        System.out.println("Okunan Data:    " + data);
        Log.endTestCase("ReadExcel");
    }

    @Test
    public void ReadTable() throws IOException {
        Log.startTestCase("ReadTable");
        ExcelLibraries readExcel = new ExcelLibraries();
        readExcel.readExcelTable("Credentials");
        Log.endTestCase("ReadTable");
    }


}
