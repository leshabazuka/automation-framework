package org.Tsyulia.entity.currency;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Query {
    private String from;
    private String to;
    private Double amount;
}
