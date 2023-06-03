package org.Tsyulia.pageobject.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import static org.Tsyulia.core.Driver.getDriver;
import static org.Tsyulia.core.MarkElements.markElementBlueColor;
import static org.Tsyulia.urlCostantsUi.URL.RESERVATION;

public class ReservationPage extends AbstractPage{

    @FindBy(xpath = "//a[@title='Instagram']")
    public WebElement instagramIcon;

    @FindBy(xpath = "//*[text()='Instagram']")
    public WebElement holdMouseOnInstagramIconElement;

    @FindBy(xpath = "//select")
    public WebElement restaurantSelection;

    @FindBy(xpath = "//select/option[text()='Ochota na Sushi Wilanów']")
    public WebElement wilanowInSelect;

    @FindBy(xpath = "//select/option[text()='Ochota na Sushi Gocław']")
    public WebElement goclawInSelect;

    @FindBy(xpath = "//button[text()='Wyślij rezerwację']")
    public WebElement sendReservationButton;

    @FindBy(xpath = "//div[./label[text()='Liczba osób']]/input")
    public WebElement peopleAmountInput;

    @FindBy(xpath = "//div[./label[text()='Liczba osób']]/p")
    public WebElement peopleAmountWarningMessage;

    @FindBy(xpath = "//div[./label[text()='Liczba osób']]/label")
    public WebElement peopleAmountTextField;

    @FindBy(xpath = "//div[./label[text()='Telefon']]/input")
    public WebElement phoneInput;

    @FindBy(xpath = "//div[./label[text()='Liczba osób']]/p")
    public WebElement phoneWarningMessage;

    @FindBy(xpath = "//div[./label[text()='E-mail']]/input")
    public WebElement emailInput;

    @FindBy(xpath = "//div[./label[text()='Liczba osób']]/p")
    public WebElement emailWarningMessage;

    @FindBy(xpath = "//div[./label[text()='Imię i nazwisko']]/input")
    public WebElement nameAndSurnameInput;

    @FindBy(xpath = "//div[./label[text()='Liczba osób']]/p")
    public WebElement nameAndSurnameWarningMessage;

    public ReservationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public ReservationPage openPage() {
        driver.navigate().to(RESERVATION);
        return this;
    }

    public Boolean existenceOfPeopleAmountWarningMessageCheck(){
        try{
            return peopleAmountWarningMessage.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e){
            return false;
        }
    }

    public Boolean existenceOfPhoneWarningMessageCheck(){
        try{
            return phoneWarningMessage.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e){
            return false;
        }
    }

    public Boolean existenceOfEmailWarningMessageCheck(){
        try{
            return emailWarningMessage.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e){
            return false;
        }
    }

    public Boolean existenceOfNameAndSurnameWarningMessageCheck(){
        try{
            return nameAndSurnameWarningMessage.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e){
            return false;
        }
    }

    public Boolean existenceOfWilanowInSelectCheck(){
        try{
            return wilanowInSelect.isEnabled();
        } catch (org.openqa.selenium.NoSuchElementException e){
            return false;
        }
    }

    public Boolean existenceOfGoclawInSelectCheck(){
        try{
            return goclawInSelect.isEnabled();
        } catch (org.openqa.selenium.NoSuchElementException e){
            return false;
        }
    }

    public List<Boolean> existenceOfElementsCheck(List<WebElement> elementsToCheck){
        List<Boolean> hotDishesList = elementsToCheck
                .stream()
                .peek(x -> markElementBlueColor(getDriver(), x))
                .map(x -> x.isDisplayed())
                .collect(Collectors.toList());
        return hotDishesList;
    }

    public ReservationPage inputRequiredFields(String amountOfPeople, String phone, String email, String nameAndSurname) {
        peopleAmountInput.sendKeys(amountOfPeople);
        phoneInput.sendKeys(phone);
        emailInput.sendKeys(email);
        nameAndSurnameInput.sendKeys(nameAndSurname);
        return this;
    }
}
