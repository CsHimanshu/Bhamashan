package com.hackathon.bhamashah.bean;

import com.hackathon.bhamashah.bean.Login.FamilyDetailsBean;
import com.hackathon.bhamashah.bean.Login.HofDetailsBean;

import java.util.List;

/**
 * Created by himanshukumarsingh on 20/03/17.
 */

public class LoginAPIResponse {

    /**
     * statusCode : 200
     * statusMessage : Done
     * data : {"profileData":{"hof_Details":{"CATEGORY_DESC_ENG":"SC","AADHAR_ID":"780623649996","STATE":"Rajasthan","MOTHER_NAME_ENG":"hurami ","HOUSE_NUMBER_ENG":null,"RELATION_ENG":"Self","DOB":"01/01/1982","ECONOMIC_GROUP":"APL","BUILDING_NO_ENG":null,"BHAMASHAH_ID":"1428-WKMY-25373","STREET_NAME_ENG":null,"IFSC_CODE":"UCBA0003061","M_ID":"0","FAMILYIDNO":"WDYYYGG","PIN_CODE":"342021","LANDLINE_NO":null,"VILLAGE_NAME":"KALAU","GP_WARD":"KALAU","EMAIL":null,"SPOUCE_NAME_ENG":"kishana ram ","IS_RURAL":"Rural","DISTRICT":"Jodhpur","EDUCATION_DESC_ENG":"Literate","ACC_NO":"30610110005033","ADDRESS":"Nayasra, KALAU, Dechu, Jodhpur","INCOME_DESC_ENG":null,"BANK_NAME":"UCO BANK","LAND_MARK_ENG":null,"RATION_CARD_NO":"008503900036","NAME_ENG":"Seeta","MOBILE_NO":"9549783966","GENDER":"Female","FATHER_NAME_ENG":"SUGANA ram ","FAX_NO":null,"BLOCK_CITY":"Dechu"},"family_Details":[{"CATEGORY_DESC_ENG":"SC","STATE":"Rajasthan","MOTHER_NAME_ENG":"Seeta","HOUSE_NUMBER_ENG":null,"RELATION_ENG":"Daughter","DOB":"27/12/2000","MEMBER_AADHAR_ID":null,"ECONOMIC_GROUP":"APL","BUILDING_NO_ENG":null,"BHAMASHAH_ID":"1428-WKMY-25373","STREET_NAME_ENG":null,"IFSC_CODE":null,"M_ID":"2676697","FAMILYIDNO":"WDYYYGG","PIN_CODE":"342021","LANDLINE_NO":null,"VILLAGE_NAME":"KALAU","GP_WARD":"KALAU","EMAIL":null,"SPOUCE_NAME_ENG":null,"IS_RURAL":"Rural","DISTRICT":"Jodhpur","EDUCATION_DESC_ENG":"10 Pass","ACC_NO":null,"ADDRESS":"Nayasra, KALAU, Dechu, Jodhpur","INCOME_DESC_ENG":null,"BANK_NAME":null,"LAND_MARK_ENG":null,"RATION_CARD_NO":"008503900036","NAME_ENG":"neelam ","MOBILE":null,"GENDER":"Female","FATHER_NAME_ENG":"kishana ram ","FAX_NO":null,"BLOCK_CITY":"Dechu"},{"CATEGORY_DESC_ENG":"SC","STATE":"Rajasthan","MOTHER_NAME_ENG":"sita","HOUSE_NUMBER_ENG":null,"RELATION_ENG":"Son","DOB":"13/11/2006","MEMBER_AADHAR_ID":null,"ECONOMIC_GROUP":"APL","BUILDING_NO_ENG":null,"BHAMASHAH_ID":"1428-WKMY-25373","STREET_NAME_ENG":null,"IFSC_CODE":null,"M_ID":"2676699","FAMILYIDNO":"WDYYYGG","PIN_CODE":"342021","LANDLINE_NO":null,"VILLAGE_NAME":"KALAU","GP_WARD":"KALAU","EMAIL":null,"SPOUCE_NAME_ENG":null,"IS_RURAL":"Rural","DISTRICT":"Jodhpur","EDUCATION_DESC_ENG":"5 Pass","ACC_NO":null,"ADDRESS":"Nayasra, KALAU, Dechu, Jodhpur","INCOME_DESC_ENG":null,"BANK_NAME":null,"LAND_MARK_ENG":null,"RATION_CARD_NO":"008503900036","NAME_ENG":"punam","MOBILE":null,"GENDER":"Male","FATHER_NAME_ENG":"kishana ram ","FAX_NO":null,"BLOCK_CITY":"Dechu"},{"CATEGORY_DESC_ENG":"SC","STATE":"Rajasthan","MOTHER_NAME_ENG":"khetu devi ","HOUSE_NUMBER_ENG":null,"RELATION_ENG":"Husband","DOB":"01/08/1974","MEMBER_AADHAR_ID":"530541094061","ECONOMIC_GROUP":"APL","BUILDING_NO_ENG":null,"BHAMASHAH_ID":"1428-WKMY-25373","STREET_NAME_ENG":null,"IFSC_CODE":null,"M_ID":"2676696","FAMILYIDNO":"WDYYYGG","PIN_CODE":"342021","LANDLINE_NO":null,"VILLAGE_NAME":"KALAU","GP_WARD":"KALAU","EMAIL":null,"SPOUCE_NAME_ENG":"Seeta","IS_RURAL":"Rural","DISTRICT":"Jodhpur","EDUCATION_DESC_ENG":"Graduate","ACC_NO":null,"ADDRESS":"Nayasra, KALAU, Dechu, Jodhpur","INCOME_DESC_ENG":null,"BANK_NAME":null,"LAND_MARK_ENG":null,"RATION_CARD_NO":"008503900036","NAME_ENG":"kishana ram ","MOBILE":null,"GENDER":"Male","FATHER_NAME_ENG":"hamira ram ","FAX_NO":null,"BLOCK_CITY":"Dechu"},{"CATEGORY_DESC_ENG":"SC","STATE":"Rajasthan","MOTHER_NAME_ENG":"SEETA ","HOUSE_NUMBER_ENG":null,"RELATION_ENG":"Son","DOB":"08/10/2002","MEMBER_AADHAR_ID":null,"ECONOMIC_GROUP":"APL","BUILDING_NO_ENG":null,"BHAMASHAH_ID":"1428-WKMY-25373","STREET_NAME_ENG":null,"IFSC_CODE":null,"M_ID":"2676698","FAMILYIDNO":"WDYYYGG","PIN_CODE":"342021","LANDLINE_NO":null,"VILLAGE_NAME":"KALAU","GP_WARD":"KALAU","EMAIL":null,"SPOUCE_NAME_ENG":null,"IS_RURAL":"Rural","DISTRICT":"Jodhpur","EDUCATION_DESC_ENG":"5 Pass","ACC_NO":null,"ADDRESS":"Nayasra, KALAU, Dechu, Jodhpur","INCOME_DESC_ENG":null,"BANK_NAME":null,"LAND_MARK_ENG":null,"RATION_CARD_NO":"008503900036","NAME_ENG":"pravin","MOBILE":null,"GENDER":"Male","FATHER_NAME_ENG":"kishana ram ","FAX_NO":null,"BLOCK_CITY":"Dechu"}]},"details":{"mobileNumber":"9549783966","otp":74097,"bhamashahId":"1428-WKMY-25373","email":null}}
     */

