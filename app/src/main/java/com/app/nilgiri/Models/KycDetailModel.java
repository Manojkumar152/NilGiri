package com.app.nilgiri.Models;

import java.util.List;

public class KycDetailModel {
    /**
     * data : [{"id":"1","client_id":"4","upload_first_proof":"79e9f913cdbc5c76ff8e9d99c4e7904a.jpg","upload_second_proof":"7de7d46c2fb9d743ed53ca60952355a6.jpg","upload_third_proof":"958d01cfd84f4379a215ec39e9d2560a.jpg","status":"0","created_at":"2019-01-24 12:15:04","updated_at":"2019-07-18"}]
     * message : null
     * status : 1
     */

    private Object message;
    private int status;
    private List<DataBean> data;

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
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
         * id : 1
         * client_id : 4
         * upload_first_proof : 79e9f913cdbc5c76ff8e9d99c4e7904a.jpg
         * upload_second_proof : 7de7d46c2fb9d743ed53ca60952355a6.jpg
         * upload_third_proof : 958d01cfd84f4379a215ec39e9d2560a.jpg
         * status : 0
         * created_at : 2019-01-24 12:15:04
         * updated_at : 2019-07-18
         */

        private String id;
        private String client_id;
        private String upload_first_proof;
        private String upload_second_proof;
        private String upload_third_proof;
        private String status;
        private String created_at;
        private String updated_at;

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

        public String getUpload_first_proof() {
            return upload_first_proof;
        }

        public void setUpload_first_proof(String upload_first_proof) {
            this.upload_first_proof = upload_first_proof;
        }

        public String getUpload_second_proof() {
            return upload_second_proof;
        }

        public void setUpload_second_proof(String upload_second_proof) {
            this.upload_second_proof = upload_second_proof;
        }

        public String getUpload_third_proof() {
            return upload_third_proof;
        }

        public void setUpload_third_proof(String upload_third_proof) {
            this.upload_third_proof = upload_third_proof;
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

        public String getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }
    }
}
