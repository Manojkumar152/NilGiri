package com.app.nilgiri.Models;

public class BankDetailModel {


    /**
     * BRANCH : BASSI PATHANA
     * CENTRE : FATEHGARH SAHIB
     * DISTRICT : FATEHGARH SAHIB
     * STATE : PUNJAB
     * ADDRESS : DISTT. FATEHGARH SAHIB,PB 140471
     * CONTACT :
     * RTGS : true
     * CITY : FATEHGARH SAHEB
     * NEFT : true
     * IMPS : true
     * MICR :
     * BANK : State Bank of India
     * BANKCODE : SBIN
     * IFSC : SBIN0011898
     */

    private String BRANCH;
    private String CENTRE;
    private String DISTRICT;
    private String STATE;
    private String ADDRESS;
    private String CONTACT;
    private boolean RTGS;
    private String CITY;
    private boolean NEFT;
    private boolean IMPS;
    private String MICR;
    private String BANK;
    private String BANKCODE;
    private String IFSC;

    public String getBRANCH() {
        return BRANCH;
    }

    public void setBRANCH(String BRANCH) {
        this.BRANCH = BRANCH;
    }

    public String getCENTRE() {
        return CENTRE;
    }

    public void setCENTRE(String CENTRE) {
        this.CENTRE = CENTRE;
    }

    public String getDISTRICT() {
        return DISTRICT;
    }

    public void setDISTRICT(String DISTRICT) {
        this.DISTRICT = DISTRICT;
    }

    public String getSTATE() {
        return STATE;
    }

    public void setSTATE(String STATE) {
        this.STATE = STATE;
    }

    public String getADDRESS() {
        return ADDRESS;
    }

    public void setADDRESS(String ADDRESS) {
        this.ADDRESS = ADDRESS;
    }

    public String getCONTACT() {
        return CONTACT;
    }

    public void setCONTACT(String CONTACT) {
        this.CONTACT = CONTACT;
    }

    public boolean isRTGS() {
        return RTGS;
    }

    public void setRTGS(boolean RTGS) {
        this.RTGS = RTGS;
    }

    public String getCITY() {
        return CITY;
    }

    public void setCITY(String CITY) {
        this.CITY = CITY;
    }

    public boolean isNEFT() {
        return NEFT;
    }

    public void setNEFT(boolean NEFT) {
        this.NEFT = NEFT;
    }

    public boolean isIMPS() {
        return IMPS;
    }

    public void setIMPS(boolean IMPS) {
        this.IMPS = IMPS;
    }

    public String getMICR() {
        return MICR;
    }

    public void setMICR(String MICR) {
        this.MICR = MICR;
    }

    public String getBANK() {
        return BANK;
    }

    public void setBANK(String BANK) {
        this.BANK = BANK;
    }

    public String getBANKCODE() {
        return BANKCODE;
    }

    public void setBANKCODE(String BANKCODE) {
        this.BANKCODE = BANKCODE;
    }

    public String getIFSC() {
        return IFSC;
    }

    public void setIFSC(String IFSC) {
        this.IFSC = IFSC;
    }
}
