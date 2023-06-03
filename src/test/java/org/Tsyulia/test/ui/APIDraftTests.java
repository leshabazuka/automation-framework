package org.Tsyulia.test.ui;

import static org.Tsyulia.api.JavaXClient.getFoodIngredientsSearch;
import static org.Tsyulia.api.JavaXClient.getResponseByItemId;
import static org.Tsyulia.core.Driver.getDriver;
import static org.Tsyulia.core.MarkElements.markElementBlueColor;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.extern.log4j.Log4j;
import org.Tsyulia.entity.currency.CurrencyConverter;
import org.Tsyulia.entity.food.RootFoodIngredientsSearch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import javax.ws.rs.core.Response;

@Log4j
@Test
public class APIDraftTests {

    protected WebDriver driver;

//    @BeforeMethod
//    public void start() {
//        getDriver();
//        System.out.println("Before");
//    }
//
//    @AfterMethod
//    public void finish() {
//        closeDriver();
//        System.out.println("After");
//    }

//    @Test
//    public void shouldAnswerWithTrue() {
//        log.info("Start test");
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
//
//        assertEquals("https://www.ochotanasushi.pl/restauracje",getDriver().getCurrentUrl());
//    }

//    @Test
//    public void shouldAnswerWithTrue() {
//        log.info("Start test");
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
//
//        WebElement seeAll2 = getDriver().findElement(By.xpath("//a[contains(text(), 'Zobacz menu')][1]"));
//        markElementBlueColor(getDriver(), seeAll2);
//        seeAll2.click();
//
//        WebElement hotDishes = getDriver().findElement(By.xpath("//a[contains(text(), 'DANIA GORĄCE')]"));
//        markElementBlueColor(getDriver(), hotDishes);
//        hotDishes.click();
//
//        List<String> hotDishesList = getDriver().findElements(By.xpath("//div[@id='menu-dania-gorace']//li//button"))
//                .stream()
//                .peek(x -> markElementBlueColor(getDriver(), x))
//                .map(x -> x.getText())
//                .collect(Collectors.toList());
//        int costList = hotDishesList.stream().map(x -> x.split(",")[0]).map(x -> Integer.parseInt(x)).min(Integer::compare).get();
//
//        List<String> minimalCostDishesNames = getDriver().findElements(By.xpath(String.format("//div[@id='section-menu-dania-gorace']//li[.//button[contains(text(), '%d')]]//div//h4", costList))).stream().map(x->x.getText()).collect(Collectors.toList());
//
//        System.out.println("Hot dishes with minimal cost:");
//        minimalCostDishesNames.forEach(x->System.out.println(x));
//
//        String message = String.format(("expected amount of dishes with minimal cost is %d, but actual is %d"), 2, minimalCostDishesNames.size());
//        assertEquals(message, 2, minimalCostDishesNames.size());
//    }

//    @Test
//    public void shouldAnswerWithTrue2() {
//        log.info("Start test");
//        getDriver().get("https://www.popolskupopolsce.edu.pl/lekcja/1/MAZOWIECKIE");
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("I love world!");
//        assertTrue(true);
//    }

//    @Test
//    public void shouldAnswerWithTrue3() {
//        log.info("Start test");
//        getDriver().get("https://oauth.vk.com/authorize");
//        System.out.println("I love world!");
//        assertTrue(true);
//    }
//
//    @Test
//    public void getMyFriendResponse() {
////        log.info("Start test");
////        Response myFirstResponse = EntityClient. getToken();
////
////        System.out.println(myFirstResponse.getStatusCode());
////        System.out.println(myFirstResponse.getBody().asString());
////        assertTrue(true);
//    }

    @Test
    public void getApiLayerResponse() {
        log.info("Start test");
        Response myFirstResponse = getResponseByItemId();

        String stringBody = myFirstResponse.readEntity(String.class);
        System.out.println(stringBody);

        JsonObject bodyJson = (JsonObject) JsonParser.parseString(stringBody);

        String confluencePageWithQuote = bodyJson.get("result")
                .toString();


        CurrencyConverter currencyConverter = new Gson().fromJson(bodyJson, CurrencyConverter.class);
        Double amount = currencyConverter.getQuery().getAmount();
        System.out.println(amount);
        assertTrue(true);
    }

    @Test
    public void getApiLayerFoodResponse() {
        log.info("Start test");
        Response myFirstResponse = getFoodIngredientsSearch("asc", "calories", "apple", 0, 10, "egg");

        String stringBody = myFirstResponse.readEntity(String.class);
        System.out.println(stringBody);

        JsonObject bodyJson = (JsonObject) JsonParser.parseString(stringBody);


        RootFoodIngredientsSearch rootFoodIngredientsSearch = new Gson().fromJson(bodyJson, RootFoodIngredientsSearch.class);
        Double amount = Double.valueOf(rootFoodIngredientsSearch.getNumber());
        System.out.println(amount);
        assertTrue(true);
    }
}
