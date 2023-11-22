package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. verifyTheTotalItemsDisplayedOnTheWomensJacketsPage()
 * * Click on ‘Sale’ Menu tab
 * * Click on ‘Jackets’ link on left side under WOMEN’S DEAL Category
 * * Verify the text ‘Jackets’ is displayed
 * * Count the Total Item Displayed on Page and print the name of all items into console.
 * * Verify total 12 Items displayed on page.
 */

public class SaleTest extends BaseTest {

    @Before
    public void setUp() {
        openBrowser("https://magento.softwaretestingboard.com");
    }

    @Test
    public void verifyTheTotalItemsDisplayedOnTheWomensJacketsPage() {
        driver.findElement(By.id("ui-id-8")).click();
        driver.findElement(By.linkText("Jackets")).click();
        String expectedText = "Jackets";
        String actualText = driver.findElement(By.xpath("//span[@class='base']")).getText();
        Assert.assertEquals("Text is not displayed", expectedText, actualText);

        List<WebElement> items = new ArrayList<>();
        int actualItemCount = items.size();
        System.out.println("Total items displayed on page: " + actualItemCount);
        System.out.println("Name of all items on page:");
        List<WebElement> count = driver.findElements(By.xpath("//Strong[@class='product name product-item-name']"));
        int totalNoOfProductsOnPage = count.size();
        System.out.println("Total No of products displayed on page:" + totalNoOfProductsOnPage);
        for (WebElement products : count) {
            System.out.println("product :" + products.getText());

        }
        int expectedProductOnPage = 12;
        Assert.assertEquals("12 Products are displayed", expectedProductOnPage, totalNoOfProductsOnPage);

    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}