package testsuite;

/**
 * 1. verifyThatSignInPageDisplay
 *  click on the ‘Create an Account’ link
 * Verify the text ‘Create New Customer Account’
 * 2. userShouldRegisterAccountSuccessfully
 * click on the ‘Create an Account’ link
 * Enter First name
 * Enter Last name
 * Click on checkbox Sign Up for Newsletter
 * Enter Email
 * Enter Password
 * Enter Confirm Password
 * Click on Create an Account button
 * Verify the text 'Thank you for registering with Main Website Store.'
 * Click on down aero near Welcome
 * Click on Sign Out link
 * Verify the text ‘You are signed out’
 */

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterTest extends BaseTest {

    String baseUrl = " https://magento.softwaretestingboard.com/";

    //open the browser
    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    //Click on the register link
    @Test
    public void verifyThatSignInPageDisplay() {
        WebElement createAnAccount = driver.findElement(By.xpath("//header/div[1]/div[1]/ul[1]/li[3]/a[1]"));
        createAnAccount.click();

        // verify the text ‘Create New Customer Account’
        String expectMessage = "Create New Customer Account";

        //find the text 'Create New Customer Account’element and get the text
        WebElement actualMessageElement = driver.findElement(By.xpath("//span[@class='base']"));
        String actualMessage = actualMessageElement.getText();
        Assert.assertEquals("Not navigate to create an account page", expectMessage, actualMessage);

    }

    //userShouldRegisterAccountSuccessfully
    @Test
    public void userShouldRegisterAccountSuccessfully() {
        driver.findElement(By.linkText("Create an Account")).click();
        driver.findElement(By.name("firstname")).sendKeys("Vahane");
        driver.findElement(By.name("lastname")).sendKeys("Nane");
        //driver.findElement(By.linkText());
        driver.findElement(By.name("email")).sendKeys("Vahane2023@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Vahane123?");
        driver.findElement(By.id("password-confirmation")).sendKeys("Vahane123?");

        driver.findElement(By.xpath("//button[@title='Create an Account']")).click();// Find create an account button and click on it
        String expectedText = "Thank you for registering with Main Website Store.";
        String actualText = driver.findElement(By.xpath("//div[@class='message-success success message']")).getText();//Find actual text and get it with get method
        Assert.assertEquals("User is not on main website store",expectedText,actualText);// Checking Actual text with Expected text

        driver.findElement(By.xpath("//span[@class='customer-name']")).click();//Find down aero and click on it
        driver.findElement(By.linkText("Sign Out")).click();//Find Sign out link and click on it.
        // Verify the 'You are signed out' text
        WebDriverWait web = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement signOutMessage = web.until(ExpectedConditions.visibilityOfElementLocated(By.className("page-title")));
        assert signOutMessage.getText().equals("You are signed out");
    }

    @After
    public void tearDown() {
           driver.close();
    }
}
