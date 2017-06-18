package yyl.rabbitcloud.bean;

import java.util.List;

/**
 * Created by yyl on 2017/6/17.
 */

public class RecommendInfoBean {

    /**
     * errno : 0
     * errmsg :
     * data : {"adsdata":[{"title":"守望先锋职业系列赛OWPS (直播)","qcmsint1":"4294967295","qcmsint3":"0",
     * "qcmsint4":"0","qcmsint5":"0","qcmsstr3":"","qcmsstr4":"","qcmsstr5":"",
     * "bigimg":"http://i9.pdim.gs/4c2ddd6060930f5f27d22c52bcd0d06a.jpeg",
     * "smallimg":"http://i7.pdim.gs/8df5c1fa9f1ea373605a96851f2e503a.jpeg","roomid":"60999",
     * "roomurl":"","order":"4294967295","brief":"","channel":"","newimg":"http://i9.pdim
     * .gs/4c2ddd6060930f5f27d22c52bcd0d06a.jpeg","nickname":"暴雪守望先锋职业系列赛",
     * "room_key":"a8b34c144e655f1fa8008ac37e75d160","name":"守望先锋职业系列赛OWPS (直播)",
     * "notice":"2017OWPS 春季赛","classification":"","person_num":"443485","details":"",
     * "start_time":"1497673354","end_time":"1497673302","schedule":"0","status":"2",
     * "display_type":"1","stream_status":"1","url":"http://www.panda.tv/room/60999",
     * "style_type":"1","picture":"http://i9.pdim
     * .gs/90/265406fb58edd825b3dba620896aaec2/w338/h190.jpg"},{"title":"季中大乱斗-淘汰赛（直播）",
     * "qcmsint1":"4000001000","qcmsint3":"0","qcmsint4":"0","qcmsint5":"0","qcmsstr3":"",
     * "qcmsstr4":"","qcmsstr5":"","bigimg":"http://i7.pdim
     * .gs/832d73d8a56160df533a914b2015c2e4.jpeg","smallimg":"http://i5.pdim
     * .gs/004322f2881e80705a5d8aca4e61a03b.jpeg","roomid":"97513","roomurl":"",
     * "order":"4000001000","brief":"","channel":"","newimg":"http://i6.pdim
     * .gs/b26158a61f8059bc624a81befb4248e8.jpeg","nickname":"暴雪游戏频道",
     * "room_key":"6c995708a93ed45efcc0d4ddf0600e68","name":"季中大乱斗-淘汰赛（直播）",
     * "notice":"16点频道1直播《风暴英雄》季中大乱斗-淘汰赛，22点频道2直播《星际争霸II》世锦赛延雪平站-小组赛","classification":"",
     * "person_num":"11653","details":"","start_time":"1497684617","end_time":"1497684551",
     * "schedule":"0","status":"2","display_type":"1","stream_status":"1","url":"http://www.panda
     * .tv/room/97513","style_type":"1","picture":"http://i5.pdim
     * .gs/90/beb5c1b02ec1ec35bb3629582fbb0fdd/w338/h190.jpg"},{"title":"lpl夏季赛WE vs Snake",
     * "qcmsint1":"4000000000","qcmsint3":"0","qcmsint4":"0","qcmsint5":"0","qcmsstr3":"",
     * "qcmsstr4":"","qcmsstr5":"","bigimg":"http://i9.pdim.gs/7942dca0f895c42e51190bcfd42be2fc
     * .jpeg","smallimg":"http://i8.pdim.gs/4721e2a97313aab3fcaa6986f56241c9.jpeg",
     * "roomid":"7000","roomurl":"","order":"4000000000","brief":"","channel":"",
     * "newimg":"http://i8.pdim.gs/a808745198b1c284313f58776470e856.jpeg","nickname":"LPL熊猫官方直播",
     * "room_key":"d364e16c7106e851e49faffb592eb7cb","name":"lpl夏季赛WE vs Snake",
     * "notice":"比赛直播时间：每周四到周日\n网页直播页面可参与竹子竞猜\n移动用户卡顿的请在APP设置里打开硬件加速","classification":"",
     * "person_num":"2013475","details":"","start_time":"1496891516","end_time":"1496891497",
     * "schedule":"1445612328","status":"2","display_type":"1","stream_status":"1",
     * "url":"http://www.panda.tv/room/7000","style_type":"1","picture":"http://i7.pdim
     * .gs/90/45dc4494f4febcecf4a5d87932b3ebdb/w338/h190.jpg"},{"title":"直播 炉鼎记",
     * "qcmsint1":"4000000000","qcmsint3":"0","qcmsint4":"0","qcmsint5":"0","qcmsstr3":"",
     * "qcmsstr4":"","qcmsstr5":"","bigimg":"http://i7.pdim
     * .gs/f1debea893ddf06187195107e6da4f53.jpeg","smallimg":"http://i9.pdim
     * .gs/7d350f3078940600d4a7d41643a7bfb0.jpeg","roomid":"462047","roomurl":"",
     * "order":"4000000000","brief":"","channel":"","newimg":"http://i5.pdim
     * .gs/f33a6b5bf5ad93db20f6b2adb7079f9f.jpeg","nickname":"Imba炉石频道",
     * "room_key":"6b3bf982bdcc5bb3176a9b019a3f2f44","name":"直播 炉鼎记","notice":"ImbaTV炉石传说频道",
     * "classification":"","person_num":"11364","details":"","start_time":"1497682357",
     * "end_time":"1497682169","schedule":"0","status":"2","display_type":"1",
     * "stream_status":"1","url":"http://www.panda.tv/room/462047","style_type":"1",
     * "picture":"http://i5.pdim.gs/90/139426cf97884e25a257625b8d574fbe/w338/h190.jpg"},
     * {"title":"剑网3大师赛总决赛","qcmsint1":"3900008001","qcmsint3":"0","qcmsint4":"0","qcmsint5":"0",
     * "qcmsstr3":"","qcmsstr4":"","qcmsstr5":"","bigimg":"http://i8.pdim
     * .gs/b2a2dca98b6cff6f8bdd191564cbf8c7.jpeg","smallimg":"http://i7.pdim
     * .gs/8f42e1ef843bc85a92bb86fdac16f80d.jpeg","roomid":"218273","roomurl":"",
     * "order":"3900008001","brief":"","channel":"","newimg":"http://i8.pdim
     * .gs/86a89442319aecf3e9e1bce258610f98.jpeg","nickname":"剑网3官方直播",
     * "room_key":"fcf64d406e90d00dbec3f5afe5478f59","name":"剑网3大师赛总决赛","notice":"",
     * "classification":"","person_num":"314911","details":"","start_time":"1497684447",
     * "end_time":"1497684445","schedule":"0","status":"2","display_type":"1",
     * "stream_status":"1","url":"http://www.panda.tv/room/218273","style_type":"1",
     * "picture":"http://i8.pdim.gs/b1f751fed25ba3614c9e23882670bc4b.jpeg"}],
     * "hotdata":[{"id":"7000","name":"lpl夏季赛WE vs Snake","hostid":"3014510",
     * "person_num":"2013475","classification":"lol","pictures":{"img":"http://i7.pdim
     * .gs/90/45dc4494f4febcecf4a5d87932b3ebdb/w338/h190.jpg"},"display_type":"1","tag":"蓝光",
     * "tag_switch":"2","tag_color":"1","style_type":"1","reliable":"1","status":"2",
     * "stream_status":"1","createtime":"2015-10-23 22:58:48","start_time":"1496891516",
     * "schedule":"1445612328","level":"9","fans":"0","announcement":"","duration":"801931",
     * "roomid":"7000","bigimg":"http://i7.pdim
     * .gs/90/45dc4494f4febcecf4a5d87932b3ebdb/w338/h190.jpg","nickname":"LPL熊猫官方直播",
     * "title":"lpl夏季赛WE vs Snake","notice":"","details":"","order":"0","url":"http://www.panda
     * .tv/room/7000"},{"id":"60999","name":"守望先锋职业系列赛OWPS (直播)","hostid":"6531262",
     * "person_num":"443485","classification":"overwatch","pictures":{"img":"http://i9.pdim
     * .gs/90/265406fb58edd825b3dba620896aaec2/w338/h190.jpg"},"display_type":"1","tag":"",
     * "tag_switch":"1","tag_color":"1","style_type":"1","reliable":"1","status":"2",
     * "stream_status":"1","createtime":"2015-11-02 19:03:08","start_time":"1497673354",
     * "schedule":"0","level":"9","fans":"0","announcement":"","duration":"20093",
     * "roomid":"60999","bigimg":"http://i9.pdim
     * .gs/90/265406fb58edd825b3dba620896aaec2/w338/h190.jpg","nickname":"暴雪守望先锋职业系列赛",
     * "title":"守望先锋职业系列赛OWPS (直播)","notice":"","details":"","order":"1","url":"http://www.panda
     * .tv/room/60999"},{"id":"403249","name":"迈凯伦650S，晚上KINGS篮球队","hostid":"29419982",
     * "person_num":"343674","classification":"hwzb","pictures":{"img":"http://i8.pdim
     * .gs/90/4771cc04b63ef776f2270892618df5f7/w338/h190.jpg"},"display_type":"1","tag":"",
     * "tag_switch":"0","tag_color":"1","style_type":"1","reliable":"1","status":"2",
     * "stream_status":"1","createtime":"2016-05-13 08:57:00","start_time":"1497690552",
     * "schedule":"0","level":"9","fans":"0","announcement":"","duration":"2895",
     * "roomid":"403249","bigimg":"http://i8.pdim
     * .gs/90/4771cc04b63ef776f2270892618df5f7/w338/h190.jpg","nickname":"洋气黄",
     * "title":"迈凯伦650S，晚上KINGS篮球队","notice":"","details":"","order":"2","url":"http://www.panda
     * .tv/room/403249"},{"id":"218273","name":"剑网3大师赛总决赛","hostid":"22958546",
     * "person_num":"314911","classification":"jxol3","pictures":{"img":"http://i8.pdim
     * .gs/b1f751fed25ba3614c9e23882670bc4b.jpeg"},"display_type":"1","tag":"","tag_switch":"1",
     * "tag_color":"1","style_type":"1","reliable":"1","status":"2","stream_status":"1",
     * "createtime":"2015-12-21 15:41:09","start_time":"1497684447","schedule":"0","level":"9",
     * "fans":"0","announcement":"","duration":"9000","roomid":"218273","bigimg":"http://i8.pdim
     * .gs/b1f751fed25ba3614c9e23882670bc4b.jpeg","nickname":"剑网3官方直播","title":"剑网3大师赛总决赛",
     * "notice":"","details":"","order":"3","url":"http://www.panda.tv/room/218273"},
     * {"id":"66666","name":"送礼物抽IP7和笔记本电脑","hostid":"3010086","person_num":"232379",
     * "classification":"lol","pictures":{"img":"http://i5.pdim
     * .gs/90/b073751d99b6ffb0507c6c02999527e1/w338/h190.jpg"},"display_type":"1","tag":"",
     * "tag_switch":"1","tag_color":"4","style_type":"1","reliable":"1","status":"2",
     * "stream_status":"1","createtime":"2015-09-21 14:17:08","start_time":"1497683057",
     * "schedule":"0","level":"9","fans":"0","announcement":"","duration":"10390",
     * "roomid":"66666","bigimg":"http://i5.pdim
     * .gs/90/b073751d99b6ffb0507c6c02999527e1/w338/h190.jpg","nickname":"刘杀鸡",
     * "title":"送礼物抽IP7和笔记本电脑","notice":"","details":"","order":"4","url":"http://www.panda
     * .tv/room/66666"},{"id":"10027","name":"瓦莉拉：今天来上传说~","hostid":"3009998",
     * "person_num":"211198","classification":"hearthstone","pictures":{"img":"http://i6.pdim
     * .gs/90/1e609fbf760f5e42cace7a1a398783ca/w338/h190.jpg"},"display_type":"1","tag":"",
     * "tag_switch":"0","tag_color":"4","style_type":"1","reliable":"1","status":"2",
     * "stream_status":"1","createtime":"2015-09-20 22:46:03","start_time":"1497688640",
     * "schedule":"1442984400","level":"9","fans":"0","announcement":"","duration":"4807",
     * "roomid":"10027","bigimg":"http://i6.pdim
     * .gs/90/1e609fbf760f5e42cace7a1a398783ca/w338/h190.jpg","nickname":"瓦莉拉的小伙伴",
     * "title":"瓦莉拉：今天来上传说~","notice":"","details":"","order":"5","url":"http://www.panda
     * .tv/room/10027"},{"id":"615017","name":"可乐：最强猴子！大圣归来简单粗暴","hostid":"26172992",
     * "person_num":"166145","classification":"kingglory","pictures":{"img":"http://i5.pdim
     * .gs/bd0bbba8ada594a78ade21afd05038d6.jpeg"},"display_type":"1","tag":"","tag_switch":"1",
     * "tag_color":"1","style_type":"1","reliable":"2","status":"2","stream_status":"1",
     * "createtime":"2016-11-27 05:11:24","start_time":"1497675873","schedule":"0","level":"1",
     * "fans":"0","announcement":"","duration":"17574","roomid":"615017","bigimg":"http://i5.pdim
     * .gs/bd0bbba8ada594a78ade21afd05038d6.jpeg","nickname":"Devil丶可乐",
     * "title":"可乐：最强猴子！大圣归来简单粗暴","notice":"","details":"","order":"6","url":"http://www.panda
     * .tv/room/615017"},{"id":"4000","name":"大咖说趴\u2014京东12小时直播秀","hostid":"27147368",
     * "person_num":"154608","classification":"yzdr","pictures":{"img":"http://i5.pdim
     * .gs/90/2cc06591edb0365866feb5815168fa3a/w338/h190.jpg"},"display_type":"1","tag":"",
     * "tag_switch":"1","tag_color":"1","style_type":"1","reliable":"1","status":"2",
     * "stream_status":"1","createtime":"2016-01-29 10:57:13","start_time":"1497687604",
     * "schedule":"1460638800","level":"9","fans":"0","announcement":"","duration":"5843",
     * "roomid":"4000","bigimg":"http://i5.pdim
     * .gs/90/2cc06591edb0365866feb5815168fa3a/w338/h190.jpg","nickname":"熊猫娱乐直播频道",
     * "title":"大咖说趴\u2014京东12小时直播秀","notice":"","details":"","order":"7","url":"http://www.panda
     * .tv/room/4000"},{"id":"317336","name":"2017 TGA夏季总决赛","hostid":"29395716",
     * "person_num":"144705","classification":"tymyd","pictures":{"img":"http://i9.pdim
     * .gs/90/f797e425487a23b902b534057574e2c7/w338/h190.jpg"},"display_type":"1","tag":"",
     * "tag_switch":"1","tag_color":"1","style_type":"1","reliable":"1","status":"2",
     * "stream_status":"1","createtime":"2016-03-02 17:46:28","start_time":"1497691453",
     * "schedule":"0","level":"9","fans":"0","announcement":"","duration":"1994",
     * "roomid":"317336","bigimg":"http://i9.pdim
     * .gs/90/f797e425487a23b902b534057574e2c7/w338/h190.jpg","nickname":"TGA大奖赛","title":"2017
     * TGA夏季总决赛","notice":"","details":"","order":"8","url":"http://www.panda.tv/room/317336"},
     * {"id":"10006","name":"【错觉】 帝国投弹手 7点比赛","hostid":"3153550","person_num":"141869",
     * "classification":"pubg","pictures":{"img":"http://i9.pdim
     * .gs/90/de542e3cd031fe9829bec15c9838b955/w338/h190.jpg"},"display_type":"1","tag":"",
     * "tag_switch":"1","tag_color":"1","style_type":"1","reliable":"1","status":"2",
     * "stream_status":"1","createtime":"2016-05-27 17:19:13","start_time":"1497678031",
     * "schedule":"1465221651","level":"9","fans":"0","announcement":"","duration":"15416",
     * "roomid":"10006","bigimg":"http://i9.pdim
     * .gs/90/de542e3cd031fe9829bec15c9838b955/w338/h190.jpg","nickname":"错觉老中医","title":"【错觉】
     * 帝国投弹手 7点比赛","notice":"","details":"","order":"9","url":"http://www.panda.tv/room/10006"},
     * {"id":"821337","name":"练个小号上王者送你们，输了讲故事","hostid":"30917012","person_num":"132886",
     * "classification":"kingglory","pictures":{"img":"http://i8.pdim
     * .gs/90/06fd448fe649f914b91fd6054605e83e/w338/h190.jpg"},"display_type":"1","tag":"",
     * "tag_switch":"1","tag_color":"1","style_type":"1","reliable":"1","status":"2",
     * "stream_status":"1","createtime":"2017-03-02 13:38:35","start_time":"1497690747",
     * "schedule":"0","level":"9","fans":"0","announcement":"","duration":"2700",
     * "roomid":"821337","bigimg":"http://i8.pdim
     * .gs/90/06fd448fe649f914b91fd6054605e83e/w338/h190.jpg","nickname":"御宅囧卡卡",
     * "title":"练个小号上王者送你们，输了讲故事","notice":"","details":"","order":"10","url":"http://www.panda
     * .tv/room/821337"},{"id":"10953","name":"君克锐雯：极限1V5掌控雷电","hostid":"3015260",
     * "person_num":"131013","classification":"lol","pictures":{"img":"http://i6.pdim
     * .gs/90/ae5b2bee915e0de2d865067667ac04f9/w338/h190.jpg"},"display_type":"1","tag":"",
     * "tag_switch":"1","tag_color":"4","style_type":"1","reliable":"1","status":"2",
     * "stream_status":"1","createtime":"2015-09-23 16:01:19","start_time":"1497679222",
     * "schedule":"0","level":"9","fans":"0","announcement":"","duration":"14225",
     * "roomid":"10953","bigimg":"http://i6.pdim
     * .gs/90/ae5b2bee915e0de2d865067667ac04f9/w338/h190.jpg","nickname":"君克解说",
     * "title":"君克锐雯：极限1V5掌控雷电","notice":"","details":"","order":"11","url":"http://www.panda
     * .tv/room/10953"},{"id":"879615","name":"恩佐，拉法，帕加尼，P1，Lfa","hostid":"79090140",
     * "person_num":"113376","classification":"hwzb","pictures":{"img":"http://i5.pdim
     * .gs/90/cf9e6e899477e6882b15131862ac7095/w338/h190.jpg"},"display_type":"1","tag":"",
     * "tag_switch":"1","tag_color":"1","style_type":"1","reliable":"2","status":"2",
     * "stream_status":"1","createtime":"2017-03-28 11:48:17","start_time":"1497692526",
     * "schedule":"0","level":"1","fans":"0","announcement":"","duration":"921",
     * "roomid":"879615","bigimg":"http://i5.pdim
     * .gs/90/cf9e6e899477e6882b15131862ac7095/w338/h190.jpg","nickname":"真正的木村拓哉",
     * "title":"恩佐，拉法，帕加尼，P1，Lfa","notice":"","details":"","order":"12","url":"http://www.panda
     * .tv/room/879615"},{"id":"769965","name":"一起游游山玩玩水","hostid":"27636760",
     * "person_num":"112398","classification":"hwzb","pictures":{"img":"http://i7.pdim
     * .gs/90/dded553fa5188ffb33c4241caf72f865/w338/h190.jpg"},"display_type":"1","tag":"",
     * "tag_switch":"0","tag_color":"1","style_type":"1","reliable":"2","status":"2",
     * "stream_status":"1","createtime":"2017-02-14 23:44:00","start_time":"1497684756",
     * "schedule":"0","level":"1","fans":"0","announcement":"","duration":"8691",
     * "roomid":"769965","bigimg":"http://i7.pdim
     * .gs/90/dded553fa5188ffb33c4241caf72f865/w338/h190.jpg","nickname":"主播方正",
     * "title":"一起游游山玩玩水","notice":"","details":"","order":"13","url":"http://www.panda
     * .tv/room/769965"},{"id":"52222","name":"熊猫最强卡牌","hostid":"3025670","person_num":"108880",
     * "classification":"lol","pictures":{"img":"http://i9.pdim
     * .gs/90/39f4267ebcd520cab405b435cb992a91/w338/h190.jpg"},"display_type":"1","tag":"",
     * "tag_switch":"1","tag_color":"1","style_type":"1","reliable":"1","status":"2",
     * "stream_status":"1","createtime":"2015-09-25 23:35:18","start_time":"1497691001",
     * "schedule":"1443434820","level":"9","fans":"0","announcement":"","duration":"2446",
     * "roomid":"52222","bigimg":"http://i9.pdim
     * .gs/90/39f4267ebcd520cab405b435cb992a91/w338/h190.jpg","nickname":"药水哥s","title":"熊猫最强卡牌",
     * "notice":"","details":"","order":"14","url":"http://www.panda.tv/room/52222"},
     * {"id":"371041","name":"乡坝头第一篮球对抗赛","hostid":"31831164","person_num":"97009",
     * "classification":"hwzb","pictures":{"img":"http://i9.pdim
     * .gs/90/b3e53752ec82ab1ba591d8d1d4d756f0/w338/h190.jpg"},"display_type":"1","tag":"",
     * "tag_switch":"0","tag_color":"4","style_type":"1","reliable":"1","status":"2",
     * "stream_status":"1","createtime":"2016-04-12 13:55:29","start_time":"1497688817",
     * "schedule":"1461409200","level":"9","fans":"0","announcement":"","duration":"4630",
     * "roomid":"371041","bigimg":"http://i9.pdim
     * .gs/90/b3e53752ec82ab1ba591d8d1d4d756f0/w338/h190.jpg","nickname":"曼谷先生",
     * "title":"乡坝头第一篮球对抗赛","notice":"","details":"","order":"15","url":"http://www.panda
     * .tv/room/371041"}]}
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
        private List<AdsdataBean> adsdata;
        private List<HotdataBean> hotdata;

        public List<AdsdataBean> getAdsdata() {
            return adsdata;
        }

        public void setAdsdata(List<AdsdataBean> adsdata) {
            this.adsdata = adsdata;
        }

        public List<HotdataBean> getHotdata() {
            return hotdata;
        }

        public void setHotdata(List<HotdataBean> hotdata) {
            this.hotdata = hotdata;
        }

        public static class AdsdataBean {
            /**
             * title : 守望先锋职业系列赛OWPS (直播)
             * qcmsint1 : 4294967295
             * qcmsint3 : 0
             * qcmsint4 : 0
             * qcmsint5 : 0
             * qcmsstr3 :
             * qcmsstr4 :
             * qcmsstr5 :
             * bigimg : http://i9.pdim.gs/4c2ddd6060930f5f27d22c52bcd0d06a.jpeg
             * smallimg : http://i7.pdim.gs/8df5c1fa9f1ea373605a96851f2e503a.jpeg
             * roomid : 60999
             * roomurl :
             * order : 4294967295
             * brief :
             * channel :
             * newimg : http://i9.pdim.gs/4c2ddd6060930f5f27d22c52bcd0d06a.jpeg
             * nickname : 暴雪守望先锋职业系列赛
             * room_key : a8b34c144e655f1fa8008ac37e75d160
             * name : 守望先锋职业系列赛OWPS (直播)
             * notice : 2017OWPS 春季赛
             * classification :
             * person_num : 443485
             * details :
             * start_time : 1497673354
             * end_time : 1497673302
             * schedule : 0
             * status : 2
             * display_type : 1
             * stream_status : 1
             * url : http://www.panda.tv/room/60999
             * style_type : 1
             * picture : http://i9.pdim.gs/90/265406fb58edd825b3dba620896aaec2/w338/h190.jpg
             */

