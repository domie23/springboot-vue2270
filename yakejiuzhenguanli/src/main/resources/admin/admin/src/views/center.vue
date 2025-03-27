<template>
  <div>
    <el-form
      class="detail-form-content"
      ref="ruleForm"
      :model="ruleForm"
      label-width="auto"
    >  
     <el-row>
                    <el-col :span="12">
           <el-form-item v-if="flag=='yayi'"  label='牙医编号' prop="yayiUuidNumber">
               <el-input v-model="ruleForm.yayiUuidNumber"disabled="true"   placeholder='牙医编号' clearable></el-input>
           </el-form-item>
         </el-col>
         <el-col :span="12">
           <el-form-item v-if="flag=='yayi'"  label='牙医姓名' prop="yayiName">
               <el-input v-model="ruleForm.yayiName"  placeholder='牙医姓名' clearable></el-input>
           </el-form-item>
         </el-col>
         <el-col :span="12">
           <el-form-item v-if="flag=='yayi'"  label='牙医手机号' prop="yayiPhone">
               <el-input v-model="ruleForm.yayiPhone"  placeholder='牙医手机号' clearable></el-input>
           </el-form-item>
         </el-col>
         <el-col :span="12">
           <el-form-item v-if="flag=='yayi'"  label='牙医身份证号' prop="yayiIdNumber">
               <el-input v-model="ruleForm.yayiIdNumber"  placeholder='牙医身份证号' clearable></el-input>
           </el-form-item>
         </el-col>
         <el-col :span="12">
             <el-form-item v-if="flag=='yayi'" label='牙医头像' prop="yayiPhoto">
                 <file-upload
                         tip="点击上传照片"
                         action="file/upload"
                         :limit="3"
                         :multiple="true"
                         :fileUrls="ruleForm.yayiPhoto?$base.url+ruleForm.yayiPhoto:''"
                         @change="yayiPhotoUploadChange"
                 ></file-upload>
             </el-form-item>
         </el-col>
         <el-col :span="12">
           <el-form-item v-if="flag=='yayi'"  label='牙医邮箱' prop="yayiEmail">
               <el-input v-model="ruleForm.yayiEmail"  placeholder='牙医邮箱' clearable></el-input>
           </el-form-item>
         </el-col>
         <el-col :span="12">
             <el-form-item v-if="flag=='yayi'"  label='挂号费用' prop="newMoney">
                 <el-input v-model="ruleForm.newMoney"  placeholder='挂号费用' disabled style="width: 100px"></el-input>
                 <!--<a id="btn-recharge" @click="chongzhi" href="javascript:void(0)">点我充值</a>-->
                 <!--<a id="btn-recharge" @click="tixian" href="javascript:void(0)">点我提现</a>-->
             </el-form-item>
         </el-col>
         <el-col :span="12">
             <el-form-item v-if="flag=='yayi'"  label='职位' prop="zhiweiTypes">
                 <el-select v-model="ruleForm.zhiweiTypes" disabled  placeholder='请选择职位'>
                     <el-option
                             v-for="(item,index) in zhiweiTypesOptions"
                             v-bind:key="item.codeIndex"
                             :label="item.indexName"
                             :value="item.codeIndex">
                     </el-option>
                 </el-select>
             </el-form-item>
         </el-col>
         <el-col :span="24">
             <el-form-item v-if="flag=='yayi'"  label="医生介绍" prop="yayiContent">
                 <editor
                         style="min-width: 200px; max-width: 600px;"
                         v-model="ruleForm.yayiContent"
                         class="editor"
                         action="file/upload">
                 </editor>
             </el-form-item>
         </el-col>
         <el-col :span="24">
             <el-form-item v-if="flag=='yayi'"  label="擅长" prop="yayiShanchangContent">
                 <editor
                         style="min-width: 200px; max-width: 600px;"
                         v-model="ruleForm.yayiShanchangContent"
                         class="editor"
                         action="file/upload">
                 </editor>
             </el-form-item>
         </el-col>
         <el-col :span="24">
             <el-form-item v-if="flag=='yayi'"  label="所获荣誉" prop="yayiRongyuContent">
                 <editor
                         style="min-width: 200px; max-width: 600px;"
                         v-model="ruleForm.yayiRongyuContent"
                         class="editor"
                         action="file/upload">
                 </editor>
             </el-form-item>
         </el-col>
         <el-col :span="12">
           <el-form-item v-if="flag=='yonghu'"  label='用户编号' prop="yonghuUuidNumber">
               <el-input v-model="ruleForm.yonghuUuidNumber"disabled="true"   placeholder='用户编号' clearable></el-input>
           </el-form-item>
         </el-col>
         <el-col :span="12">
           <el-form-item v-if="flag=='yonghu'"  label='用户姓名' prop="yonghuName">
               <el-input v-model="ruleForm.yonghuName"  placeholder='用户姓名' clearable></el-input>
           </el-form-item>
         </el-col>
         <el-col :span="12">
           <el-form-item v-if="flag=='yonghu'"  label='用户手机号' prop="yonghuPhone">
               <el-input v-model="ruleForm.yonghuPhone"  placeholder='用户手机号' clearable></el-input>
           </el-form-item>
         </el-col>
         <el-col :span="12">
           <el-form-item v-if="flag=='yonghu'"  label='用户身份证号' prop="yonghuIdNumber">
               <el-input v-model="ruleForm.yonghuIdNumber"  placeholder='用户身份证号' clearable></el-input>
           </el-form-item>
         </el-col>
         <el-col :span="12">
             <el-form-item v-if="flag=='yonghu'" label='用户头像' prop="yonghuPhoto">
                 <file-upload
                         tip="点击上传照片"
                         action="file/upload"
                         :limit="3"
                         :multiple="true"
                         :fileUrls="ruleForm.yonghuPhoto?$base.url+ruleForm.yonghuPhoto:''"
                         @change="yonghuPhotoUploadChange"
                 ></file-upload>
             </el-form-item>
         </el-col>
         <el-col :span="12">
           <el-form-item v-if="flag=='yonghu'"  label='用户邮箱' prop="yonghuEmail">
               <el-input v-model="ruleForm.yonghuEmail"  placeholder='用户邮箱' clearable></el-input>
           </el-form-item>
         </el-col>
         <el-col :span="12">
             <el-form-item v-if="flag=='yonghu'"  label='余额' prop="newMoney">
                 <el-input v-model="ruleForm.newMoney"  placeholder='余额' disabled style="width: 100px"></el-input>
                 <!--<a id="btn-recharge" @click="chongzhi" href="javascript:void(0)">点我充值</a>-->
                 <!--<a id="btn-recharge" @click="tixian" href="javascript:void(0)">点我提现</a>-->
             </el-form-item>
         </el-col>
         <el-form-item v-if="flag=='users'" label="用户名" prop="username">
             <el-input v-model="ruleForm.username"
                       placeholder="用户名"></el-input>
         </el-form-item>
         <el-col :span="12">
             <el-form-item v-if="flag!='users' &&( 1==2|| flag=='yonghu'
