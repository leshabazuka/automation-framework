package org.Tsyulia.entity.food;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MenuItemOrProduct {
    private Integer id;
    private String image;
    private String imageType;
    private String restaurantChain;
    private Servings servings;
    private String title;
}