    private int statusCode;
    private String statusMessage;
    private DataBean data;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * profileData : {"hof_Details":{"CATEGORY_DESC_ENG":"SC","AADHAR_ID":"780623649996","STATE":"Rajasthan","MOTHER_NAME_ENG":"hurami ","HOUSE_NUMBER_ENG":null,"RELATION_ENG":"Self","DOB":"01/01/1982","ECONOMIC_GROUP":"APL","BUILDING_NO_ENG":null,"BHAMASHAH_ID":"1428-WKMY-25373","STREET_NAME_ENG":null,"IFSC_CODE":"UCBA0003061","M_ID":"0","FAMILYIDNO":"WDYYYGG","PIN_CODE":"342021","LANDLINE_NO":null,"VILLAGE_NAME":"KALAU","GP_WARD":"KALAU","EMAIL":null,"SPOUCE_NAME_ENG":"kishana ram ","IS_RURAL":"Rural","DISTRICT":"Jodhpur","EDUCATION_DESC_ENG":"Literate","ACC_NO":"30610110005033","ADDRESS":"Nayasra, KALAU, Dechu, Jodhpur","INCOME_DESC_ENG":null,"BANK_NAME":"UCO BANK","LAND_MARK_ENG":null,"RATION_CARD_NO":"008503900036","NAME_ENG":"Seeta","MOBILE_NO":"9549783966","GENDER":"Female","FATHER_NAME_ENG":"SUGANA ram ","FAX_NO":null,"BLOCK_CITY":"Dechu"},"family_Details":[{"CATEGORY_DESC_ENG":"SC","STATE":"Rajasthan","MOTHER_NAME_ENG":"Seeta","HOUSE_NUMBER_ENG":null,"RELATION_ENG":"Daughter","DOB":"27/12/2000","MEMBER_AADHAR_ID":null,"ECONOMIC_GROUP":"APL","BUILDING_NO_ENG":null,"BHAMASHAH_ID":"1428-WKMY-25373","STREET_NAME_ENG":null,"IFSC_CODE":null,"M_ID":"2676697","FAMILYIDNO":"WDYYYGG","PIN_CODE":"342021","LANDLINE_NO":null,"VILLAGE_NAME":"KALAU","GP_WARD":"KALAU","EMAIL":null,"SPOUCE_NAME_ENG":null,"IS_RURAL":"Rural","DISTRICT":"Jodhpur","EDUCATION_DESC_ENG":"10 Pass","ACC_NO":null,"ADDRESS":"Nayasra, KALAU, Dechu, Jodhpur","INCOME_DESC_ENG":null,"BANK_NAME":null,"LAND_MARK_ENG":null,"RATION_CARD_NO":"008503900036","NAME_ENG":"neelam ","MOBILE":null,"GENDER":"Female","FATHER_NAME_ENG":"kishana ram ","FAX_NO":null,"BLOCK_CITY":"Dechu"},{"CATEGORY_DESC_ENG":"SC","STATE":"Rajasthan","MOTHER_NAME_ENG":"sita","HOUSE_NUMBER_ENG":null,"RELATION_ENG":"Son","DOB":"13/11/2006","MEMBER_AADHAR_ID":null,"ECONOMIC_GROUP":"APL","BUILDING_NO_ENG":null,"BHAMASHAH_ID":"1428-WKMY-25373","STREET_NAME_ENG":null,"IFSC_CODE":null,"M_ID":"2676699","FAMILYIDNO":"WDYYYGG","PIN_CODE":"342021","LANDLINE_NO":null,"VILLAGE_NAME":"KALAU","GP_WARD":"KALAU","EMAIL":null,"SPOUCE_NAME_ENG":null,"IS_RURAL":"Rural","DISTRICT":"Jodhpur","EDUCATION_DESC_ENG":"5 Pass","ACC_NO":null,"ADDRESS":"Nayasra, KALAU, Dechu, Jodhpur","INCOME_DESC_ENG":null,"BANK_NAME":null,"LAND_MARK_ENG":null,"RATION_CARD_NO":"008503900036","NAME_ENG":"punam","MOBILE":null,"GENDER":"Male","FATHER_NAME_ENG":"kishana ram ","FAX_NO":null,"BLOCK_CITY":"Dechu"},{"CATEGORY_DESC_ENG":"SC","STATE":"Rajasthan","MOTHER_NAME_ENG":"khetu devi ","HOUSE_NUMBER_ENG":null,"RELATION_ENG":"Husband","DOB":"01/08/1974","MEMBER_AADHAR_ID":"530541094061","ECONOMIC_GROUP":"APL","BUILDING_NO_ENG":null,"BHAMASHAH_ID":"1428-WKMY-25373","STREET_NAME_ENG":null,"IFSC_CODE":null,"M_ID":"2676696","FAMILYIDNO":"WDYYYGG","PIN_CODE":"342021","LANDLINE_NO":null,"VILLAGE_NAME":"KALAU","GP_WARD":"KALAU","EMAIL":null,"SPOUCE_NAME_ENG":"Seeta","IS_RURAL":"Rural","DISTRICT":"Jodhpur","EDUCATION_DESC_ENG":"Graduate","ACC_NO":null,"ADDRESS":"Nayasra, KALAU, Dechu, Jodhpur","INCOME_DESC_ENG":null,"BANK_NAME":null,"LAND_MARK_ENG":null,"RATION_CARD_NO":"008503900036","NAME_ENG":"kishana ram ","MOBILE":null,"GENDER":"Male","FATHER_NAME_ENG":"hamira ram ","FAX_NO":null,"BLOCK_CITY":"Dechu"},{"CATEGORY_DESC_ENG":"SC","STATE":"Rajasthan","MOTHER_NAME_ENG":"SEETA ","HOUSE_NUMBER_ENG":null,"RELATION_ENG":"Son","DOB":"08/10/2002","MEMBER_AADHAR_ID":null,"ECONOMIC_GROUP":"APL","BUILDING_NO_ENG":null,"BHAMASHAH_ID":"1428-WKMY-25373","STREET_NAME_ENG":null,"IFSC_CODE":null,"M_ID":"2676698","FAMILYIDNO":"WDYYYGG","PIN_CODE":"342021","LANDLINE_NO":null,"VILLAGE_NAME":"KALAU","GP_WARD":"KALAU","EMAIL":null,"SPOUCE_NAME_ENG":null,"IS_RURAL":"Rural","DISTRICT":"Jodhpur","EDUCATION_DESC_ENG":"5 Pass","ACC_NO":null,"ADDRESS":"Nayasra, KALAU, Dechu, Jodhpur","INCOME_DESC_ENG":null,"BANK_NAME":null,"LAND_MARK_ENG":null,"RATION_CARD_NO":"008503900036","NAME_ENG":"pravin","MOBILE":null,"GENDER":"Male","FATHER_NAME_ENG":"kishana ram ","FAX_NO":null,"BLOCK_CITY":"Dechu"}]}
         * details : {"mobileNumber":"9549783966","otp":74097,"bhamashahId":"1428-WKMY-25373","email":null}
         */

