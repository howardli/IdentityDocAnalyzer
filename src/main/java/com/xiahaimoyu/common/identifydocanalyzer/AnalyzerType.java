package com.xiahaimoyu.common.identifydocanalyzer;

/**
 * @author howard.li
 * @date 2023/7/25
 */
public enum AnalyzerType {

    IDENTITY_CARD_NO_ANALYZER("IDENTITY_CARD_NO_ANALYZER", "身份证号码解析器"),

    ;

    private String code;

    private String desc;

    private AnalyzerType(String code, String desc) {
        this.code = code;
        this.desc = code;
    }
}
