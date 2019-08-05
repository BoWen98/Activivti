package com.bowen.day4.activiti.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @ProjectName: Activivti
 * @Package: com.bowen.day4.activiti.pojo
 * @ClassName: Holiday
 * @Author: Bowen
 * @Description: 请假实体类
 * @Date: 2019/8/5 12:24
 * @Version: 1.0.0
 */
public class Holiday implements Serializable {

    private Integer id;
    private String holidayName;
    private Date beginDate;//开始日期
    private Date endDate;//结束日期
    private Float num;//请假天数
    private String reason;//事由
    private  String type;//请假类型

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHolidayName() {
        return holidayName;
    }

    public void setHolidayName(String holidayName) {
        this.holidayName = holidayName;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Float getNum() {
        return num;
    }

    public void setNum(Float num) {
        this.num = num;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Holiday{" +
                "id=" + id +
                ", holidayName='" + holidayName + '\'' +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", num=" + num +
                ", reason='" + reason + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
