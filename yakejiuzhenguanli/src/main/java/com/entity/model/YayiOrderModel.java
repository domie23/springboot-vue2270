package com.entity.model;

import com.entity.YayiOrderEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 牙医挂号
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class YayiOrderModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 订单编号
     */
    private String yayiOrderUuidNumber;


    /**
     * 牙医
     */
    private Integer yayiId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 预约类型
     */
    private Integer yayiOrderYuyueTypes;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 预约日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date yayiOrderTime;


    /**
     * 预约状态
     */
    private Integer yayiOrderTypes;


    /**
     * 创建时间 show3 listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：订单编号
	 */
    public String getYayiOrderUuidNumber() {
        return yayiOrderUuidNumber;
    }


    /**
	 * 设置：订单编号
	 */
    public void setYayiOrderUuidNumber(String yayiOrderUuidNumber) {
        this.yayiOrderUuidNumber = yayiOrderUuidNumber;
    }
    /**
	 * 获取：牙医
	 */
    public Integer getYayiId() {
        return yayiId;
    }


    /**
	 * 设置：牙医
	 */
    public void setYayiId(Integer yayiId) {
        this.yayiId = yayiId;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：预约类型
	 */
    public Integer getYayiOrderYuyueTypes() {
        return yayiOrderYuyueTypes;
    }


    /**
	 * 设置：预约类型
	 */
    public void setYayiOrderYuyueTypes(Integer yayiOrderYuyueTypes) {
        this.yayiOrderYuyueTypes = yayiOrderYuyueTypes;
    }
    /**
	 * 获取：申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：申请时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：预约日期
	 */
    public Date getYayiOrderTime() {
        return yayiOrderTime;
    }


    /**
	 * 设置：预约日期
	 */
    public void setYayiOrderTime(Date yayiOrderTime) {
        this.yayiOrderTime = yayiOrderTime;
    }
    /**
	 * 获取：预约状态
	 */
    public Integer getYayiOrderTypes() {
        return yayiOrderTypes;
    }


    /**
	 * 设置：预约状态
	 */
    public void setYayiOrderTypes(Integer yayiOrderTypes) {
        this.yayiOrderTypes = yayiOrderTypes;
    }
    /**
	 * 获取：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
