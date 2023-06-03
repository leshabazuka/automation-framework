package org.Tsyulia.test.ui;

import org.Tsyulia.pageobject.page.Restaurants;
import org.Tsyulia.pageobject.page.StartPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import lombok.extern.log4j.Log4j;

import java.util.logging.LogManager;
import java.util.logging.Logger;

import static org.Tsyulia.core.Driver.getDriver;
import static org.Tsyulia.core.MarkElements.markElementBlueColor;
import static org.junit.Assert.assertEquals;

@Log4j
@Test
public class PageOpening extends CommonConditions {
//    private final Logger logger = LogManager.getRootLogger();getRootLogger


    @Test
    public void open() {
        log.info("Start test");
        new StartPage(driver)
                .openPage()
                .viewMenu();

//        getDriver().get("https://www.ochotanasushi.pl/");
//
//        WebElement acceptAllCookies = getDriver().findElement(By.xpath("//button[text()='Akceptuj wszystkie']"));
//        markElementBlueColor(getDriver(), acceptAllCookies);
//        acceptAllCookies.click();
//
//
//        WebElement seeAll = getDriver().findElement(By.xpath("//a[contains(text(), 'Zobacz menu')]"));
//        markElementBlueColor(getDriver(), seeAll);
//        seeAll.click();

        assertEquals("https://www.ochotanasushi.pl/restauracje", getDriver().getCurrentUrl());

    }

    @Test(dependsOnMethods = "open", alwaysRun = true)
    public void shouldAnswerWithTrue() {
        log.info("Start test");
        getDriver().get("https://www.ochotanasushi.pl/");

        WebElement acceptAllCookies = getDriver().findElement(By.xpath("//button[text()='Akceptuj wszystkie']"));
        markElementBlueColor(getDriver(), acceptAllCookies);
        acceptAllCookies.click();


        WebElement seeAll = getDriver().findElement(By.xpath("//a[contains(text(), 'Zobacz menu')]"));
        markElementBlueColor(getDriver(), seeAll);
        seeAll.click();

        assertEquals("https://www.ochotanasushi.pl/restauracje", getDriver().getCurrentUrl());

    }
}
