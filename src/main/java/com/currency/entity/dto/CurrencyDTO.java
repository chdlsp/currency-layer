package com.currency.entity.dto;

import com.currency.entity.model.Country;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class CurrencyDTO {

    private static final List<Country> COUNTRIES = new ArrayList<>();

    static {
        initData();
    }

    private static void initData() {
        Country quoteKRW = new Country(1L, "USDKRW", "KRW", "한국");
        Country quoteJPY = new Country(2L, "USDJPY", "JPY", "일본");
        Country quotePHP = new Country(3L, "USDPHP", "PHP", "필리핀");

        COUNTRIES.add(quoteKRW);
        COUNTRIES.add(quoteJPY);
        COUNTRIES.add(quotePHP);
    }

    public static List<Country> getCountries() {
        return COUNTRIES;
    }

    public Map<Long, String> getMapCountries() {
        Map<Long, String> map = new HashMap<Long, String>();
        for (Country c : COUNTRIES) {
            map.put(c.getCountryId(), c.getCountryName());
        }
        return map;
    }

}
