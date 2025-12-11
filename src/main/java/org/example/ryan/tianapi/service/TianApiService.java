package org.example.ryan.tianapi.service;

import org.example.ryan.tianapi.config.TianApiConfig;
import org.springframework.stereotype.Service;

@Service
public class TianApiService {

    private final TianApiConfig tianApiConfig;

    public TianApiService(TianApiConfig tianApiConfig) {
        this.tianApiConfig = tianApiConfig;
    }

    public String getApiKey() {
        return tianApiConfig.getKey();
    }

    public String getBaseURL() {
        return tianApiConfig.getBaseUrl();
    }
}