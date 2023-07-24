package com.xiahaimoyu.common.identifydocanalyzer;

import java.util.HashMap;
import java.util.Map;

import com.xiahaimoyu.common.identifydocanalyzer.analyzer.IdentityCardNoAnalyzer;
import com.xiahaimoyu.common.identifydocanalyzer.analyzer.ItemAnalyzer;

/**
 * @author howard.li
 * @date 2023/7/25
 */
public class IdentifyDocItemAnalyzer {
    private static final Map<AnalyzerType, ItemAnalyzer> analyzers = new HashMap<>();

    static {
        analyzers.put(AnalyzerType.IDENTITY_CARD_NO_ANALYZER, new IdentityCardNoAnalyzer());
    }

    public static Map<String, String> getResult(AnalyzerType type, String itemValue) {
        ItemAnalyzer itemAnalyzer = analyzers.get(type);
        if (itemAnalyzer == null) {
            throw new IllegalArgumentException("不支持校验");
        }
        return itemAnalyzer.getResult(itemValue);
    }

}
