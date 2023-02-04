package tests.day02;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.OpensourceDashboardPage;
import pages.OpensourcePage;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_OpensourceTest {

    @Test(groups = {"grup1" , "grup2"})
    public void test01() throws InterruptedException {
        OpensourcePage opensourcePage=new OpensourcePage();
        Driver.getDriver().get(ConfigReader.getProperty("opensource_url"));
        opensourcePage.username.sendKeys(ConfigReader.getProperty("opensource_username"));
        opensourcePage.password.sendKeys(ConfigReader.getProperty("opensource_password"));
        opensourcePage.loginButonu.click();

        OpensourceDashboardPage opensourceDashboardPage=new OpensourceDashboardPage();
        Thread.sleep(10);
        assert opensourceDashboardPage.dashboard.isDisplayed();
        Driver.closeDriver();


    }
}
