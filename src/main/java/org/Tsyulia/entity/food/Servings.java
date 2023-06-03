package org.Tsyulia.entity.food;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Servings {
    private Integer number;
    private Integer size;
    private String unit;
}
