package task3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class FoxtrotInputField extends BaseTest {
    By inputField = By.xpath("//input[contains(@class, 'header-search__field')]");
    By submitButton = By.xpath("//input[@class='header-search__button evinent-search-button']");
    By searchResult = By.xpath("//div[contains(@class, 'sc-product')]");
    By searchDropDownMenu = By.xpath("//a[contains(@class, 'evinent-search-product')]");
    By notFoundMessage = By.xpath("//div[@class='search-page__box-title']");

    String validQuery = "робот-пылесос";
    String notValidQuery = "отамоатмовамт";

    @Test(groups = {"Input Field"})
    public void searchFieldValidDataTest() {
        WebElement input = driver.findElement(inputField);
        input.sendKeys(validQuery);
        driver.findElement(submitButton).click();
        wait.until(ExpectedConditions.numberOfElementsToBe(searchResult, 26));
        List<WebElement> element = driver.findElements(searchResult);
        boolean actualSearchResult = element.isEmpty();
        Assert.assertFalse(actualSearchResult);

    }

    @Test(groups = {"Input Field"})
    public void searchFieldNotValidDataTest() {
        WebElement input = driver.findElement(inputField);
        input.sendKeys(notValidQuery);
        driver.findElement(submitButton).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(notFoundMessage));
        boolean notFoundMessageIsDisplayed = driver.findElement(notFoundMessage).isDisplayed();
        Assert.assertTrue(notFoundMessageIsDisplayed);


    }

    @Test(groups = {"Input Field"})
    public void showDropDownMenuFromSearchFieldTest() {
        WebElement input = driver.findElement(inputField);
        input.sendKeys(validQuery);
        wait.until(ExpectedConditions.elementToBeClickable(searchDropDownMenu));
        List<WebElement> element = driver.findElements(searchDropDownMenu);
        boolean actualSearchResult = element.isEmpty();
        Assert.assertFalse(actualSearchResult);

    }
}

