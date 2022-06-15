package task2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyScenario {
    public static void main(String[] args) {
        By inputField = By.xpath("//input[@name='q']");
        By rozetkaLinkInGoogle = By.xpath("//*[contains(@class, 'iUh30 tjvcx')]");
        By iconMenu = By.xpath("//*[contains(@class, 'ng-tns-c94-1')]");
        By catalogButton = By.xpath("//*[contains(@class, 'side-menu__list--top')]/li[1]");
        By householdAppliancesCategory = By.xpath(" //a[contains(@class,'menu-categories__link_state_hovered')]");
        By roombaLink = By.xpath("//a[contains(@href,'clean_robots')]");
        By brandInputField = By.xpath("//*[contains(@class,'sidebar-search__input')]");
        By brandCheckbox = By.xpath("//a[@data-id='Xiaomi']");
        By inputMaxPrice = By.xpath("//*[contains(@formcontrolname,'max')]");
        By submitButton = By.xpath("//button[@type='submit']");

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
        driver.findElement(iconMenu).click();
        driver.findElement(catalogButton).click();
        driver.findElement(householdAppliancesCategory);
        driver.findElement(roombaLink).click();
        wait.until(ExpectedConditions.elementToBeClickable(brandInputField));
        driver.findElement(brandInputField).sendKeys("Xiaomi");
        driver.findElement(brandCheckbox).click();
        wait.until(ExpectedConditions.elementToBeClickable(inputMaxPrice));
        driver.findElement(inputMaxPrice).clear();
        driver.findElement(inputMaxPrice).sendKeys("8000");
        driver.findElement(submitButton).click();

    }

}
