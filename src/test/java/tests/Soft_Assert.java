package tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.WebAppSecurityHomePage;
import pages.WebAppSecurityLoginPage;
import pages.WebAppSecurityPayPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Soft_Assert {
    WebAppSecurityLoginPage webAppSecurityLoginPage;
    WebAppSecurityHomePage webAppSecurityHomePage;
    WebAppSecurityPayPage webAppSecurityPayPage;
    @Test
    public void test01() throws InterruptedException {

        //Yeni bir Class Olusturun : C03_SoftAssert
        //1. “http://zero.webappsecurity.com/” Adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("was_url"));

        //2. Sign in butonuna basin
        webAppSecurityLoginPage =new WebAppSecurityLoginPage();
        webAppSecurityLoginPage.signin.click();

        //3. Login kutusuna “username” yazin
        webAppSecurityLoginPage.login.sendKeys(ConfigReader.getProperty("was_username"));

        //4. Password kutusuna “password” yazin
        webAppSecurityLoginPage.password.sendKeys(ConfigReader.getProperty("was_password"));

        //5. Sign in tusuna basin
        webAppSecurityLoginPage.submit.click();
        Driver.getDriver().navigate().back();

        //6. Online banking menusu icinde Pay Bills sayfasina gidin
       webAppSecurityHomePage=new WebAppSecurityHomePage();
       webAppSecurityHomePage.onlineBanking.click();
       webAppSecurityHomePage.payBills.click();

        //7. “Purchase Foreign Currency” tusuna basin
        webAppSecurityPayPage=new WebAppSecurityPayPage();
        webAppSecurityPayPage.purchase.click();
        Thread.sleep(3000);

        //8. “Currency” drop down menusunden Eurozone’u secin
        Select select=new Select(webAppSecurityPayPage.ddm);
        select.selectByVisibleText("Eurozone (euro)");

        //9. soft assert kullanarak "Eurozone (Euro)" secildigini test edin
        String actualResult = select.getFirstSelectedOption().getText();
        String expectedResult = "Eurozone (euro)";
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualResult, expectedResult);
        //softAssert.assertTrue(webAppSecurityPayPage.ddm.isSelected());

        //10.soft assert kullanarak DropDown listesinin su secenekleri oldugunu test
        //edin "Select One", "Australia (dollar)", "Canada (dollar)","Switzerland
        //(franc)","China (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain
        //(pound)","Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway
        //(krone)","New Zealand (dollar)","Sweden (krona)","Singapore
        //(dollar)","Thailand (baht)"

        List<WebElement> ddmOptions = select.getOptions();
        List<String> actualOptions = new ArrayList<>();
        for (WebElement w : ddmOptions) {
            actualOptions.add(w.getText());
        }
        System.out.println(actualOptions);
        String []arr={"Select One", "Australia (dollar)", "Canada (dollar)",
                "Switzerland (franc)","China (yuan)","Denmark (krone)",
                "Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)",
                "Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand (dollar)",
                "Sweden (krona)","Singapore (dollar)","Thailand (baht)"};
        List<String> options= new ArrayList<>();
        for (String w : arr) {
            options.add(w);
        }
        System.out.println(options);
        softAssert.assertEquals(actualOptions, options);
        softAssert.assertAll();
    }
}
