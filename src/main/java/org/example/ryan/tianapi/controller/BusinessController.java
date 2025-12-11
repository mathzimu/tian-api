package org.example.ryan.tianapi.controller;

import org.example.ryan.tianapi.dto.ApiResponse;
import org.example.ryan.tianapi.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for business category APIs
 */
@RestController
@RequestMapping("/api/business")
public class BusinessController {
    
    @Autowired
    private BusinessService businessService;
    
    /**
     * Get express information
     * @param number express number
     * @param type express company type
     * @return express information
     */
    @GetMapping("/express")
    public ApiResponse<String> getExpressInfo(@RequestParam(required = false) String number,
                               @RequestParam(required = false) String type) {
        return businessService.getExpressInfo(number, type);
    }
    
    /**
     * Get business registration information
     * @param keyword company name or registration number
     * @return business registration information
     */
    @GetMapping("/registration")
    public ApiResponse<String> getBusinessRegistration(@RequestParam(required = false) String keyword) {
        return businessService.getBusinessRegistration(keyword);
    }
    
    /**
     * Get invoice verification
     * @param number invoice number
     * @param code invoice verification code
     * @return invoice verification result
     */
    @GetMapping("/invoice")
    public ApiResponse<String> getInvoiceVerification(@RequestParam(required = false) String number,
                                       @RequestParam(required = false) String code) {
        return businessService.getInvoiceVerification(number, code);
    }
    
    /**
     * Get holiday information
     * @param date date to check (format: yyyy-MM-dd)
     * @return holiday information
     */
    @GetMapping("/holiday")
    public ApiResponse<String> getHolidayInfo(@RequestParam(required = false) String date) {
        return businessService.getHolidayInfo(date);
    }
}