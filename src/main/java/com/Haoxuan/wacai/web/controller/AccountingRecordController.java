package com.Haoxuan.wacai.web.controller;

import com.Haoxuan.wacai.web.dao.WanghaoxuanAccountingRecordMapper;
import com.Haoxuan.wacai.web.dataobject.WanghaoxuanAccountingRecord;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.security.provider.Sun;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
public class AccountingRecordController {
    @Autowired
    WanghaoxuanAccountingRecordMapper wanghaoxuanAccountingRecordMapper;

    @RequestMapping(path = "/add")//增加数据
    public String add(){
        Date nowTime=new Date();
        WanghaoxuanAccountingRecord wanghaoxuanAccountingRecord=new WanghaoxuanAccountingRecord();
        wanghaoxuanAccountingRecord.setRecordTime(nowTime);//创建时间
        wanghaoxuanAccountingRecord.setRecordType("支付宝");//支付类型
        wanghaoxuanAccountingRecord.setAmount((double)100);//支付金额
        wanghaoxuanAccountingRecord.setCategory("学习用品");//商品类型
        wanghaoxuanAccountingRecord.setDes("计算机用书");//备注
        wanghaoxuanAccountingRecordMapper.insert(wanghaoxuanAccountingRecord);
        return "成功添加";
    }

    @RequestMapping(path = "/delete")//排除数据
    public String delete(){
        wanghaoxuanAccountingRecordMapper.deleteByPrimaryKey((long) 6);
        return "删除成功";
    }


    @RequestMapping(path = "/modify")//修改数据
    public String modify(){

        WanghaoxuanAccountingRecord recordModify=new WanghaoxuanAccountingRecord();
        recordModify.setId((long)6);
        recordModify.setRecordType("花呗");
        recordModify.setCategory("外卖");
        recordModify.setAmount((double) 100);
        recordModify.setDes("午饭是肥牛饭");
        if (recordModify.getId()!=null)
        wanghaoxuanAccountingRecordMapper.updateByPrimaryKey(recordModify);
        return "修改成功";
    }

    @RequestMapping(path = "/list")//查询数据
    public List<WanghaoxuanAccountingRecord>listall(){
        List<WanghaoxuanAccountingRecord>accountingRecords=wanghaoxuanAccountingRecordMapper.selectAll();
        return accountingRecords;
    }

    @RequestMapping(path = "/list/date")//时间查询
    public List<WanghaoxuanAccountingRecord>listdate(){
        Calendar calendar=Calendar.getInstance();
        calendar.set(2018,2,24);
        Date date=calendar.getTime();//date就是你需要的时间
        List<WanghaoxuanAccountingRecord>accountingRecords=wanghaoxuanAccountingRecordMapper.selectDate(date);
        return  accountingRecords;
    }


}
