package com.xiahaimoyu.common.identifydocanalyzer.analyzer;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

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

    private static final char[] TW_CODE = {'8', '3', '0', '0', '0', '0'};

    @Override
    public AnalysisInfo getResult(String itemValue) {
        if (itemValue == null) {
            throw new IllegalArgumentException("号码为空");
        }
        int len = itemValue.length();
        if (len != 18) {
            throw new IllegalArgumentException("号码长度不对");
        }
        TwResidentsResidencePermitNoInfo info = new TwResidentsResidencePermitNoInfo();
        char[] chars = itemValue.toCharArray();
        checkArea(chars);
        fillDateOfBirth(info, String.valueOf(chars, 6, 8));
        fillGender(info, chars[16]);
        checkDigit(chars);
        return info;
    }

    private void checkDigit(char[] chars) {
        int sum = 0;
        for (int i = 0; i < 17; i++) {
            sum += (chars[i] - '0') * COEFFICIENT_ARRAY[i];
        }
        if (CHECK_CODE_DICT[sum % 11] != chars[17]) {
            throw new IllegalArgumentException("校验位不对");
        }
    }

    private void fillGender(TwResidentsResidencePermitNoInfo info, char gender) {
        if (!Character.isDigit(gender)) {
            throw new IllegalArgumentException("性别错误");
        }
        if ((gender - '0') % 2 == 0) {
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

    private void checkArea(char[] chars) {
        char[] area = new char[6];
        System.arraycopy(chars, 0, area, 0, 6);
        if (!Arrays.equals(area, TW_CODE)) {
            throw new IllegalArgumentException("地区错误");
        }
    }
}
