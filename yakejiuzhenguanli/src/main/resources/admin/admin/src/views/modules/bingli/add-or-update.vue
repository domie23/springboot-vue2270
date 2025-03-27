<template>
    <div class="addEdit-block">
        <el-form
                class="detail-form-content"
                ref="ruleForm"
                :model="ruleForm"
                :rules="rules"
                label-width="auto"
                >
            <el-row>
                <el-col :span="12"  v-if="sessionTable !='yayi'">
                    <el-form-item class="select" v-if="type!='info'"  label="牙医" prop="yayiId">
                        <el-select v-model="ruleForm.yayiId" :disabled="ro.yayiId" filterable placeholder="请选择牙医" @change="yayiChange">
                            <el-option
                                    v-for="(item,index) in yayiOptions"
                                    v-bind:key="item.id"
                                    :label="item.yayiName"
                                    :value="item.id">
                            </el-option>
                        </el-select>
                    </el-form-item>
                </el-col>

                <el-col :span="12"  v-if="sessionTable !='yayi' ">
                    <el-form-item class="input" v-if="type!='info'"  label="牙医编号" prop="yayiUuidNumber">
                        <el-input v-model="yayiForm.yayiUuidNumber"
                                  placeholder="牙医编号" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="牙医编号" prop="yayiUuidNumber">
                            <el-input v-model="ruleForm.yayiUuidNumber"
                                      placeholder="牙医编号" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='yayi' ">
                    <el-form-item class="input" v-if="type!='info'"  label="牙医姓名" prop="yayiName">
                        <el-input v-model="yayiForm.yayiName"
                                  placeholder="牙医姓名" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="牙医姓名" prop="yayiName">
                            <el-input v-model="ruleForm.yayiName"
                                      placeholder="牙医姓名" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='yayi' ">
                    <el-form-item class="input" v-if="type!='info'"  label="牙医手机号" prop="yayiPhone">
                        <el-input v-model="yayiForm.yayiPhone"
                                  placeholder="牙医手机号" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="牙医手机号" prop="yayiPhone">
                            <el-input v-model="ruleForm.yayiPhone"
                                      placeholder="牙医手机号" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='yayi' ">
                    <el-form-item class="input" v-if="type!='info'"  label="牙医身份证号" prop="yayiIdNumber">
                        <el-input v-model="yayiForm.yayiIdNumber"
                                  placeholder="牙医身份证号" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="牙医身份证号" prop="yayiIdNumber">
                            <el-input v-model="ruleForm.yayiIdNumber"
                                      placeholder="牙医身份证号" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12" v-if="sessionTable !='yayi' ">
                    <el-form-item class="upload" v-if="type!='info' && !ro.yayiPhoto" label="牙医头像" prop="yayiPhoto">
                        <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (yayiForm.yayiPhoto || '').split(',')" :src="$base.url+item" width="100" height="100">
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item v-if="ruleForm.yayiPhoto" label="牙医头像" prop="yayiPhoto">
                            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (ruleForm.yayiPhoto || '').split(',')" :src="$base.url+item" width="100" height="100">
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='yayi' ">
                    <el-form-item class="input" v-if="type!='info'"  label="牙医邮箱" prop="yayiEmail">
                        <el-input v-model="yayiForm.yayiEmail"
                                  placeholder="牙医邮箱" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="牙医邮箱" prop="yayiEmail">
                            <el-input v-model="ruleForm.yayiEmail"
                                      placeholder="牙医邮箱" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='yayi' ">
                    <el-form-item class="input" v-if="type!='info'"  label="职位" prop="zhiweiValue">
                        <el-input v-model="yayiForm.zhiweiValue"
                                  placeholder="职位" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="职位" prop="zhiweiValue">
                            <el-input v-model="ruleForm.zhiweiValue"
                                      placeholder="职位" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='yayi' ">
                    <el-form-item class="input" v-if="type!='info'"  label="账户状态" prop="jinyongValue">
                        <el-input v-model="yayiForm.jinyongValue"
                                  placeholder="账户状态" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="账户状态" prop="jinyongValue">
                            <el-input v-model="ruleForm.jinyongValue"
                                      placeholder="账户状态" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='yonghu'">
                    <el-form-item class="select" v-if="type!='info'"  label="用户" prop="yonghuId">
                        <el-select v-model="ruleForm.yonghuId" :disabled="ro.yonghuId" filterable placeholder="请选择用户" @change="yonghuChange">
                            <el-option
                                    v-for="(item,index) in yonghuOptions"
                                    v-bind:key="item.id"
                                    :label="item.yonghuName"
                                    :value="item.id">
                            </el-option>
                        </el-select>
                    </el-form-item>
                </el-col>

                <el-col :span="12"  v-if="sessionTable !='yonghu' ">
                    <el-form-item class="input" v-if="type!='info'"  label="用户编号" prop="yonghuUuidNumber">
                        <el-input v-model="yonghuForm.yonghuUuidNumber"
                                  placeholder="用户编号" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="用户编号" prop="yonghuUuidNumber">
                            <el-input v-model="ruleForm.yonghuUuidNumber"
                                      placeholder="用户编号" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='yonghu' ">
                    <el-form-item class="input" v-if="type!='info'"  label="用户姓名" prop="yonghuName">
                        <el-input v-model="yonghuForm.yonghuName"
                                  placeholder="用户姓名" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="用户姓名" prop="yonghuName">
                            <el-input v-model="ruleForm.yonghuName"
                                      placeholder="用户姓名" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='yonghu' ">
                    <el-form-item class="input" v-if="type!='info'"  label="用户手机号" prop="yonghuPhone">
                        <el-input v-model="yonghuForm.yonghuPhone"
                                  placeholder="用户手机号" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="用户手机号" prop="yonghuPhone">
                            <el-input v-model="ruleForm.yonghuPhone"
                                      placeholder="用户手机号" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='yonghu' ">
                    <el-form-item class="input" v-if="type!='info'"  label="用户身份证号" prop="yonghuIdNumber">
                        <el-input v-model="yonghuForm.yonghuIdNumber"
                                  placeholder="用户身份证号" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="用户身份证号" prop="yonghuIdNumber">
                            <el-input v-model="ruleForm.yonghuIdNumber"
                                      placeholder="用户身份证号" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12" v-if="sessionTable !='yonghu' ">
                    <el-form-item class="upload" v-if="type!='info' && !ro.yonghuPhoto" label="用户头像" prop="yonghuPhoto">
                        <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (yonghuForm.yonghuPhoto || '').split(',')" :src="$base.url+item" width="100" height="100">
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item v-if="ruleForm.yonghuPhoto" label="用户头像" prop="yonghuPhoto">
                            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (ruleForm.yonghuPhoto || '').split(',')" :src="$base.url+item" width="100" height="100">
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='yonghu' ">
                    <el-form-item class="input" v-if="type!='info'"  label="用户邮箱" prop="yonghuEmail">
                        <el-input v-model="yonghuForm.yonghuEmail"
                                  placeholder="用户邮箱" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="用户邮箱" prop="yonghuEmail">
                            <el-input v-model="ruleForm.yonghuEmail"
                                      placeholder="用户邮箱" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='yonghu' ">
                    <el-form-item class="input" v-if="type!='info'"  label="账户状态" prop="jinyongValue">
                        <el-input v-model="yonghuForm.jinyongValue"
                                  placeholder="账户状态" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="账户状态" prop="jinyongValue">
                            <el-input v-model="ruleForm.jinyongValue"
                                      placeholder="账户状态" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <input id="updateId" name="id" type="hidden">
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="病例编号" prop="bingliUuidNumber">
                       <el-input v-model="ruleForm.bingliUuidNumber"
                                 placeholder="病例编号" clearable  :readonly="ro.bingliUuidNumber"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="病例编号" prop="bingliUuidNumber">
                           <el-input v-model="ruleForm.bingliUuidNumber"
                                     placeholder="病例编号" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
            <input id="yonghuId" name="yonghuId" type="hidden">
            <input id="yayiId" name="yayiId" type="hidden">
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="病人名称" prop="bingrenName">
                       <el-input v-model="ruleForm.bingrenName"
                                 placeholder="病人名称" clearable  :readonly="ro.bingrenName"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="病人名称" prop="bingrenName">
                           <el-input v-model="ruleForm.bingrenName"
                                     placeholder="病人名称" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
                <el-col :span="12">
                    <el-form-item class="select" v-if="type!='info'"  label="性别" prop="sexTypes">
                        <el-select v-model="ruleForm.sexTypes" :disabled="ro.sexTypes" placeholder="请选择性别">
                            <el-option
                                v-for="(item,index) in sexTypesOptions"
                                v-bind:key="item.codeIndex"
                                :label="item.indexName"
                                :value="item.codeIndex">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="性别" prop="sexValue">
                        <el-input v-model="ruleForm.sexValue"
                            placeholder="性别" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="年龄" prop="age">
                       <el-input v-model="ruleForm.age"
                                 placeholder="年龄" clearable  :readonly="ro.age"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="年龄" prop="age">
                           <el-input v-model="ruleForm.age"
                                     placeholder="年龄" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
                <el-col :span="24">
                    <el-form-item v-if="type!='info' && !ro.bingliZhusuContent"  label="主诉" prop="bingliZhusuContent">
                        <editor style="min-width: 200px; max-width: 600px;"
                                v-model="ruleForm.bingliZhusuContent"
                                class="editor"
                                action="file/upload">
                        </editor>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item v-if="ruleForm.bingliZhusuContent" label="主诉" prop="bingliZhusuContent">
                            <span v-html="ruleForm.bingliZhusuContent"></span>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="24">
                    <el-form-item v-if="type!='info' && !ro.bingliXianbingshiContent"  label="现病史" prop="bingliXianbingshiContent">
                        <editor style="min-width: 200px; max-width: 600px;"
                                v-model="ruleForm.bingliXianbingshiContent"
                                class="editor"
                                action="file/upload">
                        </editor>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item v-if="ruleForm.bingliXianbingshiContent" label="现病史" prop="bingliXianbingshiContent">
                            <span v-html="ruleForm.bingliXianbingshiContent"></span>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="24">
                    <el-form-item v-if="type!='info' && !ro.bingliJiwangshiContent"  label="既往史" prop="bingliJiwangshiContent">
                        <editor style="min-width: 200px; max-width: 600px;"
                                v-model="ruleForm.bingliJiwangshiContent"
                                class="editor"
                                action="file/upload">
                        </editor>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item v-if="ruleForm.bingliJiwangshiContent" label="既往史" prop="bingliJiwangshiContent">
                            <span v-html="ruleForm.bingliJiwangshiContent"></span>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="24">
                    <el-form-item v-if="type!='info' && !ro.bingliTijianjieguoContent"  label="体检结果" prop="bingliTijianjieguoContent">
                        <editor style="min-width: 200px; max-width: 600px;"
                                v-model="ruleForm.bingliTijianjieguoContent"
                                class="editor"
                                action="file/upload">
                        </editor>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item v-if="ruleForm.bingliTijianjieguoContent" label="体检结果" prop="bingliTijianjieguoContent">
                            <span v-html="ruleForm.bingliTijianjieguoContent"></span>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="24">
                    <el-form-item v-if="type!='info' && !ro.bingliFuzhujieguoContent"  label="辅助检查结果" prop="bingliFuzhujieguoContent">
                        <editor style="min-width: 200px; max-width: 600px;"
                                v-model="ruleForm.bingliFuzhujieguoContent"
                                class="editor"
                                action="file/upload">
                        </editor>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item v-if="ruleForm.bingliFuzhujieguoContent" label="辅助检查结果" prop="bingliFuzhujieguoContent">
                            <span v-html="ruleForm.bingliFuzhujieguoContent"></span>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="24">
                    <el-form-item v-if="type!='info' && !ro.bingliChubuzhenduanContent"  label="初步诊断" prop="bingliChubuzhenduanContent">
                        <editor style="min-width: 200px; max-width: 600px;"
                                v-model="ruleForm.bingliChubuzhenduanContent"
                                class="editor"
                                action="file/upload">
                        </editor>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item v-if="ruleForm.bingliChubuzhenduanContent" label="初步诊断" prop="bingliChubuzhenduanContent">
                            <span v-html="ruleForm.bingliChubuzhenduanContent"></span>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="24">
                    <el-form-item v-if="type!='info' && !ro.bingliZhiliaoyijianContent"  label="治疗意见" prop="bingliZhiliaoyijianContent">
                        <editor style="min-width: 200px; max-width: 600px;"
                                v-model="ruleForm.bingliZhiliaoyijianContent"
                                class="editor"
                                action="file/upload">
                        </editor>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item v-if="ruleForm.bingliZhiliaoyijianContent" label="治疗意见" prop="bingliZhiliaoyijianContent">
                            <span v-html="ruleForm.bingliZhiliaoyijianContent"></span>
                        </el-form-item>
                    </div>
                </el-col>
            </el-row>
            <el-form-item class="btn">
                <el-button v-if="type!='info'" type="primary" class="btn-success" @click="onSubmit">提交</el-button>
                <el-button v-if="type!='info'" class="btn-close" @click="back()">取消</el-button>
                <el-button v-if="type=='info'" class="btn-close" @click="back()">返回</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>
