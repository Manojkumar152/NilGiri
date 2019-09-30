package com.app.nilgiri.Models;

import java.util.List;

public class Payouts {

    /**
     * data : [{"id":"341","date":"2019-01-24","payout_id":"4","income_type_id":null,"company_id":"6","amount":"1000.0000","reward":null,"type":"Matching Income","match_sale":"10000.0000","r_left_sale":"28000.0000","r_right_sale":"0.0000","note":"Matching Income :: Business Match Rs.1,000.00 = 10000 BV * 10%","created_at":"2019-02-09 14:38:08","updated_at":null},{"id":"364","date":"2019-01-24","payout_id":"4","income_type_id":null,"company_id":"6","amount":"1000.0000","reward":null,"type":"Direct Income","match_sale":"0.0000","r_left_sale":"0.0000","r_right_sale":"0.0000","note":"Generate Direct Income :: 10000 BV * 10% = Rs.1,000.00","created_at":"2019-02-09 14:38:12","updated_at":null}]
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
         * id : 341
         * date : 2019-01-24
         * payout_id : 4
         * income_type_id : null
         * company_id : 6
         * amount : 1000.0000
         * reward : null
         * type : Matching Income
         * match_sale : 10000.0000
         * r_left_sale : 28000.0000
         * r_right_sale : 0.0000
         * note : Matching Income :: Business Match Rs.1,000.00 = 10000 BV * 10%
         * created_at : 2019-02-09 14:38:08
         * updated_at : null
         */

        private String id;
        private String date;
        private String payout_id;
        private Object income_type_id;
        private String company_id;
        private String amount;
        private Object reward;
        private String type;
        private String match_sale;
        private String r_left_sale;
        private String r_right_sale;
        private String note;
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

        public String getPayout_id() {
            return payout_id;
        }

        public void setPayout_id(String payout_id) {
            this.payout_id = payout_id;
        }

        public Object getIncome_type_id() {
            return income_type_id;
        }

        public void setIncome_type_id(Object income_type_id) {
            this.income_type_id = income_type_id;
        }

        public String getCompany_id() {
            return company_id;
        }

        public void setCompany_id(String company_id) {
            this.company_id = company_id;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public Object getReward() {
            return reward;
        }

        public void setReward(Object reward) {
            this.reward = reward;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getMatch_sale() {
            return match_sale;
        }

        public void setMatch_sale(String match_sale) {
            this.match_sale = match_sale;
        }

        public String getR_left_sale() {
            return r_left_sale;
        }

        public void setR_left_sale(String r_left_sale) {
            this.r_left_sale = r_left_sale;
        }

        public String getR_right_sale() {
            return r_right_sale;
        }

        public void setR_right_sale(String r_right_sale) {
            this.r_right_sale = r_right_sale;
        }

        public String getNote() {
            return note;
        }

        public void setNote(String note) {
            this.note = note;
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
