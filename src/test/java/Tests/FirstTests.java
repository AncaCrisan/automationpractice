package Tests;

import Help.BaseTest;
import Help.HelperMethods;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class FirstTests extends BaseTest {


    public HelperMethods selector = new HelperMethods(driver);


    @Test
    public void test1(){

        //validate that we are on homepage
        String expectedvalue = "Cele mai recente filme- Filme Noi-Filme 3D | Cinema City";
        selector.validatePageTitle(expectedvalue,driver);

        //
        WebElement cinemaweb = driver.findElement(By.xpath("//button[@data-id='select8']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", cinemaweb);

        String cinemavalue= BaseTest.getValue("cinemaName");
        //cinemaweb.click();




























    }


















}
