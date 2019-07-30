package com.Haoxuan.wacai.web.dao;

import com.Haoxuan.wacai.web.dataobject.WanghaoxuanAccountingRecord;
import org.apache.ibatis.jdbc.SQL;

public class MixBuilder {
    public String buildMix(WanghaoxuanAccountingRecord wanghaoxuanAccountingRecord){
        return new SQL() {
            {
                SELECT("id, record_type, des, amount, record_time, category, gmt_create, gmt_modifie");
                FROM("wanghaoxuan_accounting_record");
                if (wanghaoxuanAccountingRecord.getRecordTime()!=null){
                    WHERE("record_time=#{wanghaoxuanAccountingRecord.recordTime}");
                }
                ORDER_BY("record_time");
            }
            }.toString();

    }
}
