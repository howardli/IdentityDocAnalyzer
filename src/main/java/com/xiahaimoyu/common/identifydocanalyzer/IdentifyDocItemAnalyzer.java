package com.xiahaimoyu.common.identifydocanalyzer;

import java.util.HashMap;
import java.util.Map;

import com.xiahaimoyu.common.identifydocanalyzer.analyzer.*;
import com.xiahaimoyu.common.identifydocanalyzer.info.AnalysisInfo;

/**
 * @author howard.li
 * @date 2023/7/25
 */
public class IdentifyDocItemAnalyzer {
    private static final Map<AnalyzerType, ItemAnalyzer> analyzers = new HashMap<>();

    static {
        analyzers.put(AnalyzerType.IDENTITY_CARD_NO_ANALYZER, new IdentityCardNoAnalyzer());
        analyzers.put(AnalyzerType.HK_MO_RESIDENTS_MAINLAND_TRAVEL_PERMIT_NO_ANALYZER,
            new HkMoResidentsMainlandTravelPermitNoAnalyzer());
        analyzers.put(AnalyzerType.TW_RESIDENTS_MAINLAND_TRAVEL_PERMIT_NO_ANALYZER,
            new TwResidentsMainlandTravelPermitNoAnalyzer());
        analyzers.put(AnalyzerType.HK_MO_RESIDENTS_RESIDENCE_PERMIT_NO_ANALYZER,
            new HkMoResidentsResidencePermitNoAnalyzer());
        analyzers.put(AnalyzerType.TW_RESIDENTS_RESIDENCE_PERMIT_NO_ANALYZER,
            new TwResidentsResidencePermitNoAnalyzer());
        analyzers.put(AnalyzerType.PASSPORT_MRZ_FIRST_ROW_ANALYZER, new PassportMrzFirstRowAnalyzer());
    }

    public static AnalyzerResult getResult(AnalyzerType type, String itemValue) {
        try {
            ItemAnalyzer itemAnalyzer = analyzers.get(type);
            if (itemAnalyzer == null) {
                throw new IllegalArgumentException("不支持校验");
            }
            AnalysisInfo info = itemAnalyzer.getResult(itemValue);
            return AnalyzerResult.buildSuccess(info);
        } catch (Exception ex) {
            return AnalyzerResult.buildError(ex.getMessage());
        }
    }

}
