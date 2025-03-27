package com.entity.vo;

import com.entity.YayiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 牙医
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("yayi")
public class YayiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 账户
     */

    @TableField(value = "username")
    private String username;


    /**
     * 密码
     */

    @TableField(value = "password")
    private String password;


    /**
     * 牙医编号
     */

    @TableField(value = "yayi_uuid_number")
    private String yayiUuidNumber;


    /**
     * 牙医姓名
     */

    @TableField(value = "yayi_name")
    private String yayiName;


    /**
     * 牙医手机号
     */

    @TableField(value = "yayi_phone")
    private String yayiPhone;


    /**
     * 牙医身份证号
     */

    @TableField(value = "yayi_id_number")
    private String yayiIdNumber;


    /**
     * 牙医头像
     */

    @TableField(value = "yayi_photo")
    private String yayiPhoto;


    /**
     * 性别
     */

    @TableField(value = "sex_types")
    private Integer sexTypes;


    /**
     * 牙医邮箱
     */

    @TableField(value = "yayi_email")
    private String yayiEmail;


    /**
     * 挂号费用
     */

    @TableField(value = "new_money")
    private Double newMoney;


    /**
     * 职位
     */

    @TableField(value = "zhiwei_types")
    private Integer zhiweiTypes;


    /**
     * 医生介绍
     */

    @TableField(value = "yayi_content")
    private String yayiContent;


    /**
     * 擅长
     */

    @TableField(value = "yayi_shanchang_content")
    private String yayiShanchangContent;


    /**
     * 所获荣誉
     */

    @TableField(value = "yayi_rongyu_content")
    private String yayiRongyuContent;


    /**
     * 账户状态
     */

    @TableField(value = "jinyong_types")
    private Integer jinyongTypes;


    /**
     * 创建时间
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
	 * 设置：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 获取：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：牙医编号
	 */
    public String getYayiUuidNumber() {
        return yayiUuidNumber;
    }


    /**
	 * 获取：牙医编号
	 */

    public void setYayiUuidNumber(String yayiUuidNumber) {
        this.yayiUuidNumber = yayiUuidNumber;
    }
    /**
	 * 设置：牙医姓名
	 */
    public String getYayiName() {
        return yayiName;
    }


    /**
	 * 获取：牙医姓名
	 */

    public void setYayiName(String yayiName) {
        this.yayiName = yayiName;
    }
    /**
	 * 设置：牙医手机号
	 */
    public String getYayiPhone() {
        return yayiPhone;
    }


    /**
	 * 获取：牙医手机号
	 */

    public void setYayiPhone(String yayiPhone) {
        this.yayiPhone = yayiPhone;
    }
    /**
	 * 设置：牙医身份证号
	 */
    public String getYayiIdNumber() {
        return yayiIdNumber;
    }


    /**
	 * 获取：牙医身份证号
	 */

    public void setYayiIdNumber(String yayiIdNumber) {
        this.yayiIdNumber = yayiIdNumber;
    }
    /**
	 * 设置：牙医头像
	 */
    public String getYayiPhoto() {
        return yayiPhoto;
    }


    /**
	 * 获取：牙医头像
	 */

    public void setYayiPhoto(String yayiPhoto) {
        this.yayiPhoto = yayiPhoto;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：牙医邮箱
	 */
    public String getYayiEmail() {
        return yayiEmail;
    }


    /**
	 * 获取：牙医邮箱
	 */

    public void setYayiEmail(String yayiEmail) {
        this.yayiEmail = yayiEmail;
    }
    /**
	 * 设置：挂号费用
	 */
    public Double getNewMoney() {
        return newMoney;
    }


    /**
	 * 获取：挂号费用
	 */

    public void setNewMoney(Double newMoney) {
        this.newMoney = newMoney;
    }
    /**
	 * 设置：职位
	 */
    public Integer getZhiweiTypes() {
        return zhiweiTypes;
    }


    /**
	 * 获取：职位
	 */

    public void setZhiweiTypes(Integer zhiweiTypes) {
        this.zhiweiTypes = zhiweiTypes;
    }
    /**
	 * 设置：医生介绍
	 */
    public String getYayiContent() {
        return yayiContent;
    }


    /**
	 * 获取：医生介绍
	 */

    public void setYayiContent(String yayiContent) {
        this.yayiContent = yayiContent;
    }
    /**
	 * 设置：擅长
	 */
    public String getYayiShanchangContent() {
        return yayiShanchangContent;
    }


    /**
	 * 获取：擅长
	 */

    public void setYayiShanchangContent(String yayiShanchangContent) {
        this.yayiShanchangContent = yayiShanchangContent;
    }
    /**
	 * 设置：所获荣誉
	 */
    public String getYayiRongyuContent() {
        return yayiRongyuContent;
    }


    /**
	 * 获取：所获荣誉
	 */

    public void setYayiRongyuContent(String yayiRongyuContent) {
        this.yayiRongyuContent = yayiRongyuContent;
    }
    /**
	 * 设置：账户状态
	 */
    public Integer getJinyongTypes() {
        return jinyongTypes;
    }


    /**
	 * 获取：账户状态
	 */

    public void setJinyongTypes(Integer jinyongTypes) {
        this.jinyongTypes = jinyongTypes;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
