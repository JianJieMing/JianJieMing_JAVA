package com.jianjieming.study.bean;

import java.util.List;

/**
 * @author 铭
 * DATE: 18/9/11 上午7:54
 */
public class TestBean {

    /**
     * status : 200
     * msg : ok
     * count : 1
     * result : [{"lat":"38.9233642332","lng":"121.6294515373","match":"1"}]
     */

    private int status;
    private String msg;
    private int count;
    private List<ResultBean> result;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * lat : 38.9233642332
         * lng : 121.6294515373
         * match : 1
         */

        private String lat;
        private String lng;
        private String match;

        public String getLat() {
            return lat;
        }

        public void setLat(String lat) {
            this.lat = lat;
        }

        public String getLng() {
            return lng;
        }

        public void setLng(String lng) {
            this.lng = lng;
        }

        public String getMatch() {
            return match;
        }

        public void setMatch(String match) {
            this.match = match;
        }
    }
}
