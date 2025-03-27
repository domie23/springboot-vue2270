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
 * 病例
 *
 * @author 
 * @email
 */
@TableName("bingli")
public class BingliEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public BingliEntity() {

	}

	public BingliEntity(T t) {
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
     * 病例编号
     */
    @ColumnInfo(comment="病例编号",type="varchar(200)")
    @TableField(value = "bingli_uuid_number")

    private String bingliUuidNumber;


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
     * 病人名称
     */
    @ColumnInfo(comment="病人名称",type="varchar(200)")
    @TableField(value = "bingren_name")

    private String bingrenName;


    /**
     * 性别
     */
    @ColumnInfo(comment="性别",type="int(11)")
    @TableField(value = "sex_types")

    private Integer sexTypes;


    /**
     * 年龄
     */
    @ColumnInfo(comment="年龄",type="int(11)")
    @TableField(value = "age")

    private Integer age;


    /**
     * 主诉
     */
    @ColumnInfo(comment="主诉",type="text")
    @TableField(value = "bingli_zhusu_content")

    private String bingliZhusuContent;


    /**
     * 现病史
     */
    @ColumnInfo(comment="现病史",type="text")
    @TableField(value = "bingli_xianbingshi_content")

    private String bingliXianbingshiContent;


    /**
     * 既往史
     */
    @ColumnInfo(comment="既往史",type="text")
    @TableField(value = "bingli_jiwangshi_content")

    private String bingliJiwangshiContent;


    /**
     * 体检结果
     */
    @ColumnInfo(comment="体检结果",type="text")
    @TableField(value = "bingli_tijianjieguo_content")

    private String bingliTijianjieguoContent;


    /**
     * 辅助检查结果
     */
    @ColumnInfo(comment="辅助检查结果",type="text")
    @TableField(value = "bingli_fuzhujieguo_content")

    private String bingliFuzhujieguoContent;


    /**
     * 初步诊断
     */
    @ColumnInfo(comment="初步诊断",type="text")
    @TableField(value = "bingli_chubuzhenduan_content")

    private String bingliChubuzhenduanContent;


    /**
     * 治疗意见
     */
    @ColumnInfo(comment="治疗意见",type="text")
    @TableField(value = "bingli_zhiliaoyijian_content")

    private String bingliZhiliaoyijianContent;


    /**
     * 上传时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="上传时间",type="timestamp")
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
        return "Bingli{" +
            ", id=" + id +
            ", bingliUuidNumber=" + bingliUuidNumber +
            ", yonghuId=" + yonghuId +
            ", yayiId=" + yayiId +
            ", bingrenName=" + bingrenName +
            ", sexTypes=" + sexTypes +
            ", age=" + age +
            ", bingliZhusuContent=" + bingliZhusuContent +
            ", bingliXianbingshiContent=" + bingliXianbingshiContent +
            ", bingliJiwangshiContent=" + bingliJiwangshiContent +
            ", bingliTijianjieguoContent=" + bingliTijianjieguoContent +
            ", bingliFuzhujieguoContent=" + bingliFuzhujieguoContent +
            ", bingliChubuzhenduanContent=" + bingliChubuzhenduanContent +
            ", bingliZhiliaoyijianContent=" + bingliZhiliaoyijianContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
