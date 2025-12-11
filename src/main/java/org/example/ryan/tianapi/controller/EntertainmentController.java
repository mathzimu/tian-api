package org.example.ryan.tianapi.controller;

import org.example.ryan.tianapi.dto.ApiResponse;
import org.example.ryan.tianapi.service.EntertainmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for entertainment category APIs
 */
@RestController
@RequestMapping("/api/entertainment")
public class EntertainmentController {
    
    @Autowired
    private EntertainmentService entertainmentService;
    
    /**
     * Get brain teaser
     * @param num number of items (default: 10)
     * @return brain teasers
     */
    @GetMapping("/brain-teaser")
    public ApiResponse<String> getBrainTeaser(@RequestParam(required = false, defaultValue = "10") Integer num) {
        return entertainmentService.getBrainTeaser(num);
    }
    
    /**
     * Get zodiac fortune
     * @param astro zodiac sign
     * @return fortune information
     */
    @GetMapping("/zodiac")
    public ApiResponse<String> getZodiacFortune(@RequestParam(required = false) String astro) {
        return entertainmentService.getZodiacFortune(astro);
    }
    
    /**
     * Get love quotes
     * @return love quotes
     */
    @GetMapping("/love-quotes")
    public ApiResponse<String> getLoveQuotes() {
        return entertainmentService.getLoveQuotes();
    }
    
    /**
     * Get jokes
     * @param num number of items (default: 10)
     * @return jokes
     */
    @GetMapping("/jokes")
    public ApiResponse<String> getJokes(@RequestParam(required = false, defaultValue = "10") Integer num) {
        return entertainmentService.getJokes(num);
    }
}