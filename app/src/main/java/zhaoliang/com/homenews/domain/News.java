package zhaoliang.com.homenews.domain;

import java.util.List;

/**
 * Created by zhaoliang on 2016/12/22.
 */

public class News {

    /**
     * result : [{"ctime":"2016-12-22 14:15","title":"复兴航空工会500人游行 或到蔡英文官邸陈情","description":"搜狐国内","picUrl":"http://photocdn.sohu.com/20161222/Img476626654_ss.jpeg","url":"http://news.sohu.com/20161222/n476630061.shtml"},{"ctime":"2016-12-22 14:26","title":"魄力-定力-魅力 2016中国元首外交的世界印象","description":"搜狐国内","picUrl":"http://photocdn.sohu.com/20161222/Img476630063_ss.jpeg","url":"http://news.sohu.com/20161222/n476631210.shtml"},{"ctime":"2016-12-22 13:11","title":"中德研究人员宣布破解华北雾霾主要成分形成之谜","description":"搜狐国内","picUrl":"http://photocdn.sohu.com/20161222/Img476604553_ss.jpeg","url":"http://news.sohu.com/20161222/n476623726.shtml"},{"ctime":"2016-12-22 13:31","title":"陕西省委宣传部部长梁桂兼任常务副省长职务","description":"搜狐国内","picUrl":"http://photocdn.sohu.com/20161222/Img476607992_ss.jpeg","url":"http://news.sohu.com/20161222/n476625697.shtml"},{"ctime":"2016-12-22 13:37","title":"【全国文明家庭事迹展播】将小爱成就为大爱","description":"搜狐国内","picUrl":"http://photocdn.sohu.com/20161222/Img476615489_ss.jpeg","url":"http://news.sohu.com/20161222/n476626162.shtml"},{"ctime":"2016-12-22 13:38","title":"阿里回应美将淘宝列入\u201c恶名市场\u201d：非常失望","description":"搜狐国内","picUrl":"http://photocdn.sohu.com/20161222/Img476625698_ss.jpeg","url":"http://news.sohu.com/20161222/n476626286.shtml"},{"ctime":"2016-12-22 13:42","title":"国家空气监测事权全上收 环保部：严处数据造假","description":"搜狐国内","picUrl":"http://photocdn.sohu.com/20161222/Img476626163_ss.jpeg","url":"http://news.sohu.com/20161222/n476626653.shtml"},{"ctime":"2016-12-22 13:57","title":"国家税务总局：\u201c死亡税率\u201d之说严重误导公众","description":"搜狐国内","picUrl":"http://photocdn.sohu.com/20161222/Img476626654_ss.jpeg","url":"http://news.sohu.com/20161222/n476627833.shtml"},{"ctime":"2016-12-22 12:01","title":"财政部：明确金融、房地产开发等增值税政策","description":"搜狐国内","picUrl":"http://photocdn.sohu.com/20161222/Img476607992_ss.jpeg","url":"http://news.sohu.com/20161222/n476616511.shtml"},{"ctime":"2016-12-22 12:02","title":"陈水扁之子：小心尼加拉瓜在出访日提\u201c断交\u201d","description":"搜狐国内","picUrl":"http://photocdn.sohu.com/20161222/Img476615489_ss.jpeg","url":"http://news.sohu.com/20161222/n476616682.shtml"}]
     * error_code : 0
     * reason : Succes
     */

    private int error_code;
    private String reason;
    private List<ResultBean> result;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * ctime : 2016-12-22 14:15
         * title : 复兴航空工会500人游行 或到蔡英文官邸陈情
         * description : 搜狐国内
         * picUrl : http://photocdn.sohu.com/20161222/Img476626654_ss.jpeg
         * url : http://news.sohu.com/20161222/n476630061.shtml
         */

        private String ctime;
        private String title;
        private String description;
        private String picUrl;
        private String url;

        public String getCtime() {
            return ctime;
        }

        public void setCtime(String ctime) {
            this.ctime = ctime;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
