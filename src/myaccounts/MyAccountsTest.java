package myaccounts;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Utility;

public class MyAccountsTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    public void selectMyAccountOptions(String option) {
        Actions actions = new Actions(driver);
        WebElement ele1 = driver.findElement(By.xpath("//span[contains(text(),'My Account')]"));
        WebElement ele2 = driver.findElement(By.xpath("//a[contains(text(),'" + option + "')]"));
        actions.moveToElement(ele1).moveToElement(ele2).click().build().perform();
    }

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        //1.1 Click on My Account Link
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        //1.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        selectMyAccountOptions("Register");
        //1.3 Verify the text “Register Account”.
        verifyTextMessage("not navigated to Register Account", "Register Account", By.xpath("//h1[contains(text(),'Register Account')]"));

    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        //2.1 Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        //2.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        selectMyAccountOptions("Login");
        //2.3 Verify the text “Returning Customer”.
        verifyTextMessage("Not navigated to login page", "Returning Customer", By.xpath("//h2[contains(text(),'Returning Customer')]"));
    }

    @Test
    public void verifyThatUserRegisterAccountSuccessfully(){
        //3.1 Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        //3.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        selectMyAccountOptions("Register");
        //3.3 Enter First Name
        sendTextToElement(By.cssSelector("#input-firstname"), "Testinghv1");
        //3.4 Enter Last Name
        sendTextToElement(By.cssSelector("#input-lastname"), "Automate1");
        //3.5 Enter Email
        sendTextToElement(By.cssSelector("#input-email"), "Testinghv1@yahoo.com");
        //3.6 Enter Telephone
        sendTextToElement(By.cssSelector("#input-telephone"), "07788994455");
        //3.7 Enter Password
        sendTextToElement(By.cssSelector("#input-password"), "Password12345");
        //3.8 Enter Password Confirm
        sendTextToElement(By.cssSelector("#input-confirm"), "Password12345");
        //3.9 Select Subscribe Yes radio button
        clickOnElement(By.xpath("//body/div[@id='account-register']/div[1]/div[1]/form[1]/fieldset[3]/div[1]/div[1]/label[1]/input[1]"));
        //3.10 Click on Privacy Policy check box
        clickOnElement(By.xpath("//body/div[@id='account-register']/div[1]/div[1]/form[1]/div[1]/div[1]/input[1]"));
        //3.11 Click on Continue button
        clickOnElement(By.xpath("//body/div[@id='account-register']/div[1]/div[1]/form[1]/div[1]/div[1]/input[2]"));
        //3.12 Verify the message “Your Account Has Been Created!”
        verifyTextMessage("Not able to Register","Your Account Has Been Created!", By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]"));
        //3.13 Click on Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
        //3.14 Clickr on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        //3.15 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        selectMyAccountOptions("Logout");
        //3.16 Verify the text “Account Logout”
        verifyTextMessage("Account not logged out","Account Logout", By.xpath("//h1[contains(text(),'Account Logout')]"));
        //3.17 Click on Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
    }
    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully(){
        //4.1 Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        //4.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        selectMyAccountOptions("Login");
        //4.3 Enter Email address
        sendTextToElement(By.xpath("//input[@id='input-email']"), "Testinghv@yahoo.com");
        //4.4 Enter Last Name--? there is no such option on the website
        //4.5 Enter Password
        sendTextToElement(By.xpath("//input[@id='input-password']"), "Password12345");
        //4.6 Click on Login button
        clickOnElement(By.xpath("//body/div[@id='account-login']/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/input[1]"));
        //4.7 Verify text “My Account”
        verifyTextMessage("Not logged in to the account","My Account",By.xpath("//h2[contains(text(),'My Account')]"));
        //4.8 Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        //4.9 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        selectMyAccountOptions("Logout");
        //4.10 Verify the text “Account Logout”
        verifyTextMessage("Not logged out of the account","Account Logout",By.xpath("//h1[contains(text(),'Account Logout')]"));
        //4.11 Click on Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));

    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
