package org.example.ryan.tianapi.service;

import org.example.ryan.tianapi.dto.ApiResponse;
import org.springframework.stereotype.Service;

/**
 * Service for knowledge category APIs
 */
@Service
public class KnowledgeService extends BaseCategoryService {
    
    @Override
    protected String getBasePath() {
        return "knowledge";
    }
    
    /**
     * Get dictionary definition
     * @param word word to look up
     * @return dictionary definition
     */
    public ApiResponse<String> getDictionaryDefinition(String word) {
        String params = (word != null) ? "word=" + word : "";
        return callApiWithResponse("dict/index", params);
    }
    
    /**
     * Get encyclopedia information
     * @param word term to look up
     * @return encyclopedia information
     */
    public ApiResponse<String> getEncyclopediaInfo(String word) {
        String params = (word != null) ? "word=" + word : "";
        return callApiWithResponse("encyclopedia/index", params);
    }
    
    /**
     * Get poetry
     * @param word keyword for poetry
     * @return poetry information
     */
    public ApiResponse<String> getPoetry(String word) {
        String params = (word != null) ? "word=" + word : "";
        return callApiWithResponse("poem/index", params);
    }
    
    /**
     * Get idioms
     * @param word keyword for idioms
     * @return idioms information
     */
    public ApiResponse<String> getIdioms(String word) {
        String params = (word != null) ? "word=" + word : "";
        return callApiWithResponse("idiom/index", params);
    }
    
    /**
     * Get ancient books information
     * @param keyword keyword for ancient books search
     * @param num number of results (default: 10)
     * @param page page number (default: 1)
     * @return ancient books information
     */
    public ApiResponse<String> getAncientBooks(String keyword, Integer num, Integer page) {
        StringBuilder params = new StringBuilder();
        if (keyword != null) {
            params.append("keyword=").append(keyword);
        }
        if (num != null) {
            if (params.length() > 0) params.append("&");
            params.append("num=").append(num);
        }
        if (page != null) {
            if (params.length() > 0) params.append("&");
            params.append("page=").append(page);
        }
        return callApiWithResponse("gujitest/index", params.toString());
    }
}