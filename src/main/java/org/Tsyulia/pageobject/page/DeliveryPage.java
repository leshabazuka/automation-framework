package org.Tsyulia.pageobject.page;

import lombok.val;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.Tsyulia.core.MarkElements.markElementBlueColor;
import static org.Tsyulia.urlCostantsUi.URL.DELIVERY;

public class DeliveryPage extends AbstractPage {

    @FindBy(xpath = "//button[text()='Sprawdź']")//*[contains(text(), 'Teraz zamknięte')]
    public WebElement checkButton;

    @FindBy(xpath = "//label[text()='Ulica']")
    public WebElement streetLabel;

    @FindBy(xpath = "//label[text()='Ulica']/following-sibling::input")
    public WebElement streetInput;

    @FindBy(xpath = "//label[text()='Ulica']/following-sibling::span")
    public WebElement warningMessageStreetInput;

    @FindBy(xpath = "//label[text()='Numer domu']/following-sibling::input")
    public WebElement houseNumberInput;

    @FindBy(xpath = "//label[text()='Numer domu']/following-sibling::span")
    public WebElement warningMessageHouseNumberInput;

    @FindBy(xpath = "//label[text()='Miasto']/following-sibling::input")
    public WebElement cityInput;

    @FindBy(xpath = "//label[text()='Miasto']/following-sibling::span")
    public WebElement warningMessageCityInput;

    @FindBy(xpath = "//div[text()='Podany adres nie istnieje, lub nie jest wystarczająco dokładny']")
    public WebElement incorrectDataWarningMessage;

    @FindBy(xpath = "(//strong[text()='Godziny otwarcia:']/../../..)[2]")
    public WebElement greenField;

    @FindBy(xpath = "(//strong[text()='Godziny otwarcia:']/../../..)[2]//strong[text()='Godziny otwarcia:']/following-sibling::div[1]/div[2]//span[contains(text(), ' - ')]")
    public List<WebElement> timeOfOpening;

    @FindBy(xpath = "(//strong[text()='Godziny otwarcia:']/../../..)[2]//strong[text()='Godziny otwarcia:']/following-sibling::div[1]/div[2]//span[contains(text(), ' - ')]/../preceding-sibling::span")
    public List<WebElement> dayOfOpening;

    @FindBy(xpath = "(//strong[text()='Godziny otwarcia:']/../../..)[2]//strong[text()='Godziny otwarcia:']/following-sibling::div[2]/div[2]//span[contains(text(), ' - ')]")
    public List<WebElement> timeOfDelivery;

    @FindBy(xpath = "(//strong[text()='Godziny otwarcia:']/../../..)[2]//strong[text()='Godziny otwarcia:']/following-sibling::div[2]/div[2]//span[contains(text(), ' - ')]/../preceding-sibling::span")
    public List<WebElement> dayOfDelivery;

    @FindBy(xpath = "(//strong[text()='Godziny otwarcia:']/../../..)[2]//strong[text()='Godziny otwarcia:']/following-sibling::div[1]/div[1]//button[2]")
    public WebElement dropButtonOpening;

    @FindBy(xpath = "(//strong[text()='Godziny otwarcia:']/../../..)[2]//strong[text()='Godziny otwarcia:']/following-sibling::div[2]/div[1]//button[2]")
    public WebElement dropButtonDelivery;



    @FindBy(xpath = "(//strong[text()='Godziny otwarcia:']/../../..)[last()]//strong[contains(text(),'Teraz otwarte')]")
    public List<WebElement> helpBlinkFieldOpened;

    @FindBy(xpath = "(//strong[text()='Godziny otwarcia:']/../../..)[last()]//strong[contains(text(),'Teraz zamknięte')]")
    public List<WebElement> helpBlinkFieldClosed;

    @FindBy(xpath = "(//strong[text()='Godziny otwarcia:']/../../..)[last()]//strong[contains(text(),'Teraz aktywne')]")
    public List<WebElement> helpBlinkFieldActive;

    @FindBy(xpath = "(//strong[text()='Godziny otwarcia:']/../../..)[last()]//strong[contains(text(),'Teraz nieaktywne')]")
    public List<WebElement> helpBlinkFieldInactive;

    @Override
    public DeliveryPage openPage() {
        driver.navigate().to(DELIVERY);
        acceptAllCookiesClick();
        return this;
    }

