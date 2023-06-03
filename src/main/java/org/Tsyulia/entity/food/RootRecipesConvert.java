package org.Tsyulia.entity.food;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RootRecipesConvert {
    private String answer;
    private Double sourceAmount;
    private String sourceUnit;
    private Double targetAmount;
    private String targetUnit;
    private String type;
}
