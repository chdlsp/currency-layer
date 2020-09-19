package com.currency.entity.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Country {
    private Long countryId;
    private String countryQuote; // USDKRW
    private String countryCode; // KRW
    private String countryName; // 한국
}
