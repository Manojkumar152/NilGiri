package com.app.nilgiri.Models;

import java.util.List;

public class GetKycDetail {


    /**
     * data : [{"id":"135","client_id":"155","upload_first_proof":"a7c64aa5f0b758d82ede92d040047e20.jpg","upload_second_proof":"b7ed0ae65d754d695e1b5e8215ad45c7.jpg","upload_third_proof":"3c3128fba0ac98b7eb03e1bf7940b665.jpg","status":"0","created_at":"2019-02-04 22:51:56","updated_at":"2019-05-02"}]
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
         * id : 135
         * client_id : 155
         * upload_first_proof : a7c64aa5f0b758d82ede92d040047e20.jpg
         * upload_second_proof : b7ed0ae65d754d695e1b5e8215ad45c7.jpg
         * upload_third_proof : 3c3128fba0ac98b7eb03e1bf7940b665.jpg
         * status : 0
         * created_at : 2019-02-04 22:51:56
         * updated_at : 2019-05-02
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
