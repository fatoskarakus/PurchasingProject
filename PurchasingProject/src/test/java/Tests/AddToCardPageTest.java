package Tests;

import BaseClass.BaseClass;
import ExcelLibraries.ExcelLibraries;
import PageObjects.*;
import Utility.Log;
import Utility.TakeScreenShot;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.IOException;


public class AddToCardPageTest extends BaseClass {

    private AddToCardPage addToCardpage;
    private LoginPage loginPage;

    private ProductPage productPage;
    private IndexPage indexPage;
    private ExcelLibraries excelData;
    private ProductDetailPage productDetailPage;

    @BeforeMethod
    public void setUp() throws IOException {
        launchApp();
    }

    @Test
    public void VerfyOrderThePrice() throws InterruptedException, IOException {
        Log.startTestCase("VerfyOrderThePrice");
        indexPage = new IndexPage();
        indexPage.clickTheCerez();
        excelData=new ExcelLibraries();
        productPage=new ProductPage();
        productPage=indexPage.searchProduct(excelData.getCellData("SearchProduct","Product",2));
        productDetailPage=productPage.clickTheProduct();
        productDetailPage.scrollDown();
        productDetailPage.seeColorOption();
        productDetailPage.seePicLists();
        productDetailPage.choseSize();
        productDetailPage.slctQuantity();
        productDetailPage.addToCard();
        addToCardpage=productDetailPage.goToCardBtn();
        addToCardpage.validateCardPage();
        double onePrice=(addToCardpage.getUnitPrice());
        double calculate=onePrice* addToCardpage.getPcs();
        double totalPrice= addToCardpage.getTotalPrice();
        Assert.assertEquals(calculate,totalPrice);
        System.out.println("Fiyat Hesaplanmıştır: " +calculate +" TL");
        System.out.println("Total Fiyat Hesaplanmıştır: " +totalPrice +" TL");
        loginPage=addToCardpage.clickCmpltedBtn();
        TakeScreenShot.screenShot(driver,"VerfyOrderThePrice");
        Log.endTestCase("VerfyOrderThePrice");
    }

    @AfterMethod
    public void tearDownDriver() {
        closeDriver();
    }

}


