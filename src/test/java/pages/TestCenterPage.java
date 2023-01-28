package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TestCenterPage {
    public TestCenterPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id = "exampleInputEmail1")
    public WebElement username;

    @FindBy(id = "exampleInputPassword1")
    public WebElement password;

    @FindBy(xpath = "//*[@class='btn btn-primary']")
    public WebElement submitButon;
}
