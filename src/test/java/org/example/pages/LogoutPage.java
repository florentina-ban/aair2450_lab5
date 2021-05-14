package org.example.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class LogoutPage extends PageObject {
    @FindBy(className = "account_img")
    public WebElementFacade nameButton;

    @FindBy(className = "user_logout")
    public WebElementFacade logOutBtn;

    @FindBy(id = "login_action")
    public WebElementFacade authBtn;

    public void logOut(){
        logOutBtn.click();
    }
    public String verifLogOut(){
        return authBtn.getText();
    }
}
