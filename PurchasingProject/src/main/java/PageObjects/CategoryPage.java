package PageObjects;

import BaseClass.BaseClass;
import org.openqa.selenium.support.PageFactory;

public class CategoryPage extends BaseClass {
    public CategoryPage() {
        PageFactory.initElements(driver, this);
    }
}
