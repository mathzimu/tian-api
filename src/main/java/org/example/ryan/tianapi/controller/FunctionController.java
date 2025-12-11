package org.example.ryan.tianapi.controller;

import org.example.ryan.tianapi.dto.ApiResponse;
import org.example.ryan.tianapi.service.FunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for function category APIs
 */
@RestController
@RequestMapping("/api/function")
public class FunctionController {
    
    @Autowired
    private FunctionService functionService;
    
    /**
     * Get QR code
     * @param text text to encode
     * @param size QR code size (default: 200)
     * @return QR code image URL
     */
    @GetMapping("/qrcode")
    public ApiResponse<String> getQrCode(@RequestParam(required = false) String text,
                           @RequestParam(required = false, defaultValue = "200") Integer size) {
        return functionService.getQrCode(text, size);
    }
    
    /**
     * Get ID card information
     * @param cardno ID card number
     * @return ID card information
     */
    @GetMapping("/idcard")
    public ApiResponse<String> getIdCardInfo(@RequestParam(required = false) String cardno) {
        return functionService.getIdCardInfo(cardno);
    }
    
    /**
     * Get bank card information
     * @param bankcard bank card number
     * @return bank card information
     */
    @GetMapping("/bankcard")
    public ApiResponse<String> getBankCardInfo(@RequestParam(required = false) String bankcard) {
        return functionService.getBankCardInfo(bankcard);
    }
    
    /**
     * Get exchange rate
     * @param from currency to convert from
     * @param to currency to convert to
     * @param money amount to convert
     * @return exchange rate information
     */
    @GetMapping("/exchange")
    public ApiResponse<String> getExchangeRate(@RequestParam(required = false) String from,
                                 @RequestParam(required = false) String to,
                                 @RequestParam(required = false) Double money) {
        return functionService.getExchangeRate(from, to, money);
    }
}