package tests.day03;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class ScreenShotReusableMethod {
    @Test
    public void test01() throws IOException {
        //Reusable method kullanarak amazon a gidip screenShot alalim
        Driver.getDriver().get(ConfigReader.getProperty("amazon_url"));
        ReusableMethods.getScreenshot("amazon");// burdaki name olusturulan ScreenShot a vermek istedigimiz isim
        Driver.closeDriver();
    }


}
