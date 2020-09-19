package com.currency.controller;

import com.currency.application.GetCurrnetCurrencyInfoService;
import com.currency.entity.dto.CurrencyDTO;
import com.currency.entity.model.Country;
import com.currency.entity.vo.CurrencyQuoteVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@Slf4j
public class SendMoneyController {

    @Autowired
    GetCurrnetCurrencyInfoService getCurrnetCurrencyInfoService;

    @GetMapping("/")
    public String index(Model model) {

        // CurrencyDAO 에 매핑된 국가 정보 세팅
        List<Country> countryList = CurrencyDTO.getCountries();
        model.addAttribute("countries", countryList);
        log.info("countryList : " + countryList);

        // 국가 별 환율 정보 세팅
        List<CurrencyQuoteVO> currencyQuoteList = getCurrnetCurrencyInfoService.getCurrencyRate(countryList);
        model.addAttribute("quotes", currencyQuoteList);
        log.info("currencyQuoteList : " + currencyQuoteList);

        return "index";
    }
}
