package task1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Rozetka {
    public static void main(String[] args) {
       // System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        WebElement input = driver.findElement(By.xpath("//input[@name='q']"));
        input.sendKeys("rozetka ua");
        input.submit();
        driver.findElement(By.xpath("//*[contains(@class, 'LC20lb MBeuO DKV0Md')]")).click();
        WebElement input2 = driver.findElement(By.xpath("//input"));
        input2.sendKeys("горшок для орхидеи");
        driver.findElement(By.xpath("//*[contains(@class, 'search-form__submit')]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//ul[@class='catalog-grid ng-star-inserted']/li[1]")).click();
        driver.findElement(By.xpath("//div[@class='top-information__inner']")).click();
        driver.findElement(By.xpath("//*[contains(@class, 'buy-button button button--with-icon')]")).click();

    }

}


