package org.Tsyulia.api;

import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.Tsyulia.api.constantsApi.URL.*;


public class JavaXClient {

    public static final String API_KEY = "apikey";
    public static final String API_KEY_VALUE = "HPEDivfMWopXFF4w6l6ZDND4xzDqFRvD";

    public static Response getResponseByItemId() {

        final Client client = ClientBuilder.newBuilder().build();
//                .property(LoggingFeature.LOGGING_FEATURE_VERBOSITY_CLIENT, LoggingFeature.Verbosity.PAYLOAD_ANY)
//                .property(LoggingFeature.LOGGING_FEATURE_VERBOSITY_CLIENT_LOGGER_LEVEL_CLIENT, "INFO").build();

        final WebTarget webTarget = client.target("https://api.apilayer.com/exchangerates_data/convert?to=EUR&from=USD&amount=1000");

        final HttpAuthenticationFeature feature = HttpAuthenticationFeature.basicBuilder().build();

        webTarget.register(feature);

        final Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);

        invocationBuilder.header(API_KEY, API_KEY_VALUE);

        return invocationBuilder.get();
    }

    public static Response getFoodIngredientsSearch(String sortDirection, String sort, String query, int offset, int number, String intolerances) {

        final Client client = ClientBuilder.newBuilder().build();
//                .property(LoggingFeature.LOGGING_FEATURE_VERBOSITY_CLIENT, LoggingFeature.Verbosity.PAYLOAD_ANY)
//                .property(LoggingFeature.LOGGING_FEATURE_VERBOSITY_CLIENT_LOGGER_LEVEL_CLIENT, "INFO").build();

        final WebTarget webTarget = client.target(String.format(FOOD_INGREDIENTS_SEARCH, sortDirection, sort, query, offset, number, intolerances));

        final HttpAuthenticationFeature feature = HttpAuthenticationFeature.basicBuilder().build();

        webTarget.register(feature);

        final Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);

        invocationBuilder.header(API_KEY, API_KEY_VALUE);

        return invocationBuilder.get();
    }




    public static Response getFoodIngredientsIdAmount(int id, String unit, int target, String nutrient) {

        final Client client = ClientBuilder.newBuilder().build();
//                .property(LoggingFeature.LOGGING_FEATURE_VERBOSITY_CLIENT, LoggingFeature.Verbosity.PAYLOAD_ANY)
//                .property(LoggingFeature.LOGGING_FEATURE_VERBOSITY_CLIENT_LOGGER_LEVEL_CLIENT, "INFO").build();

        final WebTarget webTarget = client.target(String.format(FOOD_INGREDIENTS_ID_AMOUNT, id, unit, target, nutrient));

        final HttpAuthenticationFeature feature = HttpAuthenticationFeature.basicBuilder().build();

        webTarget.register(feature);

        final Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);

        invocationBuilder.header(API_KEY, API_KEY_VALUE);

        return invocationBuilder.get();
    }



    public static Response getFoodIngredientsIdInformation(int id, String unit, int amount) {

        final Client client = ClientBuilder.newBuilder().build();
//                .property(LoggingFeature.LOGGING_FEATURE_VERBOSITY_CLIENT, LoggingFeature.Verbosity.PAYLOAD_ANY)
//                .property(LoggingFeature.LOGGING_FEATURE_VERBOSITY_CLIENT_LOGGER_LEVEL_CLIENT, "INFO").build();

        final WebTarget webTarget = client.target(String.format(FOOD_INGREDIENTS_ID_INFORMATION, id, unit, amount));

        final HttpAuthenticationFeature feature = HttpAuthenticationFeature.basicBuilder().build();

        webTarget.register(feature);

        final Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);

        invocationBuilder.header(API_KEY, API_KEY_VALUE);

        return invocationBuilder.get();
    }




    public static Response getFoodMenuItemsSearch(String query) {

        final Client client = ClientBuilder.newBuilder().build();
//                .property(LoggingFeature.LOGGING_FEATURE_VERBOSITY_CLIENT, LoggingFeature.Verbosity.PAYLOAD_ANY)
//                .property(LoggingFeature.LOGGING_FEATURE_VERBOSITY_CLIENT_LOGGER_LEVEL_CLIENT, "INFO").build();

        final WebTarget webTarget = client.target(String.format(FOOD_MENU_ITEMS_SEARCH, query));

        final HttpAuthenticationFeature feature = HttpAuthenticationFeature.basicBuilder().build();

        webTarget.register(feature);

        final Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);

        invocationBuilder.header(API_KEY, API_KEY_VALUE);

        return invocationBuilder.get();
    }




    public static Response getFoodMenuItemsId(int id) {

        final Client client = ClientBuilder.newBuilder().build();
//                .property(LoggingFeature.LOGGING_FEATURE_VERBOSITY_CLIENT, LoggingFeature.Verbosity.PAYLOAD_ANY)
//                .property(LoggingFeature.LOGGING_FEATURE_VERBOSITY_CLIENT_LOGGER_LEVEL_CLIENT, "INFO").build();

        final WebTarget webTarget = client.target(String.format(FOOD_MENU_ITEMS_ID, id));

        final HttpAuthenticationFeature feature = HttpAuthenticationFeature.basicBuilder().build();

        webTarget.register(feature);

        final Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);

        invocationBuilder.header(API_KEY, API_KEY_VALUE);

        return invocationBuilder.get();
    }




    public static Response getFoodProductsSearch(String query) {

        final Client client = ClientBuilder.newBuilder().build();
//                .property(LoggingFeature.LOGGING_FEATURE_VERBOSITY_CLIENT, LoggingFeature.Verbosity.PAYLOAD_ANY)
//                .property(LoggingFeature.LOGGING_FEATURE_VERBOSITY_CLIENT_LOGGER_LEVEL_CLIENT, "INFO").build();

        final WebTarget webTarget = client.target(String.format(FOOD_PRODUCTS_SEARCH, query));

        final HttpAuthenticationFeature feature = HttpAuthenticationFeature.basicBuilder().build();

        webTarget.register(feature);

        final Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);

        invocationBuilder.header(API_KEY, API_KEY_VALUE);

        return invocationBuilder.get();
    }




    public static Response getFoodProductsId(int id) {

        final Client client = ClientBuilder.newBuilder().build();
//                .property(LoggingFeature.LOGGING_FEATURE_VERBOSITY_CLIENT, LoggingFeature.Verbosity.PAYLOAD_ANY)
//                .property(LoggingFeature.LOGGING_FEATURE_VERBOSITY_CLIENT_LOGGER_LEVEL_CLIENT, "INFO").build();

        final WebTarget webTarget = client.target(String.format(FOOD_PRODUCTS_ID, id));

        final HttpAuthenticationFeature feature = HttpAuthenticationFeature.basicBuilder().build();

        webTarget.register(feature);

        final Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);

        invocationBuilder.header(API_KEY, API_KEY_VALUE);

        return invocationBuilder.get();
    }




    public static Response getRecipesAutocomplete(String query) {

        final Client client = ClientBuilder.newBuilder().build();
//                .property(LoggingFeature.LOGGING_FEATURE_VERBOSITY_CLIENT, LoggingFeature.Verbosity.PAYLOAD_ANY)
//                .property(LoggingFeature.LOGGING_FEATURE_VERBOSITY_CLIENT_LOGGER_LEVEL_CLIENT, "INFO").build();

        final WebTarget webTarget = client.target(String.format(RECIPES_AUTOCOMPLETE, query));

        final HttpAuthenticationFeature feature = HttpAuthenticationFeature.basicBuilder().build();

        webTarget.register(feature);

        final Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);

        invocationBuilder.header(API_KEY, API_KEY_VALUE);

        return invocationBuilder.get();
    }




    public static Response getRecipesComplexSearch(String query) {

        final Client client = ClientBuilder.newBuilder().build();
//                .property(LoggingFeature.LOGGING_FEATURE_VERBOSITY_CLIENT, LoggingFeature.Verbosity.PAYLOAD_ANY)
//                .property(LoggingFeature.LOGGING_FEATURE_VERBOSITY_CLIENT_LOGGER_LEVEL_CLIENT, "INFO").build();

        final WebTarget webTarget = client.target(String.format(RECIPES_COMPLEX_SEARCH, query));

        final HttpAuthenticationFeature feature = HttpAuthenticationFeature.basicBuilder().build();

        webTarget.register(feature);

        final Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);

        invocationBuilder.header(API_KEY, API_KEY_VALUE);

        return invocationBuilder.get();
    }

    public static Response getRecipesConvert(String targetUnit, String sourceUnit, double sourceAmount, String ingredientName) {

        final Client client = ClientBuilder.newBuilder().build();
//                .property(LoggingFeature.LOGGING_FEATURE_VERBOSITY_CLIENT, LoggingFeature.Verbosity.PAYLOAD_ANY)
//                .property(LoggingFeature.LOGGING_FEATURE_VERBOSITY_CLIENT_LOGGER_LEVEL_CLIENT, "INFO").build();

        final WebTarget webTarget = client.target(String.format(RECIPES_CONVERT, targetUnit, sourceUnit, sourceAmount, ingredientName));

        final HttpAuthenticationFeature feature = HttpAuthenticationFeature.basicBuilder().build();

        webTarget.register(feature);

        final Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);

        invocationBuilder.header(API_KEY, API_KEY_VALUE);

        return invocationBuilder.get();
    }

    public static Response getRecipesExtract(String url) {

        final Client client = ClientBuilder.newBuilder().build();
//                .property(LoggingFeature.LOGGING_FEATURE_VERBOSITY_CLIENT, LoggingFeature.Verbosity.PAYLOAD_ANY)
//                .property(LoggingFeature.LOGGING_FEATURE_VERBOSITY_CLIENT_LOGGER_LEVEL_CLIENT, "INFO").build();

        final WebTarget webTarget = client.target(String.format(RECIPES_EXTRACT, url));

        final HttpAuthenticationFeature feature = HttpAuthenticationFeature.basicBuilder().build();

        webTarget.register(feature);

        final Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);

        invocationBuilder.header(API_KEY, API_KEY_VALUE);

        return invocationBuilder.get();
    }

    public static Response getRecipesIdInformation(int id, String includeNutrition) {

        final Client client = ClientBuilder.newBuilder().build();
//                .property(LoggingFeature.LOGGING_FEATURE_VERBOSITY_CLIENT, LoggingFeature.Verbosity.PAYLOAD_ANY)
//                .property(LoggingFeature.LOGGING_FEATURE_VERBOSITY_CLIENT_LOGGER_LEVEL_CLIENT, "INFO").build();

        final WebTarget webTarget = client.target(String.format(RECIPES_ID_INFORMATION, id, includeNutrition));

        final HttpAuthenticationFeature feature = HttpAuthenticationFeature.basicBuilder().build();

        webTarget.register(feature);

        final Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);

        invocationBuilder.header(API_KEY, API_KEY_VALUE);

        return invocationBuilder.get();
    }
}
