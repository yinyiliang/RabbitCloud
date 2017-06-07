package yyl.rabbitcloud.bean;

import java.util.List;

/**
 * Created by yyl on 2017/6/2.
 */

public class SearchRoomBean {

    /**
     * errno : 0
     * errmsg :
     * data : {"items":[{"bamboos":"17671020","class":"yzdr","classification":"熊猫星秀",
     * "fans":"19157","hostid":"75321686","name":"不忘初心","nickname":"super吴大仙",
     * "person_num":"8662","pictures":{"img":"http://i5.pdim
     * .gs/90/fa57fd0fc8e0bc74f44f4165b2a2fc8b/w338/h190.jpg","qrcode":"http://i6.pdim
     * .gs/552ec7cfa322cccc029985b09b8df46d.png"},"province":"110000","reliable":"2",
     * "roomid":"821175","sex":"0","show_pos":1,"status":"2","stream_status":1,
     * "time":"2017-05-09T23:53:34.141+0800","display_type":"1","tag":"","tag_switch":"1",
     * "tag_color":"1","style_type":"1","userinfo":{"nickName":"super吴大仙","rid":75321686,
     * "avatar":"http://i5.pdim.gs/e692d188e846425684491441cca51112.jpg","userName":""}}],
     * "total":"1"}
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
         * items : [{"bamboos":"17671020","class":"yzdr","classification":"熊猫星秀","fans":"19157",
         * "hostid":"75321686","name":"不忘初心","nickname":"super吴大仙","person_num":"8662",
         * "pictures":{"img":"http://i5.pdim
         * .gs/90/fa57fd0fc8e0bc74f44f4165b2a2fc8b/w338/h190.jpg","qrcode":"http://i6.pdim
         * .gs/552ec7cfa322cccc029985b09b8df46d.png"},"province":"110000","reliable":"2",
         * "roomid":"821175","sex":"0","show_pos":1,"status":"2","stream_status":1,
         * "time":"2017-05-09T23:53:34.141+0800","display_type":"1","tag":"","tag_switch":"1",
         * "tag_color":"1","style_type":"1","userinfo":{"nickName":"super吴大仙","rid":75321686,
         * "avatar":"http://i5.pdim.gs/e692d188e846425684491441cca51112.jpg","userName":""}}]
         * total : 1
         */

