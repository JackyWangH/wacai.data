package com.Haoxuan.wacai.web.dataobject;

import java.util.Date;

/**
 * 
 * @date 2019/07/31
 */
public class WangHaoxuanBlogChart {
    /**
     * 主键
     */
    private Long id;

    /**
     * 文章类型
     */
    private String articleType;

    /**
     * 文章标题
     */
    private String articleTitle;

    /**
     * 文章内容
     */
    private String articleContent;

    /**
     * 文章发表时间
     */
    private Date articleSdtime;

    /**
     * 阅读文章次数
     */
    private Long articleCount;

    /**
     * 文章来源(原创转载)
     */
    private String articleFrom;

    /**
     * 文章作者
     */
    private String articleAuthor;

    /**
     * 点赞数
     */
    private Long dz;

    /**
     * 收藏数
     */
    private Long sc;

    /**
     * 我发出的
     */
    private String mine;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArticleType() {
        return articleType;
    }

    public void setArticleType(String articleType) {
        this.articleType = articleType;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public Date getArticleSdtime() {
        return articleSdtime;
    }

    public void setArticleSdtime(Date articleSdtime) {
        this.articleSdtime = articleSdtime;
    }

    public Long getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(Long articleCount) {
        this.articleCount = articleCount;
    }

    public String getArticleFrom() {
        return articleFrom;
    }

    public void setArticleFrom(String articleFrom) {
        this.articleFrom = articleFrom;
    }

    public String getArticleAuthor() {
        return articleAuthor;
    }

    public void setArticleAuthor(String articleAuthor) {
        this.articleAuthor = articleAuthor;
    }

    public Long getDz() {
        return dz;
    }

    public void setDz(Long dz) {
        this.dz = dz;
    }

    public Long getSc() {
        return sc;
    }

    public void setSc(Long sc) {
        this.sc = sc;
    }

    public String getMine() {
        return mine;
    }

    public void setMine(String mine) {
        this.mine = mine;
    }
}