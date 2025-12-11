package org.example.ryan.tianapi.controller;

import org.example.ryan.tianapi.dto.ApiResponse;
import org.example.ryan.tianapi.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for news category APIs
 */
@RestController
@RequestMapping("/api/news")
public class NewsController {
    
    @Autowired
    private NewsService newsService;
    
    /**
     * Get hot news
     * @param num number of news items (default: 10)
     * @return hot news data
     */
    @GetMapping("/hot")
    public ApiResponse<String> getHotNews(@RequestParam(required = false, defaultValue = "10") Integer num) {
        return newsService.getHotNews(num);
    }
    
    /**
     * Get social news
     * @param num number of news items (default: 10)
     * @return social news data
     */
    @GetMapping("/social")
    public ApiResponse<String> getSocialNews(@RequestParam(required = false, defaultValue = "10") Integer num) {
        return newsService.getSocialNews(num);
    }
    
    /**
     * Get domestic news
     * @param num number of news items (default: 10)
     * @return domestic news data
     */
    @GetMapping("/domestic")
    public ApiResponse<String> getDomesticNews(@RequestParam(required = false, defaultValue = "10") Integer num) {
        return newsService.getDomesticNews(num);
    }
    
    /**
     * Get international news
     * @param num number of news items (default: 10)
     * @return international news data
     */
    @GetMapping("/international")
    public ApiResponse<String> getInternationalNews(@RequestParam(required = false, defaultValue = "10") Integer num) {
        return newsService.getInternationalNews(num);
    }
}