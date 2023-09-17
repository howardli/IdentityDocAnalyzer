package com.xiahaimoyu.common.identifydocanalyzer.info;

/**
 * @author howard.li
 * @date 2023/9/18
 */
public class PassportMrzSecondRowInfo extends AnalysisInfo {

    private String passportNo;

    private String nationalityCitizenship;

    private String dateOfBirth;

    private String gender;

    private String expirationDate;

    public String getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

    public String getNationalityCitizenship() {
        return nationalityCitizenship;
    }

    public void setNationalityCitizenship(String nationalityCitizenship) {
        this.nationalityCitizenship = nationalityCitizenship;
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

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

}
