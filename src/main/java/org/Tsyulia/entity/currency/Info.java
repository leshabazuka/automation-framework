package org.Tsyulia.entity.currency;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Info {
    private Long timestamp;
    private Double rate;
}