        private ProfileDataBean profileData;
        private ProfileDataBean.DetailsBean details;

        public ProfileDataBean getProfileData() {
            return profileData;
        }

        public void setProfileData(ProfileDataBean profileData) {
            this.profileData = profileData;
        }

        public ProfileDataBean.DetailsBean getDetails() {
            return details;
        }

        public void setDetails(ProfileDataBean.DetailsBean details) {
            this.details = details;
        }

        public static class ProfileDataBean {
            /**
             * hof_Details : {"CATEGORY_DESC_ENG":"SC","AADHAR_ID":"780623649996","STATE":"Rajasthan","MOTHER_NAME_ENG":"hurami ","HOUSE_NUMBER_ENG":null,"RELATION_ENG":"Self","DOB":"01/01/1982","ECONOMIC_GROUP":"APL","BUILDING_NO_ENG":null,"BHAMASHAH_ID":"1428-WKMY-25373","STREET_NAME_ENG":null,"IFSC_CODE":"UCBA0003061","M_ID":"0","FAMILYIDNO":"WDYYYGG","PIN_CODE":"342021","LANDLINE_NO":null,"VILLAGE_NAME":"KALAU","GP_WARD":"KALAU","EMAIL":null,"SPOUCE_NAME_ENG":"kishana ram ","IS_RURAL":"Rural","DISTRICT":"Jodhpur","EDUCATION_DESC_ENG":"Literate","ACC_NO":"30610110005033","ADDRESS":"Nayasra, KALAU, Dechu, Jodhpur","INCOME_DESC_ENG":null,"BANK_NAME":"UCO BANK","LAND_MARK_ENG":null,"RATION_CARD_NO":"008503900036","NAME_ENG":"Seeta","MOBILE_NO":"9549783966","GENDER":"Female","FATHER_NAME_ENG":"SUGANA ram ","FAX_NO":null,"BLOCK_CITY":"Dechu"}
             * family_Details : [{"CATEGORY_DESC_ENG":"SC","STATE":"Rajasthan","MOTHER_NAME_ENG":"Seeta","HOUSE_NUMBER_ENG":null,"RELATION_ENG":"Daughter","DOB":"27/12/2000","MEMBER_AADHAR_ID":null,"ECONOMIC_GROUP":"APL","BUILDING_NO_ENG":null,"BHAMASHAH_ID":"1428-WKMY-25373","STREET_NAME_ENG":null,"IFSC_CODE":null,"M_ID":"2676697","FAMILYIDNO":"WDYYYGG","PIN_CODE":"342021","LANDLINE_NO":null,"VILLAGE_NAME":"KALAU","GP_WARD":"KALAU","EMAIL":null,"SPOUCE_NAME_ENG":null,"IS_RURAL":"Rural","DISTRICT":"Jodhpur","EDUCATION_DESC_ENG":"10 Pass","ACC_NO":null,"ADDRESS":"Nayasra, KALAU, Dechu, Jodhpur","INCOME_DESC_ENG":null,"BANK_NAME":null,"LAND_MARK_ENG":null,"RATION_CARD_NO":"008503900036","NAME_ENG":"neelam ","MOBILE":null,"GENDER":"Female","FATHER_NAME_ENG":"kishana ram ","FAX_NO":null,"BLOCK_CITY":"Dechu"},{"CATEGORY_DESC_ENG":"SC","STATE":"Rajasthan","MOTHER_NAME_ENG":"sita","HOUSE_NUMBER_ENG":null,"RELATION_ENG":"Son","DOB":"13/11/2006","MEMBER_AADHAR_ID":null,"ECONOMIC_GROUP":"APL","BUILDING_NO_ENG":null,"BHAMASHAH_ID":"1428-WKMY-25373","STREET_NAME_ENG":null,"IFSC_CODE":null,"M_ID":"2676699","FAMILYIDNO":"WDYYYGG","PIN_CODE":"342021","LANDLINE_NO":null,"VILLAGE_NAME":"KALAU","GP_WARD":"KALAU","EMAIL":null,"SPOUCE_NAME_ENG":null,"IS_RURAL":"Rural","DISTRICT":"Jodhpur","EDUCATION_DESC_ENG":"5 Pass","ACC_NO":null,"ADDRESS":"Nayasra, KALAU, Dechu, Jodhpur","INCOME_DESC_ENG":null,"BANK_NAME":null,"LAND_MARK_ENG":null,"RATION_CARD_NO":"008503900036","NAME_ENG":"punam","MOBILE":null,"GENDER":"Male","FATHER_NAME_ENG":"kishana ram ","FAX_NO":null,"BLOCK_CITY":"Dechu"},{"CATEGORY_DESC_ENG":"SC","STATE":"Rajasthan","MOTHER_NAME_ENG":"khetu devi ","HOUSE_NUMBER_ENG":null,"RELATION_ENG":"Husband","DOB":"01/08/1974","MEMBER_AADHAR_ID":"530541094061","ECONOMIC_GROUP":"APL","BUILDING_NO_ENG":null,"BHAMASHAH_ID":"1428-WKMY-25373","STREET_NAME_ENG":null,"IFSC_CODE":null,"M_ID":"2676696","FAMILYIDNO":"WDYYYGG","PIN_CODE":"342021","LANDLINE_NO":null,"VILLAGE_NAME":"KALAU","GP_WARD":"KALAU","EMAIL":null,"SPOUCE_NAME_ENG":"Seeta","IS_RURAL":"Rural","DISTRICT":"Jodhpur","EDUCATION_DESC_ENG":"Graduate","ACC_NO":null,"ADDRESS":"Nayasra, KALAU, Dechu, Jodhpur","INCOME_DESC_ENG":null,"BANK_NAME":null,"LAND_MARK_ENG":null,"RATION_CARD_NO":"008503900036","NAME_ENG":"kishana ram ","MOBILE":null,"GENDER":"Male","FATHER_NAME_ENG":"hamira ram ","FAX_NO":null,"BLOCK_CITY":"Dechu"},{"CATEGORY_DESC_ENG":"SC","STATE":"Rajasthan","MOTHER_NAME_ENG":"SEETA ","HOUSE_NUMBER_ENG":null,"RELATION_ENG":"Son","DOB":"08/10/2002","MEMBER_AADHAR_ID":null,"ECONOMIC_GROUP":"APL","BUILDING_NO_ENG":null,"BHAMASHAH_ID":"1428-WKMY-25373","STREET_NAME_ENG":null,"IFSC_CODE":null,"M_ID":"2676698","FAMILYIDNO":"WDYYYGG","PIN_CODE":"342021","LANDLINE_NO":null,"VILLAGE_NAME":"KALAU","GP_WARD":"KALAU","EMAIL":null,"SPOUCE_NAME_ENG":null,"IS_RURAL":"Rural","DISTRICT":"Jodhpur","EDUCATION_DESC_ENG":"5 Pass","ACC_NO":null,"ADDRESS":"Nayasra, KALAU, Dechu, Jodhpur","INCOME_DESC_ENG":null,"BANK_NAME":null,"LAND_MARK_ENG":null,"RATION_CARD_NO":"008503900036","NAME_ENG":"pravin","MOBILE":null,"GENDER":"Male","FATHER_NAME_ENG":"kishana ram ","FAX_NO":null,"BLOCK_CITY":"Dechu"}]
             */

