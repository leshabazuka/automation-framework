package org.Tsyulia.api;

import lombok.extern.log4j.Log4j;
import io.restassured.response.Response;

import static com.google.common.net.HttpHeaders.CONTENT_TYPE;
import static io.netty.handler.codec.http.HttpHeaderValues.APPLICATION_JSON;
import static io.restassured.RestAssured.given;

@Log4j
public class EntityClient {

    private static final String TOKEN = "vk1.a.v0KL8pxevZOBuXpiEAIphfp4P66SNht3SSvgiggqv2NFSCrgLYDfFHZTgnuj0LFGHyH8a4IVoJA0gQzTVcoLug3-qTMBMARzjJeD6UFHZcuIsRWWP7AIEX85BmuCRGxrs9kb4cMW7KQplusuK4Rn3WUCbuElPpZKK8Nd6w8HcBJOEtSdG-m9sTDNhEBTmoyk8zlgFubnqdOmm81Il1s8KA";


    private static final String GGG = "https://oauth.vk.com/authorize?client_id=id51592033&display=page&redirect_uri=https://oauth.vk.com/blank.html&scope=offline,wall,photos,docs,groups,friends&response_type=token&v=5.131";

    public static Response getToken() {
        String ff= "https://oauth.vk.com/token?grant_type=password&client_id=51592033&client_secret=***&username=***&password=***&v=5.131&2fa_supported=1";
        Response response = given()
                .baseUri(GGG)
//                .header(CACHE_CONTROL, NO_CACHE)
                .header(CONTENT_TYPE, APPLICATION_JSON)
                .get();
//        log.info("GET: {} request url '{}'", entity, BASE_HOST + String.format(UI_PICKLIST_VALUES, entity, referenceId, field));
        return response;
    }

    public static Response getEntityFieldPickList() {
        Response response = given()
                .baseUri(String.format("https://api.vk.com/method/users.get?user_ids=vanklif_boy&fields=bdate&access_token=%s&v=5.131", TOKEN))
//                .header(CACHE_CONTROL, NO_CACHE)
//                .header(CONTENT_TYPE, APPLICATION_JSON)
                .get();
//        log.info("GET: {} request url '{}'", entity, BASE_HOST + String.format(UI_PICKLIST_VALUES, entity, referenceId, field));
        return response;
    }
}
