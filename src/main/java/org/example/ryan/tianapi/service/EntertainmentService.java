package org.example.ryan.tianapi.service;

import org.example.ryan.tianapi.dto.ApiResponse;
import org.springframework.stereotype.Service;

/**
 * Service for entertainment category APIs
 */
@Service
public class EntertainmentService extends BaseCategoryService {
    
    @Override
    protected String getBasePath() {
        return "entertainment";
    }
    
    /**
     * Get brain teaser
     * @param num number of items (default: 10)
     * @return brain teasers
     */
    public ApiResponse<String> getBrainTeaser(Integer num) {
        String params = (num != null) ? "num=" + num : "";
        return callApiWithResponse("naonao/index", params);
    }
    
    /**
     * Get zodiac fortune
     * @param astro zodiac sign
     * @return fortune information
     */
    public ApiResponse<String> getZodiacFortune(String astro) {
        String params = (astro != null) ? "astro=" + astro : "";
        return callApiWithResponse("star/index", params);
    }
    
    /**
     * Get love quotes
     * @return love quotes
     */
    public ApiResponse<String> getLoveQuotes() {
        return callApiWithResponse("saylove/index", "");
    }
    
    /**
     * Get jokes
     * @param num number of items (default: 10)
     * @return jokes
     */
    public ApiResponse<String> getJokes(Integer num) {
        String params = (num != null) ? "num=" + num : "";
        return callApiWithResponse("joke/index", params);
    }
}