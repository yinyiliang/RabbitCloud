package yyl.rabbitcloud.main.home.bean;

import java.util.List;

/**
 * Created by yyl on 2017/7/4.
 */

public class RecommendHeaderBean {

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
        private List<BannersBean> banners;
        private List<NavsBean> navs;

        public List<BannersBean> getBanners() {
            return banners;
        }

        public void setBanners(List<BannersBean> banners) {
            this.banners = banners;
        }

        public List<NavsBean> getNavs() {
            return navs;
        }

        public void setNavs(List<NavsBean> navs) {
            this.navs = navs;
        }

        public static class BannersBean {
            /**
             * img : http://i7.pdim.gs/76c527b898a3cad1d57295302a8b72e8.jpeg
             * url : http://img.yoyojie.com/templates/default/download/tlbb/
             * title :
             * type : 3
             * click_trace : banners_index
             * roomid : 1094979
             * display_type : 1
             * style_type : 1
             */

            private String img;
            private String url;
            private String title;
            private String type;
            private String click_trace;
            private String roomid;
            private String display_type;
            private String style_type;

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getClick_trace() {
                return click_trace;
            }

            public void setClick_trace(String click_trace) {
                this.click_trace = click_trace;
            }

            public String getRoomid() {
                return roomid;
            }

            public void setRoomid(String roomid) {
                this.roomid = roomid;
            }

            public String getDisplay_type() {
                return display_type;
            }

            public void setDisplay_type(String display_type) {
                this.display_type = display_type;
            }

            public String getStyle_type() {
                return style_type;
            }

            public void setStyle_type(String style_type) {
                this.style_type = style_type;
            }

            @Override
            public String toString() {
                return "BannersBean{" +
                        "img='" + img + '\'' +
                        ", url='" + url + '\'' +
                        ", title='" + title + '\'' +
                        ", type='" + type + '\'' +
                        ", click_trace='" + click_trace + '\'' +
                        ", roomid='" + roomid + '\'' +
                        ", display_type='" + display_type + '\'' +
                        ", style_type='" + style_type + '\'' +
                        '}';
            }
        }

        public static class NavsBean {
            /**
             * type : 4
             * img : http://i6.pdim.gs/113b4716cb11efc0dbeab03ec9f87150.png
             * title : 英雄联盟
             * url : pandatv://cate/lol?title=英雄联盟
             * click_trace : navs_index
             */

            private String type;
            private String img;
            private String title;
            private String url;
            private String click_trace;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getClick_trace() {
                return click_trace;
            }

            public void setClick_trace(String click_trace) {
                this.click_trace = click_trace;
            }

            @Override
            public String toString() {
                return "NavsBean{" +
                        "type='" + type + '\'' +
                        ", img='" + img + '\'' +
                        ", title='" + title + '\'' +
                        ", url='" + url + '\'' +
                        ", click_trace='" + click_trace + '\'' +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "banners=" + banners +
                    ", navs=" + navs +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "RecommendHeaderBean{" +
                "errno=" + errno +
                ", errmsg='" + errmsg + '\'' +
                ", data=" + data +
                ", authseq='" + authseq + '\'' +
                '}';
    }
}
