package org.example.ryan.tianapi.service;

import org.example.ryan.tianapi.dto.ApiResponse;
import org.springframework.stereotype.Service;

/**
 * Service for function category APIs
 */
@Service
public class FunctionService extends BaseCategoryService {
    
    @Override
    protected String getBasePath() {
        return "function";
    }
    
    /**
     * Get QR code
     * @param text text to encode
     * @param size QR code size (default: 200)
     * @return QR code image URL
     */
    public ApiResponse<String> getQrCode(String text, Integer size) {
        StringBuilder params = new StringBuilder();
        if (text != null) {
            params.append("text=").append(text);
        }
        if (size != null) {
            if (params.length() > 0) params.append("&");
            params.append("size=").append(size);
        }
        return callApiWithResponse("qrcode/index", params.toString());
    }
    
    /**
     * Get ID card information
     * @param cardno ID card number
     * @return ID card information
     */
    public ApiResponse<String> getIdCardInfo(String cardno) {
        String params = (cardno != null) ? "cardno=" + cardno : "";
        return callApiWithResponse("idcard/index", params);
    }
    
    /**
     * Get bank card information
     * @param bankcard bank card number
     * @return bank card information
     */
    public ApiResponse<String> getBankCardInfo(String bankcard) {
        String params = (bankcard != null) ? "bankcard=" + bankcard : "";
        return callApiWithResponse("bankcard/index", params);
    }
    
    /**
     * Get exchange rate
     * @param from currency to convert from
     * @param to currency to convert to
     * @param money amount to convert
     * @return exchange rate information
     */
    public ApiResponse<String> getExchangeRate(String from, String to, Double money) {
        StringBuilder params = new StringBuilder();
        if (from != null) {
            params.append("from=").append(from);
        }
        if (to != null) {
            if (params.length() > 0) params.append("&");
            params.append("to=").append(to);
        }
        if (money != null) {
            if (params.length() > 0) params.append("&");
            params.append("money=").append(money);
        }
        return callApiWithResponse("exchange/index", params.toString());
    }
}