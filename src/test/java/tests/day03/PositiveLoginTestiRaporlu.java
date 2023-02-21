package tests.day03;

import org.testng.annotations.Test;
import pages.HotelMyCampHomePage;
import pages.HotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class PositiveLoginTestiRaporlu extends TestBaseRapor {
    HotelMyCampPage hotelMyCampPage;
    HotelMyCampHomePage hotelMyCampHomePage;
    @Test
    public void test01() {
        extentTest=extentReports.createTest("Pozitif Login ", "Gecerli username ve password ile giris yapabilmeli");

        hotelMyCampPage = new HotelMyCampPage();
        Driver.getDriver().get(ConfigReader.getProperty("hotelmycamp_url"));
        extentTest.info("hmc anasayfaya gidildi");

        hotelMyCampPage.loginButonu.click();
        extentTest.info("login butonuna tiklandi");

        hotelMyCampPage.username.sendKeys(ConfigReader.getProperty("hotelmycamp_username"));
        extentTest.info("Gecerli username yazildi");

        hotelMyCampPage.password.sendKeys(ConfigReader.getProperty("hotelmycamp_password"));
        extentTest.info("Gecerli password yazildi");

        hotelMyCampPage.submitButonu.click();
        extentTest.info("login butonuna basildi");

       hotelMyCampHomePage = new HotelMyCampHomePage();
        assert hotelMyCampHomePage.hmcHomePage.isDisplayed();
        extentTest.pass("Kullanici basarili sekilde giris yapti");

        Driver.closeDriver();
    }
}
