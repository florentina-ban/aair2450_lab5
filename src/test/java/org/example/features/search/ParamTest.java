package org.example.features.search;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.example.steps.serenity.JumStepsP;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("C:\\Users\\Flore\\Desktop\\info18\\VV\\lab05\\src\\test\\resources\\dataV.csv")
public class ParamTest {
    public String email;
    public String pass;
    public String found;


    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public JumStepsP steps;

    @Issue("#La-jumatateP")
    @Test
    public void LogInTest() {
        webdriver.manage().window().maximize();
        webdriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        WebDriver.Navigation nav = webdriver.navigate();
        nav.to("https://lajumate.ro/");
        steps.acceptCookies();
        steps.enters(getEmail(), getPass());
        steps.login();
        steps.should_see_header(getFound());
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setFound(String found) {
        this.found = found;
    }

    public String getEmail() {
        return email;
    }

    public String getPass() {
        return pass;
    }

    public String getFound() {
        return found;
    }
}
