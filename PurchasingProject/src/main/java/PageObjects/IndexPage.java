package PageObjects;

import BaseClass.BaseClass;
import CommonLibraries.CommonActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class IndexPage extends BaseClass {

    public IndexPage() {
        PageFactory.initElements(driver, this);
    }

    CommonActions action = new CommonActions();
//    private AccountPage accountPage;
//    private CategoryPage categoryPage;

    @FindBy(how = How.CSS, using = "a[id='nav-logo-sprites']")
    private WebElement logoImageElmt;

    @FindBy(how = How.CSS, using = " input[id='sp-cc-accept']")
    private WebElement CerezBtnElmt;

    @FindBy(how = How.CSS, using = "select#searchDropdownBox")
    private WebElement allCategoryMenuSlct;

    @FindBy(how = How.XPATH, using = "//input[@type='text' and @id='twotabsearchtextbox']")
    private WebElement searchTxtBoxElmt;

    @FindBy(how = How.ID, using = "#nav-link-accountList")
    private WebElement singInBtnElmt;

    @FindBy(how = How.CSS, using = "input#nav-search-submit-button")
    private WebElement searchBtnElmt;

    @FindBy(how = How.CSS, using = "div[class='fst-h1-st pageBanner']>h1")
    public WebElement categoryTxtElmt;

    @FindBy(how = How.CSS, using = "span[class^='a-color-state a-text-bold'")
    public static WebElement categoryElmnt;

    //Click The SingIn Button Method and navigate the account Page
    public AccountPage clickSingInBtn() {
        action.fluentWait(driver, singInBtnElmt, 10);
        return new AccountPage();
    }

    public void clickTheCerez() throws InterruptedException {
        Thread.sleep(2000);
        CerezBtnElmt.click();
    }

    public boolean pageControl() {
        return action.isDisplayed(driver, logoImageElmt);
    }

    //Search Product Method
    public ProductPage searchProduct(String productname) throws InterruptedException {
        Thread.sleep(10000);
        boolean result = action.sendText(searchTxtBoxElmt, productname);
        action.click(driver, searchBtnElmt);
        return new ProductPage();
    }

    public ProductPage chooseTheCategory(String value) {
        action.fluentWait(driver, allCategoryMenuSlct, 10);
        action.selectByVisibleText(allCategoryMenuSlct, value);
        action.click(driver, searchBtnElmt);
        return new ProductPage();
    }
}
