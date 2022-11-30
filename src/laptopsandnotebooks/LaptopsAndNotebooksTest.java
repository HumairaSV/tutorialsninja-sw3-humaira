package laptopsandnotebooks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class LaptopsAndNotebooksTest extends Utility {

    String baseUrl= "http://tutorialsninja.com/demo/index.php?";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() throws InterruptedException {
        //1.1 Mouse hover on Laptops & Notebooks Tab.and click
        Thread.sleep(2000);
        mouseHoverAndClick(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]"));
        //1.2 Click on “Show All Laptops & Notebooks”
        clickOnElement(By.xpath("//a[contains(text(),'Show All Laptops & Notebooks')]"));
        //1.3 Select Sort By "Price (High > Low)"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Price (High > Low)");
        //1.4 Verify the Product price will arrange in High to Low order
        verifyTextMessage("Products not arranged in High to Low 1","£1,225.00", By.xpath("//body/div[@id='product-category']/div[1]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/p[2]"));
        verifyTextMessage("Products not arranged in High to Low 2","£74.73", By.xpath("//body/div[@id='product-category']/div[1]/div[1]/div[4]/div[5]/div[1]/div[2]/div[1]/p[2]"));
    }

    @Test
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException{
        //2.1 Mouse hover on Laptops & Notebooks Tab and click
        Thread.sleep(2000);
        mouseHoverAndClick(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]"));
        //2.2 Click on “Show All Laptops & Notebooks”
        clickOnElement(By.xpath("//a[contains(text(),'Show All Laptops & Notebooks')]"));
        //2.3 Select Sort By "Price (High > Low)"
        Thread.sleep(2000);
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Price (High > Low)");
        //2.4 Select Product “MacBook”
        Thread.sleep(2000);
        clickOnElement(By.xpath("//body/div[@id='product-category']/div[1]/div[1]/div[4]/div[4]/div[1]/div[2]/div[1]/h4[1]/a[1]"));
        //2.5 Verify the text “MacBook”
        Thread.sleep(2000);
        verifyTextMessage("not navigated to the product-Macbook","MacBook", By.xpath("//h1[contains(text(),'MacBook')]"));
        //2.6 Click on ‘Add To Cart’ button
        clickOnElement(By.cssSelector("#button-cart"));
        //2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        verifyTextMessage("Unable to confirm that product was added to shopping cart","Success: You have added MacBook to your shopping cart!\n" + "×", By.xpath("//div[@class= 'alert alert-success alert-dismissible']"));
        //2.8 Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));
        //2.9 Verify the text "Shopping Cart"
        verifyTextMessage("Not navigated to Shopping cart","Shopping Cart", By.xpath("//a[contains(text(),'Shopping Cart')]"));
        //2.10 Verify the Product name "MacBook"
        verifyTextMessage("Unable to confirm product name- MacBook","MacBook",By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]"));
        //2.11 Change Quantity "2"
        driver.findElement(By.xpath("//input[@value = '1']")).clear();
        sendTextToElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/input[1]"), "2");
        //2.12 Click on “Update” Tab
        clickOnElement(By.xpath("//i[@class = 'fa fa-refresh']"));
        //2.13 Verify the message “Success: You have modified your shopping cart!”
        verifyTextMessage("Shopping cart not updated","Success: You have modified your shopping cart!\n" + "×" ,By.xpath("//div[@class = 'alert alert-success alert-dismissible']"));
        //2.14 Verify the Total £737.45
        Thread.sleep(2000);
        verifyTextMessage("Basket total is not equal to £737.45","£737.45",By.xpath("//body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[4]/td[2]"));
        //2.15 Click on “Checkout” button
        clickOnElement(By.xpath("//a[contains(text(),'Checkout')]"));
        //2.16 Verify the text “Checkout”
        Thread.sleep(2000);
        verifyTextMessage("Not navigated to checkout","Checkout",By.xpath("//h1[contains(text(),'Checkout')]"));
        //2.17 Verify the Text “New Customer”
        verifyTextMessage("New Customer text not seen","New Customer",By.xpath("//h2[contains(text(),'New Customer')]"));
        //2.18 Click on “Guest Checkout” radio button
        clickOnElement(By.xpath("//input[@value= 'guest']"));
        //2.19 Click on “Continue” tab
        clickOnElement(By.xpath("//input[@value= 'Continue']"));
        //2.20 Fill the mandatory fields
        sendTextToElement(By.cssSelector("#input-payment-firstname"), "Testerhv2");//firstname
        sendTextToElement(By.cssSelector("#input-payment-lastname"), "Automation1");//lastname
        sendTextToElement(By.cssSelector("#input-payment-email"),"testerhv2@gmail.com");//email
        sendTextToElement(By.cssSelector("#input-payment-telephone"), "07744112255");//phone no
        sendTextToElement(By.cssSelector("#input-payment-address-1"), "701 Test Ave");//address line 1
        sendTextToElement(By.cssSelector("#input-payment-city"), "Manchester");//city
        sendTextToElement(By.cssSelector("#input-payment-postcode"), "O14 5bh");//post code
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-payment-country']"), "United Kingdom");//country
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-payment-zone']"), "Greater Manchester");//Region
        //2.21 Click on “Continue” Button
        clickOnElement(By.cssSelector("#button-guest"));
        //2.22 Add Comments About your order into text area
        sendTextToElement(By.xpath("//body/div[@id='checkout-checkout']/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/p[2]/textarea[1]"), "Please ensure prompt shipping");
        //2.23 Check the Terms & Conditions check box
        Thread.sleep(2000);
        clickOnElement(By.xpath("//input[@type= 'checkbox']"));
        //2.24 Click on “Continue” button
        clickOnElement(By.cssSelector("#button-payment-method"));
        //2.25 Verify the message “Warning: Payment method required!”
        Thread.sleep(2000);
        verifyTextMessage("Warning message not received","Warning: Payment method required!\n" + "×" ,By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
    }


    @After
    public void tearDown(){
        closeBrowser();
    }
}
