package org.Tsyulia.pageobject.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.Tsyulia.urlCostantsUi.URL.BASE_URL;

public class StartPage extends AbstractPage{

    @FindBy(xpath = "//a[contains(text(), ' Zobacz menu')]")
    public WebElement seeMenuSection;

    @Override
    public StartPage openPage() {
        driver.navigate().to(BASE_URL);
        acceptAllCookiesClick();
        return this;
    }

    public StartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public Restaurants viewMenu(){
        seeMenuSection.click();
        return new Restaurants(driver);
    }


}
