package Tests;

import BaseClass.BaseClass;
import ExcelLibraries.ExcelLibraries;
import PageObjects.AddToCardPage;
import PageObjects.IndexPage;
import PageObjects.ProductDetailPage;
import PageObjects.ProductPage;
import Utility.Log;
import Utility.TakeScreenShot;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class ProductDetailPageTest extends BaseClass {
    private ProductPage productPage;
    //private IndexPageTest test;
    private IndexPage indexPage;
    private ExcelLibraries excelData;
    private ProductDetailPage productDetailPage;
    private AddToCardPage addToCardPage;

    @BeforeMethod
    public void setUp() throws IOException {
        launchApp();
    }

    @Test
    public void validateProductDetailPage() throws InterruptedException, IOException {
        Log.startTestCase("validateProductDetailPage");
        indexPage = new IndexPage();
        excelData=new ExcelLibraries();
        productPage=new ProductPage();
        productPage=indexPage.searchProduct(excelData.getCellData("SearchProduct","Product",2));
        indexPage.clickTheCerez();
        productDetailPage=productPage.clickTheProduct();
        //indexPage.clickTheCerez();
        boolean result=productDetailPage.vefiyTheDetailPage();
        Assert.assertTrue(result);
        TakeScreenShot.screenShot(driver,"validateProductDetailPage");
        Log.endTestCase("validateProductDetailPage");
    }

    @Test
    public void viewTheShoesDetail() throws InterruptedException, IOException {
        Log.startTestCase("viewTheShoesDetail");
        indexPage = new IndexPage();
        excelData=new ExcelLibraries();
        productPage=new ProductPage();
        productPage=indexPage.searchProduct(excelData.getCellData("SearchProduct","Product",2));
        indexPage.clickTheCerez();
        productDetailPage=productPage.clickTheProduct();
        productDetailPage.scrollDown();
        productDetailPage.seeColorOption();
        productDetailPage.seePicLists();
        productDetailPage.choseSize();
        productDetailPage.slctQuantity();
        productDetailPage.addToCard();
        boolean result=productDetailPage.verifyAddToCardAdded();
        Assert.assertTrue(result);
        productDetailPage.goToCardBtn();
        TakeScreenShot.screenShot(driver,"viewTheShoesDetail");
        Log.endTestCase("viewTheShoesDetail");

    }

    @AfterMethod
    public void tearDownDriver() {
        closeDriver();
    }


}
