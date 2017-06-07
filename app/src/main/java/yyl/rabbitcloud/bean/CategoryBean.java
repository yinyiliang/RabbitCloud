package yyl.rabbitcloud.bean;

import java.util.List;

/**
 * Created by yyl on 2017/6/2.
 */

public class CategoryBean {

    /**
     * errno : 0
     * errmsg :
     * data : [{"cname":"英雄联盟","ename":"lol","img":"http://i9.pdim
     * .gs/23e529ba353b33c2f70e6d60f6be4c29.jpeg","ext":"400","status":"1",
     * "extra":"{\"icon\":\"http://i5.pdim.gs/79db522e2b647fd7a00c2bfc02ce3b57.png\",
     * \"icon_ipad\":\"http://i8.pdim.gs/173d4333e6dd4798732d099a4b0c08a8.png\"}"},
     * {"cname":"熊猫星秀","ename":"yzdr","img":"http://i8.pdim
     * .gs/89140c5ca93cf55b46dc6331210a4e37.jpeg","ext":"500","status":"1",
     * "extra":"{\"icon\":\"\",\"icon_ipad\":\"\"}"},{"cname":"户外直播","ename":"hwzb",
     * "img":"http://i5.pdim.gs/3a8bb81ff10136dc5270ad23c2a4e64c.png","ext":"1300","status":"1",
     * "extra":"{\"icon\":\"\"}"},{"cname":"王者荣耀","ename":"kingglory","img":"http://i6.pdim
     * .gs/1288f555f436bbc11a4146e032a5ad4e.png","ext":"1350","status":"1",
     * "extra":"{\"icon\":\"http://i7.pdim.gs/2be5c2f9469317b1bb81aaa3981e8735.png\",
     * \"icon_ipad\":\"http://i9.pdim.gs/18c9f71e0b1df89e0811a5d1c6c4ebf5.png\"}"},
     * {"cname":"主机游戏","ename":"zhuji","img":"http://i7.pdim
     * .gs/dedb172888351d04c6256e60f88f0c23.png","ext":"1400","status":"1",
     * "extra":"{\"icon\":\"http://i7.pdim.gs/480cf0e7615a5c032ebe8d9dd2154058.png\",
     * \"icon_ipad\":\"http://i5.pdim.gs/32cd47746eefff0938b8047b5d839e59.png\"}"},
     * {"cname":"炉石传说","ename":"hearthstone","img":"http://i6.pdim
     * .gs/18a15f74900b717ef5b77283ec8e0c37.png","ext":"1500","status":"1",
     * "extra":"{\"icon\":\"http://i7.pdim.gs/ec2d657bda5bf6ca02698910eec0e32d.png\",
     * \"icon_ipad\":\"http://i5.pdim.gs/0ddf2e16625260e12ab70df79f305bae.png\"}"},
     * {"cname":"守望先锋","ename":"overwatch","img":"http://i8.pdim
     * .gs/70eb88bf67257964e012eacc97263f9f.png","ext":"1600","status":"1",
     * "extra":"{\"icon\":\"http://i6.pdim.gs/6bb8a5716c42bb3786cdc7e52227f2cf.png\",
     * \"icon_ipad\":\"http://i8.pdim.gs/efc1d6694939c4552d421478bef3322d.png\"}"},
     * {"cname":"魔兽DOTA1","ename":"war3","img":"http://i7.pdim
     * .gs/2c0e9577b5e15e8d5393aaf9c7956d08.jpeg","ext":"1700","status":"1",
     * "extra":"{\"icon\":\"http://i8.pdim.gs/cf7ec6957f3605a375e5330c890fef22.png\",
     * \"icon_ipad\":\"http://i8.pdim.gs/74f3f5dcdab4e9f5c0d37649d66b5cd7.png\"}"},
     * {"cname":"DOTA2","ename":"dota2","img":"http://i5.pdim
     * .gs/4795f1e933be01c4e7055e157c58aca0.png","ext":"1800","status":"1",
     * "extra":"{\"icon\":\"http://i6.pdim.gs/6001adbfa4a017f5e4f8c1a93e3abe7e.png\",
     * \"icon_ipad\":\"http://i7.pdim.gs/fe26a15b4e9c07dea69ec88bd5868be3.png\"}"},
     * {"cname":"天天跳伞","ename":"ttts","img":"http://i7.pdim.gs/9e13c1685698d6fde5e410e50194af5d
     * .jpeg","ext":"1910","status":"1","extra":"{\"icon\":\"http://i7.pdim
     * .gs/5c148fbe43c643214dba143590134ac8.png\",\"icon_ipad\":\"http://i9.pdim
     * .gs/b59ce0c428f725d676825fef79657c19.png\"}"},{"cname":"绝地求生","ename":"pubg",
     * "img":"http://i6.pdim.gs/793d28d5ca72c5530774affdd971b879.jpeg","ext":"1950","status":"1",
     * "extra":"{\"icon\":\"http://i8.pdim.gs/f4694d0f4c77d8d1eb3c06eb8f60c952.png\",
     * \"icon_ipad\":\"http://i7.pdim.gs/bea18ac737d23d280498ba90c2fd5fd1.png\"}"},
     * {"cname":"穿越火线","ename":"cf","img":"http://i7.pdim.gs/6d15c0f3da8914a30b27105670e6d62a
     * .png","ext":"2100","status":"1","extra":"{\"icon\":\"http://i8.pdim
     * .gs/fb30c26c6c3a818d143cbfa4cdbf071a.png\",\"icon_ipad\":\"http://i9.pdim
     * .gs/9496dc84ef3f62f7c0d4f723447d64fb.png\"}"},{"cname":"DNF","ename":"dnf",
     * "img":"http://i7.pdim.gs/047467e36ad7fea589f987f5992638c8.png","ext":"2200","status":"1",
     * "extra":"{\"icon\":\"http://i8.pdim.gs/abc6fd0b0e43b8abce5e81299e091571.png\",
     * \"icon_ipad\":\"http://i8.pdim.gs/521b44281bbfcad9bdc11409bdaaa5ee.png\"}"},
     * {"cname":"影评专区","ename":"cartoon","img":"http://i5.pdim
     * .gs/18f3883d414c0c79476936e0a24fba3b.png","ext":"2222","status":"1",
     * "extra":"{\"icon\":\"http://i5.pdim.gs/79db522e2b647fd7a00c2bfc02ce3b57.png\"}"},
     * {"cname":"魔兽世界","ename":"wow","img":"http://i5.pdim
     * .gs/2d898309847b42f51e65e91c67596640.png","ext":"2300","status":"1",
     * "extra":"{\"icon\":\"http://i6.pdim.gs/b733d79cafd75459a8175cb39903814f.png\",
     * \"icon_ipad\":\"http://i8.pdim.gs/2c6ae3bec17ad3db0b72f0dee6c34ace.png\"}"},
     * {"cname":"剑网3","ename":"jxol3","img":"http://i9.pdim
     * .gs/905d8ccbd434a89adf404371ada5e929.jpeg","ext":"2400","status":"1",
     * "extra":"{\"icon\":\"http://i7.pdim.gs/54b4ae512ca816da6aa4089421333eca.png\",
     * \"icon_ipad\":\"http://i5.pdim.gs/4efbb3dafed582a610b9cf6ea61e96b0.png\"}"},
     * {"cname":"天涯明月刀","ename":"tymyd","img":"http://i7.pdim
     * .gs/22fb119d8c3e3917e1927ffdc0d54d37.png","ext":"2500","status":"1",
     * "extra":"{\"icon\":\"http://i5.pdim.gs/13c3a71f351cb29c99e91d05dd4249a0.png\",
     * \"icon_ipad\":\"http://i7.pdim.gs/cf4242ed617d4f132539774f26b07cda.png\"}"},
     * {"cname":"跑跑卡丁车","ename":"popkart","img":"http://i9.pdim
     * .gs/595edb56afb784254121f499c594931c.jpeg","ext":"2600","status":"1",
     * "extra":"{\"icon\":\"http://i8.pdim.gs/40be92aa88158ab6b5bddda970923dcd.png\",
     * \"icon_ipad\":\"http://i7.pdim.gs/e9efb1514a92208ead22680b5c986da5.png\"}"},
     * {"cname":"QQ飞车","ename":"qqfc","img":"http://i7.pdim
     * .gs/e024f3aa0628e061295d1135fc234cf3.jpeg","ext":"2800","status":"1",
     * "extra":"{\"icon\":\"http://i5.pdim.gs/a54b5cfe6d3cf43069edce6dc2ab4596.png\",
     * \"icon_ipad\":\"http://i9.pdim.gs/d3c7a0d639987429212dd9006b3d93ae.png\"}"},
     * {"cname":"枪火游侠","ename":"qhyx","img":"http://i5.pdim
     * .gs/5f504b4a9521500617cad8bc2a944386.jpeg","ext":"2900","status":"1",
     * "extra":"{\"icon\":\"http://i8.pdim.gs/d136525e40d370309d5563ebcfd7d04e.png\",
     * \"icon_ipad\":\"http://i7.pdim.gs/35edf4d14654b214ec37f15a5080372f.png\"}"},
     * {"cname":"体育竞技","ename":"spg","img":"http://i5.pdim
     * .gs/2f86239213ce4b00a78d2e5cf7295213.png","ext":"3000","status":"1",
     * "extra":"{\"icon\":\"http://i5.pdim.gs/9dffd662f03a93877c89759625b32ef1.png\",
     * \"icon_ipad\":\"http://i9.pdim.gs/7e896f687846cdaa048005d5e57a8a8d.png\"}"},
     * {"cname":"我的世界","ename":"mc","img":"http://i9.pdim
     * .gs/8deff4e452c6908621518321f6d944e3.png","ext":"3100","status":"1",
     * "extra":"{\"icon\":\"http://i5.pdim.gs/ad4174485f700e27f7bc1293c4b78186.png\",
     * \"icon_ipad\":\"http://i7.pdim.gs/0351fde67f3205dd7dab4fc22a7686c0.png\"}"},
     * {"cname":"怀旧经典","ename":"hjjd","img":"http://i8.pdim
     * .gs/deacbc1bcecbf2494a75efa6d699f031.png","ext":"3200","status":"1",
     * "extra":"{\"icon\":\"http://i6.pdim.gs/b2737ca49f0f45177f1bef9fa84118ce.png\",
     * \"icon_ipad\":\"http://i8.pdim.gs/eae84f259579ea32f5b4be557bc5a125.png\"}"},
     * {"cname":"星露谷物语","ename":"sv","img":"http://i7.pdim.gs/c79e3fc6ee6243e2b331c6fd865164ba
     * .jpeg","ext":"3250","status":"1","extra":"{\"icon\":\"http://i8.pdim
     * .gs/0d349388ecd600a840ce527c93b36b49.png\",\"icon_ipad\":\"http://i7.pdim
     * .gs/faae0ea6fa8105816147a6ee22874d8f.png\"}"},{"cname":"CS:GO","ename":"csgo",
     * "img":"http://i7.pdim.gs/95748e44de319d47d7ebdf817928218d.png","ext":"3300","status":"1",
     * "extra":"{\"icon\":\"http://i9.pdim.gs/834c272d99544bfc0b8ee923f0f0838a.png\",
     * \"icon_ipad\":\"http://i6.pdim.gs/7d173ba93191c4ca569c8f1a65d04854.png\"}"},
     * {"cname":"风暴英雄","ename":"heroes","img":"http://i9.pdim.gs/c21e0383b1d324c4d3a55f01c0785a7e
     * .png","ext":"3500","status":"1","extra":"{\"icon\":\"http://i9.pdim
     * .gs/d26286419c60585e6217a8732b90cd18.png\",\"icon_ipad\":\"http://i5.pdim
     * .gs/9b8b3c5b4e9bf1c6edd3a29e9bfd1858.png\"}"},{"cname":"星际争霸2","ename":"starcraft",
     * "img":"http://i8.pdim.gs/bac22be920ca30206eb1a2037913e5a6.png","ext":"3600","status":"1",
     * "extra":"{\"icon\":\"http://i5.pdim.gs/d6015eaa30cff8bea1dd67f55fbc3136.png\",
     * \"icon_ipad\":\"http://i8.pdim.gs/99ba066f6ea7aa0636906d04a32aebad.png\"}"},
     * {"cname":"格斗游戏","ename":"ftg","img":"http://i5.pdim
     * .gs/25b34e7976346010c855d65cf3b37ec9.png","ext":"3700","status":"1",
     * "extra":"{\"icon\":\"http://i9.pdim.gs/e1d74bf6f11be6d47febe131bc4c2c85.png\",
     * \"icon_ipad\":\"http://i8.pdim.gs/d0b5b662bea0d0366f2be9ef8127560f.png\"}"},
     * {"cname":"街头篮球","ename":"freestyle","img":"http://i9.pdim
     * .gs/2df1cca1203166fb147dc060c356b016.jpeg","ext":"3800","status":"1",
     * "extra":"{\"icon\":\"http://i5.pdim.gs/a19d34a340747c9b306a3e49d8fb934d.png\",
     * \"icon_ipad\":\"http://i5.pdim.gs/f72daf218c063bb3b1c571b42444d378.png\"}"},
     * {"cname":"传奇专区","ename":"legends","img":"http://i7.pdim
     * .gs/08293e337689b44a7df632379d292ace.png","ext":"4000","status":"1",
     * "extra":"{\"icon\":\"http://i5.pdim.gs/87ba9e960416551408daf7b4e001ce4e.png\",
     * \"icon_ipad\":\"http://i7.pdim.gs/30c38d0ad69ef048f43928225c12f07d.png\"}"},
     * {"cname":"流放之路","ename":"liufang","img":"http://i8.pdim
     * .gs/bda2f1151e1a9730ac566e07db4c59ac.jpeg","ext":"4100","status":"1",
     * "extra":"{\"icon\":\"http://i5.pdim.gs/3dc063b2b7f52ce761827111787e822e.png\",
     * \"icon_ipad\":\"http://i8.pdim.gs/a9c6c7b03663de5b69d6630012699087.png\"}"},
     * {"cname":"昆特牌","ename":"gwent","img":"http://i5.pdim
     * .gs/1bbb7de46eb33940c8a76045e545d9e9.jpeg","ext":"4200","status":"1",
     * "extra":"{\"icon\":\"http://i8.pdim.gs/14faf56d471d6b7cee400e9022177cc5.png\",
     * \"icon_ipad\":\"http://i8.pdim.gs/8ed1c97cb37682b025069c482957074f.png\"}"},
     * {"cname":"暗黑破坏神3","ename":"diablo3","img":"http://i9.pdim
     * .gs/2f5967bf2d64cf9a864eb1088fc4e6b9.png","ext":"4300","status":"1",
     * "extra":"{\"icon\":\"http://i5.pdim.gs/16be11b1f2b5a6a2c71b3f184d9980c6.png\",
     * \"icon_ipad\":\"http://i9.pdim.gs/6768717c9a1fd671c11d8716b17982d7.png\"}"},
     * {"cname":"网络游戏","ename":"wy","img":"http://i5.pdim.gs/e8b33c809f23d6bd767be39a4e9c60cd
     * .jpeg","ext":"4500","status":"1","extra":"{\"icon\":\"http://i5.pdim
     * .gs/da4ac7f2cbfb06a82f3070a7e14e95d9.png\",\"icon_ipad\":\"http://i8.pdim
     * .gs/46ce83e433d50fda966e9520fd7456c6.png\"}"},{"cname":"棋牌游戏","ename":"qipai",
     * "img":"http://i9.pdim.gs/7172f8f1093ab31311f0c92d21031618.png","ext":"4600","status":"1",
     * "extra":"{\"icon\":\"http://i7.pdim.gs/c8badbd2858be152502a8f043878010d.png\",
     * \"icon_ipad\":\"http://i7.pdim.gs/2f39dc249f27107ad16ce9c9632c56e5.png\"}"},
     * {"cname":"战争游戏","ename":"shoot","img":"http://i7.pdim.gs/08b4c3d4eaf326f2cbb1c950b3c17adb
     * .png","ext":"4700","status":"1","extra":"{\"icon\":\"http://i8.pdim
     * .gs/b77111cc000780cd473a9103266f7a01.png\",\"icon_ipad\":\"http://i7.pdim
     * .gs/a6b5a498c3e3eb6dcb0e58dcc3c51bdc.png\"}"},{"cname":"新游中心","ename":"newgames",
     * "img":"http://i5.pdim.gs/3b34f4d53d1897a5bc361e72488158f6.jpeg","ext":"4725","status":"1",
     * "extra":"{\"icon\":\"http://i8.pdim.gs/1a8373fe7162dc719c08807af4d9642c.png\",
     * \"icon_ipad\":\"http://i6.pdim.gs/2f64aad03f592c787b96b303d13045ca.png\"}"},
     * {"cname":"玩吧狼人杀","ename":"wblrs","img":"http://i7.pdim.gs/76d94671667f089a5ac2ee2e5b20182b
     * .jpeg","ext":"4750","status":"1","extra":"{\"icon\":\"http://i7.pdim
     * .gs/8d7c97c6690a6f061ab0ea4df2b78372.png\",\"icon_ipad\":\"http://i6.pdim
     * .gs/35371ee1746b96d946c170ea71c60cee.png\"}"},{"cname":"天龙八部","ename":"tlbb",
     * "img":"http://i8.pdim.gs/d6189d0985b8feb282b9f3767107df53.jpeg","ext":"4760","status":"1",
     * "extra":"{\"icon\":\"http://i8.pdim.gs/b9b10321a1f7bd5ac7796bb9c46fc821.png\",
     * \"icon_ipad\":\"http://i5.pdim.gs/e3073fe828e5791429a977aa1b8ac66b.png\"}"},
     * {"cname":"天天狼人杀","ename":"ttlrs","img":"http://i5.pdim.gs/8e5e1b00981473e0f629b967a430e33a
     * .jpeg","ext":"4800","status":"1","extra":"{\"icon\":\"http://i6.pdim
     * .gs/8ed44645b53550e528b5a5ace83156fe.png\",\"icon_ipad\":\"http://i5.pdim
     * .gs/b2ddaeb5aa12ea8b82bdaf3d0c187b8b.png\"}"},{"cname":"光明大陆","ename":"landofglory",
     * "img":"http://i6.pdim.gs/267632a8e4026c753d4ef76dfa8b2355.jpeg","ext":"4875","status":"1",
     * "extra":"{\"icon\":\"http://i5.pdim.gs/0a8c42523bc83a8f362c066cda498b11.png\",
     * \"icon_ipad\":\"http://i8.pdim.gs/81e2cf5764b6a4d31a3aae6c2c0da91a.png\"}"},
     * {"cname":"捕鱼天地","ename":"fishes","img":"http://i8.pdim
     * .gs/a527d2849b207e822a86778ab72d3741.jpeg","ext":"5000","status":"1",
     * "extra":"{\"icon\":\"http://i9.pdim.gs/83f03e03a8e9adb44e4f300d565adc68.png\",
     * \"icon_ipad\":\"http://i8.pdim.gs/13ef2c55dabe21e2664015a1d5a28fc1.png\"}"},
     * {"cname":"球球大作战","ename":"qqdzz","img":"http://i9.pdim
     * .gs/02441902eddfa641ffdc1ef39ea7a787.png","ext":"5050","status":"1",
     * "extra":"{\"icon\":\"http://i7.pdim.gs/7805db4ae8f6e3954db5fed4514afc7d.png\",
     * \"icon_ipad\":\"http://i6.pdim.gs/b45fc796740185e230bce40197ba1c67.png\"}"},
     * {"cname":"综合手游","ename":"mobilegame","img":"http://i6.pdim
     * .gs/456901c1312c739e5f8802d95671be64.jpeg","ext":"5100","status":"1",
     * "extra":"{\"icon\":\"http://i9.pdim.gs/56286aa5a674c3e6f4e18e6bbc85eafa.png\",
     * \"icon_ipad\":\"http://i5.pdim.gs/ec86a196f1a24a4312a123e1e774a20e.png\"}"},
     * {"cname":"火影忍者","ename":"naruto","img":"http://i5.pdim.gs/ed4fd721c509a49da2fdaa0070b8ea7b
     * .jpeg","ext":"5120","status":"1","extra":"{\"icon\":\"http://i5.pdim
     * .gs/2f065d2926c492aaaa7feea6f3cad3c2.png\",\"icon_ipad\":\"http://i8.pdim
     * .gs/ed982735dff34dac1b0b2dd0453f030f.png\"}"},{"cname":"龙之谷","ename":"lzg",
     * "img":"http://i7.pdim.gs/273bef2e541d9bcbe299a0f71c0aa10b.jpeg","ext":"5140","status":"1",
     * "extra":"{\"icon\":\"http://i5.pdim.gs/738c4eed918a847dbe1cb17f15400ff5.png\",
     * \"icon_ipad\":\"http://i8.pdim.gs/a99b0488599b6f066beec3f308e2e15b.png\"}"},
     * {"cname":"皇室战争","ename":"clashroyale","img":"http://i1.pdim.gs/t01dcf76a6f30fe40c9.jpg",
     * "ext":"5200","status":"1","extra":"{\"icon\":\"http://i5.pdim
     * .gs/f6dc431e485875f32d4c2c0a5975e2db.png\",\"icon_ipad\":\"http://i7.pdim
     * .gs/38eb03896c7d67fd6f994c8b2d50be93.png\"}"},{"cname":"穿越火线手游","ename":"cfmobile",
     * "img":"http://i7.pdim.gs/ed1c459f2a70ccddc2a0fda4a19abff6.jpeg","ext":"5310","status":"1",
     * "extra":"{\"icon\":\"http://i9.pdim.gs/5899d8ec28e2c2d68f9c3a5b7a7c1344.png\",
     * \"icon_ipad\":\"http://i9.pdim.gs/9496dc84ef3f62f7c0d4f723447d64fb.png\"}"},{"cname":"街篮",
     * "ename":"basketball","img":"http://i6.pdim.gs/f299f8a28e019b45705e9faf8251596a.jpeg",
     * "ext":"5320","status":"1","extra":"{\"icon\":\"http://i7.pdim
     * .gs/e1aff607b5644e5979dfe14271776360.png\",\"icon_ipad\":\"http://i9.pdim
     * .gs/cdb921622b349835a4fdef741ec90f69.png\"}"},{"cname":"畅所欲言","ename":"voice",
     * "img":"http://i7.pdim.gs/76a445876754e15663fea71abe1226f7.jpeg","ext":"5450","status":"1",
     * "extra":"{\"icon\":\"http://i7.pdim.gs/a8279e2627110448e11ec05c22393730.png\"}"},
     * {"cname":"音乐","ename":"music","img":"http://i7.pdim.gs/8e9344e30158d1c220edf0b283ea126d
     * .jpeg","ext":"5500","status":"1","extra":"{\"icon\":\"\",\"icon_ipad\":\"\"}"},
     * {"cname":"二次元","ename":"ciyuan","img":"http://i6.pdim
     * .gs/c71ffe529f4b57f20e0b96a59e9cb373.jpeg","ext":"5550","status":"1",
     * "extra":"{\"icon\":\"http://i8.pdim.gs/30644945867789c97efac6ab994c647e.png\"}"},
     * {"cname":"萌宠乐园","ename":"pets","img":"http://i9.pdim
     * .gs/f4f6afc39926a3a27ca6fd1c65915f66.jpeg","ext":"5600","status":"1",
     * "extra":"{\"icon\":\"\"}"},{"cname":"科技教育","ename":"technology","img":"http://i9.pdim
     * .gs/c229fe2fca95b936a69ad4afb1db9982.png","ext":"5800","status":"1",
     * "extra":"{\"icon\":\"\"}"},{"cname":"金融理财","ename":"finance","img":"http://i8.pdim
     * .gs/786e07efa4ac229a043cf37e6c925dfd.png","ext":"5900","status":"1",
     * "extra":"{\"icon\":\"\"}"},{"cname":"桌游","ename":"boardgames","img":"http://i6.pdim
     * .gs/6548ddd8622675ffcef9a2e05fe111f3.jpeg","ext":"6500","status":"1",
     * "extra":"{\"icon\":\"http://i8.pdim.gs/30644945867789c97efac6ab994c647e.png\"}"}]
     * authseq :
     */

    private String errno;
    private String errmsg;
    private String authseq;
    private List<DataBean> data;

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
        /**
         * cname : 英雄联盟
         * ename : lol
         * img : http://i9.pdim.gs/23e529ba353b33c2f70e6d60f6be4c29.jpeg
         * ext : 400
         * status : 1
         * extra : {"icon":"http://i5.pdim.gs/79db522e2b647fd7a00c2bfc02ce3b57.png","icon_ipad":"http://i8.pdim.gs/173d4333e6dd4798732d099a4b0c08a8.png"}
         */

        private String cname;
        private String ename;
        private String img;
        private String ext;
        private String status;
        private String extra;

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
    }
}
