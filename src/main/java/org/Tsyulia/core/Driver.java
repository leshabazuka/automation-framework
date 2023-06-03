package org.Tsyulia.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

@Log4j
public class Driver {
    private static WebDriver driver;

    private Driver() {
    }

    public static WebDriver getDriver() {
        if (null == driver) {
            String browser = System.getProperty("browser", "chrome");
            switch (browser) {
                case "firefox": {
                    launchFirefox();
                    break;
                }
                case "chrome": {
                    launchChrome();
                    break;
                }
                case "chromeremote": {
                    launchRemoteChrome();
                    break;
                }
                case "ie": {
                    lounchIe();
                    break;
                }
                case "edge": {
                    launchEdge();
                    break;
                }
                default: {
                    launchChrome();
                    break;
                }
            }
            driver.manage().window().maximize();
        }
        return driver;
    }

    private static void launchEdge() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
    }

    private static void lounchIe() {
        WebDriverManager.iedriver().setup();
        driver = new InternetExplorerDriver();
    }

    private static void launchRemoteChrome() {
        WebDriverManager.chromedriver().setup();
        log.info("Launching Chrome on remote..");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("window-size=1920x1080");
        options.setCapability("sessionTimeout", "30m");
        options.addArguments("--start-maximized");
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-setuid-sandbox");
        options.addArguments("--test-type");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    private static void launchChrome() {
        log.info("Launching Chrome");
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setCapability("sessionTimeout", "30m");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    private static void launchFirefox() {
        log.info("Launching Firefox");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
        log.info("The driver was quit");
    }


}
