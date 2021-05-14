package org.example.steps.serenity;

import net.thucydides.core.annotations.Step;
import org.example.pages.LaJumPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class JumStepsP {

    LaJumPage laJumPage;

    @Step
    public void acceptCookies(){
        laJumPage.accept_cookies();
    }

    @Step
    public void enters(String email, String pass) {
        laJumPage.get_to_login(email, pass);
    }


    @Step
    public void login() {
        laJumPage.login();
    }

    @Step
    public void should_see_header(String definition) {
        if (!definition.equals("failed"))
            assertThat(laJumPage.getH2(), containsString(definition));
        else {
            assertThat(laJumPage.getFailed(), containsString("Adresa de e-mail sau parola este greșită."));
        }
    }
}