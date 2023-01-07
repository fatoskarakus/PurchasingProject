package ExcelTest;

import ExcelLibraries.ExcelLibraries;
import ExcelLibraries.WriteExcel;
import org.testng.annotations.Test;

import java.io.IOException;

public class WriteExcelTest {
    WriteExcel write = new WriteExcel();
    ExcelLibraries write2=new ExcelLibraries();

    @Test
    public void WriteExcelTest() throws IOException {
        write.writeExcel("Credentials", "sadmin@gmail.com", 3, 0);
    }

    @Test
    public void WriteExcelTest1() throws IOException {
        write.writeExcel("Credentials", "tadmin@gmail.com", 4, 0);
    }

    @Test
    public void WriteExcelTest2() throws IOException {
       // write.writeExcel("Test", "Male", 1, 2);
        write2.writeExcel("Credentials","kadmin@gmail.com",5,0);
    }


}
