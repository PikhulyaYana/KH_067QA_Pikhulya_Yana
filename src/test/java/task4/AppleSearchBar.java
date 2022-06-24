package task4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;


public class AppleSearchBar extends BaseTest {
    By searchButton = By.xpath("//a[@id='ac-gn-link-search']");
    By searchForm = By.xpath("//input[@id='ac-gn-searchform-input']");
    By searchResultList = By.xpath("//div[@class='rf-serp-explore-curated']");
    By firstElementTitle = By.xpath("//h2[@class='rf-serp-productname']");
    By resultForNotValidData = By.xpath("//div[@class='rf-serp-nullsearch-title']");
    By dropDownResults = By.xpath("//section[contains(@class,'ac-gn-searchresults-section')]");

    String queryForDropDownMenu = "IPhone";


    @DataProvider(name = "searchFieldInputs")
    public Object[][] inputs() {
        return new Object[][]{
                {"IPhone13", "iPhone 13 Pro and iPhone 13 Pro Max"},
                {"MacBook Air", "MacBook Air"},
        };
    }

    @Test(dataProvider = "searchFieldInputs", groups = {"Input Field"})
    public void searchFieldValidDataTest(String data, String expectedSearchData) {
        WebElement input = driver.findElement(searchButton);
        input.click();
        WebElement searchField = driver.findElement(searchForm);
        searchField.sendKeys(data);
        searchField.submit();
        List<WebElement> element = driver.findElements(searchResultList);
        String actualSearchData = element.get(0).findElement(firstElementTitle).getText();
        Assert.assertEquals(actualSearchData, expectedSearchData);

    }

    @Parameters({"notValidDataForSearch"})
    @Test(groups = {"Input Field", "Negative Tests"})
    public void searchFieldNotValidDataTest(@Optional("jbjkknjbjbjk") String notValidDataForSearch) {
        WebElement input = driver.findElement(searchButton);
        input.click();
        WebElement searchField = driver.findElement(searchForm);
        searchField.sendKeys(notValidDataForSearch);
        searchField.submit();
        WebElement element = driver.findElement(resultForNotValidData);
        String actualSearchData = element.getText();
        String expectedSearchData = "Sorry, no matches were found.";
        Assert.assertEquals(actualSearchData, expectedSearchData);
    }

    @Test(groups = {"Input Field"})
    public void searchFieldDropDowmMenuTest() {
        WebElement input = driver.findElement(searchButton);
        input.click();
        WebElement searchField = driver.findElement(searchForm);
        searchField.sendKeys(queryForDropDownMenu);
        wait.until(ExpectedConditions.numberOfElementsToBe(dropDownResults, 2));
        List<WebElement> elements = driver.findElements(dropDownResults);
        int actualQuantity = elements.size();
        int expectedQuantity = 2;
        Assert.assertEquals(actualQuantity, expectedQuantity);
    }

}




