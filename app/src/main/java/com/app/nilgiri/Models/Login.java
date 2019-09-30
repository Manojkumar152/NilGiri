package com.app.nilgiri.Models;

public class Login {

    /**
     * message : Login successfull
     * status : 1
     * data : {"username":"root","email":"root@gmail.com","id":"2","company_id":"3","password":"2c8ab736b2ccab4f50e72d5fd7d21020cbb77ae7","active":"1","avatar":null,"gender":"male","group_id":"3"}
     */

    private String message;
    private int status;
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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * username : root
         * email : root@gmail.com
         * id : 2
         * company_id : 3
         * password : 2c8ab736b2ccab4f50e72d5fd7d21020cbb77ae7
         * active : 1
         * avatar : null
         * gender : male
         * group_id : 3
         */

        private String username;
        private String email;
        private String id;
        private String company_id;
        private String password;
        private String active;
        private Object avatar;
        private String gender;
        private String group_id;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCompany_id() {
            return company_id;
        }

        public void setCompany_id(String company_id) {
            this.company_id = company_id;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getActive() {
            return active;
        }

        public void setActive(String active) {
            this.active = active;
        }

        public Object getAvatar() {
            return avatar;
        }

        public void setAvatar(Object avatar) {
            this.avatar = avatar;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getGroup_id() {
            return group_id;
        }

        public void setGroup_id(String group_id) {
            this.group_id = group_id;
        }
    }
}
