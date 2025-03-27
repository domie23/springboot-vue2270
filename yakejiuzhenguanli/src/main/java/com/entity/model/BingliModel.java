package com.entity.model;

import com.entity.BingliEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 病例
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class BingliModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 病例编号
     */
    private String bingliUuidNumber;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 牙医
     */
    private Integer yayiId;


    /**
     * 病人名称
     */
    private String bingrenName;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 年龄
     */
    private Integer age;


    /**
     * 主诉
     */
    private String bingliZhusuContent;


    /**
     * 现病史
     */
    private String bingliXianbingshiContent;


    /**
     * 既往史
     */
    private String bingliJiwangshiContent;


    /**
     * 体检结果
     */
    private String bingliTijianjieguoContent;


    /**
     * 辅助检查结果
     */
    private String bingliFuzhujieguoContent;


    /**
     * 初步诊断
     */
    private String bingliChubuzhenduanContent;


    /**
     * 治疗意见
     */
    private String bingliZhiliaoyijianContent;


    /**
     * 上传时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


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
	 * 获取：病例编号
	 */
    public String getBingliUuidNumber() {
        return bingliUuidNumber;
    }


    /**
	 * 设置：病例编号
	 */
    public void setBingliUuidNumber(String bingliUuidNumber) {
        this.bingliUuidNumber = bingliUuidNumber;
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
	 * 获取：病人名称
	 */
    public String getBingrenName() {
        return bingrenName;
    }


    /**
	 * 设置：病人名称
	 */
    public void setBingrenName(String bingrenName) {
        this.bingrenName = bingrenName;
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
	 * 获取：年龄
	 */
    public Integer getAge() {
        return age;
    }


    /**
	 * 设置：年龄
	 */
    public void setAge(Integer age) {
        this.age = age;
    }
    /**
	 * 获取：主诉
	 */
    public String getBingliZhusuContent() {
        return bingliZhusuContent;
    }


    /**
	 * 设置：主诉
	 */
    public void setBingliZhusuContent(String bingliZhusuContent) {
        this.bingliZhusuContent = bingliZhusuContent;
    }
    /**
	 * 获取：现病史
	 */
    public String getBingliXianbingshiContent() {
        return bingliXianbingshiContent;
    }


    /**
	 * 设置：现病史
	 */
    public void setBingliXianbingshiContent(String bingliXianbingshiContent) {
        this.bingliXianbingshiContent = bingliXianbingshiContent;
    }
    /**
	 * 获取：既往史
	 */
    public String getBingliJiwangshiContent() {
        return bingliJiwangshiContent;
    }


    /**
	 * 设置：既往史
	 */
    public void setBingliJiwangshiContent(String bingliJiwangshiContent) {
        this.bingliJiwangshiContent = bingliJiwangshiContent;
    }
    /**
	 * 获取：体检结果
	 */
    public String getBingliTijianjieguoContent() {
        return bingliTijianjieguoContent;
    }


    /**
	 * 设置：体检结果
	 */
    public void setBingliTijianjieguoContent(String bingliTijianjieguoContent) {
        this.bingliTijianjieguoContent = bingliTijianjieguoContent;
    }
    /**
	 * 获取：辅助检查结果
	 */
    public String getBingliFuzhujieguoContent() {
        return bingliFuzhujieguoContent;
    }


    /**
	 * 设置：辅助检查结果
	 */
    public void setBingliFuzhujieguoContent(String bingliFuzhujieguoContent) {
        this.bingliFuzhujieguoContent = bingliFuzhujieguoContent;
    }
    /**
	 * 获取：初步诊断
	 */
    public String getBingliChubuzhenduanContent() {
        return bingliChubuzhenduanContent;
    }


    /**
	 * 设置：初步诊断
	 */
    public void setBingliChubuzhenduanContent(String bingliChubuzhenduanContent) {
        this.bingliChubuzhenduanContent = bingliChubuzhenduanContent;
    }
    /**
	 * 获取：治疗意见
	 */
    public String getBingliZhiliaoyijianContent() {
        return bingliZhiliaoyijianContent;
    }


    /**
	 * 设置：治疗意见
	 */
    public void setBingliZhiliaoyijianContent(String bingliZhiliaoyijianContent) {
        this.bingliZhiliaoyijianContent = bingliZhiliaoyijianContent;
    }
    /**
	 * 获取：上传时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：上传时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
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
