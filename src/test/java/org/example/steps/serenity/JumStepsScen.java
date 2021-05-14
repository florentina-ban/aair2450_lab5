package org.example.steps.serenity;

import net.thucydides.core.annotations.Step;
import org.example.pages.AdaugaPage;
import org.example.pages.LoginPage;
import org.example.pages.LogoutPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class JumStepsScen {
    LoginPage loginPage;
    AdaugaPage adaugaPage;
    LogoutPage logoutPage;

    @Step
    public void acceptCookies(){
        loginPage.acceptCookies();
    }

    @Step
    public void enters(String email, String pass) {
        loginPage.get_to_login(email, pass);
    }

    @Step
    public void login() {
        loginPage.login();
    }

    @Step
    public void should_see_header(String definition) {
       assertThat(loginPage.getH2(), containsString(definition));
    }

    @Step
    public void openAddModal(){
        adaugaPage.openAdaugaModal();
    }
    @Step
    public void completeazaDate(){
        adaugaPage.completeazaDate();
    }
    @Step
    public void adauga(){
        adaugaPage.adauga();
    }
    @Step
    public void termeni(){
        adaugaPage.termeni();
    }
    @Step
    public void should_get_error(){
        assertThat(adaugaPage.verifica(), containsString("E obligatoriu să completezi câmpul Tip"));
    }

    @Step
    public void logOut(){
        logoutPage.logOut();
    }
    @Step
    public void should_be_logged_out(){
        assertThat(logoutPage.verifLogOut(), containsString("Autentificare"));
    }
}