            private HofDetailsBean hof_Details;
            private List<FamilyDetailsBean> family_Details;

            public HofDetailsBean getHof_Details() {
                return hof_Details;
            }

            public void setHof_Details(HofDetailsBean hof_Details) {
                this.hof_Details = hof_Details;
            }

            public List<FamilyDetailsBean> getFamily_Details() {
                return family_Details;
            }

            public void setFamily_Details(List<FamilyDetailsBean> family_Details) {
                this.family_Details = family_Details;
            }

            public static class DetailsBean {
                /**
                 * mobileNumber : 9549783966
                 * otp : 74097
                 * bhamashahId : 1428-WKMY-25373
                 * email : null
                 */

                private String mobileNumber;
                private int otp;
                private String bhamashahId;
                private Object email;

                public String getMobileNumber() {
                    return mobileNumber;
                }

                public void setMobileNumber(String mobileNumber) {
                    this.mobileNumber = mobileNumber;
                }

                public int getOtp() {
                    return otp;
                }

                public void setOtp(int otp) {
                    this.otp = otp;
                }

                public String getBhamashahId() {
                    return bhamashahId;
                }

                public void setBhamashahId(String bhamashahId) {
                    this.bhamashahId = bhamashahId;
                }

                public Object getEmail() {
                    return email;
                }

                public void setEmail(Object email) {
                    this.email = email;
                }
            }
        }
    }
}