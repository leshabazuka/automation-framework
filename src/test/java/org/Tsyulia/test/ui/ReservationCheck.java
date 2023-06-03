package org.Tsyulia.test.ui;

import lombok.extern.log4j.Log4j;
import org.Tsyulia.pageobject.page.ReservationPage;
import org.Tsyulia.pageobject.page.StartPage;
import org.Tsyulia.util.StringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import static org.Tsyulia.core.Driver.getDriver;
import static org.Tsyulia.pageobject.page.ReservationPage.*;
import static org.junit.Assert.assertEquals;

@Log4j
@Test
public class ReservationCheck extends CommonConditions {
    @Test
    public void warningFieldsExistenceCheck() {
        log.info("Start test");
        SoftAssert softAssert = new SoftAssert();
        ReservationPage reservationPage = new ReservationPage(driver)
                .openPage();
        reservationPage.sendReservationButton.click();

        Boolean expectedValue = Boolean.TRUE;

        softAssert.assertEquals(reservationPage.existenceOfPeopleAmountWarningMessageCheck(), expectedValue, "People Amount warning element does not exist");
        softAssert.assertEquals(reservationPage.existenceOfPhoneWarningMessageCheck(), expectedValue, "Phone warning element does not exist");
        softAssert.assertEquals(reservationPage.existenceOfEmailWarningMessageCheck(), expectedValue, "Email warning element does not exist");
        softAssert.assertEquals(reservationPage.existenceOfNameAndSurnameWarningMessageCheck(), expectedValue, "Name And Surname element does not exist");

        softAssert.assertAll();
    }

    @Test(dependsOnMethods = "warningFieldsExistenceCheck",  dataProvider = "inputData", alwaysRun = true)
    public void warningFieldsExistenceCheckAfterInput(String amountOfPeople, String phone, String email, String nameAndSurname){
        SoftAssert softAssert = new SoftAssert();
        ReservationPage reservationPage = new ReservationPage(getDriver());
        reservationPage
                .inputRequiredFields(amountOfPeople, phone, email, nameAndSurname)
                .peopleAmountTextField.click();
        Boolean expectedValue = Boolean.FALSE;

        softAssert.assertEquals(reservationPage.existenceOfPeopleAmountWarningMessageCheck(), expectedValue, "People Amount warning element exists");
        softAssert.assertEquals(reservationPage.existenceOfPhoneWarningMessageCheck(), expectedValue, "Phone warning element exists");
        softAssert.assertEquals(reservationPage.existenceOfEmailWarningMessageCheck(), expectedValue, "Email warning element exists");
        softAssert.assertEquals(reservationPage.existenceOfNameAndSurnameWarningMessageCheck(), expectedValue, "Name And Surname element exists");
        softAssert.assertAll();
    }

    @Test(dependsOnMethods = "warningFieldsExistenceCheckAfterInput")
    public void selectFieldContentCheck(){
        SoftAssert softAssert = new SoftAssert();
        ReservationPage reservationPage = new ReservationPage(getDriver());
        reservationPage
                .restaurantSelection.click();

        Boolean expectedValue = Boolean.TRUE;

        softAssert.assertEquals(reservationPage.existenceOfWilanowInSelectCheck(), expectedValue, "Wilanow in select element does not exist");
        softAssert.assertEquals(reservationPage.existenceOfGoclawInSelectCheck(), expectedValue, "Goclaw in select element does not exist");


        softAssert.assertAll();
    }

    @DataProvider
    public Iterator<Object[]> inputData() {
        List<Object[]> data = new ArrayList<Object[]>();
        data.add(new Object[]{StringUtils.generateRandomAmountOfPeople(), StringUtils.generateRandomPhone(), StringUtils.generateRandomEmailAddress(), StringUtils.generateRandomNameAndSurname()});
        return data.iterator();
    }
}
