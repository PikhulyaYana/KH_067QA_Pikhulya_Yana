package task3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class FoxtrotCart extends BaseTest {
    By inputField = By.xpath("//input[contains(@class, 'header-search__field')]");
    By submitButton = By.xpath("//input[@class='header-search__button evinent-search-button']");
    By firstProduct = By.xpath("//div[@data-code='6744365']/i");
    By basketLink = By.xpath("//a[contains(@href, 'cart.html')]");
    By cartProductList = By.xpath("//div[@class='shop-cart__item-body']");
    By trashLink = By.xpath("//i[@class='icon icon-trash']");

    String query = "Iphone13";


    @Test(groups = {"Cart"})
    public void addProductToCart() {
        WebElement input = driver.findElement(inputField);
        input.sendKeys(query);
        driver.findElement(submitButton).click();
        wait.until(ExpectedConditions.elementToBeClickable(firstProduct));
        driver.findElement(firstProduct).click();
        wait.until(ExpectedConditions.elementToBeClickable(basketLink));
        driver.findElement(basketLink).click();
        List<WebElement> element = driver.findElements(cartProductList);
        int actualCartProductListSize = element.size();
        int expectedCartProductListSize = 1;
        Assert.assertEquals(actualCartProductListSize, expectedCartProductListSize);

    }

    @Test(groups = {"Cart"})
    public void deleteProductFromCart() {
        WebElement input = driver.findElement(inputField);
        input.sendKeys(query);
        driver.findElement(submitButton).click();
        wait.until(ExpectedConditions.elementToBeClickable(firstProduct));
        driver.findElement(firstProduct).click();
        wait.until(ExpectedConditions.elementToBeClickable(basketLink));
        driver.findElement(basketLink).click();
        driver.findElement(trashLink).click();
        List<WebElement> element = driver.findElements(cartProductList);
        boolean actualCartProductListSize = element.isEmpty();
        boolean expectedCartProductListSize = true;
        Assert.assertEquals(actualCartProductListSize, expectedCartProductListSize);

    }

}

