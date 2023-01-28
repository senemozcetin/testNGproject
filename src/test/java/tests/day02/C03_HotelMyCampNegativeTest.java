package tests.day02;

import org.testng.annotations.Test;
import pages.HotelMyCampNegativePage;
import utilities.ConfigReader;
import utilities.Driver;

//Bir test method olustur NegativeLoginTest()
//https://www.hotelmycamp.com/ adresine git
//login butonuna bas
//test data username: manager1 ,
//test data password : manager1!
//Degerleri girildiginde sayfaya girilemedigini test et

public class C03_HotelMyCampNegativeTest {
    @Test
    public void test01(){
        HotelMyCampNegativePage hotelMyCampNegativePage=new HotelMyCampNegativePage();
        Driver.getDriver().get(ConfigReader.getProperty("hotelmycamp_url"));
        hotelMyCampNegativePage.loginButonu.click();
        hotelMyCampNegativePage.username.sendKeys(ConfigReader.getProperty("hotelmycampWrong_username"));
        hotelMyCampNegativePage.password.sendKeys(ConfigReader.getProperty("hotelmycamp_password"));
        hotelMyCampNegativePage.submitButonu.click();
        assert hotelMyCampNegativePage.hataYazisi.isDisplayed();
        Driver.closeDriver();

    }
}
