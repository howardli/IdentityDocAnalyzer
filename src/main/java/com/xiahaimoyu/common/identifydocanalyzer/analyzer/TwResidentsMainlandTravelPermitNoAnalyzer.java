package com.xiahaimoyu.common.identifydocanalyzer.analyzer;

import com.xiahaimoyu.common.identifydocanalyzer.info.AnalysisInfo;
import com.xiahaimoyu.common.identifydocanalyzer.info.TwResidentsMainlandTravelPermitNoInfo;

/**
 * @author howard.li
 * @date 2023/7/26
 */
public class TwResidentsMainlandTravelPermitNoAnalyzer implements ItemAnalyzer {
    @Override
    public AnalysisInfo getResult(String itemValue) {
        if (itemValue == null) {
            throw new IllegalArgumentException("号码为空");
        }
        int len = itemValue.length();
        if (len != 10 && len != 8) {
            throw new IllegalArgumentException("号码长度不对");
        }
        TwResidentsMainlandTravelPermitNoInfo info = new TwResidentsMainlandTravelPermitNoInfo();
        char[] chars = itemValue.toCharArray();
        checkLifetimeNo(chars);
        info.setCertificateRenewals(-1);
        if (len == 10) {
            fillCertificateRenewals(info, chars);
        }
        return info;
    }

    private void fillCertificateRenewals(TwResidentsMainlandTravelPermitNoInfo info, char[] chars) {
        if (!Character.isDigit(chars[8]) || !Character.isDigit(chars[9])) {
            throw new IllegalArgumentException("换证次数错误");
        }
        info.setCertificateRenewals((chars[8] - '0') * 10 + (chars[9] - '0'));
    }

    private void checkLifetimeNo(char[] chars) {
        for (int i = 0; i < 8; i++) {
            if (!Character.isDigit(chars[i])) {
                throw new IllegalArgumentException("号码非法");
            }
        }
    }
}
