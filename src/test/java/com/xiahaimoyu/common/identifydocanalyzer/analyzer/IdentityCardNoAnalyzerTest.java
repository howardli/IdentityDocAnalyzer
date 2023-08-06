package com.xiahaimoyu.common.identifydocanalyzer.analyzer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import com.xiahaimoyu.common.identifydocanalyzer.info.IdentityCardNoInfo;

/**
 * @author howard.li
 * @date 2023/8/6
 */
class IdentityCardNoAnalyzerTest {

    private static final IdentityCardNoAnalyzer analyzer = new IdentityCardNoAnalyzer();

    @Test
    void getResult() {
        IdentityCardNoInfo info = (IdentityCardNoInfo)analyzer.getResult("11010219781027232X");
        assertEquals("北京市", info.getProvince());
        assertNull(info.getCity());
        assertEquals("西城区", info.getCounty());
        assertEquals("19781027", info.getDateOfBirth());
        assertEquals("女", info.getGender());
    }
}