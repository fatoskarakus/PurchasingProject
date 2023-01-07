package PageObjects;

import BaseClass.BaseClass;
import org.openqa.selenium.support.PageFactory;

public class AccountPage extends BaseClass {
    public AccountPage() {
        PageFactory.initElements(driver, this);
    }
}
