package yyl.rabbitcloud.main.gametype.bean;

import java.util.List;

/**
 * Created by yyl on 2017/6/20.
 */

public class CategoryGameListBean {

    private String cname;
    private String ename;
    private String img;
    private String ext;
    private String status;
    private String extra;
    private List<ChildDataBean> child_data;

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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public List<ChildDataBean> getChild_data() {
        return child_data;
    }

    public void setChild_data(List<ChildDataBean> child_data) {
        this.child_data = child_data;
    }

    public static class ChildDataBean {
        /**
         * cname : 英雄联盟
         * ename : lol
         * img : http://i5.pdim.gs/79db522e2b647fd7a00c2bfc02ce3b57.png
         * ext : 400
         * status : 1
         */

        private String cname;
        private String ename;
        private String img;
        private String ext;
        private String status;

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

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getExt() {
            return ext;
        }

        public void setExt(String ext) {
            this.ext = ext;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        @Override
        public String toString() {
            return "ChildDataBean{" +
                    "cname='" + cname + '\'' +
                    ", ename='" + ename + '\'' +
                    ", img='" + img + '\'' +
                    ", ext='" + ext + '\'' +
                    ", status='" + status + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "CategoryGameListBean{" +
                "cname='" + cname + '\'' +
                ", ename='" + ename + '\'' +
                ", img='" + img + '\'' +
                ", ext='" + ext + '\'' +
                ", status='" + status + '\'' +
                ", extra='" + extra + '\'' +
                ", child_data=" + child_data +
                '}';
    }
}
