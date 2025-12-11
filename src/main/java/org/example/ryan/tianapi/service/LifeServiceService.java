package org.example.ryan.tianapi.service;

import org.example.ryan.tianapi.dto.ApiResponse;
import org.springframework.stereotype.Service;

/**
 * Service for life service category APIs
 */
@Service
public class LifeServiceService extends BaseCategoryService {
    
    @Override
    protected String getBasePath() {
        return "lifeservice";
    }
    
    /**
     * Get weather information
     * @param city city name
     * @return weather data
     */
    public ApiResponse<String> getWeather(String city) {
        String params = (city != null) ? "city=" + city : "";
        return callApiWithResponse("tianqi/index", params);
    }
    
    /**
     * Get garbage classification
     * @param word item to classify
     * @return classification result
     */
    public ApiResponse<String> getGarbageClassification(String word) {
        String params = (word != null) ? "word=" + word : "";
        return callApiWithResponse("garbage/index", params);
    }
    
    /**
     * Get phone number attribution
     * @param mobile phone number
     * @return attribution information
     */
    public ApiResponse<String> getPhoneAttribution(String mobile) {
        String params = (mobile != null) ? "mobile=" + mobile : "";
        return callApiWithResponse("mobile/index", params);
    }
    
    /**
     * Get IP address information
     * @param ip IP address
     * @return IP information
     */
    public ApiResponse<String> getIpInfo(String ip) {
        String params = (ip != null) ? "ip=" + ip : "";
        return callApiWithResponse("ip/index", params);
    }
}