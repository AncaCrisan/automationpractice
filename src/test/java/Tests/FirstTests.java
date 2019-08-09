package Tests;

import Help.BaseTest;
import Help.HelperMethods;
import com.sun.org.apache.bcel.internal.generic.L2I;
import net.bytebuddy.asm.Advice;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.Keys.ENTER;


public class FirstTests extends BaseTest {


    public HelperMethods selector = new HelperMethods(driver);

    public String namevalue;
    public String surnamevalue;
    public String emailvalue;
    public String phonevalue;


    @Test
    public void test1(){



        //set RO language
        WebElement languageweb = driver.findElement(By.xpath("//li[@class='language-selector']//button"));//-->  //html/body/div[1]/div[1]/div/div/div[2]/nav/div/ul/li[4]/div/div/button
        languageweb.click();
        WebElement ROweb = driver.findElement(By.xpath("//li[@class='selected active']"));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ROweb.click();




        //validate that we are on homepage
        selector.validatePageTitle(BaseTest.getValue("homemessage"),driver);



        //validate "Acum in program" message
        String expectedmessage=BaseTest.getValue("message");
        WebElement message1= driver.findElement(By.xpath("//h1[contains(text(),'Acum în program')]"));
        String actualmessage = message1.getText();
        Assert.assertEquals(expectedmessage,actualmessage);



        //select a cinema
        WebElement selecteazacinemaweb = driver.findElement(By.xpath("//button[@data-id='select8']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", selecteazacinemaweb);//scroll pana la webelementul dorit
//        try {
//            Thread.sleep(7000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        new WebDriverWait(driver,10000).until(ExpectedConditions.visibilityOf(selecteazacinemaweb));

        selecteazacinemaweb.click();


        Random random = new Random();
        List<WebElement> cinemaOptionsWeb=driver.findElements(By.xpath("//div[@class='dropdown-menu open']//input[@placeholder='Selectează cinema']/../..//a/span"));
        int index = random.nextInt(15);
        Actions action = new Actions(driver);
        action.moveToElement(cinemaOptionsWeb.get(index)).build().perform();
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String actualcinema = cinemaOptionsWeb.get(index).getText().toUpperCase() + "\n" + " ";
        int actualsize = actualcinema.length();

//        new WebDriverWait(driver,10000).until(ExpectedConditions.visibilityOf(cinemaOptionsWeb.get(index)));

        cinemaOptionsWeb.get(index).click();



        //validate cinema
        String expectedcinema = selecteazacinemaweb.getText() ;
        int expectedsize = expectedcinema.length();
        Assert.assertEquals(actualsize,expectedsize);



        //select film
        WebElement alegefilmweb = driver.findElement(By.xpath("//span[contains(text(),'Alege un film')]"));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        alegefilmweb.click();

        WebElement filmweb = driver.findElement(By.xpath("//span[contains(text(),'Furios si iute:Hobbs & Shaw')]"));

        String actualfilm = filmweb.getText().toUpperCase();
        int actualfilmsize = actualfilm.length();

        filmweb.click();



        //validate film title
        String expectedfilm = "Furios si iute:Hobbs & Shaw";
        int expectedfilmsize = expectedfilm.length();
        Assert.assertEquals(expectedfilmsize,actualfilmsize);



        //select day
        WebElement aziweb = driver.findElement(By.xpath("//button[@data-automation-id='day_1']"));
        aziweb.click();



        //validate day
        WebElement textdataweb = driver.findElement(By.xpath("//div[@class='col-xs-6 col-sm-5 col-md-4 pb-none qb-date']/h4"));
        String actualdata = textdataweb.getText();
        int actualdatasize = actualdata.length();

        String expecteddata = "Mâine (07.08.2019)";
        int expecteddatasize = expecteddata.length();

        Assert.assertEquals(expecteddatasize,actualdatasize);




        //open and close calendar
        WebElement calendarweb = driver.findElement(By.xpath("//button[@title='Alege o dată']"));
        calendarweb.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement closecalendar = driver.findElement(By.xpath("//span[@class='fa fa-times pull-right datepicker-close']"));
        closecalendar.click();



        //select hour
        Random randomhour = new Random();
        List<WebElement> hourOptionsWeb1 = driver.findElements(By.xpath("//div[@class='col-xs-12 col-sm-7 col-md-8 events']/div[1]/div/a"));
        int web1 = hourOptionsWeb1.size();

        if(web1 != 0){
            int ora1 = randomhour.nextInt(web1);
            Actions action1 = new Actions(driver);
            action1.moveToElement(hourOptionsWeb1.get(ora1)).build().perform();
            hourOptionsWeb1.get(ora1).click();

        }



        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////



        //BOOKING TYPE page

        //validate "BookingType" page
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        selector.validatePageTitle(BaseTest.getValue("pagemessage"),driver);



        //validate "Campuri obligatorii" message
        String expectedmessage2 = BaseTest.getValue("message2");
        WebElement message2 = driver.findElement(By.xpath("//span[contains(text(),'Campuri Obligatorii')]"));
        String actualmessage2 = message2.getText();
        Assert.assertTrue(expectedmessage2.equals(actualmessage2));



        //validate "Rezervare si cumparare bilete" message
        String expectedmessage3 = BaseTest.getValue("message3");
        WebElement message3 = driver.findElement(By.xpath("//h1[contains(text(),'Rezervare si Cumparare Bilete')]"));
        String actualmessage3 = message3.getText();
        Assert.assertEquals(expectedmessage3,actualmessage3);



        //validate "Rezervare" message
        String expectedmessage4 = BaseTest.getValue("message4");
        WebElement message4 = driver.findElement(By.xpath("//label[contains(text(),'Rezervare')]"));
        String actualmessage4 = message4.getText();
        Assert.assertEquals(expectedmessage4,actualmessage4);



        //validate message
        String expectedmessage5 = BaseTest.getValue("message5");
        WebElement message5 = driver.findElement(By.xpath("//div[contains(text(),'Rezerva locurile acum si le poti cumpara de la casele de bilete din cinematograful selectat, dar nu mai tarziu de 30 de minute inainte de inceperea filmului. Anumite locuri sunt exclusiv disponibile pentru cumpararea de bilete, nu si pentru rezervare.')]"));
        String actualmessage5 = message5.getText();
        Assert.assertEquals(expectedmessage5,actualmessage5);



        //validate "Cumparare bilete" message
        String expectedmessage6 = BaseTest.getValue("message6");
        WebElement message6 = driver.findElement(By.xpath("//label[contains(text(),'Cumparare bilete')]"));
        String actualmessage6 = message6.getText();
        Assert.assertEquals(expectedmessage6,actualmessage6);



        //validate message
        String expectedmessage7 = BaseTest.getValue("message7");
        WebElement message7 = driver.findElement(By.xpath("//div[contains(text(),'Cumpara biletele acum si evita cozile de la casele de bilete')]"));
        String actualmessage7 = message7.getText();
        Assert.assertEquals(expectedmessage7,actualmessage7);



        //select "Rezervare"
        Actions rezervaction = new Actions(driver);
        WebElement rezervareweb = driver.findElement(By.id("rbr"));
        rezervaction.moveToElement(rezervareweb).build().perform();
        rezervareweb.click();



        //"Pasul Urmator"
        WebElement pasurmweb = driver.findElement(By.xpath("//a[contains(text(),'Pasul urmator')]"));
        pasurmweb.click();



        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////



        //CINEMA CITY page

        //validate "Cinema City" page
        selector.validatePageTitle(BaseTest.getValue("pagemessage2"),driver);



        //validate "Selecteaza Biletele" message
        String expectedmessage8 = BaseTest.getValue("message8");
        WebElement message8 = driver.findElement(By.xpath("//h1[contains(text(),'Selecteaza biletele')]"));
        String actualmessage8 = message8.getText();
        Assert.assertEquals(expectedmessage8,actualmessage8);



        //click "SELECTEAZA LOCURILE" button without selecting the number of tickets
        WebElement selecteazaLocurileButton = driver.findElement(By.xpath("//a[contains(text(),'Selecteaza locurile')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", selecteazaLocurileButton);
        selecteazaLocurileButton.click();

        String expectErrorMessage = BaseTest.getValue("Serrormessage");
        WebElement errorMessageweb = driver.findElement(By.xpath("//div[contains(text(),'Nu a fost selectat niciun bilet. Va rog sa le selectati')]"));
        String actErrorMessage = errorMessageweb.getText();
        Assert.assertEquals(expectErrorMessage,actErrorMessage);



        //select 2 tickets
        WebElement ticketWeb = driver.findElement(By.xpath("//select[@id='ddQunatity_1']"));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ticketWeb.click();

        List<WebElement> ticketListWeb = driver.findElements(By.xpath("//select[@id='ddQunatity_1']/option"));
        for(int i = 0 ; i < ticketListWeb.size() ; i++){
            if(i == 2){
                ticketListWeb.get(i).click();
            }
        }

        //click Selecteaza Locurile button
        selecteazaLocurileButton.click();



        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////



        //COMANDA PAGE

        //validate new page
        selector.validatePageTitle(BaseTest.getValue("pagemessage3"),driver);



        //click on zoom in button for 3 times
        WebElement zoomINweb = driver.findElement(By.xpath("//button[@class='zoom-in']"));
        for(int i=0;i<3;i++){
            zoomINweb.click();
        }



        //click on zoom out buuton one time
        WebElement zoomOUTweb = driver.findElement(By.xpath("//button[@class='zoom-out']"));
        zoomOUTweb.click();



        //click on "RESETARE ZOOM" button
        WebElement resetareZoomweb = driver.findElement(By.xpath("//button[@class='reset']"));
        resetareZoomweb.click();







        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////



        //DATE PERSONALE page

//        //validate message DATE PERSONALE
//        String expectedmessage9 = BaseTest.getValue("message9");
//        WebElement message9 = driver.findElement(By.xpath("//h2[contains(text(),'Date personale')]"));
//        String actualmessage9 = message9.getText();
//        Assert.assertEquals(expectedmessage9,actualmessage9);
//
//
//
//        //completare nume, prenume, telefon, email
//        namevalue = "" + BaseTest.getValue("numevalues");
//        surnamevalue = "" + BaseTest.getValue("prenumevalues");
//        phonevalue = "" + BaseTest.getValue("telefonvalues");
//        emailvalue = "" + BaseTest.getValue("mailvalues");
//
//        String[] parsename = namevalue.split(",");
//        String[] parsesurname = surnamevalue.split(",");
//        String[] parsephone = phonevalue.split(",");
//        String[] parseemail = emailvalue.split(",");
//
//        for(int i=0 ; i<4 ; i++){
//            WebElement numeweb = driver.findElement(By.xpath("//input[@placeholder='Nume']"));
//            WebElement surnameweb = driver.findElement(By.xpath("//input[@placeholder='Prenume']"));
//            WebElement phoneweb = driver.findElement(By.xpath("//input[@placeholder='Numar telefon']"));
//            WebElement emailweb = driver.findElement(By.xpath("//input[@placeholder='E-mail']"));
//            WebElement pasulUrmatorweb = driver.findElement(By.xpath("//a[@id='lbNext']"));
//
//
//            //1.The process with empty nume + prenume + telefon + email
//            if(i==0){
//                pasulUrmatorweb.click();
//
//                WebElement numeError1 = driver.findElement(By.xpath("//span[@id='ctl00_CPH1_OrderFormControl1_ReqVal_5']"));
//                String numeExpectMessage1 = BaseTest.getValue("numeerror1");
//                String numeActMessage1 = numeError1.getText();
//                Assert.assertEquals(numeExpectMessage1,numeActMessage1);
//
//                WebElement prenumeError1 = driver.findElement(By.xpath("//span[@id='ctl00_CPH1_OrderFormControl1_ReqVal_7']"));
//                String prenumExpectMessage1 = BaseTest.getValue("prenumeerror1");
//                String prenumActMessage1 = prenumeError1.getText();
//                Assert.assertEquals(prenumExpectMessage1,prenumActMessage1);
//
//                WebElement emailError1 = driver.findElement(By.xpath("//span[@id='ctl00_CPH1_OrderFormControl1_ReqVal_20']"));
//                String emailExpectMessage1 = BaseTest.getValue("emailerror1");
//                String emailActMessage1 = emailError1.getText();
//                Assert.assertEquals(emailExpectMessage1,emailActMessage1);
//
//                WebElement telError1 = driver.findElement(By.xpath("//span[@id='ctl00_CPH1_OrderFormControl1_ReqVal_21']"));
//                String telExpectMessage1 = BaseTest.getValue("telefonerror1");
//                String telActMessage1 = telError1.getText();
//                Assert.assertEquals(telExpectMessage1,telActMessage1);
//
//                driver.navigate().refresh();
//            }
//
//            //2.The process with only spaces on nume + prenume + telefon + email
//            if(i==1){
//                namevalue = parsename[1];
//                surnamevalue = parsesurname[1];
//                emailvalue = parseemail[1];
//                phonevalue = parsephone[1];
//
//                numeweb.sendKeys(namevalue);
//                surnameweb.sendKeys(surnamevalue);
//                emailweb.sendKeys(emailvalue);
//                phoneweb.sendKeys(phonevalue);
//
//                pasulUrmatorweb.click();
//
//                WebElement numeError2 = driver.findElement(By.xpath("//span[@id='ctl00_CPH1_OrderFormControl1_ReqVal_5']"));
//                String numeExpectMessage2 = BaseTest.getValue("numeerror1");
//                String numeActMessage2 = numeError2.getText();
//                Assert.assertEquals(numeExpectMessage2,numeActMessage2);
//
//                WebElement prenumeError2 = driver.findElement(By.xpath("//span[@id='ctl00_CPH1_OrderFormControl1_ReqVal_7']"));
//                String prenumExpectMessage2 = BaseTest.getValue("prenumeerror1");
//                String prenumActMessage2 = prenumeError2.getText();
//                Assert.assertEquals(prenumExpectMessage2,prenumActMessage2);
//
//                WebElement emailError2 = driver.findElement(By.xpath("//span[@id='ctl00_CPH1_OrderFormControl1_ReqVal_20']"));
//                String emailExpectMessage2 = BaseTest.getValue("emailerror1");
//                String emailActMessage2 = emailError2.getText();
//                Assert.assertEquals(emailExpectMessage2,emailActMessage2);
//
//                WebElement telError2 = driver.findElement(By.xpath("//span[@id='ctl00_CPH1_OrderFormControl1_ReqVal_21']"));
//                String telExpectMessage2 = BaseTest.getValue("telefonerror1");
//                String telActMessage2 = telError2.getText();
//                Assert.assertEquals(telExpectMessage2,telActMessage2);
//
//                driver.navigate().refresh();
//            }
//
//            //3.The process with special characters on nume + prenume + telefon + email
//            if(i==2){
//                namevalue = parsename[2];
//                surnamevalue = parsesurname[2];
//                emailvalue = parseemail[2];
//                phonevalue = parsephone[2];
//
//                numeweb.sendKeys(namevalue);
//                surnameweb.sendKeys(surnamevalue);
//                emailweb.sendKeys(emailvalue);
//                phoneweb.sendKeys(phonevalue);
//
//                pasulUrmatorweb.click();
//
//                WebElement emailError3 = driver.findElement(By.xpath("//span[@id='ctl00_CPH1_OrderFormControl1_ReqVal_20']"));
//                String emailExpectMessage3 = BaseTest.getValue("emailerror2");
//                String emailActMessage3 = emailError3.getText();
//                Assert.assertEquals(emailExpectMessage3,emailActMessage3);
//
//                WebElement telError3 = driver.findElement(By.xpath("//span[@id='ctl00_CPH1_OrderFormControl1_ctl14']"));
//                String telExpectMessage3 = BaseTest.getValue("telefonerror2");
//                String telActMessage3 = telError3.getText();
//                Assert.assertEquals(telExpectMessage3,telActMessage3);
//
//            }
//            //4.The process with numbers on nume + prenume + telefon + email
//            if(i==3){
//                namevalue = parsename[3];
//                surnamevalue = parsesurname[3];
//                emailvalue = parseemail[3];
//                phonevalue = parsephone[3];
//
//                numeweb.sendKeys(namevalue);
//                surnameweb.sendKeys(surnamevalue);
//                emailweb.sendKeys(emailvalue);
//                phoneweb.sendKeys(phonevalue);
//
//                pasulUrmatorweb.click();
//
//            }
//
//        }



















    }//acolada de la test



}//acolada clasei