|| flag=='yayi')"  label="性别" prop="sexTypes">
                 <el-select v-model="ruleForm.sexTypes" placeholder="请选择性别">
                     <el-option
                             v-for="(item,index) in sexTypesOptions"
                             v-bind:key="item.codeIndex"
                             :label="item.indexName"
                             :value="item.codeIndex">
                     </el-option>
                 </el-select>
             </el-form-item>
         </el-col>
         <el-col :span="24">
             <el-form-item>
                 <el-button type="primary" @click="onUpdateHandler">修 改</el-button>
             </el-form-item>
         </el-col>
     </el-row>
    </el-form>
  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isMobile,isPhone,isURL,checkIdCard } from "@/utils/validate";

export default {
  data() {
    return {
        ruleForm: {},
        flag: '',
        usersFlag: false,
        // sexTypesOptions : [],
// 注册表 用户
    // 注册的类型字段 用户
        // 性别
        sexTypesOptions : [],
        // 账户状态
        jinyongTypesOptions : [],
// 注册表 牙医
    // 注册的类型字段 牙医
        // 性别
        sexTypesOptions : [],
        // 职位
        zhiweiTypesOptions : [],
        // 账户状态
        jinyongTypesOptions : [],
    };
  },
  mounted() {
    //获取当前登录用户的信息
    var table = this.$storage.get("sessionTable");
    this.sessionTable = this.$storage.get("sessionTable");
    this.role = this.$storage.get("role");
    if (this.role != "管理员"){
    }

    this.flag = table;
    this.$http({
      url: `${this.$storage.get("sessionTable")}/session`,
      method: "get"
    }).then(({ data }) => {
      if (data && data.code === 0) {
        this.ruleForm = data.data;
// 注册表 用户
// 注册表 牙医
      } else {
        this.$message.error(data.msg);
      }
    });

// 注册表 用户 的级联表
// 注册表 牙医 的级联表

      this.$http({
          url: `dictionary/page?page=1&limit=100&sort=&order=&dicCode=sex_types`,
          method: "get"
      }).then(({ data }) => {
          if (data && data.code === 0) {
              this.sexTypesOptions = data.data.list;
          } else {
              this.$message.error(data.msg);
          }
      });
   this.$http({
       url: `dictionary/page?page=1&limit=100&sort=&order=&dicCode=zhiwei_types`,
       method: "get"
   }).then(({ data }) => {
       if (data && data.code === 0) {
          this.zhiweiTypesOptions = data.data.list;
      } else {
          this.$message.error(data.msg);
      }
    });
   this.$http({
       url: `dictionary/page?page=1&limit=100&sort=&order=&dicCode=jinyong_types`,
       method: "get"
   }).then(({ data }) => {
       if (data && data.code === 0) {
          this.jinyongTypesOptions = data.data.list;
      } else {
          this.$message.error(data.msg);
      }
    });
   this.$http({
       url: `dictionary/page?page=1&limit=100&sort=&order=&dicCode=jinyong_types`,
       method: "get"
   }).then(({ data }) => {
       if (data && data.code === 0) {
          this.jinyongTypesOptions = data.data.list;
      } else {
          this.$message.error(data.msg);
      }
    });
  },
  methods: {
    chongzhi() {
      this.$router.replace({ path: "/pay" });
    },
    tixian() {
      let _this=this;
      this.$confirm(`确定要提现么?`, "提示", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
      }).then(() => {
          _this.ruleForm.newMoney=0;
          _this.$http({
              url: `${this.$storage.get("sessionTable")}/update`,
              method: "post",
              data: this.ruleForm
          }).then(({ data }) => {
              if (data && data.code === 0) {
                  _this.$message({message: "提现成功",type: "success",duration: 1500,onClose: () => {}});
              } else {this.$message.error(data.msg);}
          });
      });
    },
    yayiPhotoUploadChange(fileUrls) {
        this.ruleForm.yayiPhoto = fileUrls;
    },
    yonghuPhotoUploadChange(fileUrls) {
        this.ruleForm.yonghuPhoto = fileUrls;
    },


    onUpdateHandler() {
                         if((!this.ruleForm.yayiUuidNumber)&& 'yayi'==this.flag){
                             this.$message.error('牙医编号不能为空');
                             return
                         }

                         if((!this.ruleForm.yayiName)&& 'yayi'==this.flag){
                             this.$message.error('牙医姓名不能为空');
                             return
                         }

                             if( 'yayi' ==this.flag && this.ruleForm.yayiPhone&&(!isMobile(this.ruleForm.yayiPhone))){
                                 this.$message.error(`手机应输入手机格式`);
                                 return
                             }
                         if((!this.ruleForm.yayiIdNumber)&& 'yayi'==this.flag){
                             this.$message.error('牙医身份证号不能为空');
                             return
                         }

                         if((!this.ruleForm.yayiPhoto)&& 'yayi'==this.flag){
                             this.$message.error('牙医头像不能为空');
                             return
                         }

                             if( 'yayi' ==this.flag && this.ruleForm.yayiEmail&&(!isEmail(this.ruleForm.yayiEmail))){
                                 this.$message.error(`邮箱应输入邮箱格式`);
                                 return
                             }
                         if((!this.ruleForm.zhiweiTypes)&& 'yayi'==this.flag){
                             this.$message.error('职位不能为空');
                             return
                         }

                         if((!this.ruleForm.yayiContent)&& 'yayi'==this.flag){
                             this.$message.error('医生介绍不能为空');
                             return
                         }

                         if((!this.ruleForm.yayiShanchangContent)&& 'yayi'==this.flag){
                             this.$message.error('擅长不能为空');
                             return
                         }

                         if((!this.ruleForm.yayiRongyuContent)&& 'yayi'==this.flag){
                             this.$message.error('所获荣誉不能为空');
                             return
                         }

                         if((!this.ruleForm.jinyongTypes)&& 'yayi'==this.flag){
                             this.$message.error('账户状态不能为空');
                             return
                         }

                         if((!this.ruleForm.yonghuUuidNumber)&& 'yonghu'==this.flag){
                             this.$message.error('用户编号不能为空');
                             return
                         }

                         if((!this.ruleForm.yonghuName)&& 'yonghu'==this.flag){
                             this.$message.error('用户姓名不能为空');
                             return
                         }

                             if( 'yonghu' ==this.flag && this.ruleForm.yonghuPhone&&(!isMobile(this.ruleForm.yonghuPhone))){
                                 this.$message.error(`手机应输入手机格式`);
                                 return
                             }
                         if((!this.ruleForm.yonghuIdNumber)&& 'yonghu'==this.flag){
                             this.$message.error('用户身份证号不能为空');
                             return
                         }

                         if((!this.ruleForm.yonghuPhoto)&& 'yonghu'==this.flag){
                             this.$message.error('用户头像不能为空');
                             return
                         }

                             if( 'yonghu' ==this.flag && this.ruleForm.yonghuEmail&&(!isEmail(this.ruleForm.yonghuEmail))){
                                 this.$message.error(`邮箱应输入邮箱格式`);
                                 return
                             }
                         if((!this.ruleForm.jinyongTypes)&& 'yonghu'==this.flag){
                             this.$message.error('账户状态不能为空');
                             return
                         }

        if((!this.ruleForm.sexTypes) && (1==2|| this.flag=='yonghu'
|| this.flag=='yayi')){
            this.$message.error('性别不能为空');
            return
        }
      if('users'==this.flag && this.ruleForm.username.trim().length<1) {
        this.$message.error(`用户名不能为空`);
        return	
      }
      this.$http({
        url: `${this.$storage.get("sessionTable")}/update`,
        method: "post",
        data: this.ruleForm
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.$message({
            message: "修改信息成功",
            type: "success",
            duration: 1500,
            onClose: () => {
            }
          });
        } else {
          this.$message.error(data.msg);
        }
      });
    }
  }
};
</script>
<style lang="scss" scoped>
</style>
