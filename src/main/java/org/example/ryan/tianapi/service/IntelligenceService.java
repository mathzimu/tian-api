package org.example.ryan.tianapi.service;

import org.example.ryan.tianapi.dto.ApiResponse;
import org.springframework.stereotype.Service;

/**
 * Service for intelligence category APIs
 */
@Service
public class IntelligenceService extends BaseCategoryService {
    
    @Override
    protected String getBasePath() {
        return "intelligence";
    }
    
    /**
     * Get robot response
     * @param question question to ask
     * @return robot response
     */
    public ApiResponse<String> getRobotResponse(String question) {
        String params = (question != null) ? "question=" + question : "";
        return callApiWithResponse("robot/index", params);
    }
    
    /**
     * Get translation
     * @param text text to translate
     * @param from source language
     * @param to target language
     * @return translation result
     */
    public ApiResponse<String> getTranslation(String text, String from, String to) {
        StringBuilder params = new StringBuilder();
        if (text != null) {
            params.append("text=").append(text);
        }
        if (from != null) {
            if (params.length() > 0) params.append("&");
            params.append("from=").append(from);
        }
        if (to != null) {
            if (params.length() > 0) params.append("&");
            params.append("to=").append(to);
        }
        return callApiWithResponse("translate/index", params.toString());
    }
    
    /**
     * Get OCR result
     * @param image image URL
     * @return OCR result
     */
    public ApiResponse<String> getOcrResult(String image) {
        String params = (image != null) ? "image=" + image : "";
        return callApiWithResponse("ocr/index", params);
    }
    
    /**
     * Get image recognition result
     * @param img image URL
     * @return image recognition result
     */
    public ApiResponse<String> getImageRecognition(String img) {
        String params = (img != null) ? "img=" + img : "";
        return callApiWithResponse("imagerecognition/index", params);
    }
}