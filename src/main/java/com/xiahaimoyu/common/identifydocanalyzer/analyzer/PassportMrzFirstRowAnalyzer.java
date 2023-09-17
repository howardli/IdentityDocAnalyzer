package com.xiahaimoyu.common.identifydocanalyzer.analyzer;

import com.xiahaimoyu.common.identifydocanalyzer.info.AnalysisInfo;
import com.xiahaimoyu.common.identifydocanalyzer.info.PassportMrzFirstRowInfo;
import com.xiahaimoyu.common.identifydocanalyzer.resource.AreaResource;

/**
 * @author howard.li
 * @date 2023/7/27
 */
public class PassportMrzFirstRowAnalyzer implements ItemAnalyzer {
    @Override
    public AnalysisInfo getResult(String itemValue) {
        if (itemValue == null) {
            throw new IllegalArgumentException("号码为空");
        }
        int len = itemValue.length();
        if (len != 44) {
            throw new IllegalArgumentException("号码长度不对");
        }
        PassportMrzFirstRowInfo info = new PassportMrzFirstRowInfo();
        char[] chars = itemValue.toCharArray();
        if (chars[0] != 'P') {
            throw new IllegalArgumentException("不是护照");
        }
        if (!Character.isAlphabetic(chars[2]) && chars[2] != 'P') {
            throw new IllegalArgumentException("不是护照");
        }
        fillIssuingCountryRegionOrg(info, chars);
        fillName(info, chars);
        return info;
    }

    private void fillName(PassportMrzFirstRowInfo info, char[] chars) {
        StringBuffer partName = new StringBuffer();
        String surname = "";
        String givenName = "";
        int endIndex = 43;
        for (int i = 43; i >= 5; i--) {
            if (chars[i] != '>') {
                endIndex = i;
                break;
            }
        }
        int mid = endIndex;
        for (int i = 5; i <= endIndex; i++) {
            if (i <= endIndex - 1 && chars[i] == '>' && chars[i + 1] == '>') {
                if (mid != endIndex) {
                    throw new IllegalArgumentException("格式有问题");
                }
                mid = i;
            }
        }
        info.setSurname(parseName(chars, 5, mid - 1));
        info.setGivenName(parseName(chars, mid + 2, endIndex));
    }

    private String parseName(char[] chars, int start, int end) {
        if (start > end) {
            return null;
        }
        StringBuffer partName = new StringBuffer();
        for (int i = start; i <= end; i++) {
            if (chars[i] != '>') {
                partName.append(chars[i]);
            } else {
                partName.append(" ");
            }
        }
        return partName.toString();
    }

    private void fillIssuingCountryRegionOrg(PassportMrzFirstRowInfo info, char[] chars) {
        String countryRegionOrg = AreaResource.getCountryRegionAlpha3().get(String.valueOf(chars, 2, 3));
        if (countryRegionOrg == null) {
            throw new IllegalArgumentException("不存在");
        }
        info.setIssuingCountryRegionOrg(countryRegionOrg);
    }

}
