package com.example.mvp_module.bean;

public class BaseBean {


    /**
     * data : {"id":3128,"loginName":"123niqiu","memberName":"小泥鳅"}
     * status : 200
     */

    private DataEntity data;
    private int status;

    public void setData(DataEntity data) {
        this.data = data;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public DataEntity getData() {
        return data;
    }

    public int getStatus() {
        return status;
    }

    public static class DataEntity {
        /**
         * id : 3128
         * loginName : 123niqiu
         * memberName : 小泥鳅
         */

        private int id;
        private String loginName;
        private String memberName;

        public void setId(int id) {
            this.id = id;
        }

        public void setLoginName(String loginName) {
            this.loginName = loginName;
        }

        public void setMemberName(String memberName) {
            this.memberName = memberName;
        }

        public int getId() {
            return id;
        }

        public String getLoginName() {
            return loginName;
        }

        public String getMemberName() {
            return memberName;
        }

        @Override
        public String toString() {
            return "DataEntity{" +
                    "id=" + id +
                    ", loginName='" + loginName + '\'' +
                    ", memberName='" + memberName + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "BaseBean{" +
                "data=" + data +
                ", status=" + status +
                '}';
    }
}
