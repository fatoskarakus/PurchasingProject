package MyStepDefs;//package MyStepDefs;
//
//import Pages.HomePage;
//import TestNG.BaseTest;
//import TestNG.HomeTest;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.testng.Assert;
//import org.testng.annotations.BeforeMethod;
//
//import java.sql.SQLException;
//import java.util.concurrent.TimeUnit;
//
//import static java.sql.DriverManager.getDriver;
//
//public class MyStepdefs {
//    public WebDriver driver;
//    public BaseTest test;
//    public String BaseUrl = "http://tutorialsninja.com/demo/index.php?route=common/home";
//
//    @Given("Open the homepage")
//    public void openTheHomepage() {
//        System.setProperty("webdriver.edge.driver", "Drivers/msedgedriver.exe");
//        driver = new EdgeDriver();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.manage().window().maximize();
//        driver.get(BaseUrl);
//    }
//
//    @When("Search the product on the area")
//    public void searchTheProductOnTheArea() {
//        HomePage homePage = new HomePage(driver);
//        homePage.SearchElement("Mac");
//    }
//
//    @Then("Validate the product")
//    public void validateTheProduct() {
//        HomePage homePage = new HomePage(driver);
//        homePage.ValidateTheProduct("Mac");
//    }
//
//    @When("Search the MenuBar and Clic the Mac")
//    public void searchTheMenuBarAndClickTheMac() {
//
//    }
//
//    @Then("Validate the MAC")
//    public void validateTheMAC() {
//    }
//}