            private String title;
            private String qcmsint1;
            private String qcmsint3;
            private String qcmsint4;
            private String qcmsint5;
            private String qcmsstr3;
            private String qcmsstr4;
            private String qcmsstr5;
            private String bigimg;
            private String smallimg;
            private String roomid;
            private String roomurl;
            private String order;
            private String brief;
            private String channel;
            private String newimg;
            private String nickname;
            private String room_key;
            private String name;
            private String notice;
            private String classification;
            private String person_num;
            private String details;
            private String start_time;
            private String end_time;
            private String schedule;
            private String status;
            private String display_type;
            private String stream_status;
            private String url;
            private String style_type;
            private String picture;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getQcmsint1() {
                return qcmsint1;
            }

            public void setQcmsint1(String qcmsint1) {
                this.qcmsint1 = qcmsint1;
            }

            public String getQcmsint3() {
                return qcmsint3;
            }

            public void setQcmsint3(String qcmsint3) {
                this.qcmsint3 = qcmsint3;
            }

            public String getQcmsint4() {
                return qcmsint4;
            }

            public void setQcmsint4(String qcmsint4) {
                this.qcmsint4 = qcmsint4;
            }

            public String getQcmsint5() {
                return qcmsint5;
            }

            public void setQcmsint5(String qcmsint5) {
                this.qcmsint5 = qcmsint5;
            }

