package org.Tsyulia.api.constantsApi;

public class URL {
    public static final String BASE_URL = "https://api.apilayer.com/";
    public static final String FOOD_INGREDIENTS_SEARCH = BASE_URL + "spoonacular/food/ingredients/search?sortDirection=%s&sort=%s&query=%s&offset=%s&number=%s&intolerances=%s";
    public static final String FOOD_INGREDIENTS_ID_AMOUNT = BASE_URL + "spoonacular/food/ingredients/%s/amount?unit=%s&target=%s&nutrient=%s";
    public static final String FOOD_INGREDIENTS_ID_INFORMATION = BASE_URL + "spoonacular/food/ingredients/%s/information?unit=%s&amount=%s";
    public static final String FOOD_MENU_ITEMS_SEARCH = BASE_URL + "spoonacular/food/menuItems/search?query=%s";
    public static final String FOOD_MENU_ITEMS_ID = BASE_URL + "spoonacular/food/menuItems/%s";
    public static final String FOOD_PRODUCTS_SEARCH = BASE_URL + "spoonacular/food/products/search?query=%s";
    public static final String FOOD_PRODUCTS_ID = BASE_URL + "spoonacular/food/products/%s";
    public static final String RECIPES_AUTOCOMPLETE = BASE_URL + "spoonacular/recipes/autocomplete?query=%s";
    public static final String RECIPES_COMPLEX_SEARCH = BASE_URL + "spoonacular/recipes/complexSearch?query=%s";
    public static final String RECIPES_CONVERT = BASE_URL + "spoonacular/recipes/convert?targetUnit=%s&sourceUnit=%s&sourceAmount=%s&ingredientName=%s";
    public static final String RECIPES_EXTRACT = BASE_URL + "spoonacular/recipes/extract?url=%s";
    public static final String RECIPES_ID_INFORMATION = BASE_URL + "spoonacular/recipes/%s/information?includeNutrition=%s";
}
