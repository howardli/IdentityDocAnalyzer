package com.xiahaimoyu;

import com.xiahaimoyu.common.identifydocanalyzer.AnalyzerType;
import com.xiahaimoyu.common.identifydocanalyzer.IdentifyDocItemAnalyzer;

public class Main {
    public static void main(String[] args) {
        System.out
            .println(IdentifyDocItemAnalyzer.getResult(AnalyzerType.IDENTITY_CARD_NO_ANALYZER, "11010219781027232X"));
        System.out.println(IdentifyDocItemAnalyzer
            .getResult(AnalyzerType.HK_MO_RESIDENTS_MAINLAND_TRAVEL_PERMIT_NO_ANALYZER, "M1234567802"));
        System.out.println(IdentifyDocItemAnalyzer
            .getResult(AnalyzerType.HK_MO_RESIDENTS_MAINLAND_TRAVEL_PERMIT_NO_ANALYZER, "H12345678"));
        System.out.println(IdentifyDocItemAnalyzer
            .getResult(AnalyzerType.TW_RESIDENTS_MAINLAND_TRAVEL_PERMIT_NO_ANALYZER, "1234567802"));
        System.out.println(IdentifyDocItemAnalyzer
            .getResult(AnalyzerType.TW_RESIDENTS_MAINLAND_TRAVEL_PERMIT_NO_ANALYZER, "12345678"));
    }
}