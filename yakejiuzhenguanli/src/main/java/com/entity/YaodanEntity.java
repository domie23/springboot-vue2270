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
 * 药单
 *
 * @author 
 * @email
 */
@TableName("yaodan")
public class YaodanEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public YaodanEntity() {

	}

	public YaodanEntity(T t) {
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
     * 药单编号
     */
    @ColumnInfo(comment="药单编号",type="varchar(200)")
    @TableField(value = "yaodan_uuid_number")

    private String yaodanUuidNumber;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 牙医
     */
    @ColumnInfo(comment="牙医",type="int(11)")
    @TableField(value = "yayi_id")

    private Integer yayiId;


    /**
     * 检查时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="检查时间",type="timestamp")
    @TableField(value = "jiancha_time")

    private Date jianchaTime;


    /**
     * 病人自述
     */
    @ColumnInfo(comment="病人自述",type="text")
    @TableField(value = "bingrenzishu_content")

    private String bingrenzishuContent;


    /**
     * 检查结果
     */
    @ColumnInfo(comment="检查结果",type="text")
    @TableField(value = "jianchajieguo_content")

    private String jianchajieguoContent;


    /**
     * 药品信息
     */
    @ColumnInfo(comment="药品信息",type="text")
    @TableField(value = "yishengkaifang_yaopin_content")

    private String yishengkaifangYaopinContent;


    /**
     * 医生开方
     */
    @ColumnInfo(comment="医生开方",type="text")
    @TableField(value = "yishengkaifang_content")

    private String yishengkaifangContent;


    /**
     * 医生建议
     */
    @ColumnInfo(comment="医生建议",type="text")
    @TableField(value = "yishengjianyi_content")

    private String yishengjianyiContent;


    /**
     * 花费金额
     */
    @ColumnInfo(comment="花费金额",type="decimal(10,2)")
    @TableField(value = "huafeijine")

    private Double huafeijine;


    /**
     * 下次就诊时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="下次就诊时间",type="timestamp")
    @TableField(value = "xiacijiuzhen_time")

    private Date xiacijiuzhenTime;


    /**
     * 状态
     */
    @ColumnInfo(comment="状态",type="int(11)")
    @TableField(value = "bingli_types")

    private Integer bingliTypes;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


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
	 * 获取：药单编号
	 */
    public String getYaodanUuidNumber() {
        return yaodanUuidNumber;
    }
    /**
	 * 设置：药单编号
	 */

    public void setYaodanUuidNumber(String yaodanUuidNumber) {
        this.yaodanUuidNumber = yaodanUuidNumber;
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
	 * 获取：检查时间
	 */
    public Date getJianchaTime() {
        return jianchaTime;
    }
    /**
	 * 设置：检查时间
	 */

    public void setJianchaTime(Date jianchaTime) {
        this.jianchaTime = jianchaTime;
    }
    /**
	 * 获取：病人自述
	 */
    public String getBingrenzishuContent() {
        return bingrenzishuContent;
    }
    /**
	 * 设置：病人自述
	 */

    public void setBingrenzishuContent(String bingrenzishuContent) {
        this.bingrenzishuContent = bingrenzishuContent;
    }
    /**
	 * 获取：检查结果
	 */
    public String getJianchajieguoContent() {
        return jianchajieguoContent;
    }
    /**
	 * 设置：检查结果
	 */

    public void setJianchajieguoContent(String jianchajieguoContent) {
        this.jianchajieguoContent = jianchajieguoContent;
    }
    /**
	 * 获取：药品信息
	 */
    public String getYishengkaifangYaopinContent() {
        return yishengkaifangYaopinContent;
    }
    /**
	 * 设置：药品信息
	 */

    public void setYishengkaifangYaopinContent(String yishengkaifangYaopinContent) {
        this.yishengkaifangYaopinContent = yishengkaifangYaopinContent;
    }
    /**
	 * 获取：医生开方
	 */
    public String getYishengkaifangContent() {
        return yishengkaifangContent;
    }
    /**
	 * 设置：医生开方
	 */

    public void setYishengkaifangContent(String yishengkaifangContent) {
        this.yishengkaifangContent = yishengkaifangContent;
    }
    /**
	 * 获取：医生建议
	 */
    public String getYishengjianyiContent() {
        return yishengjianyiContent;
    }
    /**
	 * 设置：医生建议
	 */

    public void setYishengjianyiContent(String yishengjianyiContent) {
        this.yishengjianyiContent = yishengjianyiContent;
    }
    /**
	 * 获取：花费金额
	 */
    public Double getHuafeijine() {
        return huafeijine;
    }
    /**
	 * 设置：花费金额
	 */

    public void setHuafeijine(Double huafeijine) {
        this.huafeijine = huafeijine;
    }
    /**
	 * 获取：下次就诊时间
	 */
    public Date getXiacijiuzhenTime() {
        return xiacijiuzhenTime;
    }
    /**
	 * 设置：下次就诊时间
	 */

    public void setXiacijiuzhenTime(Date xiacijiuzhenTime) {
        this.xiacijiuzhenTime = xiacijiuzhenTime;
    }
    /**
	 * 获取：状态
	 */
    public Integer getBingliTypes() {
        return bingliTypes;
    }
    /**
	 * 设置：状态
	 */

    public void setBingliTypes(Integer bingliTypes) {
        this.bingliTypes = bingliTypes;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
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
        return "Yaodan{" +
            ", id=" + id +
            ", yaodanUuidNumber=" + yaodanUuidNumber +
            ", yonghuId=" + yonghuId +
            ", yayiId=" + yayiId +
            ", jianchaTime=" + DateUtil.convertString(jianchaTime,"yyyy-MM-dd") +
            ", bingrenzishuContent=" + bingrenzishuContent +
            ", jianchajieguoContent=" + jianchajieguoContent +
            ", yishengkaifangYaopinContent=" + yishengkaifangYaopinContent +
            ", yishengkaifangContent=" + yishengkaifangContent +
            ", yishengjianyiContent=" + yishengjianyiContent +
            ", huafeijine=" + huafeijine +
            ", xiacijiuzhenTime=" + DateUtil.convertString(xiacijiuzhenTime,"yyyy-MM-dd") +
            ", bingliTypes=" + bingliTypes +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
