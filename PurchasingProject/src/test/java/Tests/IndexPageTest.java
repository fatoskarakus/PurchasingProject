package Tests;

import BaseClass.BaseClass;
import ExcelLibraries.ExcelLibraries;
import PageObjects.CategoryPage;
import PageObjects.IndexPage;
import Utility.Log;
import Utility.TakeScreenShot;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

public class IndexPageTest extends BaseClass {

    private IndexPage indexPage;
    private ExcelLibraries excelData;

    //@Parameters("browser")
    @BeforeMethod
    public void setUp() throws IOException {
        launchApp();
    }

    @Test(priority = 0)
    public void verifyTheIndexPageTest() throws IOException, InterruptedException {

        Log.startTestCase("verifyTheIndexPageTest");
        indexPage = new IndexPage();
        indexPage.clickTheCerez();
        boolean result = indexPage.pageControl();
        Assert.assertTrue(result);
        TakeScreenShot.screenShot(driver,"verifyTheIndexPageScreenShots");
        Log.endTestCase("verifyTheIndexPageTest");
    }

    @Test(priority = 1)
    public void searchTheProductTest() throws InterruptedException, IOException {
        Log.startTestCase("searchTheProductTest");
        indexPage = new IndexPage();
        indexPage.clickTheCerez();
        excelData=new ExcelLibraries();
        indexPage.searchProduct(excelData.getCellData("SearchProduct","Product",2));
        System.out.println(excelData.getCellData("SearchProduct","Product",2));
        String expected = IndexPage.categoryElmnt.getText();
        Assert.assertEquals(expected.substring(1, expected.length() - 1).substring(0, expected.length() - 2),excelData.getCellData("SearchProduct","Product",2));
        TakeScreenShot.screenShot(driver,"searchTheProductScreenShots");
        Log.endTestCase("searchTheProductTest");
    }

    @Test(priority = 2)
    public void chooseTheCategoryTest() throws IOException, InterruptedException {
        Log.startTestCase("chooseTheCategoryTest");
        indexPage = new IndexPage();
        //indexPage.clickTheCerez();
        indexPage.chooseTheCategory(prop.getProperty("category"));
        Assert.assertEquals(indexPage.categoryTxtElmt.getText(),prop.getProperty("category"));
        TakeScreenShot.screenShot(driver,"chooseTheCategoryScreenShots");
        Log.endTestCase("chooseTheCategoryTest");
    }

    @AfterMethod
    public void tearDownDriver() {
        closeDriver();

    }
}
