package com.app.nilgiri.Models;

import java.util.List;

public class MyTeamLeftModel {


    /**
     * message : Successfully
     * status : 1
     * page_count : 2
     * data : {"client":{"id":"4","name":"Krishnanand Prajapati","username":"TP884108","city":null,"city_text":null,"email":"krrishvns@gmail.com","avatar":null,"sales_active":"1"},"leftTeam":[{"id":"98","name":"rajesh kumar","username":"TP171397","city":null,"city_text":null,"email":"krrishbns@gmail.com","avatar":null,"sales_active":"0"},{"id":"99","name":"ritesh prajapati","username":"TP268933","city":null,"city_text":null,"email":"krrishvns@gmail.com","avatar":null,"sales_active":"0"},{"id":"100","name":"vikash yadav","username":"TP616269","city":null,"city_text":null,"email":"krrishvns@gmail.com","avatar":null,"sales_active":"0"},{"id":"101","name":"sandhya pandey pandey","username":"TP999194","city":"5211","city_text":"Varanasi","email":"jitendrapandeyvns1983@gmail.com","avatar":null,"sales_active":"1"},{"id":"102","name":"neelesh pal","username":"TP490715","city":null,"city_text":null,"email":"krrishbns@gmail.com","avatar":null,"sales_active":"0"},{"id":"103","name":"krishna  singh","username":"TP151910","city":null,"city_text":null,"email":"krrishvns@gmail.com","avatar":null,"sales_active":"0"},{"id":"118","name":"VANDANA PRAJAPATI","username":"TP631371","city":null,"city_text":null,"email":"KRRISHVNS@GMAIL.COM","avatar":null,"sales_active":"0"},{"id":"123","name":"RAMESH GUPTA","username":"TP223068","city":null,"city_text":null,"email":"RAMESHG@GMAIL.COM","avatar":null,"sales_active":"0"},{"id":"124","name":"ARVIND GUPTA","username":"TP610225","city":null,"city_text":null,"email":"RAMESHG@GMAIL.COM","avatar":null,"sales_active":"0"},{"id":"125","name":"ANITA SINGH","username":"TP419506","city":null,"city_text":null,"email":"RAMESHG@GMAIL.COM","avatar":null,"sales_active":"0"},{"id":"126","name":"SANTOSH KUMAR","username":"TP674712","city":null,"city_text":null,"email":"SANTOSHKUMAR1234@GMAIL.COM","avatar":null,"sales_active":"0"},{"id":"127","name":"SEEMA  SINGH","username":"TP926532","city":null,"city_text":null,"email":"SEEMASANTOSHG@GMAIL.COM","avatar":null,"sales_active":"0"},{"id":"128","name":"Pankaj kumar Singh","username":"TP390117","city":"4760","city_text":"Ghazipur","email":"pankaj.anjanasinghpdp@gmail.com","avatar":null,"sales_active":"0"},{"id":"182","name":"snehlata singh","username":"TP447278","city":null,"city_text":null,"email":"aashu300@gmail.com","avatar":null,"sales_active":"1"},{"id":"183","name":"rajesh kumar","username":"TP350487","city":null,"city_text":null,"email":"kumarbirla210@gmail.com","avatar":null,"sales_active":"0"},{"id":"187","name":"pawan  tripathi","username":"TP169526","city":null,"city_text":null,"email":"chintapiush@gmail.com","avatar":null,"sales_active":"0"},{"id":"222","name":"raj shree","username":"TP720324","city":null,"city_text":null,"email":"krrishvns@gmail.com","avatar":null,"sales_active":"0"},{"id":"223","name":"mitu khanna","username":"TP852109","city":null,"city_text":null,"email":"krrishvns@gmail.com","avatar":null,"sales_active":"1"},{"id":"224","name":"mukesh khanna","username":"TP636151","city":null,"city_text":null,"email":"krrishvns@gmail.com","avatar":null,"sales_active":"0"},{"id":"513","name":"Aaseem Khan","username":"TP280094","city":null,"city_text":null,"email":"aaseemkha3323@gmail.com","avatar":null,"sales_active":"0"}]}
     */

    private String message;
    private int status;
    private int page_count;
    private DataBean data;

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

    public int getPage_count() {
        return page_count;
    }

