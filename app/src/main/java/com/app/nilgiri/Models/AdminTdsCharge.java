package com.app.nilgiri.Models;

import java.util.List;

public class AdminTdsCharge {

    /**
     * data : [{"id":"526","date":"2019-05-13","company_id":"48","username":"YYCINDIA24","name":"YYC YYC","account_no":null,"ifsc_code":null,"bank":null,"power_income":"0.0000","matching_income":"0.0000","generation_income":"0.0000","magic_income":"0.0000","bonus_income":"0.0000","leadership_income":"0.0000","direct_income":"4000.0000","star_income":"0.0000","rank_income":"0.0000","amount":"4000.0000","admin_per":"5.0000","admin_charge":"200.0000","tds_per":"20.0000","tds_charge":"800.0000","repurchased_per":"5.0000","repurchased_charge":"200.0000","net_payable":"2800.0000","transaction_number":"","paid_amount":"0.0000","status":"0","created_at":"2019-05-14 02:30:22","updated_at":null}]
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
         * id : 526
         * date : 2019-05-13
         * company_id : 48
         * username : YYCINDIA24
         * name : YYC YYC
         * account_no : null
         * ifsc_code : null
         * bank : null
         * power_income : 0.0000
         * matching_income : 0.0000
         * generation_income : 0.0000
         * magic_income : 0.0000
         * bonus_income : 0.0000
         * leadership_income : 0.0000
         * direct_income : 4000.0000
         * star_income : 0.0000
         * rank_income : 0.0000
         * amount : 4000.0000
         * admin_per : 5.0000
         * admin_charge : 200.0000
         * tds_per : 20.0000
         * tds_charge : 800.0000
         * repurchased_per : 5.0000
         * repurchased_charge : 200.0000
         * net_payable : 2800.0000
         * transaction_number :
         * paid_amount : 0.0000
         * status : 0
         * created_at : 2019-05-14 02:30:22
         * updated_at : null
         */

        private String id;
        private String date;
        private String company_id;
        private String username;
        private String name;
        private Object account_no;
        private Object ifsc_code;
        private Object bank;
        private String power_income;
        private String matching_income;
        private String generation_income;
        private String magic_income;
        private String bonus_income;
        private String leadership_income;
        private String direct_income;
        private String star_income;
        private String rank_income;
        private String amount;
        private String admin_per;
        private String admin_charge;
        private String tds_per;
        private String tds_charge;
        private String repurchased_per;
        private String repurchased_charge;
        private String net_payable;
        private String transaction_number;
        private String paid_amount;
        private String status;
        private String created_at;
        private Object updated_at;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getCompany_id() {
            return company_id;
        }

        public void setCompany_id(String company_id) {
            this.company_id = company_id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Object getAccount_no() {
            return account_no;
        }

        public void setAccount_no(Object account_no) {
            this.account_no = account_no;
        }

        public Object getIfsc_code() {
            return ifsc_code;
        }

        public void setIfsc_code(Object ifsc_code) {
            this.ifsc_code = ifsc_code;
        }

        public Object getBank() {
            return bank;
        }

        public void setBank(Object bank) {
            this.bank = bank;
        }

        public String getPower_income() {
            return power_income;
        }

        public void setPower_income(String power_income) {
            this.power_income = power_income;
        }

        public String getMatching_income() {
            return matching_income;
        }

        public void setMatching_income(String matching_income) {
            this.matching_income = matching_income;
        }

        public String getGeneration_income() {
            return generation_income;
        }

        public void setGeneration_income(String generation_income) {
            this.generation_income = generation_income;
        }

        public String getMagic_income() {
            return magic_income;
        }

        public void setMagic_income(String magic_income) {
            this.magic_income = magic_income;
        }

        public String getBonus_income() {
            return bonus_income;
        }

        public void setBonus_income(String bonus_income) {
            this.bonus_income = bonus_income;
        }

        public String getLeadership_income() {
            return leadership_income;
        }

        public void setLeadership_income(String leadership_income) {
            this.leadership_income = leadership_income;
        }

        public String getDirect_income() {
            return direct_income;
        }

        public void setDirect_income(String direct_income) {
            this.direct_income = direct_income;
        }

        public String getStar_income() {
            return star_income;
        }

        public void setStar_income(String star_income) {
            this.star_income = star_income;
        }

        public String getRank_income() {
            return rank_income;
        }

        public void setRank_income(String rank_income) {
            this.rank_income = rank_income;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getAdmin_per() {
            return admin_per;
        }

        public void setAdmin_per(String admin_per) {
            this.admin_per = admin_per;
        }

        public String getAdmin_charge() {
            return admin_charge;
        }

        public void setAdmin_charge(String admin_charge) {
            this.admin_charge = admin_charge;
        }

        public String getTds_per() {
            return tds_per;
        }

        public void setTds_per(String tds_per) {
            this.tds_per = tds_per;
        }

        public String getTds_charge() {
            return tds_charge;
        }

        public void setTds_charge(String tds_charge) {
            this.tds_charge = tds_charge;
        }

        public String getRepurchased_per() {
            return repurchased_per;
        }

        public void setRepurchased_per(String repurchased_per) {
            this.repurchased_per = repurchased_per;
        }

        public String getRepurchased_charge() {
            return repurchased_charge;
        }

        public void setRepurchased_charge(String repurchased_charge) {
            this.repurchased_charge = repurchased_charge;
        }

        public String getNet_payable() {
            return net_payable;
        }

        public void setNet_payable(String net_payable) {
            this.net_payable = net_payable;
        }

        public String getTransaction_number() {
            return transaction_number;
        }

        public void setTransaction_number(String transaction_number) {
            this.transaction_number = transaction_number;
        }

        public String getPaid_amount() {
            return paid_amount;
        }

        public void setPaid_amount(String paid_amount) {
            this.paid_amount = paid_amount;
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
