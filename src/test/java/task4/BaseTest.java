package task4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected String url = "https://www.apple.com/";

    @BeforeSuite
    public void setDriver() {
        //System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver2");
    }

    @BeforeMethod
    public void SetUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get(url);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void quitBrowser() {
        driver.quit();
    }

}
