package org.example.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

@DefaultUrl("https://lajumate.ro/")
public class LaJumPage extends PageObject {
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

    public void accept_cookies(){
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
    public String getFailed() {
        WebElementFacade definitionList = find(By.className("messages"));
        String name = definitionList.getText();
        return name;
    }
}