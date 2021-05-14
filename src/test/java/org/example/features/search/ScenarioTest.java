package org.example.features.search;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import org.example.steps.serenity.JumStepsScen;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

@RunWith(SerenityRunner.class)
public class ScenarioTest {
    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public JumStepsScen steps;

    @Issue("#adauga")
    @Test
    public void adaugaTest() {
        webdriver.manage().window().maximize();
        webdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriver.Navigation nav = webdriver.navigate();
        nav.to("https://lajumate.ro/");

        //login
        steps.acceptCookies();
        steps.enters("ana_maria.1999@yahoo.com", "testVVSS99");
        steps.login();
        steps.should_see_header("Ana Asmarandei");

        //adauga anunt
        steps.openAddModal();
        steps.completeazaDate();
//        steps.termeni();
        steps.adauga();
        steps.should_get_error();

        //logout
        Actions action = new Actions(webdriver);
        WebElement element = webdriver.findElement(By.className("account_img"));
        action.moveToElement(element).perform();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        steps.logOut();
    }


//
//    @Test
//    public void searching_by_keyword_banana_should_display_the_corresponding_article() {
//        steps.is_the_home_page();
//        steps.looks_for("pear");
//        steps.should_see_definition("An edible fruit produced by the pear tree, similar to an apple but elongated towards the stem.");
//    }

    @Pending
    @Test
    @Ignore
    public void searching_by_ambiguious_keyword_should_display_the_disambiguation_page() {
    }
}
