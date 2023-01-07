package PageObjects;

import BaseClass.BaseClass;
import CommonLibraries.CommonActions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.Alert;

import java.sql.Driver;

import static org.openqa.selenium.support.How.*;

public class PaymentPage extends BaseClass {

    CommonActions action = new CommonActions();

    public PaymentPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = CSS, using = "h1[class='a-spacing-base']")
    private WebElement addrsTxt;

    @FindBy(how = XPATH, using = "//*[@id=\"apx-content\"]/div/div[2]/div[2]/div/div/div/div/div[2]/div/div/span/span[1]")
    private WebElement addCardBtn;

    @FindBy(how = CSS, using = "input[name='addCreditCardNumber']")
    private WebElement CardNmbrTxt;

    //#pp-bTbp6F-19
    @FindBy(how = CSS, using = "input[name='ppw-accountHolderName']")
    private WebElement cNameLastNTxt;

    //#pp-bTbp6F-23
    @FindBy(how = CSS, using = "select[name='ppw-expirationDate_month']")
    private WebElement sclcMont;

    @FindBy(how = CSS, using = "select[name='ppw-expirationDate_year']")
    private WebElement sclcYear;

    //#pp-bTbp6F-25
    @FindBy(how = CSS, using = "input[name='ppw-setBuyingPreference']")
    private WebElement clckDefaultCbx;

    //input[name='ppw-widgetEvent:AddCreditCardEvent']
    @FindBy(how = CSS, using = "div[class='a-row apx-add-card-buttons-in-popover apx-add-card-buttons-in-popover-align-right']>div>span>span>input")
    private WebElement clickTheRecordBtn;

    @FindBy(how = XPATH, using = "//*[@id=\"apx-content\"]/div/div[2]/div[2]/div/iframe")
    private WebElement frameElmt;

    @FindBy(how = XPATH, using = "//*[@id='a-popover-1']/div/header/button")
    private WebElement addCardBtn2;

    @FindBy(how = CSS, using = "span[id='pp-GQUDGR-28']>span")
    private WebElement addTheCardBtn;

        //Kart numarası doğru değil.
    @FindBy(how = CSS, using = "div[class='a-column a-span12']>div>div>h4")
    private WebElement alertTxt;

    public boolean ValidatePaymentPage() {
        boolean result = addrsTxt.isDisplayed();
        return result;
    }

    public void addToCardInfo() throws InterruptedException {
        Thread.sleep(1000);
        action.click(driver, addCardBtn);
    }

    public void addCardNmr() throws InterruptedException {
        action.findElement(driver, CardNmbrTxt);
        action.sendText(CardNmbrTxt,"1233456678991233");
    }

    public void addNameLastName() {
        action.findElement(driver, cNameLastNTxt);
        action.sendText(cNameLastNTxt,"1233456678991233");
    }

    public void addMonts() {
        action.selectByIndex(sclcMont, 1);
    }

    public void addYears() {
        action.selectByIndex(sclcYear, 1);
    }

    public void selectTheCheckBox() {
        action.click(driver, clckDefaultCbx);
    }

    public void clickTheSubmitBtn() {
        action.click(driver, clickTheRecordBtn);
    }
    public String alertMessage(){
     String result=alertTxt.getText();
     return result;
    }
    public void recordTheMyCard() throws InterruptedException {
        Thread.sleep(2000);
        action.click(driver, addCardBtn);
        driver.switchTo().frame(frameElmt);
        System.out.println("frame bulundu");
        //action.click(driver, CardNmbrTxt);
        action.sendText(CardNmbrTxt, "1233456678991233");
        action.sendText(cNameLastNTxt, "Fatma Karakus");
        action.selectByIndex(sclcMont, 1);
        action.selectByIndex(sclcYear, 1);
        action.click(driver, clckDefaultCbx);
        action.click(driver, clickTheRecordBtn);
    }
}
