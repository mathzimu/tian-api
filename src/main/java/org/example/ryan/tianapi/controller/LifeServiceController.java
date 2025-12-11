package org.example.ryan.tianapi.controller;

import org.example.ryan.tianapi.dto.ApiResponse;
import org.example.ryan.tianapi.service.LifeServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for life service category APIs
 */
@RestController
@RequestMapping("/api/lifeservice")
public class LifeServiceController {
    
    @Autowired
    private LifeServiceService lifeServiceService;
    
    /**
     * Get weather information
     * @param city city name
     * @return weather data
     */
    @GetMapping("/weather")
    public ApiResponse<String> getWeather(@RequestParam(required = false) String city) {
        return lifeServiceService.getWeather(city);
    }
    
    /**
     * Get garbage classification
     * @param word item to classify
     * @return classification result
     */
    @GetMapping("/garbage")
    public ApiResponse<String> getGarbageClassification(@RequestParam(required = false) String word) {
        return lifeServiceService.getGarbageClassification(word);
    }
    
    /**
     * Get phone number attribution
     * @param mobile phone number
     * @return attribution information
     */
    @GetMapping("/phone")
    public ApiResponse<String> getPhoneAttribution(@RequestParam(required = false) String mobile) {
        return lifeServiceService.getPhoneAttribution(mobile);
    }
    
    /**
     * Get IP address information
     * @param ip IP address
     * @return IP information
     */
    @GetMapping("/ip")
    public ApiResponse<String> getIpInfo(@RequestParam(required = false) String ip) {
        return lifeServiceService.getIpInfo(ip);
    }
}