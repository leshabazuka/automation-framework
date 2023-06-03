package org.Tsyulia.entity.food;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RootFoodIngredientsIdAmount {
    private Double amount;
    private String unit;
}
