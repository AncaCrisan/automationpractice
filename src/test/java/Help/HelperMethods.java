package Help;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

public class HelperMethods {


    public WebDriver driver;


    //declarare constructor
    public HelperMethods(WebDriver driver){

        this.driver=driver;

    }



    //select by value from a dropdouwn list method
    public void selectByValueDropdownMethod(WebElement element, String value){

        Select elementselect = new Select(element);
        elementselect.selectByValue(value);

    }


    //validare titlul unei pagini
    public void validatePageTitle(String expectedvalue, WebDriver driver){

        if( expectedvalue.length() > 0 ){
            String actualvalue = driver.getTitle();
            Assert.assertEquals(expectedvalue, actualvalue);
        }

    }

















}
