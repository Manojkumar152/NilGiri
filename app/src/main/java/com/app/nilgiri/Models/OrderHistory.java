package com.app.nilgiri.Models;

import java.util.List;

public class OrderHistory {
    /**
     * data : {"orderhistory":[{"id":"3","date":"2019-01-24 12:35:00","reference_no":"INV0003","customer_id":"4","customer_username":"0001","customer":"1 1","biller_id":"1","biller":"Yes You Can","warehouse_id":"1","note":"","staff_note":"","total":"15000.0000","product_discount":"0.0000","order_discount_id":"","total_discount":"0.0000","order_discount":"0.0000","product_tax":"0.0000","order_tax_id":null,"order_tax":"0.0000","total_tax":"0.0000","shipping":"0.0000","grand_total":"15000.0000","sale_status":"completed","payment_status":"paid","payment_term":"0","due_date":null,"created_by":"1","updated_by":null,"updated_at":null,"total_items":"10","pos":"0","paid":"15000.0000","return_id":null,"surcharge":"0.0000","attachment":null,"return_sale_ref":null,"sale_id":null,"return_sale_total":"0.0000","rounding":null,"suspend_note":null,"api":"0","shop":"0","address_id":null,"reserve_id":null,"hash":"9635bcf0297a41faa77880f5ae71bbabe40947fad6b73bb973758f61007c7c76","manual_payment":null,"cgst":"0.0000","sgst":"0.0000","igst":"0.0000","payment_method":null,"redeem_amount":"0.0000","pv":"15000","bv":"15000","sale_type":"0"}],"address":{"address":"batala","city_text":"0","state_text":"0","country":"101"}}
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
         * orderhistory : [{"id":"3","date":"2019-01-24 12:35:00","reference_no":"INV0003","customer_id":"4","customer_username":"0001","customer":"1 1","biller_id":"1","biller":"Yes You Can","warehouse_id":"1","note":"","staff_note":"","total":"15000.0000","product_discount":"0.0000","order_discount_id":"","total_discount":"0.0000","order_discount":"0.0000","product_tax":"0.0000","order_tax_id":null,"order_tax":"0.0000","total_tax":"0.0000","shipping":"0.0000","grand_total":"15000.0000","sale_status":"completed","payment_status":"paid","payment_term":"0","due_date":null,"created_by":"1","updated_by":null,"updated_at":null,"total_items":"10","pos":"0","paid":"15000.0000","return_id":null,"surcharge":"0.0000","attachment":null,"return_sale_ref":null,"sale_id":null,"return_sale_total":"0.0000","rounding":null,"suspend_note":null,"api":"0","shop":"0","address_id":null,"reserve_id":null,"hash":"9635bcf0297a41faa77880f5ae71bbabe40947fad6b73bb973758f61007c7c76","manual_payment":null,"cgst":"0.0000","sgst":"0.0000","igst":"0.0000","payment_method":null,"redeem_amount":"0.0000","pv":"15000","bv":"15000","sale_type":"0"}]
         * address : {"address":"batala","city_text":"0","state_text":"0","country":"101"}
         */

        private AddressBean address;
        private List<OrderhistoryBean> orderhistory;

        public AddressBean getAddress() {
            return address;
        }

        public void setAddress(AddressBean address) {
            this.address = address;
        }

        public List<OrderhistoryBean> getOrderhistory() {
            return orderhistory;
        }

        public void setOrderhistory(List<OrderhistoryBean> orderhistory) {
            this.orderhistory = orderhistory;
        }

        public static class AddressBean {
            /**
             * address : batala
             * city_text : 0
             * state_text : 0
             * country : 101
             */

            private String address;
            private String city_text;
            private String state_text;
            private String country;

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getCity_text() {
                return city_text;
            }

            public void setCity_text(String city_text) {
                this.city_text = city_text;
            }

            public String getState_text() {
                return state_text;
            }

            public void setState_text(String state_text) {
                this.state_text = state_text;
            }

            public String getCountry() {
                return country;
            }

            public void setCountry(String country) {
                this.country = country;
            }
        }

