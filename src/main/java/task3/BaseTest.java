package task3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected String url = "https://www.foxtrot.com.ua/";


    @BeforeSuite
    public void setUp() {
        //System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @BeforeTest
    public void windowSetUp() {
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void openFoxtrotLink() {
        driver.get(url);
    }

    @AfterMethod
    public void quitBrowser() {
        driver.quit();
    }
}
