package com.xiahaimoyu.common.identifydocanalyzer.analyzer;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.xiahaimoyu.common.identifydocanalyzer.info.AnalysisInfo;
import com.xiahaimoyu.common.identifydocanalyzer.info.TwResidentsResidencePermitNoInfo;

/**
 * @author howard.li
 * @date 2023/7/26
 */
public class TwResidentsResidencePermitNoAnalyzer implements ItemAnalyzer {

    // 身份证每位的权重系数，共17位
    private static final int[] COEFFICIENT_ARRAY = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
    // 身份证校验码，余数与对应校验码的映射表
    private static final char[] CHECK_CODE_DICT = {'1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'};

    @Override
    public AnalysisInfo getResult(String itemValue) {
        if (itemValue == null) {
            throw new IllegalArgumentException("号码为空");
        }
        if (itemValue.length() != 18) {
            throw new IllegalArgumentException("号码长度不对");
        }
        TwResidentsResidencePermitNoInfo info = new TwResidentsResidencePermitNoInfo();
        checkArea(itemValue.substring(0, 6));
        fillDateOfBirth(info, itemValue.substring(6, 14));
        fillGender(info, itemValue.substring(16, 17));
        checkDigit(itemValue.substring(0, 17), itemValue.charAt(17));
        return info;
    }

    public void checkDigit(String no17, char no18) {
        int sum = 0;
        for (int i = 0; i < no17.length(); i++) {
            sum += (no17.charAt(i) - '0') * COEFFICIENT_ARRAY[i];
        }
        if (CHECK_CODE_DICT[sum % 11] != no18) {
            throw new IllegalArgumentException("校验位不对");
        }
    }

    private void fillGender(TwResidentsResidencePermitNoInfo info, String gender) {
        int intGender = Integer.parseInt(gender);
        if (intGender % 2 == 0) {
            info.setGender("女");
        } else {
            info.setGender("男");
        }
    }

    private void fillDateOfBirth(TwResidentsResidencePermitNoInfo info, String strDateOfBirth) {
        DateFormat df = new SimpleDateFormat("yyyyMMdd");
        df.setLenient(false);
        try {
            df.parse(strDateOfBirth);
        } catch (ParseException e) {
            throw new IllegalArgumentException("出生日期错误");
        }
        info.setDateOfBirth(strDateOfBirth);
    }

    private void checkArea(String strArea) {
        if (!strArea.equals("830000")) {
            throw new IllegalArgumentException("地区错误");
        }
    }
}
