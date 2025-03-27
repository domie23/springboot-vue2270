package com.entity.vo;

import com.entity.BingliEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 病例
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("bingli")
public class BingliVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 病例编号
     */

    @TableField(value = "bingli_uuid_number")
    private String bingliUuidNumber;


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
     * 病人名称
     */

    @TableField(value = "bingren_name")
    private String bingrenName;


    /**
     * 性别
     */

    @TableField(value = "sex_types")
    private Integer sexTypes;


    /**
     * 年龄
     */

    @TableField(value = "age")
    private Integer age;


    /**
     * 主诉
     */

    @TableField(value = "bingli_zhusu_content")
    private String bingliZhusuContent;


    /**
     * 现病史
     */

    @TableField(value = "bingli_xianbingshi_content")
    private String bingliXianbingshiContent;


    /**
     * 既往史
     */

    @TableField(value = "bingli_jiwangshi_content")
    private String bingliJiwangshiContent;


    /**
     * 体检结果
     */

    @TableField(value = "bingli_tijianjieguo_content")
    private String bingliTijianjieguoContent;


    /**
     * 辅助检查结果
     */

    @TableField(value = "bingli_fuzhujieguo_content")
    private String bingliFuzhujieguoContent;


    /**
     * 初步诊断
     */

    @TableField(value = "bingli_chubuzhenduan_content")
    private String bingliChubuzhenduanContent;


    /**
     * 治疗意见
     */

    @TableField(value = "bingli_zhiliaoyijian_content")
    private String bingliZhiliaoyijianContent;


    /**
     * 上传时间
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
	 * 设置：病例编号
	 */
    public String getBingliUuidNumber() {
        return bingliUuidNumber;
    }


    /**
	 * 获取：病例编号
	 */

    public void setBingliUuidNumber(String bingliUuidNumber) {
        this.bingliUuidNumber = bingliUuidNumber;
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
	 * 设置：病人名称
	 */
    public String getBingrenName() {
        return bingrenName;
    }


    /**
	 * 获取：病人名称
	 */

    public void setBingrenName(String bingrenName) {
        this.bingrenName = bingrenName;
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
	 * 设置：年龄
	 */
    public Integer getAge() {
        return age;
    }


    /**
	 * 获取：年龄
	 */

    public void setAge(Integer age) {
        this.age = age;
    }
    /**
	 * 设置：主诉
	 */
    public String getBingliZhusuContent() {
        return bingliZhusuContent;
    }


    /**
	 * 获取：主诉
	 */

    public void setBingliZhusuContent(String bingliZhusuContent) {
        this.bingliZhusuContent = bingliZhusuContent;
    }
    /**
	 * 设置：现病史
	 */
    public String getBingliXianbingshiContent() {
        return bingliXianbingshiContent;
    }


    /**
	 * 获取：现病史
	 */

    public void setBingliXianbingshiContent(String bingliXianbingshiContent) {
        this.bingliXianbingshiContent = bingliXianbingshiContent;
    }
    /**
	 * 设置：既往史
	 */
    public String getBingliJiwangshiContent() {
        return bingliJiwangshiContent;
    }


    /**
	 * 获取：既往史
	 */

    public void setBingliJiwangshiContent(String bingliJiwangshiContent) {
        this.bingliJiwangshiContent = bingliJiwangshiContent;
    }
    /**
	 * 设置：体检结果
	 */
    public String getBingliTijianjieguoContent() {
        return bingliTijianjieguoContent;
    }


    /**
	 * 获取：体检结果
	 */

    public void setBingliTijianjieguoContent(String bingliTijianjieguoContent) {
        this.bingliTijianjieguoContent = bingliTijianjieguoContent;
    }
    /**
	 * 设置：辅助检查结果
	 */
    public String getBingliFuzhujieguoContent() {
        return bingliFuzhujieguoContent;
    }


    /**
	 * 获取：辅助检查结果
	 */

    public void setBingliFuzhujieguoContent(String bingliFuzhujieguoContent) {
        this.bingliFuzhujieguoContent = bingliFuzhujieguoContent;
    }
    /**
	 * 设置：初步诊断
	 */
    public String getBingliChubuzhenduanContent() {
        return bingliChubuzhenduanContent;
    }


    /**
	 * 获取：初步诊断
	 */

    public void setBingliChubuzhenduanContent(String bingliChubuzhenduanContent) {
        this.bingliChubuzhenduanContent = bingliChubuzhenduanContent;
    }
    /**
	 * 设置：治疗意见
	 */
    public String getBingliZhiliaoyijianContent() {
        return bingliZhiliaoyijianContent;
    }


    /**
	 * 获取：治疗意见
	 */

    public void setBingliZhiliaoyijianContent(String bingliZhiliaoyijianContent) {
        this.bingliZhiliaoyijianContent = bingliZhiliaoyijianContent;
    }
    /**
	 * 设置：上传时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：上传时间
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
