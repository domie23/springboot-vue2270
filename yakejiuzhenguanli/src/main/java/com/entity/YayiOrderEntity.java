package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 牙医挂号
 *
 * @author 
 * @email
 */
@TableName("yayi_order")
public class YayiOrderEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public YayiOrderEntity() {

	}

	public YayiOrderEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 订单编号
     */
    @ColumnInfo(comment="订单编号",type="varchar(200)")
    @TableField(value = "yayi_order_uuid_number")

    private String yayiOrderUuidNumber;


    /**
     * 牙医
     */
    @ColumnInfo(comment="牙医",type="int(11)")
    @TableField(value = "yayi_id")

    private Integer yayiId;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 预约类型
     */
    @ColumnInfo(comment="预约类型",type="int(11)")
    @TableField(value = "yayi_order_yuyue_types")

    private Integer yayiOrderYuyueTypes;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="申请时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 预约日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat
    @ColumnInfo(comment="预约日期",type="date")
    @TableField(value = "yayi_order_time")

    private Date yayiOrderTime;


    /**
     * 预约状态
     */
    @ColumnInfo(comment="预约状态",type="int(11)")
    @TableField(value = "yayi_order_types")

    private Integer yayiOrderTypes;


    /**
     * 创建时间  listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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
	 * 获取：创建时间  listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间  listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "YayiOrder{" +
            ", id=" + id +
            ", yayiOrderUuidNumber=" + yayiOrderUuidNumber +
            ", yayiId=" + yayiId +
            ", yonghuId=" + yonghuId +
            ", yayiOrderYuyueTypes=" + yayiOrderYuyueTypes +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", yayiOrderTime=" + DateUtil.convertString(yayiOrderTime,"yyyy-MM-dd") +
            ", yayiOrderTypes=" + yayiOrderTypes +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
