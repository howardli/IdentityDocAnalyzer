package com.xiahaimoyu.common.identifydocanalyzer;

/**
 * @author howard.li
 * @date 2023/7/25
 */
public enum AnalyzerType {

    IDENTITY_CARD_NO_ANALYZER("IDENTITY_CARD_NO_ANALYZER", "身份证号码分析器"),

    HK_MO_RESIDENTS_MAINLAND_TRAVEL_PERMIT_NO_ANALYZER("HK_MO_RESIDENTS_MAINLAND_TRAVEL_PERMIT_NO_ANALYZER",
        "港澳居民来往内地通行证号码分析器"),

    TW_RESIDENTS_MAINLAND_TRAVEL_PERMIT_NO_ANALYZER("TW_RESIDENTS_MAINLAND_TRAVEL_PERMIT_NO_ANALYZER",
        "台湾居民来往内地通行证号码分析器"),

    HK_MO_RESIDENTS_RESIDENCE_PERMIT_NO_ANALYZER("HK_MO_RESIDENTS_RESIDENCE_PERMIT_NO_ANALYZER", "港澳居民居住证号码分析器"),

    TW_RESIDENTS_RESIDENCE_PERMIT_NO_ANALYZER("TW_RESIDENTS_RESIDENCE_PERMIT_NO_ANALYZER", "台湾居民居住证号码分析器"),

    PASSPORT_MRZ_FIRST_ROW_ANALYZER("PASSPORT_MRZ_FIRST_ROW_ANALYZER", "护照MRZ第一行分析器"),;

    private String code;

    private String desc;

    private AnalyzerType(String code, String desc) {
        this.code = code;
        this.desc = code;
    }
}
