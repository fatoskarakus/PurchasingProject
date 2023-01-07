package Tests;

import BaseClass.BaseClass;
import ExcelLibraries.ExcelLibraries;
import PageObjects.IndexPage;
import PageObjects.ProductPage;
import Utility.Log;
import Utility.TakeScreenShot;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class ProductPageTest extends BaseClass {

    private IndexPage indexPage;
    private ExcelLibraries excelData;
    private ProductPage productPage;

    @BeforeMethod
    public void setUp() throws IOException {
        launchApp();
    }

    @Test
    public void choseTheProduct() throws InterruptedException, IOException {
        Log.startTestCase("choseTheProduct");
        indexPage = new IndexPage();
        excelData = new ExcelLibraries();
        productPage = new ProductPage();
        productPage = indexPage.searchProduct(excelData.getCellData("SearchProduct", "Product", 2));
        productPage.clickTheProduct();
        TakeScreenShot.screenShot(driver,"verifyTheIndexPageScreenShots");
        Log.endTestCase("verifyTheIndexPageTest");
    }

    @AfterMethod
    public void tearDownDriver() {
        closeDriver();
    }
}
