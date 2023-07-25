package com.xiahaimoyu.common.identifydocanalyzer;

import com.xiahaimoyu.common.identifydocanalyzer.info.AnalysisInfo;

/**
 * @author howard.li
 * @date 2023/7/25
 */
public class AnalyzerResult {

    private boolean isValid;

    private AnalysisInfo info;

    public static AnalyzerResult buildSuccess(AnalysisInfo info) {
        AnalyzerResult result = new AnalyzerResult();
        result.isValid = true;
        result.info = info;
        return result;
    }

    public boolean isValid() {
        return isValid;
    }

}
