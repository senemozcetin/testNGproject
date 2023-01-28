package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HotelMyCampNegativePage {
    public HotelMyCampNegativePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id = "navLogon")
    public WebElement loginButonu;

    @FindBy(id = "UserName")
    public WebElement username;

    @FindBy(id = "Password")
    public WebElement password;

    @FindBy(id = "btnSubmit")
    public WebElement submitButonu;

    @FindBy(xpath = "//*[@class='validation-summary-errors']")
    public WebElement hataYazisi;

}
