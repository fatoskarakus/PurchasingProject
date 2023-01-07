package PageObjects;

import BaseClass.BaseClass;
import CommonLibraries.CommonActions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.chrome.ChromeDriverService;

import java.util.ArrayList;
import java.util.List;

import java.awt.*;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.How.*;

public class ProductDetailPage extends BaseClass {

    CommonActions action = new CommonActions();
    ChromeDriverService services;
    public ProductDetailPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.CSS,using = " input[id='sp-cc-accept']")
    private WebElement CerezBtnElmt;
    @FindBy(how = XPATH, using = "//*[@id='variation_color_name']/ul/li")
    private List<WebElement> shooesList;
    @FindBy(how = CSS, using = "ul[class='a-unordered-list a-nostyle a-button-list a-vertical a-spacing-top-micro regularAltImageViewLayout']>li")
    private List<WebElement> seePicList;
    @FindBy(how = CSS, using = "span[id='productTitle']")
    private WebElement prdctTitle;

    //span[class='twister-dropdown-highlight transparentTwisterDropdownBorder']
    @FindBy(how = XPATH, using = "//*[@id=\"native_dropdown_selected_size_name\"]")
    private WebElement slctSize;

    @FindBy(how = XPATH, using = "//*[@id=\"tp-inline-twister-dim-values-container\"]/ul/li[2]")
    private WebElement slctSize_2;

    //select[name='quantity']
    @FindBy(how = CSS, using = "select[name='quantity']")
    private WebElement slctQntity;

    //#add-to-cart-button
    @FindBy(how = CSS, using = "span[id='submit.add-to-cart']")
    private WebElement addToCardBtn;

    @FindBy(how = CSS, using = "#sw-gtc>span")
    private WebElement goToCardBtn;

    //span[class='a-size-medium-plus a-color-base sw-atc-text a-text-bold']
    @FindBy(how = CSS, using = "span[class='a-size-medium-plus a-color-base sw-atc-text a-text-bold']")
    private WebElement vefyTheProAdd;


    public boolean vefiyTheDetailPage(){
        boolean result=prdctTitle.isDisplayed();
        return result;
    }

    public void seeColorOption() throws InterruptedException {
        for (WebElement shoes:shooesList) {
            action.mouseOverElement(driver,shoes);
            Thread.sleep(2000);
        }
    }

    public void scrollDown() throws InterruptedException {
        Thread.sleep(200);
        action.scrollDown();
    }

    public void seePicLists() throws InterruptedException {

        for (WebElement pics:seePicList) {
            action.mouseOverElement(driver,pics);
            Thread.sleep(500);
        }
    }
    public void clickTheCerez1() {
        CerezBtnElmt.click();
//        boolean result = action.findElement(driver, CerezBtnElmt);
//        return result;
    }

    public void choseSize(){
        //action.click(driver,choseNmbr);
        if(slctSize.isDisplayed()) {
            action.selectByIndex(slctSize, 5);
            action.click(driver, slctSize);
        }
        else {
            action.findElement(driver,slctSize_2);
            action.click(driver,slctSize_2);
        }
    }

    public void slctQuantity(){
        action.selectByValue(slctQntity,"1");
        action.click(driver,slctQntity);
    }

    public void addToCard(){
        action.click(driver,addToCardBtn);
    }

    public boolean verifyAddToCardAdded(){
        boolean result= vefyTheProAdd.isDisplayed();
        System.out.println("Ürün sepete eklenmiştir");
        return result;
    }

    public AddToCardPage goToCardBtn() throws InterruptedException {
        Thread.sleep(500);
        action.click(driver,goToCardBtn);
        System.out.println("sepete git butonu tıklanmıştır");
        return new AddToCardPage();
    }

}




