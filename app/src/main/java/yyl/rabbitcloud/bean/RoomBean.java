package yyl.rabbitcloud.bean;

import java.util.List;

/**
 * 所有类型的Bean类
 * Created by yyl on 2017/6/2.
 */

public class RoomBean {


    /**
     * errno : 0
     * errmsg :
     * data : {"items":[{"id":"821175","ver":"1","createtime":"2017-02-28 13:34:38",
     * "updatetime":"2017-06-02 10:40:13","name":"不忘初心","hostid":"75321686","person_num":"8696",
     * "announcement":"","classification":{"cname":"熊猫星秀","ename":"yzdr"},
     * "pictures":{"img":"http://i6.pdim.gs/90/eff430350b730d6ea948007c53fd5faa/w338/h190.jpg"},
     * "status":"2","start_time":"1496367908","end_time":"1496305385","duration":"3486",
     * "schedule":"0","remind_switch":"2","remind_content":"","level":"1","stream_status":"1",
     * "classify_switch":"1","reliable":"2","banned_reason":"","unlock_time":"0",
     * "speak_interval":"2","person_num_thres":"","reduce_ratio":"","person_switch":"",
     * "watermark_switch":"2","watermark_loc":"1","account_status":"1","person_src":"1",
     * "display_type":"1","tag":"","tag_switch":"1","tag_color":"1","rcmd_ratio":"",
     * "show_pos":"1","rtype_usable":"1","room_type":"1","rtype_value":"","style_type":"1",
     * "cdn_rate":"0","cover_switch":"0","room_key":"1d0bf2e02a6000a24e7c0b463395a010",
     * "fans":"0","userinfo":{"nickName":"super吴大仙","rid":75321686,"avatar":"http://i5.pdim
     * .gs/e692d188e846425684491441cca51112.jpg","userName":""}},{"id":"761620","ver":"1",
     * "createtime":"2017-02-12 23:45:29","updatetime":"2017-06-02 10:40:26","name":"勤快的涵宝宝上线啦
     * ~","hostid":"72809970","person_num":"104","announcement":"",
     * "classification":{"cname":"熊猫星秀","ename":"yzdr"},"pictures":{"img":"http://i6.pdim
     * .gs/90/1189be9857fdfa7b4acd0927bc5898ff/w338/h190.jpg"},"status":"2",
     * "start_time":"1496365399","end_time":"1496328469","duration":"5995","schedule":"0",
     * "remind_switch":"2","remind_content":"","level":"1","stream_status":"1",
     * "classify_switch":"1","reliable":"1","banned_reason":"","unlock_time":"0",
     * "speak_interval":"2","person_num_thres":"","reduce_ratio":"","person_switch":"",
     * "watermark_switch":"2","watermark_loc":"1","account_status":"1","person_src":"2",
     * "display_type":"1","tag":"","tag_switch":"1","tag_color":"1","rcmd_ratio":"",
     * "show_pos":"1","rtype_usable":"1","room_type":"1","rtype_value":"","style_type":"1",
     * "cdn_rate":"0","cover_switch":"0","room_key":"cfeef2f69e8f7cc49e6eec9627d7f709",
     * "fans":"0","userinfo":{"nickName":"酱麻麻","rid":72809970,"avatar":"http://i6.pdim
     * .gs/8ab9a2bf44388d737ae8a8ce4abfbf1e.jpeg","userName":""}},{"id":"435911",
     * "name":"进棚录音，让破音更猛烈些吧。","hostid":"31250832","person_num":"30992",
     * "classification":{"cname":"熊猫星秀","ename":"yzdr"},"pictures":{"img":"http://i9.pdim
     * .gs/90/3116806fb0ae6d9ab5f2f7b441436125/w338/h190.jpg"},"display_type":"1","tag":"",
     * "tag_switch":"1","tag_color":"1","style_type":"1","reliable":"1","status":"2",
     * "stream_status":"1","createtime":"2016-06-20 03:04:20","start_time":"1496371380",
     * "schedule":"0","level":"9","room_key":"","fans":"0","userinfo":{"nickName":"小丸子UuQ",
     * "rid":31250832,"avatar":"http://i8.pdim.gs/1d00091927eb43ed853b3f93292036e5.jpg",
     * "userName":""},"announcement":"","duration":"14"},{"id":"491124","name":"快进来，看我发现了什么！",
     * "hostid":"39039264","person_num":"15072","classification":{"cname":"熊猫星秀","ename":"yzdr"},
     * "pictures":{"img":"http://i8.pdim.gs/90/7c9e1e15f002da936cbd1bb295524078/w338/h190.jpg"},
     * "display_type":"1","tag":"","tag_switch":"1","tag_color":"1","style_type":"1",
     * "reliable":"1","status":"2","stream_status":"1","createtime":"2016-08-09 17:57:02",
     * "start_time":"1496366906","schedule":"0","level":"9","room_key":"","fans":"0",
     * "userinfo":{"nickName":"暴走漫画","rid":39039264,"avatar":"http://i9.pdim
     * .gs/f91ee31ecb93550cadc8d0bfd87eec18.jpeg","userName":""},"announcement":"",
     * "duration":"4488"}],"total":"97","type":{"ename":"yzdr","cname":"熊猫星秀"}}
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
         * items : [{"id":"821175","ver":"1","createtime":"2017-02-28 13:34:38",
         * "updatetime":"2017-06-02 10:40:13","name":"不忘初心","hostid":"75321686",
         * "person_num":"8696","announcement":"","classification":{"cname":"熊猫星秀",
         * "ename":"yzdr"},"pictures":{"img":"http://i6.pdim
         * .gs/90/eff430350b730d6ea948007c53fd5faa/w338/h190.jpg"},"status":"2",
         * "start_time":"1496367908","end_time":"1496305385","duration":"3486","schedule":"0",
         * "remind_switch":"2","remind_content":"","level":"1","stream_status":"1",
         * "classify_switch":"1","reliable":"2","banned_reason":"","unlock_time":"0",
         * "speak_interval":"2","person_num_thres":"","reduce_ratio":"","person_switch":"",
         * "watermark_switch":"2","watermark_loc":"1","account_status":"1","person_src":"1",
         * "display_type":"1","tag":"","tag_switch":"1","tag_color":"1","rcmd_ratio":"",
         * "show_pos":"1","rtype_usable":"1","room_type":"1","rtype_value":"","style_type":"1",
         * "cdn_rate":"0","cover_switch":"0","room_key":"1d0bf2e02a6000a24e7c0b463395a010",
         * "fans":"0","userinfo":{"nickName":"super吴大仙","rid":75321686,"avatar":"http://i5.pdim
         * .gs/e692d188e846425684491441cca51112.jpg","userName":""}},{"id":"761620","ver":"1",
         * "createtime":"2017-02-12 23:45:29","updatetime":"2017-06-02 10:40:26",
         * "name":"勤快的涵宝宝上线啦  ~","hostid":"72809970","person_num":"104","announcement":"",
         * "classification":{"cname":"熊猫星秀","ename":"yzdr"},"pictures":{"img":"http://i6.pdim
         * .gs/90/1189be9857fdfa7b4acd0927bc5898ff/w338/h190.jpg"},"status":"2",
         * "start_time":"1496365399","end_time":"1496328469","duration":"5995","schedule":"0",
         * "remind_switch":"2","remind_content":"","level":"1","stream_status":"1",
         * "classify_switch":"1","reliable":"1","banned_reason":"","unlock_time":"0",
         * "speak_interval":"2","person_num_thres":"","reduce_ratio":"","person_switch":"",
         * "watermark_switch":"2","watermark_loc":"1","account_status":"1","person_src":"2",
         * "display_type":"1","tag":"","tag_switch":"1","tag_color":"1","rcmd_ratio":"",
         * "show_pos":"1","rtype_usable":"1","room_type":"1","rtype_value":"","style_type":"1",
         * "cdn_rate":"0","cover_switch":"0","room_key":"cfeef2f69e8f7cc49e6eec9627d7f709",
         * "fans":"0","userinfo":{"nickName":"酱麻麻","rid":72809970,"avatar":"http://i6.pdim
         * .gs/8ab9a2bf44388d737ae8a8ce4abfbf1e.jpeg","userName":""}},{"id":"435911",
         * "name":"进棚录音，让破音更猛烈些吧。","hostid":"31250832","person_num":"30992",
         * "classification":{"cname":"熊猫星秀","ename":"yzdr"},"pictures":{"img":"http://i9.pdim
         * .gs/90/3116806fb0ae6d9ab5f2f7b441436125/w338/h190.jpg"},"display_type":"1","tag":"",
         * "tag_switch":"1","tag_color":"1","style_type":"1","reliable":"1","status":"2",
         * "stream_status":"1","createtime":"2016-06-20 03:04:20","start_time":"1496371380",
         * "schedule":"0","level":"9","room_key":"","fans":"0","userinfo":{"nickName":"小丸子UuQ",
         * "rid":31250832,"avatar":"http://i8.pdim.gs/1d00091927eb43ed853b3f93292036e5.jpg",
         * "userName":""},"announcement":"","duration":"14"},{"id":"491124",
         * "name":"快进来，看我发现了什么！","hostid":"39039264","person_num":"15072",
         * "classification":{"cname":"熊猫星秀","ename":"yzdr"},"pictures":{"img":"http://i8.pdim
         * .gs/90/7c9e1e15f002da936cbd1bb295524078/w338/h190.jpg"},"display_type":"1","tag":"",
         * "tag_switch":"1","tag_color":"1","style_type":"1","reliable":"1","status":"2",
         * "stream_status":"1","createtime":"2016-08-09 17:57:02","start_time":"1496366906",
         * "schedule":"0","level":"9","room_key":"","fans":"0","userinfo":{"nickName":"暴走漫画",
         * "rid":39039264,"avatar":"http://i9.pdim.gs/f91ee31ecb93550cadc8d0bfd87eec18.jpeg",
         * "userName":""},"announcement":"","duration":"4488"}]
         * total : 97
         * type : {"ename":"yzdr","cname":"熊猫星秀"}
         */

