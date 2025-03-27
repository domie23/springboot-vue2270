package com.entity.model;

import com.entity.YayiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 牙医
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class YayiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 账户
     */
    private String username;


    /**
     * 密码
     */
    private String password;


    /**
     * 牙医编号
     */
    private String yayiUuidNumber;


    /**
     * 牙医姓名
     */
    private String yayiName;


    /**
     * 牙医手机号
     */
    private String yayiPhone;


    /**
     * 牙医身份证号
     */
    private String yayiIdNumber;


    /**
     * 牙医头像
     */
    private String yayiPhoto;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 牙医邮箱
     */
    private String yayiEmail;


    /**
     * 挂号费用
     */
    private Double newMoney;


    /**
     * 职位
     */
    private Integer zhiweiTypes;


    /**
     * 医生介绍
     */
    private String yayiContent;


    /**
     * 擅长
     */
    private String yayiShanchangContent;


    /**
     * 所获荣誉
     */
    private String yayiRongyuContent;


    /**
     * 账户状态
     */
    private Integer jinyongTypes;


    /**
     * 创建时间
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

    }
