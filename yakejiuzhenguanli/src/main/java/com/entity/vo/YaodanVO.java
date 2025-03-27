package com.entity.vo;

import com.entity.YaodanEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 药单
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("yaodan")
public class YaodanVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 药单编号
     */

    @TableField(value = "yaodan_uuid_number")
    private String yaodanUuidNumber;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 牙医
     */

    @TableField(value = "yayi_id")
    private Integer yayiId;


    /**
     * 检查时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "jiancha_time")
    private Date jianchaTime;


    /**
     * 病人自述
     */

    @TableField(value = "bingrenzishu_content")
    private String bingrenzishuContent;


    /**
     * 检查结果
     */

    @TableField(value = "jianchajieguo_content")
    private String jianchajieguoContent;


    /**
     * 药品信息
     */

    @TableField(value = "yishengkaifang_yaopin_content")
    private String yishengkaifangYaopinContent;


    /**
     * 医生开方
     */

    @TableField(value = "yishengkaifang_content")
    private String yishengkaifangContent;


    /**
     * 医生建议
     */

    @TableField(value = "yishengjianyi_content")
    private String yishengjianyiContent;


    /**
     * 花费金额
     */

    @TableField(value = "huafeijine")
    private Double huafeijine;


    /**
     * 下次就诊时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "xiacijiuzhen_time")
    private Date xiacijiuzhenTime;


    /**
     * 状态
     */

    @TableField(value = "bingli_types")
    private Integer bingliTypes;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


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
	 * 设置：药单编号
	 */
    public String getYaodanUuidNumber() {
        return yaodanUuidNumber;
    }


    /**
	 * 获取：药单编号
	 */

    public void setYaodanUuidNumber(String yaodanUuidNumber) {
        this.yaodanUuidNumber = yaodanUuidNumber;
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
	 * 设置：检查时间
	 */
    public Date getJianchaTime() {
        return jianchaTime;
    }


    /**
	 * 获取：检查时间
	 */

    public void setJianchaTime(Date jianchaTime) {
        this.jianchaTime = jianchaTime;
    }
    /**
	 * 设置：病人自述
	 */
    public String getBingrenzishuContent() {
        return bingrenzishuContent;
    }


    /**
	 * 获取：病人自述
	 */

    public void setBingrenzishuContent(String bingrenzishuContent) {
        this.bingrenzishuContent = bingrenzishuContent;
    }
    /**
	 * 设置：检查结果
	 */
    public String getJianchajieguoContent() {
        return jianchajieguoContent;
    }


    /**
	 * 获取：检查结果
	 */

    public void setJianchajieguoContent(String jianchajieguoContent) {
        this.jianchajieguoContent = jianchajieguoContent;
    }
    /**
	 * 设置：药品信息
	 */
    public String getYishengkaifangYaopinContent() {
        return yishengkaifangYaopinContent;
    }


    /**
	 * 获取：药品信息
	 */

    public void setYishengkaifangYaopinContent(String yishengkaifangYaopinContent) {
        this.yishengkaifangYaopinContent = yishengkaifangYaopinContent;
    }
    /**
	 * 设置：医生开方
	 */
    public String getYishengkaifangContent() {
        return yishengkaifangContent;
    }


    /**
	 * 获取：医生开方
	 */

    public void setYishengkaifangContent(String yishengkaifangContent) {
        this.yishengkaifangContent = yishengkaifangContent;
    }
    /**
	 * 设置：医生建议
	 */
    public String getYishengjianyiContent() {
        return yishengjianyiContent;
    }


    /**
	 * 获取：医生建议
	 */

    public void setYishengjianyiContent(String yishengjianyiContent) {
        this.yishengjianyiContent = yishengjianyiContent;
    }
    /**
	 * 设置：花费金额
	 */
    public Double getHuafeijine() {
        return huafeijine;
    }


    /**
	 * 获取：花费金额
	 */

    public void setHuafeijine(Double huafeijine) {
        this.huafeijine = huafeijine;
    }
    /**
	 * 设置：下次就诊时间
	 */
    public Date getXiacijiuzhenTime() {
        return xiacijiuzhenTime;
    }


    /**
	 * 获取：下次就诊时间
	 */

    public void setXiacijiuzhenTime(Date xiacijiuzhenTime) {
        this.xiacijiuzhenTime = xiacijiuzhenTime;
    }
    /**
	 * 设置：状态
	 */
    public Integer getBingliTypes() {
        return bingliTypes;
    }


    /**
	 * 获取：状态
	 */

    public void setBingliTypes(Integer bingliTypes) {
        this.bingliTypes = bingliTypes;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
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
