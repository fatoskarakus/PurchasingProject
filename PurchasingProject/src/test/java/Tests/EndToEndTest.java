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

public class EndToEndTest extends BaseClass {
    private AddToCardPage addToCard;
    private LoginPage loginPage;
    private ProductPage productPage;
    //private IndexPageTest test;
    private IndexPage indexPage;
    private ExcelLibraries excelData;
    private ProductDetailPage productDetailPage;
    private AdressPage adresPage;
    private PaymentPage paymentPage;

    @BeforeMethod
    public void setUp() throws IOException {
        launchApp();
    }
    @Test
    public void SingInForTheOrder() throws InterruptedException, IOException {
        Log.startTestCase("SingInForTheOrder");
        indexPage = new IndexPage();
        indexPage.clickTheCerez();
        excelData=new ExcelLibraries();
        productPage=new ProductPage();
        productPage=indexPage.searchProduct(excelData.getCellData("SearchProduct","Product",2));
        productDetailPage=productPage.clickTheProduct();
        productDetailPage.scrollDown();
        //productDetailPage.seeColorOption();
        productDetailPage.seePicLists();
        productDetailPage.choseSize();
        productDetailPage.slctQuantity();
        productDetailPage.addToCard();
        addToCard=productDetailPage.goToCardBtn();
        addToCard.validateCardPage();
        double onePrice=(addToCard.getUnitPrice());
        double calculate=onePrice* addToCard.getPcs();
        double totalPrice= addToCard.getTotalPrice();
        Assert.assertEquals(calculate,totalPrice);
        System.out.println("Fiyat Hesaplanmıştır: " +calculate +" TL");
        System.out.println("Total Fiyat Hesaplanmıştır: " +totalPrice +" TL");
        loginPage=addToCard.clickCmpltedBtn();
        loginPage.VerifyTheLoginPage();
        loginPage.sendMail();
        adresPage=loginPage.sendPasswrd();
        //paymentPage=adresPage.setTheNewAdress();
        paymentPage=adresPage.useDefaultAdres();
        //Assert.assertTrue(paymentPage.ValidatePaymentPage());
        paymentPage.recordTheMyCard();
        Assert.assertEquals(paymentPage.alertMessage(),"Bir sorun vardı.");
        System.out.println("Caseniz başarıyla tamamlanmıştır.");
        TakeScreenShot.screenShot(driver,"SingInForTheOrder");
        Log.endTestCase("SingInForTheOrder");
    }

    @AfterMethod
    public void tearDownDriver() {
        closeDriver();
    }

}
