package com.xiahaimoyu.common.identifydocanalyzer;

import com.xiahaimoyu.common.identifydocanalyzer.info.AnalysisInfo;

/**
 * @author howard.li
 * @date 2023/7/25
 */
public class AnalyzerResult {

    private boolean isValid;

    private AnalysisInfo info;

    private String errorCode;

    public static AnalyzerResult buildSuccess(AnalysisInfo info) {
        AnalyzerResult result = new AnalyzerResult();
        result.isValid = true;
        result.info = info;
        return result;
    }

    public static AnalyzerResult buildError(String errorCode) {
        AnalyzerResult result = new AnalyzerResult();
        result.isValid = false;
        result.errorCode = errorCode;
        return result;
    }

    public boolean isValid() {
        return isValid;
    }

    public AnalysisInfo getInfo() {
        return info;
    }

}
