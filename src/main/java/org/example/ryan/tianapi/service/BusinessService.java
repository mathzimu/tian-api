package org.example.ryan.tianapi.service;

import org.example.ryan.tianapi.dto.ApiResponse;
import org.springframework.stereotype.Service;

/**
 * Service for business category APIs
 */
@Service
public class BusinessService extends BaseCategoryService {
    
    @Override
    protected String getBasePath() {
        return "business";
    }
    
    /**
     * Get express information
     * @param number express number
     * @param type express company type
     * @return express information
     */
    public ApiResponse<String> getExpressInfo(String number, String type) {
        StringBuilder params = new StringBuilder();
        if (number != null) {
            params.append("number=").append(number);
        }
        if (type != null) {
            if (params.length() > 0) params.append("&");
            params.append("type=").append(type);
        }
        return callApiWithResponse("express/index", params.toString());
    }
    
    /**
     * Get business registration information
     * @param keyword company name or registration number
     * @return business registration information
     */
    public ApiResponse<String> getBusinessRegistration(String keyword) {
        String params = (keyword != null) ? "keyword=" + keyword : "";
        return callApiWithResponse("businessreg/index", params);
    }
    
    /**
     * Get invoice verification
     * @param number invoice number
     * @param code invoice verification code
     * @return invoice verification result
     */
    public ApiResponse<String> getInvoiceVerification(String number, String code) {
        StringBuilder params = new StringBuilder();
        if (number != null) {
            params.append("number=").append(number);
        }
        if (code != null) {
            if (params.length() > 0) params.append("&");
            params.append("code=").append(code);
        }
        return callApiWithResponse("invoice/index", params.toString());
    }
    
    /**
     * Get holiday information
     * @param date date to check (format: yyyy-MM-dd)
     * @return holiday information
     */
    public ApiResponse<String> getHolidayInfo(String date) {
        String params = (date != null) ? "date=" + date : "";
        return callApiWithResponse("holiday/index", params);
    }
}