        public static class OrderhistoryBean {
            /**
             * id : 3
             * date : 2019-01-24 12:35:00
             * reference_no : INV0003
             * customer_id : 4
             * customer_username : 0001
             * customer : 1 1
             * biller_id : 1
             * biller : Yes You Can
             * warehouse_id : 1
             * note :
             * staff_note :
             * total : 15000.0000
             * product_discount : 0.0000
             * order_discount_id :
             * total_discount : 0.0000
             * order_discount : 0.0000
             * product_tax : 0.0000
             * order_tax_id : null
             * order_tax : 0.0000
             * total_tax : 0.0000
             * shipping : 0.0000
             * grand_total : 15000.0000
             * sale_status : completed
             * payment_status : paid
             * payment_term : 0
             * due_date : null
             * created_by : 1
             * updated_by : null
             * updated_at : null
             * total_items : 10
             * pos : 0
             * paid : 15000.0000
             * return_id : null
             * surcharge : 0.0000
             * attachment : null
             * return_sale_ref : null
             * sale_id : null
             * return_sale_total : 0.0000
             * rounding : null
             * suspend_note : null
             * api : 0
             * shop : 0
             * address_id : null
             * reserve_id : null
             * hash : 9635bcf0297a41faa77880f5ae71bbabe40947fad6b73bb973758f61007c7c76
             * manual_payment : null
             * cgst : 0.0000
             * sgst : 0.0000
             * igst : 0.0000
             * payment_method : null
             * redeem_amount : 0.0000
             * pv : 15000
             * bv : 15000
             * sale_type : 0
             */

            private String id;
            private String date;
            private String reference_no;
            private String customer_id;
            private String customer_username;
            private String customer;
            private String biller_id;
            private String biller;
            private String warehouse_id;
            private String note;
            private String staff_note;
            private String total;
            private String product_discount;
            private String order_discount_id;
            private String total_discount;
            private String order_discount;
            private String product_tax;
            private Object order_tax_id;
            private String order_tax;
            private String total_tax;
            private String shipping;
            private String grand_total;
            private String sale_status;
            private String payment_status;
            private String payment_term;
            private Object due_date;
            private String created_by;
            private Object updated_by;
            private Object updated_at;
            private String total_items;
            private String pos;
            private String paid;
            private Object return_id;
            private String surcharge;
            private Object attachment;
            private Object return_sale_ref;
            private Object sale_id;
            private String return_sale_total;
            private Object rounding;
            private Object suspend_note;
            private String api;
            private String shop;
            private Object address_id;
            private Object reserve_id;
            private String hash;
            private Object manual_payment;
            private String cgst;
            private String sgst;
            private String igst;
            private Object payment_method;
            private String redeem_amount;
            private String pv;
            private String bv;
            private String sale_type;

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

            public String getReference_no() {
                return reference_no;
            }

            public void setReference_no(String reference_no) {
                this.reference_no = reference_no;
            }

            public String getCustomer_id() {
                return customer_id;
            }

            public void setCustomer_id(String customer_id) {
                this.customer_id = customer_id;
            }

            public String getCustomer_username() {
                return customer_username;
            }

            public void setCustomer_username(String customer_username) {
                this.customer_username = customer_username;
            }

            public String getCustomer() {
                return customer;
            }

            public void setCustomer(String customer) {
                this.customer = customer;
            }

            public String getBiller_id() {
                return biller_id;
            }

            public void setBiller_id(String biller_id) {
                this.biller_id = biller_id;
            }

            public String getBiller() {
                return biller;
            }

            public void setBiller(String biller) {
                this.biller = biller;
            }

            public String getWarehouse_id() {
                return warehouse_id;
            }

            public void setWarehouse_id(String warehouse_id) {
                this.warehouse_id = warehouse_id;
            }

            public String getNote() {
                return note;
            }

            public void setNote(String note) {
                this.note = note;
            }

            public String getStaff_note() {
                return staff_note;
            }

            public void setStaff_note(String staff_note) {
                this.staff_note = staff_note;
            }

            public String getTotal() {
                return total;
            }

            public void setTotal(String total) {
                this.total = total;
            }

            public String getProduct_discount() {
                return product_discount;
            }

            public void setProduct_discount(String product_discount) {
                this.product_discount = product_discount;
            }

            public String getOrder_discount_id() {
                return order_discount_id;
            }

            public void setOrder_discount_id(String order_discount_id) {
                this.order_discount_id = order_discount_id;
            }

            public String getTotal_discount() {
                return total_discount;
            }

            public void setTotal_discount(String total_discount) {
                this.total_discount = total_discount;
            }

            public String getOrder_discount() {
                return order_discount;
            }

            public void setOrder_discount(String order_discount) {
                this.order_discount = order_discount;
            }

            public String getProduct_tax() {
                return product_tax;
            }

            public void setProduct_tax(String product_tax) {
                this.product_tax = product_tax;
            }

            public Object getOrder_tax_id() {
                return order_tax_id;
            }

            public void setOrder_tax_id(Object order_tax_id) {
                this.order_tax_id = order_tax_id;
            }

            public String getOrder_tax() {
                return order_tax;
            }

            public void setOrder_tax(String order_tax) {
                this.order_tax = order_tax;
            }

            public String getTotal_tax() {
                return total_tax;
            }

            public void setTotal_tax(String total_tax) {
                this.total_tax = total_tax;
            }

