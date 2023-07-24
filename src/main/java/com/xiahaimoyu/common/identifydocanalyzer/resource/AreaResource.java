package com.xiahaimoyu.common.identifydocanalyzer.resource;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @author howard.li
 * @date 2023/7/25
 */
public class AreaResource {

    private static final Map<String, String> chinaAreas = new HashMap<>();

    static {
        loadChinaAreas();
    }

    private static void loadChinaAreas() {
        try {
            BufferedReader in = new BufferedReader(
                new InputStreamReader(ClassLoader.getSystemResourceAsStream("config/GB.T2260-2021.txt")));
            String str;
            while ((str = in.readLine()) != null) {
                String[] strArray = str.split(" ");
                chinaAreas.put(strArray[0].trim(), strArray[1].trim());
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static Map<String, String> getChinaAreas() {
        return chinaAreas;
    }
}
