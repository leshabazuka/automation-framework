package org.Tsyulia.pageobject.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class AbstractPage {
    protected WebDriver driver;

    protected abstract AbstractPage openPage();

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//button[text()='Akceptuj wszystkie']")
    public WebElement acceptAllCookies;

    @FindBy(xpath = "//button[text()='Akceptuj wymagane']")
    public WebElement acceptNeedCookies;

    @FindBy(xpath = "//div[@class='m-header__main ']//a[contains(text(), 'Zamów online')]")
    public WebElement reserveOnline;

    public void acceptAllCookiesClick(){
        acceptAllCookies.click();
    }

    public void acceptNeedCookiesClick(){
        acceptNeedCookies.click();
    }
}

