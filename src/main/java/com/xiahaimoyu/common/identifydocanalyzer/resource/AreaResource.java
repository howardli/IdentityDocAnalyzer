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

    private static final Map<String, String> countryRegionOrgAlpha3 = new HashMap<>();

    static {
        loadChinaAreas();
        loadCountryRegionOrgAlpha3();
    }

    private static void loadCountryRegionOrgAlpha3() {
        try {
            BufferedReader in = new BufferedReader(
                new InputStreamReader(ClassLoader.getSystemResourceAsStream("config/ISO3166-1alpha-3.txt")));
            String str;
            while ((str = in.readLine()) != null) {
                String[] strArray = str.split(" ");
                countryRegionOrgAlpha3.put(strArray[0].trim(), strArray[1].trim());
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    private static void loadChinaAreas() {
        try {
            BufferedReader in =
                new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream("config/GBT2260.txt")));
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

    public static Map<String, String> getCountryRegionOrgAlpha3() {
        return countryRegionOrgAlpha3;
    }
}
