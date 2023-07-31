package com.xiahaimoyu.common.identifydocanalyzer.analyzer;

import com.xiahaimoyu.common.identifydocanalyzer.info.AnalysisInfo;
import com.xiahaimoyu.common.identifydocanalyzer.info.HkMoResidentsMainlandTravelPermitNoInfo;

/**
 * @author howard.li
 * @date 2023/7/26
 */
public class HkMoResidentsMainlandTravelPermitNoAnalyzer implements ItemAnalyzer {
    @Override
    public AnalysisInfo getResult(String itemValue) {
        if (itemValue == null) {
            throw new IllegalArgumentException("号码为空");
        }
        int len = itemValue.length();
        if (len != 11 && len != 9) {
            throw new IllegalArgumentException("号码长度不对");
        }
        HkMoResidentsMainlandTravelPermitNoInfo info = new HkMoResidentsMainlandTravelPermitNoInfo();
        char[] chars = itemValue.toCharArray();
        fillArea(info, chars[0]);
        checkLifetimeNo(chars);
        info.setCertificateRenewals(-1);
        if (len == 11) {
            fillCertificateRenewals(info, chars);
        }
        return info;
    }

    private void fillCertificateRenewals(HkMoResidentsMainlandTravelPermitNoInfo info, char[] chars) {
        if (!Character.isDigit(chars[9]) || !Character.isDigit(chars[10])) {
            throw new IllegalArgumentException("换证次数错误");
        }
        info.setCertificateRenewals((chars[9] - '0') * 10 + (chars[10] - '0'));
    }

    private void checkLifetimeNo(char[] chars) {
        for (int i = 1; i < 9; i++) {
            if (!Character.isDigit(chars[i])) {
                throw new IllegalArgumentException("号码非法");
            }
        }
    }

    private void fillArea(HkMoResidentsMainlandTravelPermitNoInfo info, char area) {
        if (area == 'H') {
            info.setArea("香港");
        } else if (area == 'M') {
            info.setArea("澳门");
        } else {
            throw new IllegalArgumentException("证件非法");
        }
    }
}
