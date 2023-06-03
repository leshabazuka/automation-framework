package org.Tsyulia.test.ui;

import lombok.extern.log4j.Log4j;
import org.Tsyulia.pageobject.page.DeliveryPage;
import org.Tsyulia.pageobject.page.ReservationPage;
import org.Tsyulia.util.ListOfListFromFile;
import org.Tsyulia.util.StringUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.Tsyulia.core.Driver.getDriver;
import static org.junit.Assert.assertEquals;

@Log4j
@Test
public class DeliveryCheck extends CommonConditions {
    @Test
    public void warningFieldsExistenceCheck() {
        log.info("Start test");
        SoftAssert softAssert = new SoftAssert();
        DeliveryPage deliveryPage = new DeliveryPage(driver)
                .openPage();
        deliveryPage.checkButton.click();

        softAssert.assertEquals(deliveryPage.existenceOfWarningMessageStreetInputCheck(), Boolean.TRUE, "Street warning element does not exist");
        softAssert.assertEquals(deliveryPage.existenceOfWarningMessageHouseNumberInputCheck(), Boolean.TRUE, "House Number warning element does not exist");
        softAssert.assertEquals(deliveryPage.existenceOfWarningMessageCityInputCheck(), Boolean.TRUE, "City warning element does not exist");

        softAssert.assertAll();
    }

    @Test(dependsOnMethods = "warningFieldsExistenceCheck", dataProvider = "inputCorrectData", alwaysRun = true, priority = 1)
    public void warningFieldsExistenceCheckAfterInput(String street, String houseNumber, String city) {
        SoftAssert softAssert = new SoftAssert();
        DeliveryPage deliveryPage = new DeliveryPage(driver);
        deliveryPage
                .inputRequiredFields(street, houseNumber, city)
                .checkButton.click();

        softAssert.assertEquals(deliveryPage.existenceOfWarningMessageStreetInputCheck(), Boolean.FALSE, "Street warning element exists");
        softAssert.assertEquals(deliveryPage.existenceOfWarningMessageHouseNumberInputCheck(), Boolean.FALSE, "House Number warning element exists");
        softAssert.assertEquals(deliveryPage.existenceOfWarningMessageCityInputCheck(), Boolean.FALSE, "City warning element exists");

        softAssert.assertAll();
        deliveryPage.clearRequiredFields();
    }

    @DataProvider
    public Iterator<Object[]> inputCorrectData() {
        List<Object[]> data = new ArrayList<Object[]>();
        data.add(new Object[]{"Czapelska", "25", "Warszawa"});
        return data.iterator();
    }

    @Test(dependsOnMethods = "warningFieldsExistenceCheck", dataProvider = "inputIncorrectData", alwaysRun = true, priority = 2)
    public void oneWarningFieldExistenceCheckAfterInputIncorrectData(String street, String houseNumber, String city) {
        SoftAssert softAssert = new SoftAssert();
        DeliveryPage deliveryPage = new DeliveryPage(driver);
        deliveryPage
                .inputRequiredFields(street, houseNumber, city)
                .checkButton.click();
        String expectedMessage = "Podany adres nie istnieje, lub nie jest wystarczająco dokładny";
        String actualMessage = deliveryPage
                .incorrectDataWarningMessage
                .getText();

        softAssert.assertEquals(deliveryPage.existenceOfIncorrectDataWarningMessageCheck(), Boolean.TRUE, "Street warning element does not exist");
        softAssert.assertEquals(actualMessage, expectedMessage, String.format("Expected message is \"%s\", but actual is \"%s\"", expectedMessage, actualMessage));
        softAssert.assertAll();

        deliveryPage.clearRequiredFields();
        System.out.println();
    }

    @DataProvider
    public Iterator<Object[]> inputIncorrectData() {
        List<Object[]> data = new ArrayList<Object[]>();
        data.add(new Object[]{"Czapelska", "25", "Warszaw"});
        data.add(new Object[]{"45", "dwa", "Abama"});
        return data.iterator();
    }

    @Test(dependsOnMethods = "warningFieldsExistenceCheck", dataProvider = "inputCorrectData", alwaysRun = true, priority = 3)
    public void greenDeskElement(String street, String houseNumber, String city) {
        SoftAssert softAssert = new SoftAssert();
        DeliveryPage deliveryPage = new DeliveryPage(driver);
        deliveryPage
                .inputRequiredFields(street, houseNumber, city)
                .checkButton.click();
        Boolean expectedValue1 = Boolean.TRUE;
        Boolean expectedValue2 = Boolean.FALSE;



        softAssert.assertEquals(deliveryPage.existenceOfGreenFieldCheck(), expectedValue1, "Green field element does not exist");
        deliveryPage.clearRequiredFields();
        System.out.println();
        softAssert.assertEquals(deliveryPage.existenceOfGreenFieldCheck(), expectedValue2, "Green field element exists");
        softAssert.assertAll();

        System.out.println();
    }

    @Test(dependsOnMethods = "warningFieldsExistenceCheck", dataProvider = "inputCorrectDataAndFile", alwaysRun = true, priority = 4)
    public void deliveryAndOpeningTimeTableCheck(String street, String houseNumber, String city, String filePath) {
        DeliveryPage deliveryPage = new DeliveryPage(driver);
        deliveryPage
                .inputRequiredFields(street, houseNumber, city)
                .checkButton.click();
        deliveryPage.dropButtonDelivery.getAttribute("color");


        List<List<String>> expectedList = new ArrayList<>();
        try {
            expectedList = ListOfListFromFile.convertFileWords(new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<List<String>> actualList = deliveryPage.getTimeTableData(filePath);
        deliveryPage.clearRequiredFields();
        assertEquals(expectedList, actualList);
    }

    @DataProvider
    public Iterator<Object[]> inputCorrectDataAndFile() {
        List<Object[]> data = new ArrayList<Object[]>();
        data.add(new Object[]{"Czapelska", "25", "Warszawa", "E:\\automation\\TimeTableOpening.txt"});
        data.add(new Object[]{"Czapelska", "25", "Warszawa", "E:\\automation\\TimeTableDelivery.txt"});
        return data.iterator();
    }

    @Test(alwaysRun = true, dataProvider = "inputCorrectData")
    public void informationFieldCheck(String street, String houseNumber, String city) {
        log.info("Start test");
        SoftAssert softAssert = new SoftAssert();
        DeliveryPage deliveryPage = new DeliveryPage(driver)
                .openPage();
        deliveryPage.inputRequiredFields(street, houseNumber, city)
                .checkButton.click();

        softAssert.assertEquals(deliveryPage.timeOpeningCheck(), Boolean.TRUE, "Time of opening works incorrectly");
        softAssert.assertEquals(deliveryPage.timeDeliveryCheck(), Boolean.TRUE, "Time of delivery works incorrectly");
        softAssert.assertAll();
    }
}
