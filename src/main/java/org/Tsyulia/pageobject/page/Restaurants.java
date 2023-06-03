package org.Tsyulia.pageobject.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.Tsyulia.urlCostantsUi.URL.RESTAURANTS;

public class Restaurants extends AbstractPage{

    @FindBy(xpath = "//article[.//h4[contains(text(), 'Wilanów')]]//a[contains(text(),'Zobacz menu')]")
    public WebElement vilanowMenu;

    @FindBy(xpath = "//article[.//h4[contains(text(), 'Gocław')]]//a[contains(text(),'Zobacz menu')]")
    public WebElement goclawMenu;

    public Restaurants(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public AbstractPage openPage() {
        driver.navigate().to(RESTAURANTS);
        return this;
    }

    public String getCurrentURLAddress(){
        return driver.getCurrentUrl();
    }
}
