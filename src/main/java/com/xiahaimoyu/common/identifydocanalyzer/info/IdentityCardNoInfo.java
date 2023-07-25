package com.xiahaimoyu.common.identifydocanalyzer.info;

/**
 * @author howard.li
 * @date 2023/7/25
 */
public class IdentityCardNoInfo extends AnalysisInfo {

    private String province;

    private String city;

    private String county;
    private String dateOfBirth;

    private String gender;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
