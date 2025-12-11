package org.example.ryan.tianapi.controller;

import org.example.ryan.tianapi.dto.ApiResponse;
import org.example.ryan.tianapi.service.KnowledgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for knowledge category APIs
 */
@RestController
@RequestMapping("/api/knowledge")
public class KnowledgeController {
    
    @Autowired
    private KnowledgeService knowledgeService;
    
    /**
     * Get dictionary definition
     * @param word word to look up
     * @return dictionary definition
     */
    @GetMapping("/dictionary")
    public ApiResponse<String> getDictionaryDefinition(@RequestParam(required = false) String word) {
        return knowledgeService.getDictionaryDefinition(word);
    }
    
    /**
     * Get encyclopedia information
     * @param word term to look up
     * @return encyclopedia information
     */
    @GetMapping("/encyclopedia")
    public ApiResponse<String> getEncyclopediaInfo(@RequestParam(required = false) String word) {
        return knowledgeService.getEncyclopediaInfo(word);
    }
    
    /**
     * Get poetry
     * @param word keyword for poetry
     * @return poetry information
     */
    @GetMapping("/poetry")
    public ApiResponse<String> getPoetry(@RequestParam(required = false) String word) {
        return knowledgeService.getPoetry(word);
    }
    
    /**
     * Get idioms
     * @param word keyword for idioms
     * @return idioms information
     */
    @GetMapping("/idioms")
    public ApiResponse<String> getIdioms(@RequestParam(required = false) String word) {
        return knowledgeService.getIdioms(word);
    }
    
    /**
     * Get ancient books information
     * @param keyword keyword for ancient books search
     * @param num number of results (default: 10)
     * @param page page number (default: 1)
     * @return ancient books information
     */
    @GetMapping("/ancient-books")
    public ApiResponse<String> getAncientBooks(@RequestParam(required = false) String keyword,
                                 @RequestParam(required = false, defaultValue = "10") Integer num,
                                 @RequestParam(required = false, defaultValue = "1") Integer page) {
        return knowledgeService.getAncientBooks(keyword, num, page);
    }
}