<script>
    import styleJs from "../../../utils/style.js";
    // 数字，邮件，手机，url，身份证校验
    import { isNumber,isIntNumer,isEmail,isPhone, isMobile,isURL,checkIdCard } from "@/utils/validate";
    import utilsJs, {getYearFormat,getMonthFormat,getDateFormat,getDatetimeFormat} from "../../../utils/utils.js";
    export default {
        data() {
            return {
                addEditForm:null,
                id: '',
                type: '',
                sessionTable : "",//登录账户所在表名
                role : "",//权限
                userId:"",//当前登录人的id
                yayiForm: {},
                yonghuForm: {},
                ro:{
                    bingliUuidNumber: true,
                    yonghuId: false,
                    yayiId: false,
                    bingrenName: false,
                    sexTypes: false,
                    age: false,
                    bingliZhusuContent: false,
                    bingliXianbingshiContent: false,
                    bingliJiwangshiContent: false,
                    bingliTijianjieguoContent: false,
                    bingliFuzhujieguoContent: false,
                    bingliChubuzhenduanContent: false,
                    bingliZhiliaoyijianContent: false,
                    insertTime: false,
                },
                ruleForm: {
                    bingliUuidNumber: new Date().getTime(),
                    yonghuId: '',
                    yayiId: '',
                    bingrenName: '',
                    sexTypes: '',
                    age: '',
                    bingliZhusuContent: '',
                    bingliXianbingshiContent: '',
                    bingliJiwangshiContent: '',
                    bingliTijianjieguoContent: '',
                    bingliFuzhujieguoContent: '',
                    bingliChubuzhenduanContent: '',
                    bingliZhiliaoyijianContent: '',
                    insertTime: '',
                },
                sexTypesOptions : [],
                yayiOptions : [],
                yonghuOptions : [],
                rules: {
                   bingliUuidNumber: [
                              { required: true, message: '病例编号不能为空', trigger: 'blur' },
                          ],
                   yonghuId: [
                              { required: true, message: '用户不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   yayiId: [
                              { required: true, message: '牙医不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   bingrenName: [
                              { required: true, message: '病人名称不能为空', trigger: 'blur' },
                          ],
                   sexTypes: [
                              { required: true, message: '性别不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   age: [
                              { required: true, message: '年龄不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   bingliZhusuContent: [
                              { required: true, message: '主诉不能为空', trigger: 'blur' },
                          ],
                   bingliXianbingshiContent: [
                              { required: true, message: '现病史不能为空', trigger: 'blur' },
                          ],
                   bingliJiwangshiContent: [
                              { required: true, message: '既往史不能为空', trigger: 'blur' },
                          ],
                   bingliTijianjieguoContent: [
                              { required: true, message: '体检结果不能为空', trigger: 'blur' },
                          ],
                   bingliFuzhujieguoContent: [
                              { required: true, message: '辅助检查结果不能为空', trigger: 'blur' },
                          ],
                   bingliChubuzhenduanContent: [
                              { required: true, message: '初步诊断不能为空', trigger: 'blur' },
                          ],
                   bingliZhiliaoyijianContent: [
                              { required: true, message: '治疗意见不能为空', trigger: 'blur' },
                          ],
                   insertTime: [
                              { required: true, message: '上传时间不能为空', trigger: 'blur' },
                          ],
                }
            };
        },
        props: ["parent"],
        computed: {
        },
        created() {
            //获取当前登录用户的信息
            this.sessionTable = this.$storage.get("sessionTable");
            this.role = this.$storage.get("role");
            this.userId = this.$storage.get("userId");


            if (this.role != "管理员"){
            }else{
            }
            this.addEditForm = styleJs.addStyle();
            this.addEditStyleChange()
            this.addEditUploadStyleChange()
            //获取下拉框信息
                this.$http({
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=sex_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.sexTypesOptions = data.data.list;
                    }
                });

         this.$http({
             url: `yayi/page?page=1&limit=100`,
             method: "get"
         }).then(({ data }) => {
             if (data && data.code === 0) {
                this.yayiOptions = data.data.list;
            }
         });
         this.$http({
             url: `yonghu/page?page=1&limit=100`,
             method: "get"
         }).then(({ data }) => {
             if (data && data.code === 0) {
                this.yonghuOptions = data.data.list;
            }
         });

        },
        mounted() {
        },
        methods: {
            // 下载
            download(file){
                window.open(`${file}`)
            },
            // 初始化
            init(id,type) {
                if (id) {
                    this.id = id;
                    this.type = type;
                }
                if(this.type=='info'||this.type=='else'){
                    this.info(id);
                }
                // 获取用户信息
                this.$http({
                    url:`${this.$storage.get("sessionTable")}/session`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        var json = data.data;
                    } else {
                        this.$message.error(data.msg);
                    }
                });
            },
            yayiChange(id){
                this.$http({
                    url: `yayi/info/`+id,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.yayiForm = data.data;
                    }
                });
            },
            yonghuChange(id){
                this.$http({
                    url: `yonghu/info/`+id,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.yonghuForm = data.data;
                    }
                });
            },
            // 多级联动参数
            info(id) {
                let _this =this;
                _this.$http({
                    url: `bingli/info/${id}`,
                    method: 'get'
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        _this.ruleForm = data.data;
                        _this.yayiChange(data.data.yayiId)
                        _this.yonghuChange(data.data.yonghuId)
                        _this.ruleForm.bingliZhusuContent = _this.ruleForm.bingliZhusuContent.replaceAll("src=\"upload/","src=\""+this.$base.url+"upload/");
                        _this.ruleForm.bingliXianbingshiContent = _this.ruleForm.bingliXianbingshiContent.replaceAll("src=\"upload/","src=\""+this.$base.url+"upload/");
                        _this.ruleForm.bingliJiwangshiContent = _this.ruleForm.bingliJiwangshiContent.replaceAll("src=\"upload/","src=\""+this.$base.url+"upload/");
                        _this.ruleForm.bingliTijianjieguoContent = _this.ruleForm.bingliTijianjieguoContent.replaceAll("src=\"upload/","src=\""+this.$base.url+"upload/");
                        _this.ruleForm.bingliFuzhujieguoContent = _this.ruleForm.bingliFuzhujieguoContent.replaceAll("src=\"upload/","src=\""+this.$base.url+"upload/");
                        _this.ruleForm.bingliChubuzhenduanContent = _this.ruleForm.bingliChubuzhenduanContent.replaceAll("src=\"upload/","src=\""+this.$base.url+"upload/");
                        _this.ruleForm.bingliZhiliaoyijianContent = _this.ruleForm.bingliZhiliaoyijianContent.replaceAll("src=\"upload/","src=\""+this.$base.url+"upload/");
                    } else {
                        _this.$message.error(data.msg);
                    }
                });
            },
            // 提交
            onSubmit() {
                this.$refs["ruleForm"].validate(valid => {
                    if (valid) {
                        this.ruleForm.bingliZhusuContent = this.ruleForm.bingliZhusuContent.replaceAll(this.$base.url,"");
                        this.ruleForm.bingliXianbingshiContent = this.ruleForm.bingliXianbingshiContent.replaceAll(this.$base.url,"");
                        this.ruleForm.bingliJiwangshiContent = this.ruleForm.bingliJiwangshiContent.replaceAll(this.$base.url,"");
                        this.ruleForm.bingliTijianjieguoContent = this.ruleForm.bingliTijianjieguoContent.replaceAll(this.$base.url,"");
                        this.ruleForm.bingliFuzhujieguoContent = this.ruleForm.bingliFuzhujieguoContent.replaceAll(this.$base.url,"");
                        this.ruleForm.bingliChubuzhenduanContent = this.ruleForm.bingliChubuzhenduanContent.replaceAll(this.$base.url,"");
                        this.ruleForm.bingliZhiliaoyijianContent = this.ruleForm.bingliZhiliaoyijianContent.replaceAll(this.$base.url,"");
                        this.$http({
                            url:`bingli/${!this.ruleForm.id ? "save" : "update"}`,
                            method: "post",
                            data: this.ruleForm
                        }).then(({ data }) => {
                            if (data && data.code === 0) {
                                this.$message({
                                    message: "操作成功",
                                    type: "success",
                                    duration: 1500,
                                    onClose: () => {
                                        this.parent.showFlag = true;
                                        this.parent.addOrUpdateFlag = false;
                                        this.parent.bingliCrossAddOrUpdateFlag = false;
                                        this.parent.search();
                                        this.parent.contentStyleChange();
                                    }
                                });
                            } else {
                                this.$message.error(data.msg);
                            }
                        });
                    }
                });
            },
            // 获取uuid
            getUUID () {
                return new Date().getTime();
            },
            // 返回
            back() {
                this.parent.showFlag = true;
                this.parent.addOrUpdateFlag = false;
                this.parent.bingliCrossAddOrUpdateFlag = false;
                this.parent.contentStyleChange();
            },
            //图片

            addEditStyleChange() {
                this.$nextTick(()=>{
                    // input
                    document.querySelectorAll('.addEdit-block .input .el-input__inner').forEach(el=>{
                        el.style.height = this.addEditForm.inputHeight
                        el.style.color = this.addEditForm.inputFontColor
                        el.style.fontSize = this.addEditForm.inputFontSize
                        el.style.borderWidth = this.addEditForm.inputBorderWidth
                        el.style.borderStyle = this.addEditForm.inputBorderStyle
                        el.style.borderColor = this.addEditForm.inputBorderColor
                        el.style.borderRadius = this.addEditForm.inputBorderRadius
                        el.style.backgroundColor = this.addEditForm.inputBgColor
                    })
                    document.querySelectorAll('.addEdit-block .input .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.inputHeight
                        el.style.color = this.addEditForm.inputLableColor
                        el.style.fontSize = this.addEditForm.inputLableFontSize
                    })
                    // select
                    document.querySelectorAll('.addEdit-block .select .el-input__inner').forEach(el=>{
                        el.style.height = this.addEditForm.selectHeight
                        el.style.color = this.addEditForm.selectFontColor
                        el.style.fontSize = this.addEditForm.selectFontSize
                        el.style.borderWidth = this.addEditForm.selectBorderWidth
                        el.style.borderStyle = this.addEditForm.selectBorderStyle
                        el.style.borderColor = this.addEditForm.selectBorderColor
                        el.style.borderRadius = this.addEditForm.selectBorderRadius
                        el.style.backgroundColor = this.addEditForm.selectBgColor
                    })
                    document.querySelectorAll('.addEdit-block .select .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.selectHeight
                        el.style.color = this.addEditForm.selectLableColor
                        el.style.fontSize = this.addEditForm.selectLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .select .el-select__caret').forEach(el=>{
                        el.style.color = this.addEditForm.selectIconFontColor
                        el.style.fontSize = this.addEditForm.selectIconFontSize
                    })
                    // date
                    document.querySelectorAll('.addEdit-block .date .el-input__inner').forEach(el=>{
                        el.style.height = this.addEditForm.dateHeight
                        el.style.color = this.addEditForm.dateFontColor
                        el.style.fontSize = this.addEditForm.dateFontSize
                        el.style.borderWidth = this.addEditForm.dateBorderWidth
                        el.style.borderStyle = this.addEditForm.dateBorderStyle
                        el.style.borderColor = this.addEditForm.dateBorderColor
                        el.style.borderRadius = this.addEditForm.dateBorderRadius
                        el.style.backgroundColor = this.addEditForm.dateBgColor
                    })
                    document.querySelectorAll('.addEdit-block .date .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.dateHeight
                        el.style.color = this.addEditForm.dateLableColor
                        el.style.fontSize = this.addEditForm.dateLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .date .el-input__icon').forEach(el=>{
                        el.style.color = this.addEditForm.dateIconFontColor
                        el.style.fontSize = this.addEditForm.dateIconFontSize
                        el.style.lineHeight = this.addEditForm.dateHeight
                    })
                    // upload
                    let iconLineHeight = parseInt(this.addEditForm.uploadHeight) - parseInt(this.addEditForm.uploadBorderWidth) * 2 + 'px'
                    document.querySelectorAll('.addEdit-block .upload .el-upload--picture-card').forEach(el=>{
                        el.style.width = this.addEditForm.uploadHeight
                        el.style.height = this.addEditForm.uploadHeight
                        el.style.borderWidth = this.addEditForm.uploadBorderWidth
                        el.style.borderStyle = this.addEditForm.uploadBorderStyle
                        el.style.borderColor = this.addEditForm.uploadBorderColor
                        el.style.borderRadius = this.addEditForm.uploadBorderRadius
                        el.style.backgroundColor = this.addEditForm.uploadBgColor
                    })
                    document.querySelectorAll('.addEdit-block .upload .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.uploadHeight
                        el.style.color = this.addEditForm.uploadLableColor
                        el.style.fontSize = this.addEditForm.uploadLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .upload .el-icon-plus').forEach(el=>{
                        el.style.color = this.addEditForm.uploadIconFontColor
                        el.style.fontSize = this.addEditForm.uploadIconFontSize
                        el.style.lineHeight = iconLineHeight
                        el.style.display = 'block'
                    })
                    // 多文本输入框
                    document.querySelectorAll('.addEdit-block .textarea .el-textarea__inner').forEach(el=>{
                        el.style.height = this.addEditForm.textareaHeight
                        el.style.color = this.addEditForm.textareaFontColor
                        el.style.fontSize = this.addEditForm.textareaFontSize
                        el.style.borderWidth = this.addEditForm.textareaBorderWidth
                        el.style.borderStyle = this.addEditForm.textareaBorderStyle
                        el.style.borderColor = this.addEditForm.textareaBorderColor
                        el.style.borderRadius = this.addEditForm.textareaBorderRadius
                        el.style.backgroundColor = this.addEditForm.textareaBgColor
                    })
                    document.querySelectorAll('.addEdit-block .textarea .el-form-item__label').forEach(el=>{
                        // el.style.lineHeight = this.addEditForm.textareaHeight
                        el.style.color = this.addEditForm.textareaLableColor
                        el.style.fontSize = this.addEditForm.textareaLableFontSize
                    })
                    // 保存
                    document.querySelectorAll('.addEdit-block .btn .btn-success').forEach(el=>{
                        el.style.width = this.addEditForm.btnSaveWidth
                        el.style.height = this.addEditForm.btnSaveHeight
                        el.style.color = this.addEditForm.btnSaveFontColor
                        el.style.fontSize = this.addEditForm.btnSaveFontSize
                        el.style.borderWidth = this.addEditForm.btnSaveBorderWidth
                        el.style.borderStyle = this.addEditForm.btnSaveBorderStyle
                        el.style.borderColor = this.addEditForm.btnSaveBorderColor
                        el.style.borderRadius = this.addEditForm.btnSaveBorderRadius
                        el.style.backgroundColor = this.addEditForm.btnSaveBgColor
                    })
                    // 返回
                    document.querySelectorAll('.addEdit-block .btn .btn-close').forEach(el=>{
                        el.style.width = this.addEditForm.btnCancelWidth
                        el.style.height = this.addEditForm.btnCancelHeight
                        el.style.color = this.addEditForm.btnCancelFontColor
                        el.style.fontSize = this.addEditForm.btnCancelFontSize
                        el.style.borderWidth = this.addEditForm.btnCancelBorderWidth
                        el.style.borderStyle = this.addEditForm.btnCancelBorderStyle
                        el.style.borderColor = this.addEditForm.btnCancelBorderColor
                        el.style.borderRadius = this.addEditForm.btnCancelBorderRadius
                        el.style.backgroundColor = this.addEditForm.btnCancelBgColor
                    })
                })
            },
            addEditUploadStyleChange() {
                this.$nextTick(()=>{
                    document.querySelectorAll('.addEdit-block .upload .el-upload-list--picture-card .el-upload-list__item').forEach(el=>{
                        el.style.width = this.addEditForm.uploadHeight
                        el.style.height = this.addEditForm.uploadHeight
                        el.style.borderWidth = this.addEditForm.uploadBorderWidth
                        el.style.borderStyle = this.addEditForm.uploadBorderStyle
                        el.style.borderColor = this.addEditForm.uploadBorderColor
                        el.style.borderRadius = this.addEditForm.uploadBorderRadius
                        el.style.backgroundColor = this.addEditForm.uploadBgColor
                    })
                })
            },
        }
    };
</script>
<style lang="scss">
.editor{
  height: 500px;

  & /deep/ .ql-container {
	  height: 310px;
  }
}
.amap-wrapper {
  width: 100%;
  height: 500px;
}
.search-box {
  position: absolute;
}
.addEdit-block {
	margin: -10px;
}
.detail-form-content {
	padding: 12px;
	background-color: transparent;
}
.btn .el-button {
  padding: 0;
}</style>

