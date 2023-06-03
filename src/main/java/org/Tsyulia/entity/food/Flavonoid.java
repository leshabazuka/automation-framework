package org.Tsyulia.entity.food;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Flavonoid {
    private Double amount;
    private String name;
    private String unit;
}
