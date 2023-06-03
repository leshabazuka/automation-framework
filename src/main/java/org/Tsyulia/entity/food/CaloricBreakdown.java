package org.Tsyulia.entity.food;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CaloricBreakdown {
    private Double percentCarbs;
    private Double percentFat;
    private Double percentProtein;
}
