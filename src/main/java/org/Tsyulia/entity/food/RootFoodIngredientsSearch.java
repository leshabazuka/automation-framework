package org.Tsyulia.entity.food;

import lombok.*;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RootFoodIngredientsSearch {
    private Integer number;
    private Integer offset;
    private List<FoodIngredientsSearchResults> results;
    private Integer totalResults;
}
