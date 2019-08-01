package com.Haoxuan.wacai.web.dao;

import com.Haoxuan.wacai.web.dataobject.WanghaoxuanAccountingRecord;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
@Mapper
public interface WanghaoxuanAccountingRecordMapper {
    @Delete({
        "delete from wanghaoxuan_accounting_record",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into wanghaoxuan_accounting_record (record_type, ",
        "des, amount, record_time, ",
        "category, gmt_create, ",
        "gmt_modifie)",
        " #{recordType,jdbcType=VARCHAR}, ",
        "#{des,jdbcType=VARCHAR}, #{amount,jdbcType=DOUBLE}, #{recordTime,jdbcType=TIMESTAMP}, ",
        "#{category,jdbcType=VARCHAR}, now(),",
        "now())"
    })
    int insert(WanghaoxuanAccountingRecord record);

    @Select({
        "select",
        "id, record_type, des, amount, record_time, category, gmt_create, gmt_modifie",
        "from wanghaoxuan_accounting_record",
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
    WanghaoxuanAccountingRecord selectByPrimaryKey(Long id);

    @Select({
        "select",
        "id, record_type, des, amount, record_time, category, gmt_create, gmt_modifie",
        "from wanghaoxuan_accounting_record"
    })
    @Results(id = "Alldata",value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="record_type", property="recordType", jdbcType=JdbcType.VARCHAR),
        @Result(column="des", property="des", jdbcType=JdbcType.VARCHAR),
        @Result(column="amount", property="amount", jdbcType=JdbcType.DOUBLE),
        @Result(column="record_time", property="recordTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="category", property="category", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modifie", property="gmtModifie", jdbcType=JdbcType.TIMESTAMP)
    })
    List<WanghaoxuanAccountingRecord> selectAll();

    @Select({
            "select",
            "id, record_type, des, amount, record_time, category, gmt_create, gmt_modifie",
            "from wanghaoxuan_accounting_record",
            "where record_time=#{recordTime}"
    })
    @ResultMap("Alldata")
    List<WanghaoxuanAccountingRecord> selectDate(@Param("recordTime") Date recordTime);

    @Update({
        "update wanghaoxuan_accounting_record",
        "set record_type = #{recordType,jdbcType=VARCHAR},",
          "des = #{des,jdbcType=VARCHAR},",
          "amount = #{amount,jdbcType=DOUBLE},",
          "record_time = #{recordTime,jdbcType=TIMESTAMP},",
          "category = #{category,jdbcType=VARCHAR},",
          "gmt_modifie = now()",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(WanghaoxuanAccountingRecord record);
}