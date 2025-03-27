package com.entity.vo;

import com.entity.YaopinEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 药品
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("yaopin")
public class YaopinVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 药品名称
     */

    @TableField(value = "yaopin_name")
    private String yaopinName;


    /**
     * 药品编号
     */

    @TableField(value = "yaopin_uuid_number")
    private String yaopinUuidNumber;


    /**
     * 药品照片
     */

    @TableField(value = "yaopin_photo")
    private String yaopinPhoto;


    /**
     * 药品类型
     */

    @TableField(value = "yaopin_types")
    private Integer yaopinTypes;


    /**
     * 药品库存
     */

    @TableField(value = "yaopin_kucun_number")
    private Integer yaopinKucunNumber;


    /**
     * 药品原价
     */

    @TableField(value = "yaopin_old_money")
    private Double yaopinOldMoney;


    /**
     * 现价
     */

    @TableField(value = "yaopin_new_money")
    private Double yaopinNewMoney;


    /**
     * 所属仓库
     */

    @TableField(value = "yaopin_cangku")
    private String yaopinCangku;


    /**
     * 药品热度
     */

    @TableField(value = "yaopin_clicknum")
    private Integer yaopinClicknum;


    /**
     * 药品介绍
     */

    @TableField(value = "yaopin_content")
    private String yaopinContent;


    /**
     * 禁忌
     */

    @TableField(value = "yaopin_jinji_content")
    private String yaopinJinjiContent;


    /**
     * 功效
     */

    @TableField(value = "yaopin_gongxiao_content")
    private String yaopinGongxiaoContent;


    /**
     * 说明书
     */

    @TableField(value = "yaopin_shuomingshu_content")
    private String yaopinShuomingshuContent;


    /**
     * 是否上架
     */

    @TableField(value = "shangxia_types")
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */

    @TableField(value = "yaopin_delete")
    private Integer yaopinDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 设置：药品名称
	 */
    public String getYaopinName() {
        return yaopinName;
    }


    /**
	 * 获取：药品名称
	 */

    public void setYaopinName(String yaopinName) {
        this.yaopinName = yaopinName;
    }
    /**
	 * 设置：药品编号
	 */
    public String getYaopinUuidNumber() {
        return yaopinUuidNumber;
    }


    /**
	 * 获取：药品编号
	 */

    public void setYaopinUuidNumber(String yaopinUuidNumber) {
        this.yaopinUuidNumber = yaopinUuidNumber;
    }
    /**
	 * 设置：药品照片
	 */
    public String getYaopinPhoto() {
        return yaopinPhoto;
    }


    /**
	 * 获取：药品照片
	 */

    public void setYaopinPhoto(String yaopinPhoto) {
        this.yaopinPhoto = yaopinPhoto;
    }
    /**
	 * 设置：药品类型
	 */
    public Integer getYaopinTypes() {
        return yaopinTypes;
    }


    /**
	 * 获取：药品类型
	 */

    public void setYaopinTypes(Integer yaopinTypes) {
        this.yaopinTypes = yaopinTypes;
    }
    /**
	 * 设置：药品库存
	 */
    public Integer getYaopinKucunNumber() {
        return yaopinKucunNumber;
    }


    /**
	 * 获取：药品库存
	 */

    public void setYaopinKucunNumber(Integer yaopinKucunNumber) {
        this.yaopinKucunNumber = yaopinKucunNumber;
    }
    /**
	 * 设置：药品原价
	 */
    public Double getYaopinOldMoney() {
        return yaopinOldMoney;
    }


    /**
	 * 获取：药品原价
	 */

    public void setYaopinOldMoney(Double yaopinOldMoney) {
        this.yaopinOldMoney = yaopinOldMoney;
    }
    /**
	 * 设置：现价
	 */
    public Double getYaopinNewMoney() {
        return yaopinNewMoney;
    }


    /**
	 * 获取：现价
	 */

    public void setYaopinNewMoney(Double yaopinNewMoney) {
        this.yaopinNewMoney = yaopinNewMoney;
    }
    /**
	 * 设置：所属仓库
	 */
    public String getYaopinCangku() {
        return yaopinCangku;
    }


    /**
	 * 获取：所属仓库
	 */

    public void setYaopinCangku(String yaopinCangku) {
        this.yaopinCangku = yaopinCangku;
    }
    /**
	 * 设置：药品热度
	 */
    public Integer getYaopinClicknum() {
        return yaopinClicknum;
    }


    /**
	 * 获取：药品热度
	 */

    public void setYaopinClicknum(Integer yaopinClicknum) {
        this.yaopinClicknum = yaopinClicknum;
    }
    /**
	 * 设置：药品介绍
	 */
    public String getYaopinContent() {
        return yaopinContent;
    }


    /**
	 * 获取：药品介绍
	 */

    public void setYaopinContent(String yaopinContent) {
        this.yaopinContent = yaopinContent;
    }
    /**
	 * 设置：禁忌
	 */
    public String getYaopinJinjiContent() {
        return yaopinJinjiContent;
    }


    /**
	 * 获取：禁忌
	 */

    public void setYaopinJinjiContent(String yaopinJinjiContent) {
        this.yaopinJinjiContent = yaopinJinjiContent;
    }
    /**
	 * 设置：功效
	 */
    public String getYaopinGongxiaoContent() {
        return yaopinGongxiaoContent;
    }


    /**
	 * 获取：功效
	 */

    public void setYaopinGongxiaoContent(String yaopinGongxiaoContent) {
        this.yaopinGongxiaoContent = yaopinGongxiaoContent;
    }
    /**
	 * 设置：说明书
	 */
    public String getYaopinShuomingshuContent() {
        return yaopinShuomingshuContent;
    }


    /**
	 * 获取：说明书
	 */

    public void setYaopinShuomingshuContent(String yaopinShuomingshuContent) {
        this.yaopinShuomingshuContent = yaopinShuomingshuContent;
    }
    /**
	 * 设置：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }


    /**
	 * 获取：是否上架
	 */

    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getYaopinDelete() {
        return yaopinDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setYaopinDelete(Integer yaopinDelete) {
        this.yaopinDelete = yaopinDelete;
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
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
