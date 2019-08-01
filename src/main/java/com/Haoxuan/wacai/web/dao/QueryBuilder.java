package com.Haoxuan.wacai.web.dao;

import com.Haoxuan.wacai.web.dataobject.WangHaoxuanBlogChart;
import com.Haoxuan.wacai.web.dataobject.WanghaoxuanAccountingRecord;
import org.apache.ibatis.jdbc.SQL;

public class QueryBuilder {
    public String buildQuery(WangHaoxuanBlogChart wangHaoxuanBlogChart){
        return new SQL() {
            {
                SELECT("id, article_type, article_title, article_content, article_sdTime, article_count");
                FROM("wang_haoxuan_blog_chart");

                if(wangHaoxuanBlogChart.getArticleSdtime()!=null){
                    WHERE("article_sdTime");
                }
                ORDER_BY("article_sdTime desc limit 8");
            }
            }.toString();

    }
}
