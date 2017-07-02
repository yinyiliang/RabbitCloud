package yyl.rabbitcloud.liveroom.bean;

/**
 * Created by yyl on 2017/6/28.
 */

public class DanMuDataBean {


    /**
     * from : {"identity":"30","nickName":"PatrickCN","badge":"","rid":"6193824","msgcolor":"",
     * "level":"2","sp_identity":"0","__plat":"pc_web","userName":""}
     * to : {"toroom":"615017"}
     * content : 这个打字是用了洪荒之力啊
     */

    private FromBean from;
    private ToBean to;
    private String content;

    public FromBean getFrom() {
        return from;
    }

    public void setFrom(FromBean from) {
        this.from = from;
    }

    public ToBean getTo() {
        return to;
    }

    public void setTo(ToBean to) {
        this.to = to;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public static class FromBean {
        /**
         * identity : 30
         * nickName : PatrickCN
         * badge :
         * rid : 6193824
         * msgcolor :
         * level : 2
         * sp_identity : 0
         * __plat : pc_web
         * userName :
         */

        private String identity;
        private String nickName;
        private String badge;
        private String rid;
        private String msgcolor;
        private String level;
        private String sp_identity;
        private String __plat;
        private String userName;

        public String getIdentity() {
            return identity;
        }

        public void setIdentity(String identity) {
            this.identity = identity;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getBadge() {
            return badge;
        }

        public void setBadge(String badge) {
            this.badge = badge;
        }

        public String getRid() {
            return rid;
        }

        public void setRid(String rid) {
            this.rid = rid;
        }

        public String getMsgcolor() {
            return msgcolor;
        }

        public void setMsgcolor(String msgcolor) {
            this.msgcolor = msgcolor;
        }

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        public String getSp_identity() {
            return sp_identity;
        }

        public void setSp_identity(String sp_identity) {
            this.sp_identity = sp_identity;
        }

        public String get__plat() {
            return __plat;
        }

        public void set__plat(String __plat) {
            this.__plat = __plat;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }
    }

    public static class ToBean {
        /**
         * toroom : 615017
         */

        private String toroom;

        public String getToroom() {
            return toroom;
        }

        public void setToroom(String toroom) {
            this.toroom = toroom;
        }
    }
}
