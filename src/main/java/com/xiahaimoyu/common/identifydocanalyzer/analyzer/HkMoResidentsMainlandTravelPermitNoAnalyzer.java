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
        if (itemValue.length() != 11 && itemValue.length() != 9) {
            throw new IllegalArgumentException("号码长度不对");
        }
        HkMoResidentsMainlandTravelPermitNoInfo info = new HkMoResidentsMainlandTravelPermitNoInfo();
        fillArea(info, itemValue.substring(0, 1));
        checkLifetimeNo(itemValue.substring(1, 9));
        info.setCertificateRenewals(-1);
        if (itemValue.length() == 11) {
            fillCertificateRenewals(info, itemValue.substring(9, 11));
        }
        return info;
    }

    private void fillCertificateRenewals(HkMoResidentsMainlandTravelPermitNoInfo info, String certificateRenewals) {
        info.setCertificateRenewals(Integer.parseInt(certificateRenewals));
    }

    private void checkLifetimeNo(String lifetimeNo) {
        for (char c : lifetimeNo.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("号码非法");
            }
        }
    }

    private void fillArea(HkMoResidentsMainlandTravelPermitNoInfo info, String area) {
        if (area.equals("H")) {
            info.setArea("香港");
        } else if (area.equals("M")) {
            info.setArea("澳门");
        } else {
            throw new IllegalArgumentException("证件非法");
        }
    }
}
