package com.xiahaimoyu.common.identifydocanalyzer.analyzer;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.xiahaimoyu.common.identifydocanalyzer.info.AnalysisInfo;
import com.xiahaimoyu.common.identifydocanalyzer.info.IdentityCardNoInfo;
import com.xiahaimoyu.common.identifydocanalyzer.resource.AreaResource;

/**
 * @author howard.li
 * @date 2023/7/25
 */
public class IdentityCardNoAnalyzer implements ItemAnalyzer {

    // 身份证每位的权重系数，共17位
    private static final int[] COEFFICIENT_ARRAY = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
    // 身份证校验码，余数与对应校验码的映射表
    private static final char[] CHECK_CODE_DICT = {'1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'};

    @Override
    public AnalysisInfo getResult(String itemValue) {
        if (itemValue == null) {
            throw new IllegalArgumentException("号码为空");
        }
        if (itemValue.length() != 18 && itemValue.length() != 15) {
            throw new IllegalArgumentException("号码长度不对");
        }
        IdentityCardNoInfo info = new IdentityCardNoInfo();
        fillArea(info, itemValue.substring(0, 6));
        if (itemValue.length() == 18) {
            fillDateOfBirth(info, itemValue.substring(6, 14));
            fillGender(info, itemValue.substring(16, 17));
            if (getCheckCode(itemValue.substring(0, 17)) != itemValue.charAt(17)) {
                throw new IllegalArgumentException("校验位不对");
            }
        } else if (itemValue.length() == 15) {
            fillDateOfBirth(info, "19" + itemValue.substring(6, 12));
            fillGender(info, itemValue.substring(14, 15));
        }
        return info;
    }

    public static char getCheckCode(String id17) {
        int sum = 0;
        for (int i = 0; i < id17.length(); i++) {
            sum += (id17.charAt(i) - '0') * COEFFICIENT_ARRAY[i];
        }
        return CHECK_CODE_DICT[sum % 11];
    }

    private void fillGender(IdentityCardNoInfo info, String gender) {
        int intGender = Integer.valueOf(gender);
        if (intGender % 2 == 0) {
            info.setGender("女");
        } else {
            info.setGender("男");
        }
    }

    private void fillDateOfBirth(IdentityCardNoInfo info, String strDateOfBirth) {
        DateFormat df = new SimpleDateFormat("yyyyMMdd");
        df.setLenient(false);
        try {
            Date date = df.parse(strDateOfBirth);
        } catch (ParseException e) {
            throw new IllegalArgumentException("出生日期错误");
        }
        info.setDateOfBirth(strDateOfBirth);
    }

    private void fillArea(IdentityCardNoInfo info, String strArea) {
        if (strArea.equals("710000") || strArea.equals("810000") || strArea.equals("820000")) {
            throw new IllegalArgumentException("不支持港澳台");
        }
        Map<String, String> areas = AreaResource.getChinaAreas();
        String county = areas.get(strArea);
        if (county == null) {
            throw new IllegalArgumentException("地区错误");
        }
        info.setCounty(county);
        String strCity = strArea.substring(0, 4) + "00";
        String city = areas.get(strCity);
        if (city == null) {
            city = "";
        }
        info.setCity(city);
        String strProvince = strArea.substring(0, 2) + "0000";
        String province = areas.get(strProvince);
        if (province == null) {
            province = "";
        }
        info.setProvince(province);
    }
}
