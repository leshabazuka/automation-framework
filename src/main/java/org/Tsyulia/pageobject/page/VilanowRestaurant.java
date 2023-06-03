package org.Tsyulia.pageobject.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static org.Tsyulia.urlCostantsUi.URL.RESTAURANT_VILANOW;

public class VilanowRestaurant extends AbstractPage{
    public VilanowRestaurant(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public AbstractPage openPage() {
        driver.navigate().to(RESTAURANT_VILANOW);
        return this;
    }
}
