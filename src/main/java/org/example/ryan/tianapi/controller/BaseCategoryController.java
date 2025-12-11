package org.example.ryan.tianapi.controller;

import org.example.ryan.tianapi.dto.ApiResponse;
import org.example.ryan.tianapi.service.ApiCallService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Base controller for all API categories
 */
public abstract class BaseCategoryController {

    protected ApiCallService apiCallService;
    
    /**
     * Get the base path for this category
     * @return the base path
     */
    protected abstract String getBasePath();
    
    /**
     * Call an API endpoint within this category and wrap response in ApiResponse
     * @param endpoint the specific endpoint
     * @param params the parameters
     * @return API response wrapped in ApiResponse
     */
    protected ApiResponse<String> callApiWithResponse(String endpoint, String params) {
        try {
            String result = apiCallService.callTianApi(getBasePath() + "/" + endpoint, params);
            return ApiResponse.success(result);
        } catch (Exception e) {
            return ApiResponse.error("API call failed: " + e.getMessage());
        }
    }
}