package yyl.rabbitcloud.main.home.bean;

import java.util.List;

/**
 * Created by yyl on 2017/7/4.
 */

public class RecommendCardListBean {

    private int errno;
    private String errmsg;
    private String authseq;
    private List<DataBean> data;

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

    public String getAuthseq() {
        return authseq;
    }

    public void setAuthseq(String authseq) {
        this.authseq = authseq;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {

        private String id;
        private String card_type;
        private String card_title;
        private String room_cate;
        private String datanum;
        private String click_trace;
        private String total;
        private List<ItemsBean> items;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCard_type() {
            return card_type;
        }

        public void setCard_type(String card_type) {
            this.card_type = card_type;
        }

        public String getCard_title() {
            return card_title;
        }

        public void setCard_title(String card_title) {
            this.card_title = card_title;
        }

        public String getRoom_cate() {
            return room_cate;
        }

        public void setRoom_cate(String room_cate) {
            this.room_cate = room_cate;
        }

        public String getDatanum() {
            return datanum;
        }

        public void setDatanum(String datanum) {
            this.datanum = datanum;
        }

        public String getClick_trace() {
            return click_trace;
        }

        public void setClick_trace(String click_trace) {
            this.click_trace = click_trace;
        }

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
             * classification : {"cname":"王者荣耀","ename":"kingglory"}
             * display_type : 1
             * img : http://i6.pdim.gs/ffe0b293b386effc5931c028d6b57077.jpeg
             * person_num : 44526
             * roomid : 847407
             * style_type : 1
             * tag :
             * tag_color : 1
             * tag_switch : 1
             * title : 国服第一射手！新赛季带一波房管
             * userinfo : {"nickName":"紅尘丶青衣","rid":34212558,"avatar":"http://i7.pdim
             * .gs/1b1456354aaf3a7801e87b955d2ef2e7.jpeg","userName":""}
             * xid : 7227979
             * streamurl : http://flv-live-qn.xingyan.panda
             * .tv/panda-xingyan/96bb8a5f626fc145ecc3ef0dd839f325.flv
             * streaminfo : {"width":"480","height":"848","decode_type":2}
             * taginfo : {"text":"","color":"","icon":""}
             * city : 成都市
             */

            private ClassificationBean classification;
            private String display_type;
            private String img;
            private String person_num;
            private String roomid;
            private String style_type;
            private String tag;
            private String tag_color;
            private String tag_switch;
            private String title;
            private UserinfoBean userinfo;
            private String xid;
            private String streamurl;
            private StreaminfoBean streaminfo;
            private TaginfoBean taginfo;
            private String city;

            public ClassificationBean getClassification() {
                return classification;
            }

            public void setClassification(ClassificationBean classification) {
                this.classification = classification;
            }

            public String getDisplay_type() {
                return display_type;
            }

            public void setDisplay_type(String display_type) {
                this.display_type = display_type;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getPerson_num() {
                return person_num;
            }

            public void setPerson_num(String person_num) {
                this.person_num = person_num;
            }

            public String getRoomid() {
                return roomid;
            }

            public void setRoomid(String roomid) {
                this.roomid = roomid;
            }

            public String getStyle_type() {
                return style_type;
            }

            public void setStyle_type(String style_type) {
                this.style_type = style_type;
            }

            public String getTag() {
                return tag;
            }

            public void setTag(String tag) {
                this.tag = tag;
            }

            public String getTag_color() {
                return tag_color;
            }

            public void setTag_color(String tag_color) {
                this.tag_color = tag_color;
            }

            public String getTag_switch() {
                return tag_switch;
            }

            public void setTag_switch(String tag_switch) {
                this.tag_switch = tag_switch;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public UserinfoBean getUserinfo() {
                return userinfo;
            }

            public void setUserinfo(UserinfoBean userinfo) {
                this.userinfo = userinfo;
            }

            public String getXid() {
                return xid;
            }

            public void setXid(String xid) {
                this.xid = xid;
            }

            public String getStreamurl() {
                return streamurl;
            }

            public void setStreamurl(String streamurl) {
                this.streamurl = streamurl;
            }

            public StreaminfoBean getStreaminfo() {
                return streaminfo;
            }

            public void setStreaminfo(StreaminfoBean streaminfo) {
                this.streaminfo = streaminfo;
            }

            public TaginfoBean getTaginfo() {
                return taginfo;
            }

            public void setTaginfo(TaginfoBean taginfo) {
                this.taginfo = taginfo;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public static class ClassificationBean {
                /**
                 * cname : 王者荣耀
                 * ename : kingglory
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

                @Override
                public String toString() {
                    return "ClassificationBean{" +
                            "cname='" + cname + '\'' +
                            ", ename='" + ename + '\'' +
                            '}';
                }
            }

            public static class UserinfoBean {
                /**
                 * nickName : 紅尘丶青衣
                 * rid : 34212558
                 * avatar : http://i7.pdim.gs/1b1456354aaf3a7801e87b955d2ef2e7.jpeg
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

                @Override
                public String toString() {
                    return "UserinfoBean{" +
                            "nickName='" + nickName + '\'' +
                            ", rid=" + rid +
                            ", avatar='" + avatar + '\'' +
                            ", userName='" + userName + '\'' +
                            '}';
                }
            }

            public static class StreaminfoBean {
                /**
                 * width : 480
                 * height : 848
                 * decode_type : 2
                 */

                private String width;
                private String height;
                private int decode_type;

                public String getWidth() {
                    return width;
                }

                public void setWidth(String width) {
                    this.width = width;
                }

                public String getHeight() {
                    return height;
                }

                public void setHeight(String height) {
                    this.height = height;
                }

                public int getDecode_type() {
                    return decode_type;
                }

                public void setDecode_type(int decode_type) {
                    this.decode_type = decode_type;
                }

                @Override
                public String toString() {
                    return "StreaminfoBean{" +
                            "width='" + width + '\'' +
                            ", height='" + height + '\'' +
                            ", decode_type=" + decode_type +
                            '}';
                }
            }

            public static class TaginfoBean {
                /**
                 * text :
                 * color :
                 * icon :
                 */

                private String text;
                private String color;
                private String icon;

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }

                public String getColor() {
                    return color;
                }

                public void setColor(String color) {
                    this.color = color;
                }

                public String getIcon() {
                    return icon;
                }

                public void setIcon(String icon) {
                    this.icon = icon;
                }

                @Override
                public String toString() {
                    return "TaginfoBean{" +
                            "text='" + text + '\'' +
                            ", color='" + color + '\'' +
                            ", icon='" + icon + '\'' +
                            '}';
                }
            }

            @Override
            public String toString() {
                return "ItemsBean{" +
                        "classification=" + classification +
                        ", display_type='" + display_type + '\'' +
                        ", img='" + img + '\'' +
                        ", person_num='" + person_num + '\'' +
                        ", roomid='" + roomid + '\'' +
                        ", style_type='" + style_type + '\'' +
                        ", tag='" + tag + '\'' +
                        ", tag_color='" + tag_color + '\'' +
                        ", tag_switch='" + tag_switch + '\'' +
                        ", title='" + title + '\'' +
                        ", userinfo=" + userinfo +
                        ", xid='" + xid + '\'' +
                        ", streamurl='" + streamurl + '\'' +
                        ", streaminfo=" + streaminfo +
                        ", taginfo=" + taginfo +
                        ", city='" + city + '\'' +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "id='" + id + '\'' +
                    ", card_type='" + card_type + '\'' +
                    ", card_title='" + card_title + '\'' +
                    ", room_cate='" + room_cate + '\'' +
                    ", datanum='" + datanum + '\'' +
                    ", click_trace='" + click_trace + '\'' +
                    ", total='" + total + '\'' +
                    ", items=" + items +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "RecommendCardListBean{" +
                "errno=" + errno +
                ", errmsg='" + errmsg + '\'' +
                ", authseq='" + authseq + '\'' +
                ", data=" + data +
                '}';
    }
}
