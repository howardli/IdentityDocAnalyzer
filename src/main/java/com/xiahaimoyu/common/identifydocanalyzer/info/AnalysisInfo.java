package com.xiahaimoyu.common.identifydocanalyzer.info;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @author howard.li
 * @date 2023/7/25
 */
public abstract class AnalysisInfo {

    @Override
    public String toString() {
        return String.valueOf(toMap());
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        for (Field field : this.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                map.put(field.getName(), field.get(this));
            } catch (Exception ex) {

            }
        }
        return map;
    }
}
