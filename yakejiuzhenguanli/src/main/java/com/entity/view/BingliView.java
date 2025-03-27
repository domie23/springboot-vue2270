package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.BingliEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 病例
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("bingli")
public class BingliView extends BingliEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 性别的值
	*/
	@ColumnInfo(comment="性别的字典表值",type="varchar(200)")
	private String sexValue;

	//级联表 牙医
		/**
		* 牙医编号
		*/

		@ColumnInfo(comment="牙医编号",type="varchar(200)")
		private String yayiUuidNumber;
		/**
		* 牙医姓名
		*/

		@ColumnInfo(comment="牙医姓名",type="varchar(200)")
		private String yayiName;
		/**
		* 牙医手机号
		*/

		@ColumnInfo(comment="牙医手机号",type="varchar(200)")
		private String yayiPhone;
		/**
		* 牙医身份证号
		*/

		@ColumnInfo(comment="牙医身份证号",type="varchar(200)")
		private String yayiIdNumber;
		/**
		* 牙医头像
		*/

		@ColumnInfo(comment="牙医头像",type="varchar(200)")
		private String yayiPhoto;
		/**
		* 牙医邮箱
		*/

		@ColumnInfo(comment="牙医邮箱",type="varchar(200)")
		private String yayiEmail;
		/**
		* 挂号费用
		*/
		@ColumnInfo(comment="挂号费用",type="decimal(10,2)")
		private Double newMoney;
		/**
		* 职位
		*/
		@ColumnInfo(comment="职位",type="int(11)")
		private Integer zhiweiTypes;
			/**
			* 职位的值
			*/
			@ColumnInfo(comment="职位的字典表值",type="varchar(200)")
			private String zhiweiValue;
		/**
		* 医生介绍
		*/

		@ColumnInfo(comment="医生介绍",type="longtext")
		private String yayiContent;
		/**
		* 擅长
		*/

		@ColumnInfo(comment="擅长",type="longtext")
		private String yayiShanchangContent;
		/**
		* 所获荣誉
		*/

		@ColumnInfo(comment="所获荣誉",type="longtext")
		private String yayiRongyuContent;
	//级联表 用户
		/**
		* 用户编号
		*/

		@ColumnInfo(comment="用户编号",type="varchar(200)")
		private String yonghuUuidNumber;
		/**
		* 用户姓名
		*/

		@ColumnInfo(comment="用户姓名",type="varchar(200)")
		private String yonghuName;
		/**
		* 用户手机号
		*/

		@ColumnInfo(comment="用户手机号",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 用户身份证号
		*/

		@ColumnInfo(comment="用户身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 用户头像
		*/

		@ColumnInfo(comment="用户头像",type="varchar(200)")
		private String yonghuPhoto;
		/**
		* 用户邮箱
		*/

		@ColumnInfo(comment="用户邮箱",type="varchar(200)")
		private String yonghuEmail;

	//重复字段
			/**
			* 重复字段 的types
			*/
			@ColumnInfo(comment="重复字段 的types",type="Integer")
			private Integer jinyongTypes;
				@ColumnInfo(comment="重复字段 的值",type="varchar(200)")
				private String jinyongValue;


	public BingliView() {

	}

	public BingliView(BingliEntity bingliEntity) {
		try {
			BeanUtils.copyProperties(this, bingliEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 性别的值
	*/
	public String getSexValue() {
		return sexValue;
	}
	/**
	* 设置： 性别的值
	*/
	public void setSexValue(String sexValue) {
		this.sexValue = sexValue;
	}


	//级联表的get和set 牙医

		/**
		* 获取： 牙医编号
		*/
		public String getYayiUuidNumber() {
			return yayiUuidNumber;
		}
		/**
		* 设置： 牙医编号
		*/
		public void setYayiUuidNumber(String yayiUuidNumber) {
			this.yayiUuidNumber = yayiUuidNumber;
		}

		/**
		* 获取： 牙医姓名
		*/
		public String getYayiName() {
			return yayiName;
		}
		/**
		* 设置： 牙医姓名
		*/
		public void setYayiName(String yayiName) {
			this.yayiName = yayiName;
		}

		/**
		* 获取： 牙医手机号
		*/
		public String getYayiPhone() {
			return yayiPhone;
		}
		/**
		* 设置： 牙医手机号
		*/
		public void setYayiPhone(String yayiPhone) {
			this.yayiPhone = yayiPhone;
		}

		/**
		* 获取： 牙医身份证号
		*/
		public String getYayiIdNumber() {
			return yayiIdNumber;
		}
		/**
		* 设置： 牙医身份证号
		*/
		public void setYayiIdNumber(String yayiIdNumber) {
			this.yayiIdNumber = yayiIdNumber;
		}

		/**
		* 获取： 牙医头像
		*/
		public String getYayiPhoto() {
			return yayiPhoto;
		}
		/**
		* 设置： 牙医头像
		*/
		public void setYayiPhoto(String yayiPhoto) {
			this.yayiPhoto = yayiPhoto;
		}

		/**
		* 获取： 牙医邮箱
		*/
		public String getYayiEmail() {
			return yayiEmail;
		}
		/**
		* 设置： 牙医邮箱
		*/
		public void setYayiEmail(String yayiEmail) {
			this.yayiEmail = yayiEmail;
		}
		/**
		* 获取： 职位
		*/
		public Integer getZhiweiTypes() {
			return zhiweiTypes;
		}
		/**
		* 设置： 职位
		*/
		public void setZhiweiTypes(Integer zhiweiTypes) {
			this.zhiweiTypes = zhiweiTypes;
		}


			/**
			* 获取： 职位的值
			*/
			public String getZhiweiValue() {
				return zhiweiValue;
			}
			/**
			* 设置： 职位的值
			*/
			public void setZhiweiValue(String zhiweiValue) {
				this.zhiweiValue = zhiweiValue;
			}

		/**
		* 获取： 医生介绍
		*/
		public String getYayiContent() {
			return yayiContent;
		}
		/**
		* 设置： 医生介绍
		*/
		public void setYayiContent(String yayiContent) {
			this.yayiContent = yayiContent;
		}

		/**
		* 获取： 擅长
		*/
		public String getYayiShanchangContent() {
			return yayiShanchangContent;
		}
		/**
		* 设置： 擅长
		*/
		public void setYayiShanchangContent(String yayiShanchangContent) {
			this.yayiShanchangContent = yayiShanchangContent;
		}

		/**
		* 获取： 所获荣誉
		*/
		public String getYayiRongyuContent() {
			return yayiRongyuContent;
		}
		/**
		* 设置： 所获荣誉
		*/
		public void setYayiRongyuContent(String yayiRongyuContent) {
			this.yayiRongyuContent = yayiRongyuContent;
		}
	//级联表的get和set 用户

		/**
		* 获取： 用户编号
		*/
		public String getYonghuUuidNumber() {
			return yonghuUuidNumber;
		}
		/**
		* 设置： 用户编号
		*/
		public void setYonghuUuidNumber(String yonghuUuidNumber) {
			this.yonghuUuidNumber = yonghuUuidNumber;
		}

		/**
		* 获取： 用户姓名
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 用户姓名
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 用户手机号
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 用户手机号
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 用户身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 用户身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 用户头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 用户头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 用户邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 用户邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}

		/**
		* 获取： 余额
		*/
		public Double getNewMoney() {
			return newMoney;
		}
		/**
		* 设置： 余额
		*/
		public void setNewMoney(Double newMoney) {
			this.newMoney = newMoney;
		}

	//重复字段
			/**
			* 获取： 重复字段 的types
			*/
			public Integer getJinyongTypes() {
			return jinyongTypes;
			}
			/**
			* 设置： 重复字段 的types
			*/
			public void setJinyongTypes(Integer jinyongTypes) {
			this.jinyongTypes = jinyongTypes;
			}
				public String getJinyongValue() {
				return jinyongValue;
				}
				public void setJinyongValue(String jinyongValue) {
				this.jinyongValue = jinyongValue;
				}

	@Override
	public String toString() {
		return "BingliView{" +
			", sexValue=" + sexValue +
			", yonghuUuidNumber=" + yonghuUuidNumber +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			", newMoney=" + newMoney +
			", yayiUuidNumber=" + yayiUuidNumber +
			", yayiName=" + yayiName +
			", yayiPhone=" + yayiPhone +
			", yayiIdNumber=" + yayiIdNumber +
			", yayiPhoto=" + yayiPhoto +
			", yayiEmail=" + yayiEmail +
			", newMoney=" + newMoney +
			", yayiContent=" + yayiContent +
			", yayiShanchangContent=" + yayiShanchangContent +
			", yayiRongyuContent=" + yayiRongyuContent +
			"} " + super.toString();
	}
}
