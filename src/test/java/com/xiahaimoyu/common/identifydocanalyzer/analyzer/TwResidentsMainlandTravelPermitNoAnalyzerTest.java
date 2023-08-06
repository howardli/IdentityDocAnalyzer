package com.xiahaimoyu.common.identifydocanalyzer.analyzer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.xiahaimoyu.common.identifydocanalyzer.info.TwResidentsMainlandTravelPermitNoInfo;

/**
 * @author howard.li
 * @date 2023/8/7
 */
class TwResidentsMainlandTravelPermitNoAnalyzerTest {

    private static TwResidentsMainlandTravelPermitNoAnalyzer analyzer = new TwResidentsMainlandTravelPermitNoAnalyzer();

    @Test
    void getResult() {
        TwResidentsMainlandTravelPermitNoInfo info =
            (TwResidentsMainlandTravelPermitNoInfo)analyzer.getResult("1234567802");
        assertEquals(2, info.getCertificateRenewals());
        info = (TwResidentsMainlandTravelPermitNoInfo)analyzer.getResult("12345678");
        assertEquals(-1, info.getCertificateRenewals());
    }
}