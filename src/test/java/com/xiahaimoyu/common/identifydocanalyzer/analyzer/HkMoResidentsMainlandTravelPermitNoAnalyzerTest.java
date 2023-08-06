package com.xiahaimoyu.common.identifydocanalyzer.analyzer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.xiahaimoyu.common.identifydocanalyzer.info.HkMoResidentsMainlandTravelPermitNoInfo;

/**
 * @author howard.li
 * @date 2023/8/6
 */
class HkMoResidentsMainlandTravelPermitNoAnalyzerTest {

    private static HkMoResidentsMainlandTravelPermitNoAnalyzer analyzer =
        new HkMoResidentsMainlandTravelPermitNoAnalyzer();

    @Test
    void getResult() {
        HkMoResidentsMainlandTravelPermitNoInfo info =
            (HkMoResidentsMainlandTravelPermitNoInfo)analyzer.getResult("M1234567802");
        assertEquals("澳门", info.getArea());
        assertEquals(2, info.getCertificateRenewals());
        info = (HkMoResidentsMainlandTravelPermitNoInfo)analyzer.getResult("H12345678");
        assertEquals("香港", info.getArea());
        assertEquals(-1, info.getCertificateRenewals());
    }
}