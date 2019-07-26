package com.Haoxuan.wacai.web.dao;

import com.Haoxuan.wacai.web.dataobject.WanghaoxuanRecordtable;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface WanghaoxuanRecordtableMapper {
    @Delete({
        "delete from wanghaoxuan_recordtable",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into wanghaoxuan_recordtable (id, record_type, ",
        "des, amount, record_time, ",
        "category, gmt_create, ",
        "gmt_modifie)",
        "values (#{id,jdbcType=BIGINT}, #{recordType,jdbcType=VARCHAR}, ",
        "#{des,jdbcType=VARCHAR}, #{amount,jdbcType=DOUBLE}, #{recordTime,jdbcType=TIMESTAMP}, ",
        "#{category,jdbcType=VARCHAR}, now(), ",
        "now()"
    })
    int insert(WanghaoxuanRecordtable record);

    @Select({
        "select",
        "id, record_type, des, amount, record_time, category, gmt_create, gmt_modifie",
        "from wanghaoxuan_recordtable",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="record_type", property="recordType", jdbcType=JdbcType.VARCHAR),
        @Result(column="des", property="des", jdbcType=JdbcType.VARCHAR),
        @Result(column="amount", property="amount", jdbcType=JdbcType.DOUBLE),
        @Result(column="record_time", property="recordTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="category", property="category", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modifie", property="gmtModifie", jdbcType=JdbcType.TIMESTAMP)
    })
    WanghaoxuanRecordtable selectByPrimaryKey(Long id);

    @Select({
        "select",
        "id, record_type, des, amount, record_time, category, gmt_create, gmt_modifie",
        "from wanghaoxuan_recordtable"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="record_type", property="recordType", jdbcType=JdbcType.VARCHAR),
        @Result(column="des", property="des", jdbcType=JdbcType.VARCHAR),
        @Result(column="amount", property="amount", jdbcType=JdbcType.DOUBLE),
        @Result(column="record_time", property="recordTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="category", property="category", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modifie", property="gmtModifie", jdbcType=JdbcType.TIMESTAMP)
    })
    List<WanghaoxuanRecordtable> selectAll();

    @Update({
        "update wanghaoxuan_recordtable",
        "set record_type = #{recordType,jdbcType=VARCHAR},",
          "des = #{des,jdbcType=VARCHAR},",
          "amount = #{amount,jdbcType=DOUBLE},",
          "record_time = #{recordTime,jdbcType=TIMESTAMP},",
          "category = #{category,jdbcType=VARCHAR},",
          "gmt_modifie = #{gmtModifie,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(WanghaoxuanRecordtable record);
}