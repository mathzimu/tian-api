package org.example.ryan.tianapi.service;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ApiCallService {

    private static final Logger logger = LoggerFactory.getLogger(ApiCallService.class);

    private final TianApiService tianApiService;

    public ApiCallService(TianApiService tianApiService) {
        this.tianApiService = tianApiService;
    }

    /**
     * Generic method to call TianAPI
     *
     * @param endpoint API endpoint
     * @param params   Request parameters
     * @return API response result
     */
    public String callTianApi(String endpoint, String params) {
        String apiKey = tianApiService.getApiKey();
        String baseUrl = tianApiService.getBaseURL();

        String url = baseUrl + "/" + endpoint + "?key=" + apiKey;
        if (params != null && !params.isEmpty()) {
            url += "&" + params;
        }

        logger.info("Calling TianAPI: {}", url);

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet httpGet = new HttpGet(url);
            ClassicHttpResponse response = httpClient.execute(httpGet);
            return EntityUtils.toString(response.getEntity());
        } catch (IOException | ParseException e) {
            logger.error("Error calling TianAPI: {}", e.getMessage(), e);
            return "{\"code\": -1, \"msg\": \"API call failed: " + e.getMessage() + "\"}";
        }
    }
}