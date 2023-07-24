package com.xiahaimoyu.common.identifydocanalyzer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author howard.li
 * @date 2023/7/25
 */
public class AnalyzerResult {

    private boolean isValid;

    private Map<String, String> value = new HashMap<>();

    public static AnalyzerResult buildSuccess(Map<String, String> value) {
        AnalyzerResult result = new AnalyzerResult();
        result.isValid = true;
        result.value = value;
        return result;
    }

    public boolean isValid() {
        return isValid;
    }

    public Map<String, String> getValue() {
        return value;
    }

}
