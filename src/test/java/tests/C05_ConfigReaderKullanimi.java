package tests;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C05_ConfigReaderKullanimi {
    @Test
    public void test01() {
FacebookPage facebookPage= new FacebookPage();

        //facebook anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("facebook_url"));


        //cookies kabul edin
        //kullanici mail kutusuna rastgele bir isim yazdirin
        facebookPage.mailKutusu.sendKeys(ConfigReader.getProperty("facebookWrongUsername"));

        //kullanici sifre kutusuna yanlis bir password yazdirin
        facebookPage.sifreKutusu.sendKeys(ConfigReader.getProperty("facebookWrongPassword"));

        //login butonuna basin
        facebookPage.loginButonu.click();

        //giris yapilamadigini test edin
        assert facebookPage.girilemediYazisi.isDisplayed();
        Driver.closeDriver();

    }
}