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
        if (itemValue.length() != 10 && itemValue.length() != 8) {
            throw new IllegalArgumentException("号码长度不对");
        }
        TwResidentsMainlandTravelPermitNoInfo info = new TwResidentsMainlandTravelPermitNoInfo();
        checkLifetimeNo(itemValue.substring(0, 8));
        info.setCertificateRenewals(-1);
        if (itemValue.length() == 10) {
            fillCertificateRenewals(info, itemValue.substring(8, 10));
        }
        return info;
    }

    private void fillCertificateRenewals(TwResidentsMainlandTravelPermitNoInfo info, String certificateRenewals) {
        info.setCertificateRenewals(Integer.parseInt(certificateRenewals));
    }

    private void checkLifetimeNo(String lifetimeNo) {
        for (char c : lifetimeNo.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("号码非法");
            }
        }
    }
}
