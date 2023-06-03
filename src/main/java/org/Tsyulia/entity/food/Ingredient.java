package org.Tsyulia.entity.food;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Ingredient {
    private String description;
    private String name;
    private String safety_level;
}
