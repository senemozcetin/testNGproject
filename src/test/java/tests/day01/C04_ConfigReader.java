package tests.day01;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class C04_ConfigReader {
    @Test
    public void test01() {

        Driver.getDriver().get(ConfigReader.getProperty("amazon_url"));
        Driver.getDriver().get(ConfigReader.getProperty("facebook_url"));

    }
}
