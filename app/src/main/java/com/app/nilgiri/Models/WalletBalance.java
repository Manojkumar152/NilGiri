package com.app.nilgiri.Models;

public class WalletBalance {

    /**
     * data : {"debit_total":"41975.0000","credit_total":"42000.0000","balance_total":"264162.5000"}
     * message : Successfully
     * status : 1
     */

    private DataBean data;
    private String message;
    private int status;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

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

    public static class DataBean {
        /**
         * debit_total : 41975.0000
         * credit_total : 42000.0000
         * balance_total : 264162.5000
         */

        private String debit_total;
        private String credit_total;
        private String balance_total;

        public String getDebit_total() {
            return debit_total;
        }

        public void setDebit_total(String debit_total) {
            this.debit_total = debit_total;
        }

        public String getCredit_total() {
            return credit_total;
        }

        public void setCredit_total(String credit_total) {
            this.credit_total = credit_total;
        }

        public String getBalance_total() {
            return balance_total;
        }

        public void setBalance_total(String balance_total) {
            this.balance_total = balance_total;
        }
    }
}