        private String total;
        private TypeBean type;
        private List<ItemsBean> items;

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }

        public TypeBean getType() {
            return type;
        }

        public void setType(TypeBean type) {
            this.type = type;
        }

        public List<ItemsBean> getItems() {
            return items;
        }

        public void setItems(List<ItemsBean> items) {
            this.items = items;
        }

        public static class TypeBean {
            /**
             * ename : yzdr
             * cname : 熊猫星秀
             */

            private String ename;
            private String cname;

            public String getEname() {
                return ename;
            }

            public void setEname(String ename) {
                this.ename = ename;
            }

            public String getCname() {
                return cname;
            }

            public void setCname(String cname) {
                this.cname = cname;
            }
        }

        public static class ItemsBean {
            /**
             * id : 821175
             * ver : 1
             * createtime : 2017-02-28 13:34:38
             * updatetime : 2017-06-02 10:40:13
             * name : 不忘初心
             * hostid : 75321686
             * person_num : 8696
             * announcement :
             * classification : {"cname":"熊猫星秀","ename":"yzdr"}
             * pictures : {"img":"http://i6.pdim
             * .gs/90/eff430350b730d6ea948007c53fd5faa/w338/h190.jpg"}
             * status : 2
             * start_time : 1496367908
             * end_time : 1496305385
             * duration : 3486
             * schedule : 0
             * remind_switch : 2
             * remind_content :
             * level : 1
             * stream_status : 1
             * classify_switch : 1
             * reliable : 2
             * banned_reason :
             * unlock_time : 0
             * speak_interval : 2
             * person_num_thres :
             * reduce_ratio :
             * person_switch :
             * watermark_switch : 2
             * watermark_loc : 1
             * account_status : 1
             * person_src : 1
             * display_type : 1
             * tag :
             * tag_switch : 1
             * tag_color : 1
             * rcmd_ratio :
             * show_pos : 1
             * rtype_usable : 1
             * room_type : 1
             * rtype_value :
             * style_type : 1
             * cdn_rate : 0
             * cover_switch : 0
             * room_key : 1d0bf2e02a6000a24e7c0b463395a010
             * fans : 0
             * userinfo : {"nickName":"super吴大仙","rid":75321686,"avatar":"http://i5.pdim
             * .gs/e692d188e846425684491441cca51112.jpg","userName":""}
             */

            private String id;
            private String ver;
            private String createtime;
            private String updatetime;
            private String name;
            private String hostid;
            private String person_num;
            private String announcement;
            private ClassificationBean classification;
            private PicturesBean pictures;
            private String status;
            private String start_time;
            private String end_time;
            private String duration;
            private String schedule;
            private String remind_switch;
            private String remind_content;
            private String level;
            private String stream_status;
            private String classify_switch;
            private String reliable;
            private String banned_reason;
            private String unlock_time;
            private String speak_interval;
            private String person_num_thres;
            private String reduce_ratio;
            private String person_switch;
            private String watermark_switch;
            private String watermark_loc;
            private String account_status;
            private String person_src;
            private String display_type;
            private String tag;
            private String tag_switch;
            private String tag_color;
            private String rcmd_ratio;
            private String show_pos;
            private String rtype_usable;
            private String room_type;
            private String rtype_value;
            private String style_type;
            private String cdn_rate;
            private String cover_switch;
            private String room_key;
            private String fans;
            private UserinfoBean userinfo;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getVer() {
                return ver;
            }

            public void setVer(String ver) {
                this.ver = ver;
            }

            public String getCreatetime() {
                return createtime;
            }

            public void setCreatetime(String createtime) {
                this.createtime = createtime;
            }

            public String getUpdatetime() {
                return updatetime;
            }

            public void setUpdatetime(String updatetime) {
                this.updatetime = updatetime;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getHostid() {
                return hostid;
            }

            public void setHostid(String hostid) {
                this.hostid = hostid;
            }

            public String getPerson_num() {
                return person_num;
            }

            public void setPerson_num(String person_num) {
                this.person_num = person_num;
            }

            public String getAnnouncement() {
                return announcement;
            }

            public void setAnnouncement(String announcement) {
                this.announcement = announcement;
            }

            public ClassificationBean getClassification() {
                return classification;
            }

            public void setClassification(ClassificationBean classification) {
                this.classification = classification;
            }

            public PicturesBean getPictures() {
                return pictures;
            }

            public void setPictures(PicturesBean pictures) {
                this.pictures = pictures;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getStart_time() {
                return start_time;
            }

            public void setStart_time(String start_time) {
                this.start_time = start_time;
            }

            public String getEnd_time() {
                return end_time;
            }

            public void setEnd_time(String end_time) {
                this.end_time = end_time;
            }

            public String getDuration() {
                return duration;
            }

            public void setDuration(String duration) {
                this.duration = duration;
            }

            public String getSchedule() {
                return schedule;
            }

            public void setSchedule(String schedule) {
                this.schedule = schedule;
            }

            public String getRemind_switch() {
                return remind_switch;
            }

            public void setRemind_switch(String remind_switch) {
                this.remind_switch = remind_switch;
            }

            public String getRemind_content() {
                return remind_content;
            }

            public void setRemind_content(String remind_content) {
                this.remind_content = remind_content;
            }

            public String getLevel() {
                return level;
            }

            public void setLevel(String level) {
                this.level = level;
            }

            public String getStream_status() {
                return stream_status;
            }

            public void setStream_status(String stream_status) {
                this.stream_status = stream_status;
            }

            public String getClassify_switch() {
                return classify_switch;
            }

            public void setClassify_switch(String classify_switch) {
                this.classify_switch = classify_switch;
            }

            public String getReliable() {
                return reliable;
            }

            public void setReliable(String reliable) {
                this.reliable = reliable;
            }

            public String getBanned_reason() {
                return banned_reason;
            }

            public void setBanned_reason(String banned_reason) {
                this.banned_reason = banned_reason;
            }

            public String getUnlock_time() {
                return unlock_time;
            }

            public void setUnlock_time(String unlock_time) {
                this.unlock_time = unlock_time;
            }

            public String getSpeak_interval() {
                return speak_interval;
            }

            public void setSpeak_interval(String speak_interval) {
                this.speak_interval = speak_interval;
            }

            public String getPerson_num_thres() {
                return person_num_thres;
            }

            public void setPerson_num_thres(String person_num_thres) {
                this.person_num_thres = person_num_thres;
            }

            public String getReduce_ratio() {
                return reduce_ratio;
            }

            public void setReduce_ratio(String reduce_ratio) {
                this.reduce_ratio = reduce_ratio;
            }

            public String getPerson_switch() {
                return person_switch;
            }

            public void setPerson_switch(String person_switch) {
                this.person_switch = person_switch;
            }

            public String getWatermark_switch() {
                return watermark_switch;
            }

            public void setWatermark_switch(String watermark_switch) {
                this.watermark_switch = watermark_switch;
            }

            public String getWatermark_loc() {
                return watermark_loc;
            }

            public void setWatermark_loc(String watermark_loc) {
                this.watermark_loc = watermark_loc;
            }

            public String getAccount_status() {
                return account_status;
            }

            public void setAccount_status(String account_status) {
                this.account_status = account_status;
            }

            public String getPerson_src() {
                return person_src;
            }

            public void setPerson_src(String person_src) {
                this.person_src = person_src;
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

            public String getRcmd_ratio() {
                return rcmd_ratio;
            }

            public void setRcmd_ratio(String rcmd_ratio) {
                this.rcmd_ratio = rcmd_ratio;
            }

            public String getShow_pos() {
                return show_pos;
            }

            public void setShow_pos(String show_pos) {
                this.show_pos = show_pos;
            }

            public String getRtype_usable() {
                return rtype_usable;
            }

            public void setRtype_usable(String rtype_usable) {
                this.rtype_usable = rtype_usable;
            }

            public String getRoom_type() {
                return room_type;
            }

            public void setRoom_type(String room_type) {
                this.room_type = room_type;
            }

            public String getRtype_value() {
                return rtype_value;
            }

            public void setRtype_value(String rtype_value) {
                this.rtype_value = rtype_value;
            }

            public String getStyle_type() {
                return style_type;
            }

            public void setStyle_type(String style_type) {
                this.style_type = style_type;
            }

            public String getCdn_rate() {
                return cdn_rate;
            }

            public void setCdn_rate(String cdn_rate) {
                this.cdn_rate = cdn_rate;
            }

            public String getCover_switch() {
                return cover_switch;
            }

            public void setCover_switch(String cover_switch) {
                this.cover_switch = cover_switch;
            }

            public String getRoom_key() {
                return room_key;
            }

            public void setRoom_key(String room_key) {
                this.room_key = room_key;
            }

            public String getFans() {
                return fans;
            }

            public void setFans(String fans) {
                this.fans = fans;
            }

            public UserinfoBean getUserinfo() {
                return userinfo;
            }

            public void setUserinfo(UserinfoBean userinfo) {
                this.userinfo = userinfo;
            }

            public static class ClassificationBean {
                /**
                 * cname : 熊猫星秀
                 * ename : yzdr
                 */

                private String cname;
                private String ename;

                public String getCname() {
                    return cname;
                }

                public void setCname(String cname) {
                    this.cname = cname;
                }

                public String getEname() {
                    return ename;
                }

                public void setEname(String ename) {
                    this.ename = ename;
                }
            }

            public static class PicturesBean {
                /**
                 * img : http://i6.pdim.gs/90/eff430350b730d6ea948007c53fd5faa/w338/h190.jpg
                 */

                private String img;

                public String getImg() {
                    return img;
                }

                public void setImg(String img) {
                    this.img = img;
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
