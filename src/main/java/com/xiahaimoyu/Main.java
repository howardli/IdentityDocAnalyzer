package com.xiahaimoyu;

import com.xiahaimoyu.common.identifydocanalyzer.AnalyzerType;
import com.xiahaimoyu.common.identifydocanalyzer.IdentifyDocItemAnalyzer;

public class Main {
    public static void main(String[] args) {
        System.out
            .println(IdentifyDocItemAnalyzer.getResult(AnalyzerType.IDENTITY_CARD_NO_ANALYZER, "11010219781027232X"));
    }
}