package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class WebAppSecurityPayPage {
    public WebAppSecurityPayPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[text()='Purchase Foreign Currency']")
    public WebElement purchase;

    @FindBy (id = "pc_currency")
    public WebElement ddm;
}
