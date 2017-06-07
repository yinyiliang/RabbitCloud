package yyl.rabbitcloud.bean;

/**
 * 闪屏页Bean类
 * Created by yyl on 2017/6/2.
 */

public class SplashScreenBean {

    /**
     * errno : 0
     * errmsg :
     * data : {"title":"","imgurl":"","linkurl":"","actiontype":"5","delaytime":"3000",
     * "starttime":"","endtime":"","web":{"title":"","starttime":"","endtime":"","count":"",
     * "linkurl":""},"rmddata":{"img":"http://i7.pdim.gs/9ab34c204005120652fc13fb316548c3.gif",
     * "text":{"title":"\u201c正义的地球人，举起你们的双手！\u201d","from":"熊猫主播","role":"SOL君"}}}
     * authseq :
     */

    private String errno;
    private String errmsg;
    private DataBean data;
    private String authseq;

    public String getErrno() {
        return errno;
    }

    public void setErrno(String errno) {
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
         * title :
         * imgurl :
         * linkurl :
         * actiontype : 5
         * delaytime : 3000
         * starttime :
         * endtime :
         * web : {"title":"","starttime":"","endtime":"","count":"","linkurl":""}
         * rmddata : {"img":"http://i7.pdim.gs/9ab34c204005120652fc13fb316548c3.gif",
         * "text":{"title":"\u201c正义的地球人，举起你们的双手！\u201d","from":"熊猫主播","role":"SOL君"}}
         */

        private String title;
        private String imgurl;
        private String linkurl;
        private String actiontype;
        private String delaytime;
        private String starttime;
        private String endtime;
        private WebBean web;
        private RmddataBean rmddata;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getImgurl() {
            return imgurl;
        }

        public void setImgurl(String imgurl) {
            this.imgurl = imgurl;
        }

        public String getLinkurl() {
            return linkurl;
        }

        public void setLinkurl(String linkurl) {
            this.linkurl = linkurl;
        }

        public String getActiontype() {
            return actiontype;
        }

        public void setActiontype(String actiontype) {
            this.actiontype = actiontype;
        }

        public String getDelaytime() {
            return delaytime;
        }

        public void setDelaytime(String delaytime) {
            this.delaytime = delaytime;
        }

        public String getStarttime() {
            return starttime;
        }

        public void setStarttime(String starttime) {
            this.starttime = starttime;
        }

        public String getEndtime() {
            return endtime;
        }

        public void setEndtime(String endtime) {
            this.endtime = endtime;
        }

        public WebBean getWeb() {
            return web;
        }

        public void setWeb(WebBean web) {
            this.web = web;
        }

        public RmddataBean getRmddata() {
            return rmddata;
        }

        public void setRmddata(RmddataBean rmddata) {
            this.rmddata = rmddata;
        }

        public static class WebBean {
            /**
             * title :
             * starttime :
             * endtime :
             * count :
             * linkurl :
             */

            private String title;
            private String starttime;
            private String endtime;
            private String count;
            private String linkurl;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getStarttime() {
                return starttime;
            }

            public void setStarttime(String starttime) {
                this.starttime = starttime;
            }

            public String getEndtime() {
                return endtime;
            }

            public void setEndtime(String endtime) {
                this.endtime = endtime;
            }

            public String getCount() {
                return count;
            }

            public void setCount(String count) {
                this.count = count;
            }

            public String getLinkurl() {
                return linkurl;
            }

            public void setLinkurl(String linkurl) {
                this.linkurl = linkurl;
            }
        }

        public static class RmddataBean {
            /**
             * img : http://i7.pdim.gs/9ab34c204005120652fc13fb316548c3.gif
             * text : {"title":"\u201c正义的地球人，举起你们的双手！\u201d","from":"熊猫主播","role":"SOL君"}
             */

            private String img;
            private TextBean text;

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public TextBean getText() {
                return text;
            }

            public void setText(TextBean text) {
                this.text = text;
            }

            public static class TextBean {
                /**
                 * title : “正义的地球人，举起你们的双手！”
                 * from : 熊猫主播
                 * role : SOL君
                 */

                private String title;
                private String from;
                private String role;

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getFrom() {
                    return from;
                }

                public void setFrom(String from) {
                    this.from = from;
                }

                public String getRole() {
                    return role;
                }

                public void setRole(String role) {
                    this.role = role;
                }
            }
        }
    }
}
