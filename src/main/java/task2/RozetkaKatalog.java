package task2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RozetkaKatalog {
    public static void main(String[] args) {
        By inputField = By.xpath("//input[@name='q']");
        By rozetkaLinkInGoogle = By.xpath("//*[contains(@class, 'iUh30 tjvcx')]");
        By catalogButton = By.xpath("//button[@id='fat-menu']");
        By monitorLink = By.xpath("//a[contains(@href,'monitors')]");
        By seller = By.xpath("//a[@data-id='Rozetka']");
        By monitorsFirstElement = By.xpath("//div[@data-goods-id='219872521']");


        String url = "https://www.google.com/";
        String query = "rozetka ua";

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get(url);
        driver.manage().window().maximize();
        WebElement input = driver.findElement(inputField);
        input.sendKeys(query);
        input.submit();
        driver.findElement(rozetkaLinkInGoogle).click();
        driver.findElement(catalogButton).click();
        driver.findElement(monitorLink).click();
        wait.until((ExpectedConditions.elementToBeClickable(seller)));
        driver.findElement(seller).click();
        WebElement element = driver.findElement(monitorsFirstElement);
        element.click();

    }
    
}
