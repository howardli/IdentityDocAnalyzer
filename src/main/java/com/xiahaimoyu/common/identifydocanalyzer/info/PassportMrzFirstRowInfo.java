package com.xiahaimoyu.common.identifydocanalyzer.info;

/**
 * @author howard.li
 * @date 2023/7/27
 */
public class PassportMrzFirstRowInfo extends AnalysisInfo {

    private String issuingCountryRegionOrg;

    private String surname;

    private String givenName;

    public String getIssuingCountryRegionOrg() {
        return issuingCountryRegionOrg;
    }

    public void setIssuingCountryRegionOrg(String issuingCountryRegionOrg) {
        this.issuingCountryRegionOrg = issuingCountryRegionOrg;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }
}
