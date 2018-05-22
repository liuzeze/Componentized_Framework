package gctraveltools.jsj.com.cn.zhihuribao.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * -------- 日期 ---------- 维护人 ------------ 变更内容 --------
 * 2017/12/28	15:44	    刘泽			    新增 类
 * 2017/12/28	15:44	    刘泽			    增加yyy属性
 */

public class NewsDetailBean {


    /**
     * body :
     * css : ["http://news.at.zhihu.com/css/news_qa.auto.css?v=1edab"]
     * id : 4772126
     * title : 深夜惊奇 · 朋友圈错觉
     */

    @SerializedName("body")
    private String body;
    @SerializedName("id")
    private int id;
    @SerializedName("title")
    private String title;
    @SerializedName("css")
    private List<String> css;

    public void setBody(String body) {
        this.body = body;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCss(List<String> css) {
        this.css = css;
    }

    public String getBody() {
        return body;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getCss() {
        return css;
    }
}
