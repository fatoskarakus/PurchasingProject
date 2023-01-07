package BaseClass;

import Utility.ExtentManager;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseClass {

    public static Properties prop;
    public static WebDriver driver;
    static EdgeDriverService services;

    @BeforeSuite()
    public void loadConfig() {
        //ExtentFactory.setExtent();
        //ExtentManager.setExtentReports();
        PropertyConfigurator.configure("log4j.properties");
        prop = new Properties();
        try {
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/Configuration/Config.properties");
            prop.load(ip);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //@BeforeClass
    public static WebDriver launchApp() throws IOException {
        System.setProperty("webdriver.chrome.driver", "C:/Users/FATMA/Selenium/ChromeDriver/chromedriver.exe");
        driver=new ChromeDriver();
        driver.get(prop.getProperty("url"));
        driver.manage().window().maximize();
        driver.manage().getCookies();
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(prop.getProperty("implicitWait")), TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(prop.getProperty("pageLoadTimeOut")), TimeUnit.SECONDS);
        return driver;
    }

    @AfterClass
    public void closeDriver() {
        driver.quit();

    }

    public static String getCurrentTime() {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");
        Date date = new Date();
        String date1 = dateFormat.format(date);
        return date1;
    }

//    @AfterSuite()
//    public void afterSuite() {
//        ExtentManager.endReport();
//    }

}