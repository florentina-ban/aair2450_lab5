package org.example.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class LoginPage extends PageObject {
    //logIn
    @FindBy(id="onetrust-accept-btn-handler")
    private WebElementFacade acceptCookiesBtn;
    @FindBy(id="login_action")
    private WebElementFacade contulMeuLink;
    @FindBy(id="email")
    private WebElementFacade userNameInput;
    @FindBy(id="password")
    private WebElementFacade passwordInput;
    @FindBy(className="login_auth")
    private WebElementFacade loginButton;


    public void acceptCookies(){
        acceptCookiesBtn.click();
    }

    public void get_to_login(String email, String pass) {
        contulMeuLink.click();
        userNameInput.type(email);
        passwordInput.type(pass);
    }

    public void login() {
        loginButton.click();
    }

    public String getH2() {
        WebElementFacade definitionList = find(By.className("account_img"));
        String name = definitionList.findElements(By.tagName("img")).get(0).getAttribute("alt");
        return name;
    }
}