    public DeliveryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public Boolean existenceOfWarningMessageStreetInputCheck() {
        try {
            return warningMessageStreetInput.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public Boolean existenceOfWarningMessageHouseNumberInputCheck() {
        try {
            return warningMessageHouseNumberInput.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public Boolean existenceOfWarningMessageCityInputCheck() {
        try {
            return warningMessageCityInput.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public Boolean existenceOfIncorrectDataWarningMessageCheck() {
        try {
            return incorrectDataWarningMessage.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public Boolean existenceOfGreenFieldCheck() {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(2))
                    .until(ExpectedConditions.visibilityOf(greenField));
            return greenField.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.TimeoutException e) {
            return false;
        }
    }

    public DeliveryPage inputRequiredFields(String street, String houseNumber, String city) {
        streetInput.sendKeys(street);
        houseNumberInput.sendKeys(houseNumber);
        cityInput.sendKeys(city);
        streetLabel.click();
        return this;
    }

    public DeliveryPage clearRequiredFields() {
        streetInput.clear();
        houseNumberInput.clear();
        cityInput.clear();
        return this;
    }

    public List<List<String>> getTimeTableData(String fileName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        List<List<String>> result = new ArrayList<>();
        if (fileName.endsWith("Opening.txt")) {
            dropButtonOpening.click();
            List<String> days = wait.until(ExpectedConditions.visibilityOfAllElements(dayOfOpening))
                    .stream()
                    .peek(x -> markElementBlueColor(driver, x))
                    .map(WebElement::getText)
                    .collect(Collectors.toList());
            List<String> times = wait.until(ExpectedConditions.visibilityOfAllElements(timeOfOpening))
                    .stream()
                    .peek(x -> markElementBlueColor(driver, x))
                    .map(WebElement::getText)
                    .collect(Collectors.toList());

            IntStream.range(0, days.size())
                    .forEach(x -> {
                        String stringConcat = days.get(x) + " " + times.get(x);
                        result.add(Arrays.asList(stringConcat.split("\\s+")));
                    });
        } else {
            dropButtonDelivery.click();
            List<String> days = wait.until(ExpectedConditions.visibilityOfAllElements(dayOfDelivery))
                    .stream()
                    .peek(x -> markElementBlueColor(driver, x))
                    .map(WebElement::getText)
                    .collect(Collectors.toList());
            List<String> times = wait.until(ExpectedConditions.visibilityOfAllElements(timeOfDelivery))
                    .stream()
                    .peek(x -> markElementBlueColor(driver, x))
                    .map(WebElement::getText)
                    .collect(Collectors.toList());
            IntStream.range(0, days.size())
                    .forEach(x -> {
                        String stringConcat = days.get(x) + " " + times.get(x);
                        result.add(Arrays.asList(stringConcat.split("\\s+")));
                    });
//            for (int i = 0; i<days.size();i++){
//                String stringConcat = days.get(i) + " " + times.get(i);
//                result.add(Arrays.asList(stringConcat.split("\\s+")));
//            }
        }

        return result;
    }

    public Boolean timeOpeningCheck() {
        dropButtonOpening.click();
        LocalDate currentDate = LocalDate.now();
        DayOfWeek currentDayOfWeek = currentDate.getDayOfWeek();
        int currentDayOfWeekNumber = currentDayOfWeek.getValue()-1;

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        List<String> times = wait.until(ExpectedConditions.visibilityOfAllElements(timeOfOpening))
                .stream()
                .peek(x -> markElementBlueColor(driver, x))
                .map(WebElement::getText)
                .collect(Collectors.toList());

        List<String> start = new ArrayList<>();
        IntStream.range(0, times.size())
                .forEach(x -> {
                    start.add(Arrays.asList(times.get(x).split("\\s+")).get(0));
                });

        List<String> finish = new ArrayList<>();
        IntStream.range(0, times.size())
                .forEach(x -> {
                    finish.add(Arrays.asList(times.get(x).split("\\s+")).get(2));
                });




        LocalTime currentTime = LocalTime.now();


        LocalTime startTime = LocalTime.parse(start.get(currentDayOfWeekNumber));
        LocalTime finishTime = LocalTime.parse(finish.get(currentDayOfWeekNumber));

        Boolean openFact;
        // сравниваем время
        if (currentTime.isAfter(startTime)&&helpBlinkFieldOpened.size()==1&&currentTime.isBefore(finishTime)) {
            openFact = Boolean.TRUE;
        } else if (currentTime.isBefore(startTime)&&helpBlinkFieldClosed.size()==1&&currentTime.isAfter(finishTime)) {
            openFact = Boolean.TRUE;
        } else {
            openFact = Boolean.FALSE;
        }

        return openFact;
    }


    public Boolean timeDeliveryCheck() {
        dropButtonDelivery.click();
        LocalDate currentDate = LocalDate.now();
        DayOfWeek currentDayOfWeek = currentDate.getDayOfWeek();
        int currentDayOfWeekNumber = currentDayOfWeek.getValue()-1;

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        List<String> times = wait.until(ExpectedConditions.visibilityOfAllElements(timeOfDelivery))
                .stream()
                .peek(x -> markElementBlueColor(driver, x))
                .map(WebElement::getText)
                .collect(Collectors.toList());

        List<String> start = new ArrayList<>();
        IntStream.range(0, times.size())
                .forEach(x -> {
                    start.add(Arrays.asList(times.get(x).split("\\s+")).get(0));
                });

        List<String> finish = new ArrayList<>();
        IntStream.range(0, times.size())
                .forEach(x -> {
                    finish.add(Arrays.asList(times.get(x).split("\\s+")).get(2));
                });




        LocalTime currentTime = LocalTime.now();


        LocalTime startTime = LocalTime.parse(start.get(currentDayOfWeekNumber));
        LocalTime finishTime = LocalTime.parse(finish.get(currentDayOfWeekNumber));

        Boolean activeFact;
        // сравниваем время
        if (currentTime.isAfter(startTime)&&helpBlinkFieldActive.size()==1&&currentTime.isBefore(finishTime)) {
            activeFact = Boolean.TRUE;
        } else if (currentTime.isBefore(startTime)&&helpBlinkFieldInactive.size()==1&&currentTime.isAfter(finishTime)) {
            activeFact = Boolean.TRUE;
        } else {
            activeFact = Boolean.FALSE;
        }

        return activeFact;
    }
}
