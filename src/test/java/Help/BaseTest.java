package Help;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BaseTest {


    public WebDriver driver;

    public static Properties property;
    public FileInputStream file;


    @Before
    public void setUp() throws FileNotFoundException {

        //accessing site with chrome browser
        System.setProperty("webdriver.chrome.driver", "C:\\Automation\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.cinemacity.ro/#/buy-tickets-by-cinema?in-cinema=1815&at=2019-07-25&view-mode=list");
        driver.manage().window().maximize();

        //wait implicit
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Loadproperty();






    }


    public void Loadproperty() throws FileNotFoundException {
        property = new Properties();
        file = new FileInputStream("C:\\Users\\Anca\\IdeaProjects\\AutomationProject\\src\\test\\java\\Resources\\Data.properties");
        try {
            property.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static String getValue(String key){
        return property.getProperty(key);

    }





    @After
    public void finish(){
        //driver.quit();
    }






















}