            public String getShipping() {
                return shipping;
            }

            public void setShipping(String shipping) {
                this.shipping = shipping;
            }

            public String getGrand_total() {
                return grand_total;
            }

            public void setGrand_total(String grand_total) {
                this.grand_total = grand_total;
            }

            public String getSale_status() {
                return sale_status;
            }

            public void setSale_status(String sale_status) {
                this.sale_status = sale_status;
            }

            public String getPayment_status() {
                return payment_status;
            }

            public void setPayment_status(String payment_status) {
                this.payment_status = payment_status;
            }

            public String getPayment_term() {
                return payment_term;
            }

            public void setPayment_term(String payment_term) {
                this.payment_term = payment_term;
            }

            public Object getDue_date() {
                return due_date;
            }

            public void setDue_date(Object due_date) {
                this.due_date = due_date;
            }

            public String getCreated_by() {
                return created_by;
            }

            public void setCreated_by(String created_by) {
                this.created_by = created_by;
            }

            public Object getUpdated_by() {
                return updated_by;
            }

            public void setUpdated_by(Object updated_by) {
                this.updated_by = updated_by;
            }

            public Object getUpdated_at() {
                return updated_at;
            }

            public void setUpdated_at(Object updated_at) {
                this.updated_at = updated_at;
            }

            public String getTotal_items() {
                return total_items;
            }

            public void setTotal_items(String total_items) {
                this.total_items = total_items;
            }

            public String getPos() {
                return pos;
            }

            public void setPos(String pos) {
                this.pos = pos;
            }

            public String getPaid() {
                return paid;
            }

            public void setPaid(String paid) {
                this.paid = paid;
            }

            public Object getReturn_id() {
                return return_id;
            }

            public void setReturn_id(Object return_id) {
                this.return_id = return_id;
            }

            public String getSurcharge() {
                return surcharge;
            }

            public void setSurcharge(String surcharge) {
                this.surcharge = surcharge;
            }

            public Object getAttachment() {
                return attachment;
            }

            public void setAttachment(Object attachment) {
                this.attachment = attachment;
            }

            public Object getReturn_sale_ref() {
                return return_sale_ref;
            }

            public void setReturn_sale_ref(Object return_sale_ref) {
                this.return_sale_ref = return_sale_ref;
            }

            public Object getSale_id() {
                return sale_id;
            }

            public void setSale_id(Object sale_id) {
                this.sale_id = sale_id;
            }

            public String getReturn_sale_total() {
                return return_sale_total;
            }

            public void setReturn_sale_total(String return_sale_total) {
                this.return_sale_total = return_sale_total;
            }

            public Object getRounding() {
                return rounding;
            }

            public void setRounding(Object rounding) {
                this.rounding = rounding;
            }

            public Object getSuspend_note() {
                return suspend_note;
            }

            public void setSuspend_note(Object suspend_note) {
                this.suspend_note = suspend_note;
            }

            public String getApi() {
                return api;
            }

            public void setApi(String api) {
                this.api = api;
            }

            public String getShop() {
                return shop;
            }

            public void setShop(String shop) {
                this.shop = shop;
            }

            public Object getAddress_id() {
                return address_id;
            }

            public void setAddress_id(Object address_id) {
                this.address_id = address_id;
            }

            public Object getReserve_id() {
                return reserve_id;
            }

            public void setReserve_id(Object reserve_id) {
                this.reserve_id = reserve_id;
            }

            public String getHash() {
                return hash;
            }

            public void setHash(String hash) {
                this.hash = hash;
            }

            public Object getManual_payment() {
                return manual_payment;
            }

            public void setManual_payment(Object manual_payment) {
                this.manual_payment = manual_payment;
            }

            public String getCgst() {
                return cgst;
            }

            public void setCgst(String cgst) {
                this.cgst = cgst;
            }

            public String getSgst() {
                return sgst;
            }

            public void setSgst(String sgst) {
                this.sgst = sgst;
            }

            public String getIgst() {
                return igst;
            }

            public void setIgst(String igst) {
                this.igst = igst;
            }

            public Object getPayment_method() {
                return payment_method;
            }

            public void setPayment_method(Object payment_method) {
                this.payment_method = payment_method;
            }

            public String getRedeem_amount() {
                return redeem_amount;
            }

            public void setRedeem_amount(String redeem_amount) {
                this.redeem_amount = redeem_amount;
            }

            public String getPv() {
                return pv;
            }

            public void setPv(String pv) {
                this.pv = pv;
            }

            public String getBv() {
                return bv;
            }

            public void setBv(String bv) {
                this.bv = bv;
            }

            public String getSale_type() {
                return sale_type;
            }

            public void setSale_type(String sale_type) {
                this.sale_type = sale_type;
            }
        }
    }
}
