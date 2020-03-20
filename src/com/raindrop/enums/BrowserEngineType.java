package com.raindrop.enums;

/**
 * @name: com.raindrop.enums.BrowserEngineType.java
 * @description: Browser engine types
 * @author: Raindrop
 * @create Time: 2020/3/20 11:14
 */
public enum BrowserEngineType {

    /**
     * BaiDu search engine
     */
    BAIDU_ENGINE("BaiDu", "https://www.baidu.com/s?wd="),
    /**
     * Bing search engine
     */
    BING_ENGINE("Bing", "https://cn.bing.com/search?q="),
    /**
     * DuckDuckGo search engine
     */
    DUCK_ENGINE("DuckDuckGo", "https://duckduckgo.com/?q="),
    /**
     * Google search engine
     */
    GOOGLE_ENGINE("Google", "https://www.google.com/search?q="),
    /**
     * StackOverflow search engine
     */
    SSO_ENGINE("StackOverflow", "https://stackoverflow.com/search?q=");

    private final String engineName;
    private final String enginePath;

    BrowserEngineType(String engineName, String enginePath) {
        this.engineName = engineName;
        this.enginePath = enginePath;
    }

    public String getEngineName() {
        return engineName;
    }

    public String getEnginePath() {
        return enginePath;
    }

}
