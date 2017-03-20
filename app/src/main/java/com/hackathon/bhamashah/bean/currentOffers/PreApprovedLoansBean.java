package com.hackathon.bhamashah.bean.currentOffers;

/**
 * Created by himanshukumarsingh on 20/03/17.
 */

public class PreApprovedLoansBean {
    /**
     * loanId : 1
     * startAge : 25
     * endAge : 40
     * gender : Female
     * category : Home Loan
     * subCategory :
     * forRural : 0
     * incomeType : BPL
     * loanAmount : 200000
     * startFrom : 2017-03-02
     * endAt : 2017-03-31
     */

    private String loanId;
    private String startAge;
    private String endAge;
    private String gender;
    private String category;
    private String subCategory;
    private String forRural;
    private String incomeType;
    private String loanAmount;
    private String startFrom;
    private String endAt;
    private boolean isAlreadyApplied;

    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId;
    }

    public String getStartAge() {
        return startAge;
    }

    public void setStartAge(String startAge) {
        this.startAge = startAge;
    }

    public String getEndAge() {
        return endAge;
    }

    public void setEndAge(String endAge) {
        this.endAge = endAge;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public String getForRural() {
        return forRural;
    }

    public void setForRural(String forRural) {
        this.forRural = forRural;
    }

    public String getIncomeType() {
        return incomeType;
    }

    public void setIncomeType(String incomeType) {
        this.incomeType = incomeType;
    }

    public String getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(String loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getStartFrom() {
        return startFrom;
    }

    public void setStartFrom(String startFrom) {
        this.startFrom = startFrom;
    }

    public String getEndAt() {
        return endAt;
    }

    public void setEndAt(String endAt) {
        this.endAt = endAt;
    }

    public boolean isAlreadyApplied() {
        return isAlreadyApplied;
    }

    public void setAlreadyApplied(boolean alreadyApplied) {
        isAlreadyApplied = alreadyApplied;
    }
}
