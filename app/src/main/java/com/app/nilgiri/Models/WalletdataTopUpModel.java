package com.app.nilgiri.Models;

import java.util.List;

public class WalletdataTopUpModel {


    /**
     * data : [{"id":"118","date":"2019-07-15","company_id":"3","payout_id":"0","debit":"0.0000","credit":"1000.0000","balance":"1000.0000","note":"owner has added fund","created_by":"1","created_at":"2019-07-15 15:29:54"},{"id":"122","date":"2019-07-16","company_id":"3","payout_id":"406752","debit":"0.0000","credit":"1312.5000","balance":"2312.5000","note":"Generate Direct Income :: Rs.1,312.50 (Rs.26,250.00 X 5%) From TEST@RAVI012","created_by":"1","created_at":"2019-07-16 13:46:00"},{"id":"1536","date":"2019-07-20","company_id":"3","payout_id":"0","debit":"0.0000","credit":"27000.0000","balance":"29312.5000","note":"owner has added fund","created_by":"1","created_at":"2019-07-20 13:30:52"},{"id":"1537","date":"2019-07-20","company_id":"3","payout_id":"447692","debit":"0.0000","credit":"625.0000","balance":"29937.5000","note":"Generate Direct Income :: Rs.625.00 (Rs.12,500.00 X 5%) From tptest2","created_by":"1","created_at":"2019-07-20 23:59:59"},{"id":"5320","date":"2019-08-02","company_id":"3","payout_id":"487470","debit":"0.0000","credit":"194.1748","balance":"30131.6748","note":null,"created_by":"1","created_at":"2019-08-02 23:59:59"},{"id":"5349","date":"2019-08-02","company_id":"3","payout_id":"487499","debit":"0.0000","credit":"1941.7476","balance":"32073.4224","note":null,"created_by":"1","created_at":"2019-08-02 23:59:59"},{"id":"11422","date":"2019-08-16","company_id":"3","payout_id":"0","debit":"120.0000","credit":"0.0000","balance":"31953.4224","note":null,"created_by":"2","created_at":"2019-08-16 17:13:15"},{"id":"11464","date":"2019-08-16","company_id":"3","payout_id":"0","debit":"110.0000","credit":"0.0000","balance":"31843.4224","note":null,"created_by":"2","created_at":"2019-08-16 18:50:54"},{"id":"11487","date":"2019-08-16","company_id":"3","payout_id":"0","debit":"110.0000","credit":"0.0000","balance":"31733.4224","note":null,"created_by":"2","created_at":"2019-08-16 21:36:35"},{"id":"12392","date":"2019-08-19","company_id":"3","payout_id":"0","debit":"150.0000","credit":"0.0000","balance":"31583.4224","note":null,"created_by":"2","created_at":"2019-08-19 14:07:05"},{"id":"12412","date":"2019-08-19","company_id":"3","payout_id":"0","debit":"150.0000","credit":"0.0000","balance":"31433.4224","note":"Transfer to Bank using Instant Payout. Net payable 135","created_by":"2","created_at":"2019-08-19 17:24:21"},{"id":"12424","date":"2019-08-19","company_id":"3","payout_id":"0","debit":"150.0000","credit":"0.0000","balance":"31283.4224","note":"Transfer to Bank Using Instant Pay 135","created_by":"2","created_at":"2019-08-19 18:24:12"},{"id":"14271","date":"2019-08-21","company_id":"3","payout_id":"0","debit":"100.0000","credit":"0.0000","balance":"31183.4224","note":"Transfer to top up wallet TEST@RAVI09","created_by":"2","created_at":"2019-08-21 15:31:39"},{"id":"14275","date":"2019-08-21","company_id":"3","payout_id":"0","debit":"1000.0000","credit":"0.0000","balance":"30183.4224","note":"Transfer to instant wallet TEST@RAVI09","created_by":"2","created_at":"2019-08-21 15:34:37"},{"id":"16590","date":"2019-08-28","company_id":"3","payout_id":"0","debit":"30183.4224","credit":"0.0000","balance":"0.0000","note":"We Have Closed Instant Wallet. We transferred your amount to Payout Wallet","created_by":"1","created_at":"2019-08-28 00:15:58"}]
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
         * id : 118
         * date : 2019-07-15
         * company_id : 3
         * payout_id : 0
         * debit : 0.0000
         * credit : 1000.0000
         * balance : 1000.0000
         * note : owner has added fund
         * created_by : 1
         * created_at : 2019-07-15 15:29:54
         */

        private String id;
        private String date;
        private String company_id;
        private String payout_id;
        private String debit;
        private String credit;
        private String balance;
        private String note;
        private String created_by;
        private String created_at;

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

        public String getPayout_id() {
            return payout_id;
        }

        public void setPayout_id(String payout_id) {
            this.payout_id = payout_id;
        }

        public String getDebit() {
            return debit;
        }

        public void setDebit(String debit) {
            this.debit = debit;
        }

        public String getCredit() {
            return credit;
        }

        public void setCredit(String credit) {
            this.credit = credit;
        }

        public String getBalance() {
            return balance;
        }

        public void setBalance(String balance) {
            this.balance = balance;
        }

        public String getNote() {
            return note;
        }

        public void setNote(String note) {
            this.note = note;
        }

        public String getCreated_by() {
            return created_by;
        }

        public void setCreated_by(String created_by) {
            this.created_by = created_by;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }
    }
}
