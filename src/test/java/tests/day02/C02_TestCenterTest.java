package tests.day02;

import org.testng.annotations.Test;
import pages.TestCenterHomePage;
import pages.TestCenterPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_TestCenterTest {
    @Test(groups ="grup1" )
    public void test01(){
        TestCenterPage testCenterPage= new TestCenterPage();
        Driver.getDriver().get(ConfigReader.getProperty("testcenter_url"));
        testCenterPage.username.sendKeys(ConfigReader.getProperty("testcenter_username"));
        testCenterPage.password.sendKeys(ConfigReader.getProperty("testcenter_password"));
        testCenterPage.submitButon.click();

        TestCenterHomePage testCenterHomePage= new TestCenterHomePage();
        assert testCenterHomePage.homePageText.isDisplayed();

        Driver.closeDriver();
    }
}
