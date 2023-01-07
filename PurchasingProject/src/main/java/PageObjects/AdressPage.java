package PageObjects;

import BaseClass.BaseClass;
import CommonLibraries.CommonActions;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.support.How.*;

public class AdressPage extends BaseClass {

    CommonActions action = new CommonActions();

    public AdressPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = CSS, using = "h1[class='a-spacing-base']")
    private WebElement addrsTxt;

    @FindBy(how = ID, using = "#address-ui-widgets-countryCode")
    private WebElement cntrySlct;

    @FindBy(how = XPATH, using = "//*[@id=\"address-ui-checkout-form\"]/div/div/div/div[4]/input")
    private WebElement nameLastnameTxt;

    @FindBy(how = XPATH, using = "//*[@id=\"address-ui-checkout-form\"]/div/div/div/div[6]/input")
    private WebElement phoneNumbr;

    @FindBy(how = XPATH, using = "//*[@id=\"address-ui-checkout-form\"]/div/div/div/div[8]/input")
    private WebElement adrsLine1Txt;

    @FindBy(how = XPATH, using = "//*[@id=\"address-ui-checkout-form\"]/div/div/div/div[10]/input")
    private WebElement adrsLine2Txt;

    @FindBy(how = XPATH, using = "//*[@id=\"address-ui-checkout-form\"]/div/div/div/div[12]/input")
    private WebElement citySlc;
    @FindBy(how = XPATH, using = "//*[@id=\"address-ui-checkout-form\"]/div/div/div/div[12]/input/ul")
    private WebElement citySlcul;


    @FindBy(how = XPATH, using = "//*[@id=\"address-ui-checkout-form\"]/div/div/div/div[14]/input")
    private WebElement regionSlc;

    @FindBy(how = XPATH, using = "//*[@id=\"address-ui-checkout-form\"]/div/div/div/div[16]/input")
    private WebElement distritcSlc;

    @FindBy(how = ID, using = "#address-ui-widgets-use-as-my-default")
    private WebElement defualAdressChckBx;

    @FindBy(how = XPATH, using = "(//span[@id='address-ui-widgets-form-submit-button'])")
    private WebElement sbmtBtn;

    ////*[@id="address-book-entry-0"]/div[2]/span[1]/a[1]
    @FindBy(how = XPATH, using = " //*[@id='address-book-entry-0']/div[2]/span/a ")
    private WebElement useTheAdresBtn;

    public boolean getAdressText() {
        return addrsTxt.isDisplayed();
    }

    public void sendNameUsername() {
        action.sendText(nameLastnameTxt, "Fatma Karakuş");
    }

    public void sendPhone() {
        action.sendText(phoneNumbr, "523222222");
    }

    public void sendLine1() {
        action.sendText(adrsLine1Txt, "test1");
    }

    public void sendLine2() {
        action.sendText(adrsLine2Txt, "test2");
    }

    public boolean slctCity() {
        boolean result = action.selectByIndex(citySlc, 1);
        return result;
    }

    public boolean slctReligion() {
        boolean result1 = action.selectByIndex(regionSlc, 1);
        return result1;
    }

    public boolean slctDistrict() {
        boolean result2 = action.selectByIndex(distritcSlc, 1);
        return result2;
    }

    public void selctCheck() {
        action.click(driver, defualAdressChckBx);
    }

    public PaymentPage recordAdres() {
        action.click(driver, sbmtBtn);
        return new PaymentPage();
    }

    public PaymentPage useDefaultAdres(){
        action.click(driver,useTheAdresBtn);
        return new PaymentPage();
    }

    public PaymentPage setTheNewAdress() {
        action.sendText(nameLastnameTxt, "Fatma Karakuş");
        action.sendText(phoneNumbr, "523222222");
        action.sendText(adrsLine1Txt, "test1");
        action.sendText(adrsLine2Txt, "test2");
        action.sendText(citySlc, "Istanbul");
        action.selectByIndex(citySlcul,0);
        action.sendText(regionSlc, "Maltepe");
        //action.selectByIndex(regionSlc,0);
        action.sendText(distritcSlc, "Cevizli");
        //action.selectByIndex(distritcSlc,0);
//        boolean result=action.selectByIndex(citySlc,1);
//        boolean result1=action.selectByIndex(regionSlc,1);
//        boolean result2=action.selectByIndex(distritcSlc,1);
//        action.click(driver, defualAdressChckBx);
        action.click(driver, sbmtBtn);
        return new PaymentPage();
    }

    //Yazılacak
    public void selctTheDefultAdress(){

    }


}
