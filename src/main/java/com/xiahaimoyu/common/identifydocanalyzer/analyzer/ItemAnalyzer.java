package com.xiahaimoyu.common.identifydocanalyzer.analyzer;

import java.util.Map;

/**
 * @author howard.li
 * @date 2023/7/25
 */
public interface ItemAnalyzer {

    public Map<String, String> getResult(String itemValue);
}
