package tests.day03;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.Set;

public class C01_WindowHandleReusableMethods {
    @Test
    public void test01(){
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");

        String ilkSayfaWindowHandle= Driver.getDriver().getWindowHandle();

        Driver.getDriver().findElement(By.linkText("Click Here")).click();

        Set<String> windowHandleSeti= Driver.getDriver().getWindowHandles();
        String ikinciSyfWH="";
        for (String each:windowHandleSeti) {
            if (!each.equals(ilkSayfaWindowHandle)){
                ikinciSyfWH=each;
            }
        }
        Driver.getDriver().switchTo().window(ikinciSyfWH);
        System.out.println(Driver.getDriver().getTitle());

        String expectedTitle= "New Window";
        String actualTitle= Driver.getDriver().getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }

    @Test
    public void test02() {
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        Driver.getDriver().findElement(By.linkText("Click Here")).click();
        ReusableMethods.switchToWindow("New Window");
        String expectedTitle= "New Window";
        String actualTitle= Driver.getDriver().getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);

    }
}
