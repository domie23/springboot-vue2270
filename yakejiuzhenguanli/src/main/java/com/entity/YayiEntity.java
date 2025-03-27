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
 * 牙医
 *
 * @author 
 * @email
 */
@TableName("yayi")
public class YayiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public YayiEntity() {

	}

	public YayiEntity(T t) {
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
     * 账户
     */
    @ColumnInfo(comment="账户",type="varchar(200)")
    @TableField(value = "username")

    private String username;


    /**
     * 密码
     */
    @ColumnInfo(comment="密码",type="varchar(200)")
    @TableField(value = "password")

    private String password;


    /**
     * 牙医编号
     */
    @ColumnInfo(comment="牙医编号",type="varchar(200)")
    @TableField(value = "yayi_uuid_number")

    private String yayiUuidNumber;


    /**
     * 牙医姓名
     */
    @ColumnInfo(comment="牙医姓名",type="varchar(200)")
    @TableField(value = "yayi_name")

    private String yayiName;


    /**
     * 牙医手机号
     */
    @ColumnInfo(comment="牙医手机号",type="varchar(200)")
    @TableField(value = "yayi_phone")

    private String yayiPhone;


    /**
     * 牙医身份证号
     */
    @ColumnInfo(comment="牙医身份证号",type="varchar(200)")
    @TableField(value = "yayi_id_number")

    private String yayiIdNumber;


    /**
     * 牙医头像
     */
    @ColumnInfo(comment="牙医头像",type="varchar(200)")
    @TableField(value = "yayi_photo")

    private String yayiPhoto;


    /**
     * 性别
     */
    @ColumnInfo(comment="性别",type="int(11)")
    @TableField(value = "sex_types")

    private Integer sexTypes;


    /**
     * 牙医邮箱
     */
    @ColumnInfo(comment="牙医邮箱",type="varchar(200)")
    @TableField(value = "yayi_email")

    private String yayiEmail;


    /**
     * 挂号费用
     */
    @ColumnInfo(comment="挂号费用",type="decimal(10,2)")
    @TableField(value = "new_money")

    private Double newMoney;


    /**
     * 职位
     */
    @ColumnInfo(comment="职位",type="int(11)")
    @TableField(value = "zhiwei_types")

    private Integer zhiweiTypes;


    /**
     * 医生介绍
     */
    @ColumnInfo(comment="医生介绍",type="longtext")
    @TableField(value = "yayi_content")

    private String yayiContent;


    /**
     * 擅长
     */
    @ColumnInfo(comment="擅长",type="longtext")
    @TableField(value = "yayi_shanchang_content")

    private String yayiShanchangContent;


    /**
     * 所获荣誉
     */
    @ColumnInfo(comment="所获荣誉",type="longtext")
    @TableField(value = "yayi_rongyu_content")

    private String yayiRongyuContent;


    /**
     * 账户状态
     */
    @ColumnInfo(comment="账户状态",type="int(11)")
    @TableField(value = "jinyong_types")

    private Integer jinyongTypes;


    /**
     * 创建时间
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
	 * 获取：账户
	 */
    public String getUsername() {
        return username;
    }
    /**
	 * 设置：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 获取：密码
	 */
    public String getPassword() {
        return password;
    }
    /**
	 * 设置：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 获取：牙医编号
	 */
    public String getYayiUuidNumber() {
        return yayiUuidNumber;
    }
    /**
	 * 设置：牙医编号
	 */

    public void setYayiUuidNumber(String yayiUuidNumber) {
        this.yayiUuidNumber = yayiUuidNumber;
    }
    /**
	 * 获取：牙医姓名
	 */
    public String getYayiName() {
        return yayiName;
    }
    /**
	 * 设置：牙医姓名
	 */

    public void setYayiName(String yayiName) {
        this.yayiName = yayiName;
    }
    /**
	 * 获取：牙医手机号
	 */
    public String getYayiPhone() {
        return yayiPhone;
    }
    /**
	 * 设置：牙医手机号
	 */

    public void setYayiPhone(String yayiPhone) {
        this.yayiPhone = yayiPhone;
    }
    /**
	 * 获取：牙医身份证号
	 */
    public String getYayiIdNumber() {
        return yayiIdNumber;
    }
    /**
	 * 设置：牙医身份证号
	 */

    public void setYayiIdNumber(String yayiIdNumber) {
        this.yayiIdNumber = yayiIdNumber;
    }
    /**
	 * 获取：牙医头像
	 */
    public String getYayiPhoto() {
        return yayiPhoto;
    }
    /**
	 * 设置：牙医头像
	 */

    public void setYayiPhoto(String yayiPhoto) {
        this.yayiPhoto = yayiPhoto;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }
    /**
	 * 设置：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：牙医邮箱
	 */
    public String getYayiEmail() {
        return yayiEmail;
    }
    /**
	 * 设置：牙医邮箱
	 */

    public void setYayiEmail(String yayiEmail) {
        this.yayiEmail = yayiEmail;
    }
    /**
	 * 获取：挂号费用
	 */
    public Double getNewMoney() {
        return newMoney;
    }
    /**
	 * 设置：挂号费用
	 */

    public void setNewMoney(Double newMoney) {
        this.newMoney = newMoney;
    }
    /**
	 * 获取：职位
	 */
    public Integer getZhiweiTypes() {
        return zhiweiTypes;
    }
    /**
	 * 设置：职位
	 */

    public void setZhiweiTypes(Integer zhiweiTypes) {
        this.zhiweiTypes = zhiweiTypes;
    }
    /**
	 * 获取：医生介绍
	 */
    public String getYayiContent() {
        return yayiContent;
    }
    /**
	 * 设置：医生介绍
	 */

    public void setYayiContent(String yayiContent) {
        this.yayiContent = yayiContent;
    }
    /**
	 * 获取：擅长
	 */
    public String getYayiShanchangContent() {
        return yayiShanchangContent;
    }
    /**
	 * 设置：擅长
	 */

    public void setYayiShanchangContent(String yayiShanchangContent) {
        this.yayiShanchangContent = yayiShanchangContent;
    }
    /**
	 * 获取：所获荣誉
	 */
    public String getYayiRongyuContent() {
        return yayiRongyuContent;
    }
    /**
	 * 设置：所获荣誉
	 */

    public void setYayiRongyuContent(String yayiRongyuContent) {
        this.yayiRongyuContent = yayiRongyuContent;
    }
    /**
	 * 获取：账户状态
	 */
    public Integer getJinyongTypes() {
        return jinyongTypes;
    }
    /**
	 * 设置：账户状态
	 */

    public void setJinyongTypes(Integer jinyongTypes) {
        this.jinyongTypes = jinyongTypes;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Yayi{" +
            ", id=" + id +
            ", username=" + username +
            ", password=" + password +
            ", yayiUuidNumber=" + yayiUuidNumber +
            ", yayiName=" + yayiName +
            ", yayiPhone=" + yayiPhone +
            ", yayiIdNumber=" + yayiIdNumber +
            ", yayiPhoto=" + yayiPhoto +
            ", sexTypes=" + sexTypes +
            ", yayiEmail=" + yayiEmail +
            ", newMoney=" + newMoney +
            ", zhiweiTypes=" + zhiweiTypes +
            ", yayiContent=" + yayiContent +
            ", yayiShanchangContent=" + yayiShanchangContent +
            ", yayiRongyuContent=" + yayiRongyuContent +
            ", jinyongTypes=" + jinyongTypes +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
