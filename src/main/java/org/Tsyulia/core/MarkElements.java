package org.Tsyulia.core;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MarkElements {

    private MarkElements() {}

    public static void markElementRedColor(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border= 'thick solid #FF0000'; ", element);
    }

    public static void markElementBlueColor(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border= 'thick solid #0000FF'; ", element);
    }
}