        private String total;
        private List<ItemsBean> items;

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }

        public List<ItemsBean> getItems() {
            return items;
        }

        public void setItems(List<ItemsBean> items) {
            this.items = items;
        }

        public static class ItemsBean {
            /**
             * bamboos : 17671020
             * class : yzdr
             * classification : 熊猫星秀
             * fans : 19157
             * hostid : 75321686
             * name : 不忘初心
             * nickname : super吴大仙
             * person_num : 8662
             * pictures : {"img":"http://i5.pdim
             * .gs/90/fa57fd0fc8e0bc74f44f4165b2a2fc8b/w338/h190.jpg","qrcode":"http://i6.pdim
             * .gs/552ec7cfa322cccc029985b09b8df46d.png"}
             * province : 110000
             * reliable : 2
             * roomid : 821175
             * sex : 0
             * show_pos : 1
             * status : 2
             * stream_status : 1
             * time : 2017-05-09T23:53:34.141+0800
             * display_type : 1
             * tag :
             * tag_switch : 1
             * tag_color : 1
             * style_type : 1
             * userinfo : {"nickName":"super吴大仙","rid":75321686,"avatar":"http://i5.pdim
             * .gs/e692d188e846425684491441cca51112.jpg","userName":""}
             */

            private String bamboos;
            private String classX;
            private String classification;
            private String fans;
            private String hostid;
            private String name;
            private String nickname;
            private String person_num;
            private PicturesBean pictures;
            private String province;
            private String reliable;
            private String roomid;
            private String sex;
            private int show_pos;
            private String status;
            private int stream_status;
            private String time;
            private String display_type;
            private String tag;
            private String tag_switch;
            private String tag_color;
            private String style_type;
            private UserinfoBean userinfo;

            public String getBamboos() {
                return bamboos;
            }

            public void setBamboos(String bamboos) {
                this.bamboos = bamboos;
            }

            public String getClassX() {
                return classX;
            }

            public void setClassX(String classX) {
                this.classX = classX;
            }

            public String getClassification() {
                return classification;
            }

            public void setClassification(String classification) {
                this.classification = classification;
            }

            public String getFans() {
                return fans;
            }

            public void setFans(String fans) {
                this.fans = fans;
            }

            public String getHostid() {
                return hostid;
            }

            public void setHostid(String hostid) {
                this.hostid = hostid;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getPerson_num() {
                return person_num;
            }

            public void setPerson_num(String person_num) {
                this.person_num = person_num;
            }

            public PicturesBean getPictures() {
                return pictures;
            }

            public void setPictures(PicturesBean pictures) {
                this.pictures = pictures;
            }

            public String getProvince() {
                return province;
            }

            public void setProvince(String province) {
                this.province = province;
            }

            public String getReliable() {
                return reliable;
            }

            public void setReliable(String reliable) {
                this.reliable = reliable;
            }

            public String getRoomid() {
                return roomid;
            }

            public void setRoomid(String roomid) {
                this.roomid = roomid;
            }

            public String getSex() {
                return sex;
            }

            public void setSex(String sex) {
                this.sex = sex;
            }

            public int getShow_pos() {
                return show_pos;
            }

            public void setShow_pos(int show_pos) {
                this.show_pos = show_pos;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public int getStream_status() {
                return stream_status;
            }

            public void setStream_status(int stream_status) {
                this.stream_status = stream_status;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public String getDisplay_type() {
                return display_type;
            }

            public void setDisplay_type(String display_type) {
                this.display_type = display_type;
            }

            public String getTag() {
                return tag;
            }

            public void setTag(String tag) {
                this.tag = tag;
            }

            public String getTag_switch() {
                return tag_switch;
            }

            public void setTag_switch(String tag_switch) {
                this.tag_switch = tag_switch;
            }

            public String getTag_color() {
                return tag_color;
            }

            public void setTag_color(String tag_color) {
                this.tag_color = tag_color;
            }

            public String getStyle_type() {
                return style_type;
            }

            public void setStyle_type(String style_type) {
                this.style_type = style_type;
            }

            public UserinfoBean getUserinfo() {
                return userinfo;
            }

            public void setUserinfo(UserinfoBean userinfo) {
                this.userinfo = userinfo;
            }

            public static class PicturesBean {
                /**
                 * img : http://i5.pdim.gs/90/fa57fd0fc8e0bc74f44f4165b2a2fc8b/w338/h190.jpg
                 * qrcode : http://i6.pdim.gs/552ec7cfa322cccc029985b09b8df46d.png
                 */

                private String img;
                private String qrcode;

                public String getImg() {
                    return img;
                }

                public void setImg(String img) {
                    this.img = img;
                }

                public String getQrcode() {
                    return qrcode;
                }

                public void setQrcode(String qrcode) {
                    this.qrcode = qrcode;
                }
            }

            public static class UserinfoBean {
                /**
                 * nickName : super吴大仙
                 * rid : 75321686
                 * avatar : http://i5.pdim.gs/e692d188e846425684491441cca51112.jpg
                 * userName :
                 */

                private String nickName;
                private int rid;
                private String avatar;
                private String userName;

                public String getNickName() {
                    return nickName;
                }

                public void setNickName(String nickName) {
                    this.nickName = nickName;
                }

                public int getRid() {
                    return rid;
                }

                public void setRid(int rid) {
                    this.rid = rid;
                }

                public String getAvatar() {
                    return avatar;
                }

                public void setAvatar(String avatar) {
                    this.avatar = avatar;
                }

                public String getUserName() {
                    return userName;
                }

                public void setUserName(String userName) {
                    this.userName = userName;
                }
            }
        }
    }
}
