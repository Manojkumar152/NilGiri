package com.app.nilgiri.Models;

import java.util.List;

public class BankDetailData {

    /**
     * data : [{"id":"269","client_id":"3","username":"TPID","account_holder_name":"ritusingh","account_number":"031001535141","ifsc_code":"SBIN0011897","bank":"State Bank of India","branch":"TALWANDI SABO","bankcode":"SBIN","address":"DISTBHATINDA151302","city":"BHATINDA","state":"PUNJAB","status":"0","created_at":"0000-00-00 00:00:00","updated_at":null},{"id":"2783","client_id":"3","username":null,"account_holder_name":null,"account_number":null,"ifsc_code":null,"bank":null,"branch":null,"bankcode":null,"address":"varanasi","city":"5211","state":"38","status":"0","created_at":"2019-09-11 17:34:25","updated_at":null}]
     * message : Successfully
     * status : 1
     */

    private String message;
    private int status;
    private List<DataBean> data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 269
         * client_id : 3
         * username : TPID
         * account_holder_name : ritusingh
         * account_number : 031001535141
         * ifsc_code : SBIN0011897
         * bank : State Bank of India
         * branch : TALWANDI SABO
         * bankcode : SBIN
         * address : DISTBHATINDA151302
         * city : BHATINDA
         * state : PUNJAB
         * status : 0
         * created_at : 0000-00-00 00:00:00
         * updated_at : null
         */

        private String id;
        private String client_id;
        private String username;
        private String account_holder_name;
        private String account_number;
        private String ifsc_code;
        private String bank;
        private String branch;
        private String bankcode;
        private String address;
        private String city;
        private String state;
        private String status;
        private String created_at;
        private Object updated_at;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getClient_id() {
            return client_id;
        }

        public void setClient_id(String client_id) {
            this.client_id = client_id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getAccount_holder_name() {
            return account_holder_name;
        }

        public void setAccount_holder_name(String account_holder_name) {
            this.account_holder_name = account_holder_name;
        }

        public String getAccount_number() {
            return account_number;
        }

        public void setAccount_number(String account_number) {
            this.account_number = account_number;
        }

        public String getIfsc_code() {
            return ifsc_code;
        }

        public void setIfsc_code(String ifsc_code) {
            this.ifsc_code = ifsc_code;
        }

        public String getBank() {
            return bank;
        }

        public void setBank(String bank) {
            this.bank = bank;
        }

        public String getBranch() {
            return branch;
        }

        public void setBranch(String branch) {
            this.branch = branch;
        }

        public String getBankcode() {
            return bankcode;
        }

        public void setBankcode(String bankcode) {
            this.bankcode = bankcode;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public Object getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(Object updated_at) {
            this.updated_at = updated_at;
        }
    }
}
