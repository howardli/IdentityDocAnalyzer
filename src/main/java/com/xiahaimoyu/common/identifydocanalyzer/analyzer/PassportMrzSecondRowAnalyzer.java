package com.xiahaimoyu.common.identifydocanalyzer.analyzer;

import com.xiahaimoyu.common.identifydocanalyzer.info.AnalysisInfo;
import com.xiahaimoyu.common.identifydocanalyzer.info.PassportMrzSecondRowInfo;

/**
 * @author howard.li
 * @date 2023/9/18
 */
public class PassportMrzSecondRowAnalyzer implements ItemAnalyzer {
    @Override
    public AnalysisInfo getResult(String itemValue) {
        if (itemValue == null) {
            throw new IllegalArgumentException("号码为空");
        }
        int len = itemValue.length();
        if (len != 44) {
            throw new IllegalArgumentException("号码长度不对");
        }
        PassportMrzSecondRowInfo info = new PassportMrzSecondRowInfo();
        char[] chars = itemValue.toCharArray();
        fillPassportNo(info, chars);
        return info;
    }

    private void fillPassportNo(PassportMrzSecondRowInfo info, char[] chars) {
        info.setPassportNo(String.valueOf(chars, 6, 8));
    }
}
