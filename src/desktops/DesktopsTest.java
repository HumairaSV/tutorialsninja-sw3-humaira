package desktops;

import javafx.scene.control.Tab;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class DesktopsTest extends Utility {
    String baseUrl= "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductArrangeInAlphabeticalOrder()throws InterruptedException{
        //1.1 Mouse hover on Desktops Tab and click
        Thread.sleep(2000);
        mouseHoverAndClick(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]"));
        //1.2 Click on “Show All Desktops”
        clickOnElement(By.xpath("//a[contains(text(),'Show All Desktops')]"));
        //1.3 Select Sort By position "Name: Z to A"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Name (Z - A)");
        //1.4 Verify the Product will arrange in Descending order.
        verifyTextMessage("Product is not arranged in Descending order","Sony VAIO", By.cssSelector("div.container:nth-child(4) div.row div.col-sm-9 div.row:nth-child(7) div.product-layout.product-grid.col-lg-4.col-md-4.col-sm-6.col-xs-12:nth-child(1) div.product-thumb div:nth-child(2) div.caption h4:nth-child(1) > a:nth-child(1)"));
        verifyTextMessage("Product is not arranged in Descending order","HP LP3065", By.cssSelector("div.container:nth-child(4) div.row div.col-sm-9 div.row:nth-child(7) div.product-layout.product-grid.col-lg-4.col-md-4.col-sm-6.col-xs-12:nth-child(10) div.product-thumb div:nth-child(2) div.caption h4:nth-child(1) > a:nth-child(1)"));
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        //2.1 Mouse hover on Desktops Tab. and click
        Thread.sleep(2000);
        mouseHoverAndClick(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]"));
        //2.2 Click on “Show All Desktops”
        clickOnElement(By.xpath("//a[contains(text(),'Show All Desktops')]"));
        //2.3 Select Sort By position "Name: A to Z"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Name (A - Z)");
        //2.4 Select product “HP LP3065”
        clickOnElement(By.xpath("//a[contains(text(),'HP LP3065')]"));
        //2.5 Verify the Text "HP LP3065"
        verifyTextMessage("not navigated to selected product- HP LP3065 ","HP LP3065",By.xpath("//h1[contains(text(),'HP LP3065')]"));
        //2.6 Select Delivery Date "2022-11-30"
        String year = "2022";
        String month = "November";
        String date = "30";
        clickOnElement(By.xpath("//span[@class = 'input-group-btn']//i[@class = 'fa fa-calendar']"));
        //  I keep getting Array out of bound exception even though sout is printing the array element at index 1-please advise
        /*while(true){
            Thread.sleep(2000);
            String monthYear = driver.findElement(By.xpath("//div[@class = 'datepicker-days']//tr[1]/th[2]")).getText();
            System.out.println(monthYear);
            String arr[] = monthYear.split(" ");
            String mon = arr[0];
            //System.out.println(mon);
            //Thread.sleep(5000);
            String yr = arr[1];
            //Thread.sleep(5000);
            //System.out.println(yr);

            if(mon.equalsIgnoreCase(month) && yr.equalsIgnoreCase(year)){
                //System.out.println("checking");
                break;
            }else{
                clickOnElement(By.xpath("//div[@class= 'datepicker-days']//tr[1]/th[3]"));
            }
            //selecting the date
            List<WebElement> allDates = driver.findElements(By.xpath("//td[@class = 'day']"));
            for(WebElement dateReq:allDates){
                if(dateReq.getText().equalsIgnoreCase(date)){
                    dateReq.click();
                    break;
                }
            }
        }*/

        //2.7.Enter Qty "1” using Select class
        driver.findElement(By.xpath("//input[@id='input-quantity']")).clear();
        sendTextToElement(By.xpath("//input[@id='input-quantity']"), "1");
        //2.8 Click on “Add to Cart” button
        clickOnElement(By.xpath("//button[@id='button-cart']"));
        //2.9 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
        Thread.sleep(6000);
        verifyTextMessage("Item not added to the cart successfully", "Success: You have added HP LP3065 to your shopping cart!\n" + "×", By.xpath("//div[@class = 'alert alert-success alert-dismissible']"));
        //2.10 Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));
        //2.11 Verify the text "Shopping Cart"
        verifyTextMessage("User is not navigated to the shopping cart","Shopping Cart", By.xpath("//a[contains(text(),'Shopping Cart')]"));
        //2.12 Verify the Product name "HP LP3065"
        verifyTextMessage("Unable to verify the product name -HP LP3065 ","HP LP3065", By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]"));
        //2.13 Verify the Delivery Date "2022-11-30"
        //verifyTextMessage("Unable to confirm the delivery date:  2022-11-30", "2022-11-30", By.cssSelector("div.container:nth-child(4) div.row div.col-sm-12 div.table-responsive table.table.table-bordered tbody:nth-child(2) tr:nth-child(1) td.text-left:nth-child(2) > small:nth-child(3)"));
        //2.14 Verify the Model "Product 21"
        verifyTextMessage("Unable to verify model is Product21","Product 21",By.xpath("//td[contains(text(),'Product 21')]"));
        //2.15 Verify the Total "£74.73"
        verifyTextMessage("Unable to verify the total is £74.73", "£74.73",By.xpath("//body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[4]/td[2]"));

    }


    @After
    public void tearDown(){
        closeBrowser();
    }
}
