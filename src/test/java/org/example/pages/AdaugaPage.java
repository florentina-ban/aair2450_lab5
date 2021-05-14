package org.example.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

public class AdaugaPage extends PageObject {
    @FindBy(className = "add_btn")
    public WebElementFacade adaugaBtn1;
    @FindBy(name = "title")
    public WebElementFacade titluInput;
    @FindBy(id = "description")
    public WebElementFacade descInput;
    @FindBy(name = "price")
    public WebElementFacade pret;
    @FindBy(className = "lei_container")
    public WebElementFacade tipMoneda;
    @FindBy(id = "category-field")
    public WebElementFacade categorie;
    @FindBy(id = "categ_name_9")
    public WebElementFacade categAnimale;
    @FindBy(id="li_50")
    public WebElementFacade animCompanie;
    @FindBy(id="location")
    public WebElementFacade location;
    @FindBy(className="close_btn")
    public WebElementFacade closeLocationBtn;
    @FindBy(id="terms")
    public WebElementFacade termsBtn;
    @FindBy(id="insert_new")
    public WebElementFacade adaugaBtn;
    @FindBy(id="type")
    public WebElementFacade tipAnimalList;
    @FindBy(tagName ="option" )
    public WebElementFacade tipAnimal;

    public void openAdaugaModal(){
        adaugaBtn1.click();
    }
    public void completeazaDate(){
        titluInput.type("pisica");
        descInput.type("este adorabila, maraie si musca");
        pret.type("1");
        tipMoneda.click();
        categorie.click();
        categAnimale.click();
        animCompanie.click();
        location.type("Cluj-Napoca");
        closeLocationBtn.click();
//        tipAnimalList.click();
    }
    public void termeni() {
        termsBtn.click();
    }

    public void adauga(){
        adaugaBtn.click();
    }
    public String verifica(){
         return find(By.id("type-error")).getText();
    }
}
