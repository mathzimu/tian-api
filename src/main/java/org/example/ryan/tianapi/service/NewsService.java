package org.example.ryan.tianapi.service;

import org.example.ryan.tianapi.dto.ApiResponse;
import org.springframework.stereotype.Service;

/**
 * Service for news category APIs
 */
@Service
public class NewsService extends BaseCategoryService {
    
    @Override
    protected String getBasePath() {
        return "news";
    }
    
    /**
     * Get hot news
     * @param num number of news items (default: 10)
     * @return hot news data
     */
    public ApiResponse<String> getHotNews(Integer num) {
        String params = (num != null) ? "num=" + num : "";
        return callApiWithResponse("hotnews/index", params);
    }
    
    /**
     * Get social news
     * @param num number of news items (default: 10)
     * @return social news data
     */
    public ApiResponse<String> getSocialNews(Integer num) {
        String params = (num != null) ? "num=" + num : "";
        return callApiWithResponse("social/index", params);
    }
    
    /**
     * Get domestic news
     * @param num number of news items (default: 10)
     * @return domestic news data
     */
    public ApiResponse<String> getDomesticNews(Integer num) {
        String params = (num != null) ? "num=" + num : "";
        return callApiWithResponse("domestic/index", params);
    }
    
    /**
     * Get international news
     * @param num number of news items (default: 10)
     * @return international news data
     */
    public ApiResponse<String> getInternationalNews(Integer num) {
        String params = (num != null) ? "num=" + num : "";
        return callApiWithResponse("international/index", params);
    }
}