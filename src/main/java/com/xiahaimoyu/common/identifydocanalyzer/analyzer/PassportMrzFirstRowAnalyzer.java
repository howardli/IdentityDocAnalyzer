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
        if (itemValue.length() != 44) {
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

    private void fillName(PassportMrzFirstRowInfo info, char[] array) {
        StringBuffer partName = new StringBuffer();
        String surname = "";
        String givenName = "";
        int endIndex = 43;
        for (int i = 43; i >= 5; i--) {
            if (array[i] != '>') {
                endIndex = i;
                break;
            }
        }
        int mid = endIndex;
        for (int i = 5; i <= endIndex; i++) {
            if (i <= endIndex - 1 && array[i] == '>' && array[i + 1] == '>') {
                if (mid != endIndex) {
                    throw new IllegalArgumentException("格式有问题");
                }
                mid = i - 1;
            }
        }
        info.setSurname(parseName(array, 5, mid));
        info.setGivenName(parseName(array, mid + 3, endIndex));
    }

    private String parseName(char[] array, int start, int end) {
        if (start > end) {
            throw new IllegalArgumentException("格式有问题");
        }
        StringBuffer partName = new StringBuffer();
        for (int i = start; i <= end; i++) {
            if (array[i] != '>') {
                partName.append(array[i]);
            } else {
                partName.append(" ");
            }
        }
        return partName.toString();
    }

    private void fillIssuingCountryRegionOrg(PassportMrzFirstRowInfo info, char[] chars) {
        String countryRegionOrg = AreaResource.getCountryRegionOrgAlpha3().get(String.valueOf(chars, 2, 3));
        if (countryRegionOrg == null) {
            throw new IllegalArgumentException("不存在");
        }
        info.setIssuingCountryRegionOrg(countryRegionOrg);
    }

}
