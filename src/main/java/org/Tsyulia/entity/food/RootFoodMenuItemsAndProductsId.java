package org.Tsyulia.entity.food;

import lombok.*;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RootFoodMenuItemsAndProductsId {
    private List<String> badges;
    private List<String> breadcrumbs;
    private String generatedText;
    private Integer id;
    private String image;
    private String imageType;
    private List<String> images;
    private Double likes;
    private Nutrition nutrition;
    private Double price;
    private String restaurantChain;
    private Servings servings;
    private Double spoonacularScore;
    private String title;
    private String aisle;
    private String brand;
    private String description;
    private List<String> importantBadges;
    private Integer ingredientCount;
    private String ingredientList;
    private List<Ingredient> ingredients;
    private String upc;
}
