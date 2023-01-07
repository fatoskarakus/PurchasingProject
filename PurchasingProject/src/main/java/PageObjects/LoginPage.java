package PageObjects;

import BaseClass.BaseClass;
import CommonLibraries.CommonActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.plaf.synth.SynthTextAreaUI;

import static org.openqa.selenium.support.How.*;

public class LoginPage extends BaseClass {

    CommonActions action = new CommonActions();
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = CSS, using = "div[class='a-box-inner a-padding-extra-large']>h1")
    private WebElement grisYapTxt;

    ////*[@type='password' and @id='ap-credential-autofill-hint']

    @FindBy(how = XPATH, using = "//*[@type='email' and @id='ap_email']")
    private WebElement emailTxt;

    @FindBy(how = XPATH, using = "//*[@type='password' and @id='ap_password']")
    private WebElement passWrdTxt;

    //input[id='continue']
    @FindBy(how = CSS, using = "input[id='continue']")
    private WebElement contnBtn;




    //#signInSubmit
    @FindBy(how = CSS, using = "span[id='auth-signin-button']")
    private WebElement sngInBtn;

//    public boolean validateTheLoginPage(){
//        boolean result = grisYapTxt.isDisplayed();
//        System.out.println("Giriş Yap Text:  " +result);
//        return result;
//    }
    public boolean VerifyTheLoginPage() throws InterruptedException {
        Thread.sleep(5000);
        boolean result=emailTxt.isDisplayed();
        return result;
        //xpath=(.//*[normalize=space(text()) and normalize-space(.)='username'])[1]/following::input
    }

    public void clickTheGoOnBtn(){
        action.click(driver,contnBtn);
    }

    public AdressPage clickInTheSingInBtn(){
        action.click(driver,sngInBtn);
        return new AdressPage();
    }

    public void sendMail(){
        action.sendText(emailTxt,prop.getProperty("username"));
        action.click(driver,contnBtn);
    }

    public AdressPage sendPasswrd(){
        action.sendText(passWrdTxt,prop.getProperty("password"));
        action.click(driver,sngInBtn);
        return new AdressPage();
    }

}
