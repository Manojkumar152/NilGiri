package com.app.nilgiri.Models;

import java.util.List;

public class MyTeamLeftModel {

    /**
     * message : Successfully
     * status : 1
     * page_count : 2
     * data : {"client":{"id":"4","name":"Krishnanand Prajapati","username":"TP884108","city":null,"city_text":null,"email":"krrishvns@gmail.com","avatar":null,"sales_active":"1"},"leftTeam":[{"id":"23","name":"Abhai  Chaurasia","username":"TP987754","city":"5212","city_text":"Varanasi Cantonment","email":"lovely4mlm@gmail.com","avatar":null,"sales_active":"1"},{"id":"27","name":"vivek pandey","username":"TP493107","city":null,"city_text":null,"email":"vivekpandeyall@gmail.com","avatar":null,"sales_active":"0"},{"id":"28","name":"yuvraj ","username":"TP776442","city":null,"city_text":null,"email":"krrishvns@gmail.com","avatar":null,"sales_active":"0"},{"id":"29","name":"sachin gupta","username":"TP575397","city":null,"city_text":null,"email":"sachingunja@gmail.com","avatar":null,"sales_active":"0"},{"id":"31","name":" ","username":"TP470834","city":"5211","city_text":"Varanasi","email":"dkjaiswal8585@gmail.com","avatar":null,"sales_active":"1"},{"id":"32","name":"pravbeen  ","username":"TP499339","city":null,"city_text":null,"email":"krrishvns@gmail.com","avatar":null,"sales_active":"0"},{"id":"33","name":"brij mohan","username":"TP400092","city":null,"city_text":null,"email":"sk.chaurasia1976@gmail.com","avatar":null,"sales_active":"0"},{"id":"34","name":"RAVI KUMAR VISHWAKARMA","username":"TP319795","city":null,"city_text":null,"email":"kumarravi210876@gmail.com","avatar":null,"sales_active":"0"},{"id":"37","name":"Brijmohan Kumar Singh","username":"TP187561","city":"1492","city_text":"Ranchi","email":"brij25051989@gmail.com","avatar":null,"sales_active":"1"},{"id":"38","name":"sunil ","username":"TP368124","city":null,"city_text":null,"email":"sk.chaurasia1976@gmail.com","avatar":null,"sales_active":"0"},{"id":"39","name":"amit ","username":"TP721457","city":null,"city_text":null,"email":"sk.chaurasia1976@gmail.com","avatar":null,"sales_active":"0"},{"id":"40","name":"raghvendra ","username":"TP969540","city":null,"city_text":null,"email":"sk.chaurasia1976@gmail.com","avatar":null,"sales_active":"0"},{"id":"41","name":"ashutosh anand","username":"TP191439","city":null,"city_text":null,"email":"ashutoshvansh@gmail.com","avatar":null,"sales_active":"0"},{"id":"42","name":"nidhi ","username":"TP829185","city":null,"city_text":null,"email":"sk.chaurasia1976@gmail.com","avatar":null,"sales_active":"0"},{"id":"59","name":"mahendra  nath","username":"TP335533","city":null,"city_text":null,"email":"krrishvns@gmail.com","avatar":null,"sales_active":"0"},{"id":"60","name":"prashant kumar","username":"TP406929","city":null,"city_text":null,"email":"krrishvns@gmail.com","avatar":null,"sales_active":"0"},{"id":"87","name":"MOHD farid Alam","username":"TP908680","city":"5211","city_text":"Varanasi","email":"farid751976@gmail.com","avatar":null,"sales_active":"1"},{"id":"95","name":"anita  devi","username":"TP353097","city":null,"city_text":null,"email":"krrishvns@gmail.com","avatar":null,"sales_active":"0"},{"id":"96","name":"sandeep  singh","username":"TP217340","city":null,"city_text":null,"email":"krrishvns@gmail.com","avatar":null,"sales_active":"0"},{"id":"97","name":"nirmala yadav","username":"TP245514","city":null,"city_text":null,"email":"krrishvns@gmail.com","avatar":null,"sales_active":"0"}]}
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
         * leftTeam : [{"id":"23","name":"Abhai  Chaurasia","username":"TP987754","city":"5212","city_text":"Varanasi Cantonment","email":"lovely4mlm@gmail.com","avatar":null,"sales_active":"1"},{"id":"27","name":"vivek pandey","username":"TP493107","city":null,"city_text":null,"email":"vivekpandeyall@gmail.com","avatar":null,"sales_active":"0"},{"id":"28","name":"yuvraj ","username":"TP776442","city":null,"city_text":null,"email":"krrishvns@gmail.com","avatar":null,"sales_active":"0"},{"id":"29","name":"sachin gupta","username":"TP575397","city":null,"city_text":null,"email":"sachingunja@gmail.com","avatar":null,"sales_active":"0"},{"id":"31","name":" ","username":"TP470834","city":"5211","city_text":"Varanasi","email":"dkjaiswal8585@gmail.com","avatar":null,"sales_active":"1"},{"id":"32","name":"pravbeen  ","username":"TP499339","city":null,"city_text":null,"email":"krrishvns@gmail.com","avatar":null,"sales_active":"0"},{"id":"33","name":"brij mohan","username":"TP400092","city":null,"city_text":null,"email":"sk.chaurasia1976@gmail.com","avatar":null,"sales_active":"0"},{"id":"34","name":"RAVI KUMAR VISHWAKARMA","username":"TP319795","city":null,"city_text":null,"email":"kumarravi210876@gmail.com","avatar":null,"sales_active":"0"},{"id":"37","name":"Brijmohan Kumar Singh","username":"TP187561","city":"1492","city_text":"Ranchi","email":"brij25051989@gmail.com","avatar":null,"sales_active":"1"},{"id":"38","name":"sunil ","username":"TP368124","city":null,"city_text":null,"email":"sk.chaurasia1976@gmail.com","avatar":null,"sales_active":"0"},{"id":"39","name":"amit ","username":"TP721457","city":null,"city_text":null,"email":"sk.chaurasia1976@gmail.com","avatar":null,"sales_active":"0"},{"id":"40","name":"raghvendra ","username":"TP969540","city":null,"city_text":null,"email":"sk.chaurasia1976@gmail.com","avatar":null,"sales_active":"0"},{"id":"41","name":"ashutosh anand","username":"TP191439","city":null,"city_text":null,"email":"ashutoshvansh@gmail.com","avatar":null,"sales_active":"0"},{"id":"42","name":"nidhi ","username":"TP829185","city":null,"city_text":null,"email":"sk.chaurasia1976@gmail.com","avatar":null,"sales_active":"0"},{"id":"59","name":"mahendra  nath","username":"TP335533","city":null,"city_text":null,"email":"krrishvns@gmail.com","avatar":null,"sales_active":"0"},{"id":"60","name":"prashant kumar","username":"TP406929","city":null,"city_text":null,"email":"krrishvns@gmail.com","avatar":null,"sales_active":"0"},{"id":"87","name":"MOHD farid Alam","username":"TP908680","city":"5211","city_text":"Varanasi","email":"farid751976@gmail.com","avatar":null,"sales_active":"1"},{"id":"95","name":"anita  devi","username":"TP353097","city":null,"city_text":null,"email":"krrishvns@gmail.com","avatar":null,"sales_active":"0"},{"id":"96","name":"sandeep  singh","username":"TP217340","city":null,"city_text":null,"email":"krrishvns@gmail.com","avatar":null,"sales_active":"0"},{"id":"97","name":"nirmala yadav","username":"TP245514","city":null,"city_text":null,"email":"krrishvns@gmail.com","avatar":null,"sales_active":"0"}]
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
             * id : 23
             * name : Abhai  Chaurasia
             * username : TP987754
             * city : 5212
             * city_text : Varanasi Cantonment
             * email : lovely4mlm@gmail.com
             * avatar : null
             * sales_active : 1
             */

            private String id;
            private String name;
            private String username;
            private String city;
            private String city_text;
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

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getCity_text() {
                return city_text;
            }

            public void setCity_text(String city_text) {
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
