package com.Haoxuan.wacai.web.dao;


import com.Haoxuan.wacai.web.dataobject.WangHaoxuanBlogChart;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface WangHaoxuanBlogChartMapper {

    @Delete({        "delete from wang_haoxuan_blog_chart",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(int id);

    @Insert({
        "insert into wang_haoxuan_blog_chart (article_type, ",
        "article_title, article_content, ",
        "article_sdTime, article_count, ",
        "article_from, article_author, ",
        "dz, sc, Mine)",
        "values (#{articleType,jdbcType=VARCHAR}, ",
        "#{articleTitle,jdbcType=VARCHAR}, #{articleContent,jdbcType=VARCHAR}, ",
        "now(), #{articleCount,jdbcType=BIGINT}, ",
        "#{articleFrom,jdbcType=VARCHAR}, #{articleAuthor,jdbcType=VARCHAR}, ",
        "#{dz,jdbcType=BIGINT}, #{sc,jdbcType=BIGINT}, #{mine,jdbcType=VARCHAR})"
    })
    int insert(WangHaoxuanBlogChart record);

    @Select({
        "select",
        "id, article_type, article_title, article_content, article_sdTime, article_count, ",
        "article_from, article_author, dz, sc, Mine",
        "from wang_haoxuan_blog_chart",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="article_type", property="articleType", jdbcType=JdbcType.VARCHAR),
        @Result(column="article_title", property="articleTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="article_content", property="articleContent", jdbcType=JdbcType.VARCHAR),
        @Result(column="article_sdTime", property="articleSdtime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="article_count", property="articleCount", jdbcType=JdbcType.BIGINT),
        @Result(column="article_from", property="articleFrom", jdbcType=JdbcType.VARCHAR),
        @Result(column="article_author", property="articleAuthor", jdbcType=JdbcType.VARCHAR),
        @Result(column="dz", property="dz", jdbcType=JdbcType.BIGINT),
        @Result(column="sc", property="sc", jdbcType=JdbcType.BIGINT),
        @Result(column="Mine", property="mine", jdbcType=JdbcType.VARCHAR)
    })
    WangHaoxuanBlogChart selectByPrimaryKey(Long id);

    @Select({
        "select",
        "id, article_type, article_title, article_content, article_sdTime, article_count, ",
        "article_from, article_author, dz, sc, Mine",
        "from wang_haoxuan_blog_chart order by article_sdTime desc limit 8 ",
    })
    @Results(id = "blogChart",value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="article_type", property="articleType", jdbcType=JdbcType.VARCHAR),
        @Result(column="article_title", property="articleTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="article_content", property="articleContent", jdbcType=JdbcType.VARCHAR),
        @Result(column="article_sdTime", property="articleSdtime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="article_count", property="articleCount", jdbcType=JdbcType.BIGINT),
        @Result(column="article_from", property="articleFrom", jdbcType=JdbcType.VARCHAR),
        @Result(column="article_author", property="articleAuthor", jdbcType=JdbcType.VARCHAR),
        @Result(column="dz", property="dz", jdbcType=JdbcType.BIGINT),
        @Result(column="sc", property="sc", jdbcType=JdbcType.BIGINT),
        @Result(column="Mine", property="mine", jdbcType=JdbcType.VARCHAR)
    })
    List<WangHaoxuanBlogChart> selectAll();


    @Select({
            "select",
            "id, article_type, article_title, article_content, article_sdTime, article_count, ",
            "article_from, article_author, dz, sc, Mine",
            "from wang_haoxuan_blog_chart",
            "where Mine='Y' limit 8"
    })

    @ResultMap("blogChart")
    List<WangHaoxuanBlogChart>selectMine();

    @Select({
            "select",
            "id, article_type, article_title, article_content, article_sdTime, article_count, ",
            "article_from, article_author, dz, sc, Mine",
            "from wang_haoxuan_blog_chart"
    })

   /* @SelectProvider(type = QueryBuilder.class,method = "buildQuery")
    @ResultMap("blogChart")
    List<WangHaoxuanBlogChart> query(@Param("wangHaoxuanBlogChart")WangHaoxuanBlogChart wangHaoxuanBlogChart);
*/



    @Update({
        "update wang_haoxuan_blog_chart",
        "set article_type = #{articleType,jdbcType=VARCHAR},",
          "article_title = #{articleTitle,jdbcType=VARCHAR},",
          "article_content = #{articleContent,jdbcType=VARCHAR},",
          "article_sdTime = now()",
          "article_count = #{articleCount,jdbcType=BIGINT},",
          "article_from = #{articleFrom,jdbcType=VARCHAR},",
          "article_author = #{articleAuthor,jdbcType=VARCHAR},",
          "dz = #{dz,jdbcType=BIGINT},",
          "sc = #{sc,jdbcType=BIGINT},",
          "Mine = #{mine,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(WangHaoxuanBlogChart record);
}