            public String getQcmsstr3() {
                return qcmsstr3;
            }

            public void setQcmsstr3(String qcmsstr3) {
                this.qcmsstr3 = qcmsstr3;
            }

            public String getQcmsstr4() {
                return qcmsstr4;
            }

            public void setQcmsstr4(String qcmsstr4) {
                this.qcmsstr4 = qcmsstr4;
            }

            public String getQcmsstr5() {
                return qcmsstr5;
            }

            public void setQcmsstr5(String qcmsstr5) {
                this.qcmsstr5 = qcmsstr5;
            }

            public String getBigimg() {
                return bigimg;
            }

            public void setBigimg(String bigimg) {
                this.bigimg = bigimg;
            }

            public String getSmallimg() {
                return smallimg;
            }

            public void setSmallimg(String smallimg) {
                this.smallimg = smallimg;
            }

            public String getRoomid() {
                return roomid;
            }

            public void setRoomid(String roomid) {
                this.roomid = roomid;
            }

            public String getRoomurl() {
                return roomurl;
            }

            public void setRoomurl(String roomurl) {
                this.roomurl = roomurl;
            }

            public String getOrder() {
                return order;
            }

            public void setOrder(String order) {
                this.order = order;
            }

            public String getBrief() {
                return brief;
            }

            public void setBrief(String brief) {
                this.brief = brief;
            }

