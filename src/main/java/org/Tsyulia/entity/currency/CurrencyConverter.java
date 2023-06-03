package org.Tsyulia.entity.currency;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CurrencyConverter {
    private Boolean success;
    private Query query;
    private Info info;
    private String date;
    private Double result;
}
