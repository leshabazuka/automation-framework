package org.Tsyulia.entity.food;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RootFoodMenuItemsAndProductsSearch {
    private Long expires;
    private Boolean isStale;
    private List<MenuItemOrProduct> menuItems;
    private Integer number;
    private Integer offset;
    private Integer processingTimeMs;
    private Integer totalMenuItems;
    private String type;
}
