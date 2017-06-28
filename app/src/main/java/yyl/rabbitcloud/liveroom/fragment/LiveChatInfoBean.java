package yyl.rabbitcloud.liveroom.fragment;

import java.util.List;

/**
 * 获取聊天信息  可以用来解析去获取弹幕数据
 * Created by yyl on 2017/6/27.
 */

public class LiveChatInfoBean {


    /**
     * errno : 0
     * errmsg :
     * data : {"rid":-87431708,"appid":"134278727","chat_addr_list":["123.56.12.165:8080",
     * "123.56.10.94:8080","101.201.70.99:3389","123.56.10.94:3389","101.201.70.99:8080",
     * "123.56.12.165:3389"],"ts":"1498554245000","sign":"084310f20f1b0c756bb6fe05de4c0291",
     * "authtype":"4"}
     * authseq :
     */

    private int errno;
    private String errmsg;
    private DataBean data;
    private String authseq;

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getAuthseq() {
        return authseq;
    }

    public void setAuthseq(String authseq) {
        this.authseq = authseq;
    }

    public static class DataBean {
        /**
         * rid : -87431708
         * appid : 134278727
         * chat_addr_list : ["123.56.12.165:8080","123.56.10.94:8080","101.201.70.99:3389",
         * "123.56.10.94:3389","101.201.70.99:8080","123.56.12.165:3389"]
         * ts : 1498554245000
         * sign : 084310f20f1b0c756bb6fe05de4c0291
         * authtype : 4
         */

        private int rid;
        private String appid;
        private String ts;
        private String sign;
        private String authtype;
        private List<String> chat_addr_list;

        public int getRid() {
            return rid;
        }

        public void setRid(int rid) {
            this.rid = rid;
        }

        public String getAppid() {
            return appid;
        }

        public void setAppid(String appid) {
            this.appid = appid;
        }

        public String getTs() {
            return ts;
        }

        public void setTs(String ts) {
            this.ts = ts;
        }

        public String getSign() {
            return sign;
        }

        public void setSign(String sign) {
            this.sign = sign;
        }

        public String getAuthtype() {
            return authtype;
        }

        public void setAuthtype(String authtype) {
            this.authtype = authtype;
        }

        public List<String> getChat_addr_list() {
            return chat_addr_list;
        }

        public void setChat_addr_list(List<String> chat_addr_list) {
            this.chat_addr_list = chat_addr_list;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "rid=" + rid +
                    ", appid='" + appid + '\'' +
                    ", ts='" + ts + '\'' +
                    ", sign='" + sign + '\'' +
                    ", authtype='" + authtype + '\'' +
                    ", chat_addr_list=" + chat_addr_list +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "LiveChatInfoBean{" +
                "errno=" + errno +
                ", errmsg='" + errmsg + '\'' +
                ", data=" + data +
                ", authseq='" + authseq + '\'' +
                '}';
    }
}
