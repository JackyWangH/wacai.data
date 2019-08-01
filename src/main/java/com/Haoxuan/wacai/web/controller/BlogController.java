package com.Haoxuan.wacai.web.controller;


import com.Haoxuan.wacai.web.dao.WangHaoxuanBlogChartMapper;
import com.Haoxuan.wacai.web.dataobject.WangHaoxuanBlogChart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class BlogController {
    @Autowired
    WangHaoxuanBlogChartMapper wangHaoxuanBlogChartMapper;

    @RequestMapping(path = "/blog/add")
    public String add(){
        WangHaoxuanBlogChart blogChart=new WangHaoxuanBlogChart();
        Date nowTime=new Date();
        blogChart.setArticleAuthor("王灏轩");
        blogChart.setArticleContent("");
        blogChart.setArticleCount((long)2);
        blogChart.setArticleFrom("");
        blogChart.setArticleTitle("");
        blogChart.setArticleType("");
        blogChart.setMine("");
        blogChart.setDz((long)6);
        blogChart.setSc((long)4);
        blogChart.setArticleSdtime(nowTime);
        wangHaoxuanBlogChartMapper.insert(blogChart);
        return  "成功添加一条博客数据";
    }

    @RequestMapping(path = "/blog/delete")
    public String delete(){
        wangHaoxuanBlogChartMapper.deleteByPrimaryKey(31);
        return "成功删除一条博客";
    }

    @RequestMapping(path = "/blog/find")
    public List<WangHaoxuanBlogChart> find(){
        WangHaoxuanBlogChart blogChart=new WangHaoxuanBlogChart();

       List<WangHaoxuanBlogChart>blogCharts=wangHaoxuanBlogChartMapper.selectAll();
       return blogCharts;
    }

    @RequestMapping(path = "/blog/mine")
    public List<WangHaoxuanBlogChart> mine(){
        WangHaoxuanBlogChart myBlog=new WangHaoxuanBlogChart();
        List<WangHaoxuanBlogChart>wangHaoxuanBlogCharts=wangHaoxuanBlogChartMapper.selectMine();
        return wangHaoxuanBlogCharts;
    }

}
