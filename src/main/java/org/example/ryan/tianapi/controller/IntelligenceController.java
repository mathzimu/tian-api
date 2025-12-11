package org.example.ryan.tianapi.controller;

import org.example.ryan.tianapi.dto.ApiResponse;
import org.example.ryan.tianapi.service.IntelligenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for intelligence category APIs
 */
@RestController
@RequestMapping("/api/intelligence")
public class IntelligenceController {
    
    @Autowired
    private IntelligenceService intelligenceService;
    
    /**
     * Get robot response
     * @param question question to ask
     * @return robot response
     */
    @GetMapping("/robot")
    public ApiResponse<String> getRobotResponse(@RequestParam(required = false) String question) {
        return intelligenceService.getRobotResponse(question);
    }
    
    /**
     * Get translation
     * @param text text to translate
     * @param from source language
     * @param to target language
     * @return translation result
     */
    @GetMapping("/translate")
    public ApiResponse<String> getTranslation(@RequestParam(required = false) String text,
                                @RequestParam(required = false) String from,
                                @RequestParam(required = false) String to) {
        return intelligenceService.getTranslation(text, from, to);
    }
    
    /**
     * Get OCR result
     * @param image image URL
     * @return OCR result
     */
    @GetMapping("/ocr")
    public ApiResponse<String> getOcrResult(@RequestParam(required = false) String image) {
        return intelligenceService.getOcrResult(image);
    }
    
    /**
     * Get image recognition result
     * @param img image URL
     * @return image recognition result
     */
    @GetMapping("/image-recognition")
    public ApiResponse<String> getImageRecognition(@RequestParam(required = false) String img) {
        return intelligenceService.getImageRecognition(img);
    }
}