package org.Tsyulia.entity.food;

import lombok.*;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RootFoodIngredientsIdInformation {
    private String aisle;
    private Double amount;
    private List<String> categoryPath;
    private String consistency;
    private EstimatedCost estimatedCost;
    private Integer id;
    private String image;
    private List<Object> meta;
    private String name;
    private Nutrition nutrition;
    private String original;
    private String originalName;
    private List<String> possibleUnits;
    private List<String> shoppingListUnits;
    private String unit;
    private String unitLong;
    private String unitShort;




}
