package task4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.util.List;

public class AppleItemMenuList extends BaseTest {
    By allSubLinks = By.xpath("//li[contains(@class,'chapternav-item')]");
    By macLink = By.xpath("//li[contains(@class,'ac-gn-mac')]");
    By firstElementTitle = By.xpath("//span[@class='chapternav-label']");
    By iPadLink = By.xpath("//li[contains(@class,'ac-gn-ipad')]");
    By iPhoneLink = By.xpath("//li[contains(@class,'ac-gn-iphone')]");


    @Test(groups = {"itemMenuList", "mac"})
    public void clickOfMacLinkTest() {
        driver.findElement(macLink).click();
        List<WebElement> element = driver.findElements(allSubLinks);
        String actualTitle = element.get(0).findElement(firstElementTitle).getText();
        String expectedTitle = "MacBook Air";
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test(groups = {"itemMenuList", "iPad"})
    public void clickOfIPadLinkTest() {
        driver.findElement(iPadLink).click();
        List<WebElement> element = driver.findElements(allSubLinks);
        String actualTitle = element.get(0).getText();
        String expectedTitle = "iPad Pro";
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test(groups = {"itemMenuList", "iPhone"})
    public void clickOfIPhoneLinkTest() {
        driver.findElement(iPhoneLink).click();
        List<WebElement> element = driver.findElements(allSubLinks);
        String actualTitle = element.get(0).findElement(firstElementTitle).getText();
        String expectedTitle = "iPhone 13 Pro";
        Assert.assertEquals(actualTitle, expectedTitle);
        System.out.println(actualTitle);
    }

}

