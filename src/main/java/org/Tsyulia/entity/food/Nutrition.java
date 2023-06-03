package org.Tsyulia.entity.food;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Nutrition {
    private CaloricBreakdown caloricBreakdown;
    private List<Flavonoid> flavonoids;
    private List<Nutrient> nutrients;
    private List<Property> properties;
    private WeightPerServing weightPerServing;
    private Double calories;
    private String carbs;
    private String fat;
    private String protein;
}
