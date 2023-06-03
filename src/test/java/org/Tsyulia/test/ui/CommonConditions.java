package org.Tsyulia.test.ui;

import org.Tsyulia.core.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

@Test
public class CommonConditions {
    protected WebDriver driver;

    @BeforeClass()
    public void setUp() {
        driver = Driver.getDriver();
        System.out.println("BeforeClass");
    }

    @AfterClass(alwaysRun = true)
    public void stopBrowser() {
        Driver.closeDriver();
        System.out.println("AfterClass");
    }
}
