package PageObjects;

import BaseClass.BaseClass;
import CommonLibraries.CommonActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.support.How.CSS;
import static org.openqa.selenium.support.How.XPATH;

public class AddToCardPage extends BaseClass {

    CommonActions action = new CommonActions();

    public AddToCardPage() {
        PageFactory.initElements(driver, this);
    }

    //a[name='sc-anchor-active-cart']
    @FindBy(how = CSS, using = "a[name='sc-anchor-active-cart']")
    private WebElement addToCardTxt;

    @FindBy(how = XPATH, using = "//div[@class='sc-item-price-block']/p/span")
    private WebElement unitPrice;

    @FindBy(how = CSS, using = "span[id='sc-subtotal-amount-activecart']")
    private WebElement totalPrice;

    //span[id='sc-buy-box-ptc-button']
    @FindBy(how = CSS, using = "span[id='sc-buy-box-ptc-button']")
    private WebElement clickOrderCmpltedBtn;

    //span[class='a-dropdown-prompt']
    @FindBy(how = CSS, using = "span[class='a-dropdown-prompt']")
    private WebElement adet;

    public boolean validateCardPage() {
        boolean result = addToCardTxt.isDisplayed();
        return result;
    }

    public double getPcs() {
        //Thread.sleep(7000);
        String sayi = adet.getText();
        double finalSayi = Double.parseDouble(sayi);
        return finalSayi;
    }
    public double getUnitPrice() throws InterruptedException {
        action.findElement(driver,unitPrice);
        System.out.println("unit price bulundu");
        Thread.sleep(500);
        String unitValue = unitPrice.getText(); //  774,69 TL
        Thread.sleep(500);
        System.out.println("birim fiyat:" +unitValue);
        Thread.sleep(500);
        String unitVal = (String) unitValue.subSequence(0, unitValue.length() -3);  // 774,69 TL-->774,69
        System.out.println("birim fiyat:" +unitVal);
        Thread.sleep(500);
        //unitVal.subSequence()
        String Uval = unitVal.replace(",", "");// 774,69 -->77469
        String Unal2 = Uval.replace(".", "");
        double finalUnitValue = Double.parseDouble(Unal2);
        System.out.println("Final birim fiyat:" +finalUnitValue);
        Thread.sleep(500);
        return finalUnitValue / 100;
    }

    public double getTotalPrice() {
        //Thread.sleep(10000);
        String totalValue = totalPrice.getText(); //155966 TL değerini alıyoruz  [^a-zA-Z0-9]--!TL ye karşılık gelir.
        System.out.println("gelen toplam deger:" +totalValue);
        String totValue = (String) totalValue.subSequence(0, totalValue.length() -3);  //-->155966
        System.out.println("TL siz toplam değer 1.016,25:" +totalValue);
        String tottVal = totValue.replace(",", "");
        System.out.println("Total fiyat 1.01625:" +tottVal);
        String tottVal2 = tottVal.replace(".", "");
        System.out.println("tottVal2 fiyat noktasız 101625:" +tottVal2);
        double finalTotalValue = Double.parseDouble(tottVal2);  // 155966 Double değere döndürüyoruz.
        System.out.println("double deger:" +finalTotalValue);
        return finalTotalValue / 100; //1559,66 değerine
    }

    public LoginPage clickCmpltedBtn() {
        action.click(driver, clickOrderCmpltedBtn);
        return new LoginPage();
    }


}
