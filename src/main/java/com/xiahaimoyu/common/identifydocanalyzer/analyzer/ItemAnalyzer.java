package com.xiahaimoyu.common.identifydocanalyzer.analyzer;

import com.xiahaimoyu.common.identifydocanalyzer.info.AnalysisInfo;

/**
 * @author howard.li
 * @date 2023/7/25
 */
public interface ItemAnalyzer {

    public AnalysisInfo getResult(String itemValue);
}
