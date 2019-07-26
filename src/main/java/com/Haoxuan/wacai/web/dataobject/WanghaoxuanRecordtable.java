package com.Haoxuan.wacai.web.dataobject;

import java.util.Date;

/**
 * 
 * @date 2019/07/26
 */
public class WanghaoxuanRecordtable {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 记录类型：支付类型
     */
    private String recordType;

    /**
     * 账户记录详情，备注
     */
    private String des;

    /**
     * 流水金额
     */
    private Double amount;

    /**
     * 流水时间
     */
    private Date recordTime;

    /**
     * 分类
     */
    private String category;

    /**
     * 数据创建时间
     */
    private Date gmtCreate;

    /**
     * 数据修改时间
     */
    private Date gmtModifie;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRecordType() {
        return recordType;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModifie() {
        return gmtModifie;
    }

    public void setGmtModifie(Date gmtModifie) {
        this.gmtModifie = gmtModifie;
    }
}