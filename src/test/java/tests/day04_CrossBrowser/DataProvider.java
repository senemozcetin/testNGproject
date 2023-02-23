package tests.day04_CrossBrowser;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class DataProvider {
    AmazonPage amazonPage;
    @Test
    public void test01() {
        //amazon anasayfaya gidelim
        Driver.getDriver().get(ConfigReader.getProperty("amazon_url"));
        //nutella icin arama yapalim
        amazonPage=new AmazonPage();
        amazonPage.aramaKutusu.sendKeys("Nutella"+Keys.ENTER);

        //sonuclarin nutella icerdigini test edelim
        Assert.assertTrue(amazonPage.aramaSonucYazisi.getText().contains("Nutella"));

        //driver i kapatalim
        Driver.closeDriver();
    }


    @org.testng.annotations.DataProvider
    public static Object[][] AranacakKelimeler() {
        Object[][] arananKelimeArrayi={{"Nutella"},{"Java"},{"cigdem"},{"Netherlands"}};
        return arananKelimeArrayi;
    }
    @Test(dataProvider ="AranacakKelimeler" )
    //arayacagimiz kelimeleri bir liste gibi tutup
    //bana yollayacak bir veri saglayicisi olusturacagiz
    public void dataProviderTesti(String arananKelime){
        amazonPage=new AmazonPage();
        //amazon anasayfaya gidelim
        Driver.getDriver().get(ConfigReader.getProperty("amazon_url"));

        //Nutella, Java, cigdem ve Netherlands icin arama yapalim
        amazonPage.aramaKutusu.sendKeys(arananKelime+ Keys.ENTER);

        //Sonuclarin aradigimiz kelime icerdigini test edelim
        Assert.assertTrue(amazonPage.aramaSonucYazisi.getText().contains(arananKelime));
        //sayfayi kapatalim
        Driver.closeDriver();
    }
}
