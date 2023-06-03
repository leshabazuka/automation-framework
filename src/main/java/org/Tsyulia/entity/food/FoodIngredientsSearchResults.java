package org.Tsyulia.entity.food;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FoodIngredientsSearchResults {
    private Integer id;
    private String image;
    private String name;
}
