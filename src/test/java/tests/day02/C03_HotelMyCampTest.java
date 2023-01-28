package tests.day02;

import org.testng.annotations.Test;
import pages.HotelMyCampHomePage;
import pages.HotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_HotelMyCampTest {

    //https://www.hotelmycamp.com/ adresine git
    //login butonuna bas
    //test data username: manager ,
    //test data password : Manager1!
    //Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et

    @Test
    public void test01(){
        HotelMyCampPage hotelMyCampPage=new HotelMyCampPage();
        Driver.getDriver().get(ConfigReader.getProperty("hotelmycamp_url"));
        hotelMyCampPage.loginButonu.click();
        hotelMyCampPage.username.sendKeys(ConfigReader.getProperty("hotelmycamp_username"));
        hotelMyCampPage.password.sendKeys(ConfigReader.getProperty("hotelmycamp_password"));
        hotelMyCampPage.submitButonu.click();

        HotelMyCampHomePage hotelMyCampHomePage=new HotelMyCampHomePage();
        assert hotelMyCampHomePage.hmcHomePage.isDisplayed();
        Driver.closeDriver();

    }
}
