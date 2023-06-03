package org.Tsyulia.pageobject.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static org.Tsyulia.urlCostantsUi.URL.RESTAURANT_GOCLAV;

public class GoclawRestaurant extends AbstractPage{
    public GoclawRestaurant(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public AbstractPage openPage() {
        driver.navigate().to(RESTAURANT_GOCLAV);
        return this;
    }
}
