package com.xiahaimoyu.common.identifydocanalyzer.analyzer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.xiahaimoyu.common.identifydocanalyzer.info.TwResidentsResidencePermitNoInfo;

/**
 * @author howard.li
 * @date 2023/8/7
 */
class TwResidentsResidencePermitNoAnalyzerTest {

    private static TwResidentsResidencePermitNoAnalyzer analyzer = new TwResidentsResidencePermitNoAnalyzer();

    @Test
    void getResult() {
        TwResidentsResidencePermitNoInfo info =
            (TwResidentsResidencePermitNoInfo)analyzer.getResult("830000197810272320");
        assertEquals("19781027", info.getDateOfBirth());
        assertEquals("女", info.getGender());
    }
}