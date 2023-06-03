package org.Tsyulia.entity.food;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Nutrient {
    private Double amount;
    private String name;
    private Double percentOfDailyNeeds;
    private String unit;
}
