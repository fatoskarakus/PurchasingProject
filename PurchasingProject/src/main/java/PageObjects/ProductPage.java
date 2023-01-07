package PageObjects;

import BaseClass.BaseClass;
import CommonLibraries.CommonActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends BaseClass {
    IndexPage indexpage;

    CommonActions action = new CommonActions();
    public ProductPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH,using = "//*[@id='search']/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div")
    public WebElement productElmt;

    public ProductDetailPage clickTheProduct() throws InterruptedException {
        Thread.sleep(5000);
        action.mouseOverElement(driver,productElmt);
        action.click(driver,productElmt);
        return new ProductDetailPage();
    }


}
