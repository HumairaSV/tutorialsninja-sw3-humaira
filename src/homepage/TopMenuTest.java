package homepage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TopMenuTest extends Utility {

    String baseUrl= "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    public void selectMenu(String menu){
        driver.findElement(By.xpath(menu)).click();
    }
    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        //1.1 Mouse hover on “Desktops” Tab and click
        mouseHoverAndClick(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]"));
        //1.2 call selectMenu method and pass the menu = “Show All Desktops”
        selectMenu("//a[contains(text(),'Show All Desktops')]");
        //1.3 Verify the text ‘Desktops’
        verifyTextMessage("Not navigated to Show all Desktops page", "Desktops", By.xpath("//h2[contains(text(),'Desktops')]"));
    }

    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully(){
        //2.1 Mouse hover on “Laptops & Notebooks” Tab and click
        mouseHoverAndClick(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]"));
        //2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
        selectMenu("//a[contains(text(),'Show All Laptops & Notebooks')]");
        //2.3 Verify the text ‘Laptops & Notebooks’
        verifyTextMessage("Not navigated to Show All Laptops & Notebooks","Laptops & Notebooks", By.xpath("//h2[contains(text(),'Laptops & Notebooks')]"));
    }

    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully(){
        //3.1 Mouse hover on “Components” Tab and click
        mouseHoverAndClick(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[3]/a[1]"));
        //3.2 call selectMenu method and pass the menu = “Show All Components”
        selectMenu("//a[contains(text(),'Show All Components')]");
        //3.3 Verify the text ‘Components’
        verifyTextMessage("Not navigated to Show All Components","Components",By.xpath("//h2[contains(text(),'Components')]"));
    }

    @After
    public void tearDown(){
        closeBrowser();
    }




}

