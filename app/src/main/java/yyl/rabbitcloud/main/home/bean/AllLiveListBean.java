package yyl.rabbitcloud.main.home.bean;

import java.util.List;

/**
 * Created by yyl on 2017/7/4.
 */

public class AllLiveListBean {

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
             * id : 237908
             * name : 老刘：刘莱厄斯怒冲王者！
             * hostid : 24872350
             * person_num : 182447
             * classification : lol
             * pictures : {"img":"http://i9.pdim
             * .gs/90/0b3cd674e7614fca1bd24c81ec4ac7fa/w338/h190.jpg"}
             * display_type : 1
             * tag :
             * tag_switch : 1
             * tag_color : 1
             * style_type : 1
             * reliable : 1
             * status : 2
             * stream_status : 1
             * createtime : 2015-12-30 04:44:08
             * start_time : 1499128889
             * schedule : 1457226000
             * level : 9
             * room_key :
             * fans : 0
             * userinfo : {"nickName":"旋转的老刘诺手","rid":24872350,"avatar":"http://i9.pdim
             * .gs/29477546afa44e466ba958c682ecb844.jpg","userName":""}
             * announcement :
             * duration : 13652
             * click_trace : alllist
             */

            private String id;
            private String name;
            private String hostid;
            private String person_num;
            private String classification;
            private PicturesBean pictures;
            private String display_type;
            private String tag;
            private String tag_switch;
            private String tag_color;
            private String style_type;
            private String reliable;
            private String status;
            private String stream_status;
            private String createtime;
            private String start_time;
            private String schedule;
            private String level;
            private String room_key;
            private String fans;
            private UserinfoBean userinfo;
            private String announcement;
            private String duration;
            private String click_trace;

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

            public String getClassification() {
                return classification;
            }

            public void setClassification(String classification) {
                this.classification = classification;
            }

            public PicturesBean getPictures() {
                return pictures;
            }

            public void setPictures(PicturesBean pictures) {
                this.pictures = pictures;
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

            public String getReliable() {
                return reliable;
            }

            public void setReliable(String reliable) {
                this.reliable = reliable;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getStream_status() {
                return stream_status;
            }

            public void setStream_status(String stream_status) {
                this.stream_status = stream_status;
            }

            public String getCreatetime() {
                return createtime;
            }

            public void setCreatetime(String createtime) {
                this.createtime = createtime;
            }

            public String getStart_time() {
                return start_time;
            }

            public void setStart_time(String start_time) {
                this.start_time = start_time;
            }

            public String getSchedule() {
                return schedule;
            }

            public void setSchedule(String schedule) {
                this.schedule = schedule;
            }

            public String getLevel() {
                return level;
            }

            public void setLevel(String level) {
                this.level = level;
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

            public String getAnnouncement() {
                return announcement;
            }

            public void setAnnouncement(String announcement) {
                this.announcement = announcement;
            }

            public String getDuration() {
                return duration;
            }

            public void setDuration(String duration) {
                this.duration = duration;
            }

            public String getClick_trace() {
                return click_trace;
            }

            public void setClick_trace(String click_trace) {
                this.click_trace = click_trace;
            }

            public static class PicturesBean {
                /**
                 * img : http://i9.pdim.gs/90/0b3cd674e7614fca1bd24c81ec4ac7fa/w338/h190.jpg
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
                 * nickName : 旋转的老刘诺手
                 * rid : 24872350
                 * avatar : http://i9.pdim.gs/29477546afa44e466ba958c682ecb844.jpg
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