    public void setPage_count(int page_count) {
        this.page_count = page_count;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * client : {"id":"4","name":"Krishnanand Prajapati","username":"TP884108","city":null,"city_text":null,"email":"krrishvns@gmail.com","avatar":null,"sales_active":"1"}
         * leftTeam : [{"id":"98","name":"rajesh kumar","username":"TP171397","city":null,"city_text":null,"email":"krrishbns@gmail.com","avatar":null,"sales_active":"0"},{"id":"99","name":"ritesh prajapati","username":"TP268933","city":null,"city_text":null,"email":"krrishvns@gmail.com","avatar":null,"sales_active":"0"},{"id":"100","name":"vikash yadav","username":"TP616269","city":null,"city_text":null,"email":"krrishvns@gmail.com","avatar":null,"sales_active":"0"},{"id":"101","name":"sandhya pandey pandey","username":"TP999194","city":"5211","city_text":"Varanasi","email":"jitendrapandeyvns1983@gmail.com","avatar":null,"sales_active":"1"},{"id":"102","name":"neelesh pal","username":"TP490715","city":null,"city_text":null,"email":"krrishbns@gmail.com","avatar":null,"sales_active":"0"},{"id":"103","name":"krishna  singh","username":"TP151910","city":null,"city_text":null,"email":"krrishvns@gmail.com","avatar":null,"sales_active":"0"},{"id":"118","name":"VANDANA PRAJAPATI","username":"TP631371","city":null,"city_text":null,"email":"KRRISHVNS@GMAIL.COM","avatar":null,"sales_active":"0"},{"id":"123","name":"RAMESH GUPTA","username":"TP223068","city":null,"city_text":null,"email":"RAMESHG@GMAIL.COM","avatar":null,"sales_active":"0"},{"id":"124","name":"ARVIND GUPTA","username":"TP610225","city":null,"city_text":null,"email":"RAMESHG@GMAIL.COM","avatar":null,"sales_active":"0"},{"id":"125","name":"ANITA SINGH","username":"TP419506","city":null,"city_text":null,"email":"RAMESHG@GMAIL.COM","avatar":null,"sales_active":"0"},{"id":"126","name":"SANTOSH KUMAR","username":"TP674712","city":null,"city_text":null,"email":"SANTOSHKUMAR1234@GMAIL.COM","avatar":null,"sales_active":"0"},{"id":"127","name":"SEEMA  SINGH","username":"TP926532","city":null,"city_text":null,"email":"SEEMASANTOSHG@GMAIL.COM","avatar":null,"sales_active":"0"},{"id":"128","name":"Pankaj kumar Singh","username":"TP390117","city":"4760","city_text":"Ghazipur","email":"pankaj.anjanasinghpdp@gmail.com","avatar":null,"sales_active":"0"},{"id":"182","name":"snehlata singh","username":"TP447278","city":null,"city_text":null,"email":"aashu300@gmail.com","avatar":null,"sales_active":"1"},{"id":"183","name":"rajesh kumar","username":"TP350487","city":null,"city_text":null,"email":"kumarbirla210@gmail.com","avatar":null,"sales_active":"0"},{"id":"187","name":"pawan  tripathi","username":"TP169526","city":null,"city_text":null,"email":"chintapiush@gmail.com","avatar":null,"sales_active":"0"},{"id":"222","name":"raj shree","username":"TP720324","city":null,"city_text":null,"email":"krrishvns@gmail.com","avatar":null,"sales_active":"0"},{"id":"223","name":"mitu khanna","username":"TP852109","city":null,"city_text":null,"email":"krrishvns@gmail.com","avatar":null,"sales_active":"1"},{"id":"224","name":"mukesh khanna","username":"TP636151","city":null,"city_text":null,"email":"krrishvns@gmail.com","avatar":null,"sales_active":"0"},{"id":"513","name":"Aaseem Khan","username":"TP280094","city":null,"city_text":null,"email":"aaseemkha3323@gmail.com","avatar":null,"sales_active":"0"}]
         */

        private ClientBean client;
        private List<LeftTeamBean> leftTeam;

        public ClientBean getClient() {
            return client;
        }

        public void setClient(ClientBean client) {
            this.client = client;
        }

        public List<LeftTeamBean> getLeftTeam() {
            return leftTeam;
        }

        public void setLeftTeam(List<LeftTeamBean> leftTeam) {
            this.leftTeam = leftTeam;
        }

        public static class ClientBean {
            /**
             * id : 4
             * name : Krishnanand Prajapati
             * username : TP884108
             * city : null
             * city_text : null
             * email : krrishvns@gmail.com
             * avatar : null
             * sales_active : 1
             */

            private String id;
            private String name;
            private String username;
            private Object city;
            private Object city_text;
            private String email;
            private Object avatar;
            private String sales_active;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public Object getCity() {
                return city;
            }

            public void setCity(Object city) {
                this.city = city;
            }

            public Object getCity_text() {
                return city_text;
            }

            public void setCity_text(Object city_text) {
                this.city_text = city_text;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public Object getAvatar() {
                return avatar;
            }

            public void setAvatar(Object avatar) {
                this.avatar = avatar;
            }

            public String getSales_active() {
                return sales_active;
            }

            public void setSales_active(String sales_active) {
                this.sales_active = sales_active;
            }
        }

        public static class LeftTeamBean {
            /**
             * id : 98
             * name : rajesh kumar
             * username : TP171397
             * city : null
             * city_text : null
             * email : krrishbns@gmail.com
             * avatar : null
             * sales_active : 0
             */

            private String id;
            private String name;
            private String username;
            private Object city;
            private Object city_text;
            private String email;
            private Object avatar;
            private String sales_active;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public Object getCity() {
                return city;
            }

            public void setCity(Object city) {
                this.city = city;
            }

            public Object getCity_text() {
                return city_text;
            }

            public void setCity_text(Object city_text) {
                this.city_text = city_text;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public Object getAvatar() {
                return avatar;
            }

            public void setAvatar(Object avatar) {
                this.avatar = avatar;
            }

            public String getSales_active() {
                return sales_active;
            }

            public void setSales_active(String sales_active) {
                this.sales_active = sales_active;
            }
        }
    }
}
