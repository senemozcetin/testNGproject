package tests.day04_CrossBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBaseCross;

public class AssertionsCross extends TestBaseCross {
    @Test
    public void test01(){
    driver.get("https://www.amazon.com");
    String expectedResult= "Amazon";
    String actualResilt= driver.getTitle();
        Assert.assertTrue(actualResilt.contains(expectedResult));
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        Assert.assertTrue(aramaKutusu.isEnabled());
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        WebElement sonucYaziElementi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertTrue(sonucYaziElementi.getText().contains("Nutella"));
    }
}
