package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class WebAppSecurityHomePage {
    public WebAppSecurityHomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "onlineBankingMenu")
    public WebElement onlineBanking;


    @FindBy(id = "pay_bills_link")
    public WebElement payBills;
}
