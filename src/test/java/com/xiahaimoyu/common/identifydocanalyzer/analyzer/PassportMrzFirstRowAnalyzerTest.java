package com.xiahaimoyu.common.identifydocanalyzer.analyzer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.xiahaimoyu.common.identifydocanalyzer.info.PassportMrzFirstRowInfo;

/**
 * @author howard.li
 * @date 2023/8/7
 */
class PassportMrzFirstRowAnalyzerTest {

    private static PassportMrzFirstRowAnalyzer analyzer = new PassportMrzFirstRowAnalyzer();

    @Test
    void getResult() {
        PassportMrzFirstRowInfo info =
            (PassportMrzFirstRowInfo)analyzer.getResult("P>CHNLI>>HOWARD>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        assertEquals("中国", info.getIssuingCountryRegionOrg());
        assertEquals("LI", info.getSurname());
        assertEquals("HOWARD", info.getGivenName());
    }
}