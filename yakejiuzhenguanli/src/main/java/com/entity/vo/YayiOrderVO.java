package com.entity.vo;

import com.entity.YayiOrderEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 牙医挂号
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("yayi_order")
public class YayiOrderVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 订单编号
     */

    @TableField(value = "yayi_order_uuid_number")
    private String yayiOrderUuidNumber;


    /**
     * 牙医
     */

    @TableField(value = "yayi_id")
    private Integer yayiId;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 预约类型
     */

    @TableField(value = "yayi_order_yuyue_types")
    private Integer yayiOrderYuyueTypes;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 预约日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "yayi_order_time")
    private Date yayiOrderTime;


    /**
     * 预约状态
     */

    @TableField(value = "yayi_order_types")
    private Integer yayiOrderTypes;


    /**
     * 创建时间 show3 listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：订单编号
	 */
    public String getYayiOrderUuidNumber() {
        return yayiOrderUuidNumber;
    }


    /**
	 * 获取：订单编号
	 */

    public void setYayiOrderUuidNumber(String yayiOrderUuidNumber) {
        this.yayiOrderUuidNumber = yayiOrderUuidNumber;
    }
    /**
	 * 设置：牙医
	 */
    public Integer getYayiId() {
        return yayiId;
    }


    /**
	 * 获取：牙医
	 */

    public void setYayiId(Integer yayiId) {
        this.yayiId = yayiId;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：预约类型
	 */
    public Integer getYayiOrderYuyueTypes() {
        return yayiOrderYuyueTypes;
    }


    /**
	 * 获取：预约类型
	 */

    public void setYayiOrderYuyueTypes(Integer yayiOrderYuyueTypes) {
        this.yayiOrderYuyueTypes = yayiOrderYuyueTypes;
    }
    /**
	 * 设置：申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：申请时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：预约日期
	 */
    public Date getYayiOrderTime() {
        return yayiOrderTime;
    }


    /**
	 * 获取：预约日期
	 */

    public void setYayiOrderTime(Date yayiOrderTime) {
        this.yayiOrderTime = yayiOrderTime;
    }
    /**
	 * 设置：预约状态
	 */
    public Integer getYayiOrderTypes() {
        return yayiOrderTypes;
    }


    /**
	 * 获取：预约状态
	 */

    public void setYayiOrderTypes(Integer yayiOrderTypes) {
        this.yayiOrderTypes = yayiOrderTypes;
    }
    /**
	 * 设置：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
