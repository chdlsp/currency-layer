package com.currency.application;

import com.currency.entity.model.Country;
import com.currency.entity.vo.CurrencyQuoteVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class GetCurrnetCurrencyInfoService {

    // essential URL structure is built using constants
    public static final String ACCESS_KEY = "fb689a7e0d4466e56d6f3206fb5c5c64";
    public static final String BASE_URL = "http://api.currencylayer.com/";
    public static final String ENDPOINT = "live";

    static CloseableHttpClient httpClient = HttpClients.createDefault();

    public List<CurrencyQuoteVO> getCurrencyRate(List<Country> countryList) {

        HttpGet get = new HttpGet(BASE_URL + ENDPOINT + "?access_key=" + ACCESS_KEY);
        List<CurrencyQuoteVO> currencyQuoteList = new ArrayList<>();

        try {

            CloseableHttpResponse response =  httpClient.execute(get);
            HttpEntity entity = response.getEntity();

            JSONObject exchangeRates = new JSONObject(EntityUtils.toString(entity));
            log.info("exchangeRates : " + exchangeRates);

            // countries 별 환율 매핑
            for(Country country : countryList) {
                String quote = country.getCountryQuote(); // ex : USDKRW
                currencyQuoteList.add(new CurrencyQuoteVO(quote,
                        exchangeRates.getJSONObject("quotes").getDouble(quote)));

            }

            response.close();

        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return currencyQuoteList;
    }

}
