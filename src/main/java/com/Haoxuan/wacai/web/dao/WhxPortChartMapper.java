package com.File.Wang.Web.dao;

import com.File.Wang.Web.dataobject.WhxPortChart;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
@Mapper
public interface WhxPortChartMapper {
    @Delete({
        "delete from whx_port_chart",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into whx_port_chart ( port, ",
        "password, name, ",
        "phone)",
        "values ( #{port,jdbcType=VARCHAR}, ",
        "#{password,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, ",
        "#{phone,jdbcType=VARCHAR})"
    })
    int insert(WhxPortChart record);

    @Select({
        "select",
        "id, port, password, name, phone",
        "from whx_port_chart",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="port", property="port", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR)
    })
    WhxPortChart selectByPrimaryKey(Integer id);
    @Select({
            "select",
            "count(*)",
            "from whx_port_chart"
    })
    int countRecords();
    @Select({
        "select",
        "id, port, password, name, phone",
        "from whx_port_chart"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="port", property="port", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR)
    })
    List<WhxPortChart> selectAll();
    @Select({
            "select",
            "id,phone, name, port, password",
            "from whx_port_chart",
            "limit #{offset}, #{size}"
    })
    @ResultMap("select")
    List<WhxPortChart> selectByPagination(@Param("offset") int offset, @Param("size") int size);
    @Update({
        "update whx_port_chart",
        "set port = #{port,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "name = #{name,jdbcType=VARCHAR},",
          "phone = #{phone,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(WhxPortChart record);
}