package com.xiahaimoyu.common.identifydocanalyzer.analyzer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.xiahaimoyu.common.identifydocanalyzer.info.HkMoResidentsResidencePermitNoInfo;

/**
 * @author howard.li
 * @date 2023/8/7
 */
class HkMoResidentsResidencePermitNoAnalyzerTest {

    private static HkMoResidentsResidencePermitNoAnalyzer analyzer = new HkMoResidentsResidencePermitNoAnalyzer();

    @Test
    void getResult() {
        HkMoResidentsResidencePermitNoInfo info =
            (HkMoResidentsResidencePermitNoInfo)analyzer.getResult("810000197810272327");
        assertEquals("香港", info.getArea());
        assertEquals("19781027", info.getDateOfBirth());
        assertEquals("女", info.getGender());
    }
}