            public String getChannel() {
                return channel;
            }

            public void setChannel(String channel) {
                this.channel = channel;
            }

            public String getNewimg() {
                return newimg;
            }

            public void setNewimg(String newimg) {
                this.newimg = newimg;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getRoom_key() {
                return room_key;
            }

            public void setRoom_key(String room_key) {
                this.room_key = room_key;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getNotice() {
                return notice;
            }

            public void setNotice(String notice) {
                this.notice = notice;
            }

            public String getClassification() {
                return classification;
            }

            public void setClassification(String classification) {
                this.classification = classification;
            }

            public String getPerson_num() {
                return person_num;
            }

            public void setPerson_num(String person_num) {
                this.person_num = person_num;
            }

            public String getDetails() {
                return details;
            }

            public void setDetails(String details) {
                this.details = details;
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

            public String getSchedule() {
                return schedule;
            }

            public void setSchedule(String schedule) {
                this.schedule = schedule;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getDisplay_type() {
                return display_type;
            }

            public void setDisplay_type(String display_type) {
                this.display_type = display_type;
            }

            public String getStream_status() {
                return stream_status;
            }

            public void setStream_status(String stream_status) {
                this.stream_status = stream_status;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getStyle_type() {
                return style_type;
            }

            public void setStyle_type(String style_type) {
                this.style_type = style_type;
            }

            public String getPicture() {
                return picture;
            }

            public void setPicture(String picture) {
                this.picture = picture;
            }
        }

        public static class HotdataBean {
            /**
             * id : 7000
             * name : lpl夏季赛WE vs Snake
             * hostid : 3014510
             * person_num : 2013475
             * classification : lol
             * pictures : {"img":"http://i7.pdim.gs/90/45dc4494f4febcecf4a5d87932b3ebdb/w338/h190.jpg"}
             * display_type : 1
             * tag : 蓝光
             * tag_switch : 2
             * tag_color : 1
             * style_type : 1
             * reliable : 1
             * status : 2
             * stream_status : 1
             * createtime : 2015-10-23 22:58:48
             * start_time : 1496891516
             * schedule : 1445612328
             * level : 9
             * fans : 0
             * announcement :
             * duration : 801931
             * roomid : 7000
             * bigimg : http://i7.pdim.gs/90/45dc4494f4febcecf4a5d87932b3ebdb/w338/h190.jpg
             * nickname : LPL熊猫官方直播
             * title : lpl夏季赛WE vs Snake
             * notice :
             * details :
             * order : 0
             * url : http://www.panda.tv/room/7000
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
            private String fans;
            private String announcement;
            private String duration;
            private String roomid;
            private String bigimg;
            private String nickname;
            private String title;
            private String notice;
            private String details;
            private String order;
            private String url;

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

            public String getFans() {
                return fans;
            }

            public void setFans(String fans) {
                this.fans = fans;
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

            public String getRoomid() {
                return roomid;
            }

            public void setRoomid(String roomid) {
                this.roomid = roomid;
            }

            public String getBigimg() {
                return bigimg;
            }

            public void setBigimg(String bigimg) {
                this.bigimg = bigimg;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getNotice() {
                return notice;
            }

            public void setNotice(String notice) {
                this.notice = notice;
            }

            public String getDetails() {
                return details;
            }

            public void setDetails(String details) {
                this.details = details;
            }

            public String getOrder() {
                return order;
            }

            public void setOrder(String order) {
                this.order = order;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public static class PicturesBean {
                /**
                 * img : http://i7.pdim.gs/90/45dc4494f4febcecf4a5d87932b3ebdb/w338/h190.jpg
                 */

                private String img;

                public String getImg() {
                    return img;
                }

                public void setImg(String img) {
                    this.img = img;
                }
            }
        }
    }
}
