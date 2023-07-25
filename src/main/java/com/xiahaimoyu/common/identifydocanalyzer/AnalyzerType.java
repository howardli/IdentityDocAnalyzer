package com.xiahaimoyu.common.identifydocanalyzer;

/**
 * @author howard.li
 * @date 2023/7/25
 */
public enum AnalyzerType {

    IDENTITY_CARD_NO_ANALYZER("IDENTITY_CARD_NO_ANALYZER", "身份证号码解析器"),

    HK_MO_RESIDENTS_MAINLAND_TRAVEL_PERMIT_NO_ANALYZER("HK_MO_RESIDENTS_MAINLAND_TRAVEL_PERMIT_NO_ANALYZER",
        "港澳居民来往内地通行证号码解析器"),

    TW_RESIDENTS_MAINLAND_TRAVEL_PERMIT_NO_ANALYZER("TW_RESIDENTS_MAINLAND_TRAVEL_PERMIT_NO_ANALYZER",
        "台湾居民来往内地通行证号码解析器"),

    ;

    private String code;

    private String desc;

    private AnalyzerType(String code, String desc) {
        this.code = code;
        this.desc = code;
    }
}
