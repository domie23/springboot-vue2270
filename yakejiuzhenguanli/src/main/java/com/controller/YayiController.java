
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 牙医
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/yayi")
public class YayiController {
    private static final Logger logger = LoggerFactory.getLogger(YayiController.class);

    private static final String TABLE_NAME = "yayi";

    @Autowired
    private YayiService yayiService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private BingliService bingliService;//病例
    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private GonggaoService gonggaoService;//公告
    @Autowired
    private YaodanService yaodanService;//药单
    @Autowired
    private YaopinService yaopinService;//药品
    @Autowired
    private YaopinCollectionService yaopinCollectionService;//药品收藏
    @Autowired
    private YaopinCommentbackService yaopinCommentbackService;//药品评价
    @Autowired
    private YaopinOrderService yaopinOrderService;//药品订单
    @Autowired
    private YayiCollectionService yayiCollectionService;//牙医收藏
    @Autowired
    private YayiCommentbackService yayiCommentbackService;//牙医评价
    @Autowired
    private YayiOrderService yayiOrderService;//牙医挂号
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("牙医".equals(role))
            params.put("yayiId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = yayiService.queryPage(params);

        //字典表数据转换
        List<YayiView> list =(List<YayiView>)page.getList();
        for(YayiView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        YayiEntity yayi = yayiService.selectById(id);
        if(yayi !=null){
            //entity转view
            YayiView view = new YayiView();
            BeanUtils.copyProperties( yayi , view );//把实体数据重构到view中
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody YayiEntity yayi, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,yayi:{}",this.getClass().getName(),yayi.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<YayiEntity> queryWrapper = new EntityWrapper<YayiEntity>()
            .eq("username", yayi.getUsername())
            .or()
            .eq("yayi_phone", yayi.getYayiPhone())
            .or()
            .eq("yayi_id_number", yayi.getYayiIdNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YayiEntity yayiEntity = yayiService.selectOne(queryWrapper);
        if(yayiEntity==null){
            yayi.setCreateTime(new Date());
            yayi.setPassword("123456");
            yayiService.insert(yayi);
            return R.ok();
        }else {
            return R.error(511,"账户或者牙医手机号或者牙医身份证号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody YayiEntity yayi, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,yayi:{}",this.getClass().getName(),yayi.toString());
        YayiEntity oldYayiEntity = yayiService.selectById(yayi.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(yayi.getYayiPhoto()) || "null".equals(yayi.getYayiPhoto())){
                yayi.setYayiPhoto(null);
        }
        if("".equals(yayi.getYayiContent()) || "null".equals(yayi.getYayiContent())){
                yayi.setYayiContent(null);
        }
        if("".equals(yayi.getYayiShanchangContent()) || "null".equals(yayi.getYayiShanchangContent())){
                yayi.setYayiShanchangContent(null);
        }
        if("".equals(yayi.getYayiRongyuContent()) || "null".equals(yayi.getYayiRongyuContent())){
                yayi.setYayiRongyuContent(null);
        }

            yayiService.updateById(yayi);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<YayiEntity> oldYayiList =yayiService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        yayiService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //.eq("time", new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
        try {
            List<YayiEntity> yayiList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            YayiEntity yayiEntity = new YayiEntity();
//                            yayiEntity.setUsername(data.get(0));                    //账户 要改的
//                            yayiEntity.setPassword("123456");//密码
//                            yayiEntity.setYayiUuidNumber(data.get(0));                    //牙医编号 要改的
//                            yayiEntity.setYayiName(data.get(0));                    //牙医姓名 要改的
//                            yayiEntity.setYayiPhone(data.get(0));                    //牙医手机号 要改的
//                            yayiEntity.setYayiIdNumber(data.get(0));                    //牙医身份证号 要改的
//                            yayiEntity.setYayiPhoto("");//详情和图片
//                            yayiEntity.setSexTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            yayiEntity.setYayiEmail(data.get(0));                    //牙医邮箱 要改的
//                            yayiEntity.setNewMoney(data.get(0));                    //挂号费用 要改的
//                            yayiEntity.setZhiweiTypes(Integer.valueOf(data.get(0)));   //职位 要改的
//                            yayiEntity.setYayiContent("");//详情和图片
//                            yayiEntity.setYayiShanchangContent("");//详情和图片
//                            yayiEntity.setYayiRongyuContent("");//详情和图片
//                            yayiEntity.setJinyongTypes(Integer.valueOf(data.get(0)));   //账户状态 要改的
//                            yayiEntity.setCreateTime(date);//时间
                            yayiList.add(yayiEntity);


                            //把要查询是否重复的字段放入map中
                                //账户
                                if(seachFields.containsKey("username")){
                                    List<String> username = seachFields.get("username");
                                    username.add(data.get(0));//要改的
                                }else{
                                    List<String> username = new ArrayList<>();
                                    username.add(data.get(0));//要改的
                                    seachFields.put("username",username);
                                }
                                //牙医编号
                                if(seachFields.containsKey("yayiUuidNumber")){
                                    List<String> yayiUuidNumber = seachFields.get("yayiUuidNumber");
                                    yayiUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> yayiUuidNumber = new ArrayList<>();
                                    yayiUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("yayiUuidNumber",yayiUuidNumber);
                                }
                                //牙医手机号
                                if(seachFields.containsKey("yayiPhone")){
                                    List<String> yayiPhone = seachFields.get("yayiPhone");
                                    yayiPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> yayiPhone = new ArrayList<>();
                                    yayiPhone.add(data.get(0));//要改的
                                    seachFields.put("yayiPhone",yayiPhone);
                                }
                                //牙医身份证号
                                if(seachFields.containsKey("yayiIdNumber")){
                                    List<String> yayiIdNumber = seachFields.get("yayiIdNumber");
                                    yayiIdNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> yayiIdNumber = new ArrayList<>();
                                    yayiIdNumber.add(data.get(0));//要改的
                                    seachFields.put("yayiIdNumber",yayiIdNumber);
                                }
                        }

                        //查询是否重复
                         //账户
                        List<YayiEntity> yayiEntities_username = yayiService.selectList(new EntityWrapper<YayiEntity>().in("username", seachFields.get("username")));
                        if(yayiEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(YayiEntity s:yayiEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //牙医编号
                        List<YayiEntity> yayiEntities_yayiUuidNumber = yayiService.selectList(new EntityWrapper<YayiEntity>().in("yayi_uuid_number", seachFields.get("yayiUuidNumber")));
                        if(yayiEntities_yayiUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(YayiEntity s:yayiEntities_yayiUuidNumber){
                                repeatFields.add(s.getYayiUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [牙医编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //牙医手机号
                        List<YayiEntity> yayiEntities_yayiPhone = yayiService.selectList(new EntityWrapper<YayiEntity>().in("yayi_phone", seachFields.get("yayiPhone")));
                        if(yayiEntities_yayiPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(YayiEntity s:yayiEntities_yayiPhone){
                                repeatFields.add(s.getYayiPhone());
                            }
                            return R.error(511,"数据库的该表中的 [牙医手机号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //牙医身份证号
                        List<YayiEntity> yayiEntities_yayiIdNumber = yayiService.selectList(new EntityWrapper<YayiEntity>().in("yayi_id_number", seachFields.get("yayiIdNumber")));
                        if(yayiEntities_yayiIdNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(YayiEntity s:yayiEntities_yayiIdNumber){
                                repeatFields.add(s.getYayiIdNumber());
                            }
                            return R.error(511,"数据库的该表中的 [牙医身份证号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        yayiService.insertBatch(yayiList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }

    /**
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        YayiEntity yayi = yayiService.selectOne(new EntityWrapper<YayiEntity>().eq("username", username));
        if(yayi==null || !yayi.getPassword().equals(password))
            return R.error("账号或密码不正确");
        else if(yayi.getJinyongTypes() != 1)
            return R.error("账户已被禁用");
        String token = tokenService.generateToken(yayi.getId(),username, "yayi", "牙医");
        R r = R.ok();
        r.put("token", token);
        r.put("role","牙医");
        r.put("username",yayi.getYayiName());
        r.put("tableName","yayi");
        r.put("userId",yayi.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody YayiEntity yayi, HttpServletRequest request) {
//    	ValidatorUtils.validateEntity(user);
        Wrapper<YayiEntity> queryWrapper = new EntityWrapper<YayiEntity>()
            .eq("username", yayi.getUsername())
            .or()
            .eq("yayi_phone", yayi.getYayiPhone())
            .or()
            .eq("yayi_id_number", yayi.getYayiIdNumber())
            ;
        YayiEntity yayiEntity = yayiService.selectOne(queryWrapper);
        if(yayiEntity != null)
            return R.error("账户或者牙医手机号或者牙医身份证号已经被使用");
        yayi.setYayiUuidNumber(String.valueOf(new Date().getTime()));
        yayi.setNewMoney(0.0);
        yayi.setJinyongTypes(1);//启用
        yayi.setCreateTime(new Date());
        yayiService.insert(yayi);

        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id, HttpServletRequest request) {
        YayiEntity yayi = yayiService.selectById(id);
        yayi.setPassword("123456");
        yayiService.updateById(yayi);
        return R.ok();
    }

	/**
	 * 修改密码
	 */
	@GetMapping(value = "/updatePassword")
	public R updatePassword(String  oldPassword, String  newPassword, HttpServletRequest request) {
        YayiEntity yayi = yayiService.selectById((Integer)request.getSession().getAttribute("userId"));
		if(newPassword == null){
			return R.error("新密码不能为空") ;
		}
		if(!oldPassword.equals(yayi.getPassword())){
			return R.error("原密码输入错误");
		}
		if(newPassword.equals(yayi.getPassword())){
			return R.error("新密码不能和原密码一致") ;
		}
        yayi.setPassword(newPassword);
		yayiService.updateById(yayi);
		return R.ok();
	}



    /**
     * 忘记密码
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        YayiEntity yayi = yayiService.selectOne(new EntityWrapper<YayiEntity>().eq("username", username));
        if(yayi!=null){
            yayi.setPassword("123456");
            yayiService.updateById(yayi);
            return R.ok();
        }else{
           return R.error("账号不存在");
        }
    }


    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrYayi(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        YayiEntity yayi = yayiService.selectById(id);
        if(yayi !=null){
            //entity转view
            YayiView view = new YayiView();
            BeanUtils.copyProperties( yayi , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }
    }


    /**
    * 退出
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }


    /**
    * 个性推荐
    */
    @IgnoreAuth
    @RequestMapping("/gexingtuijian")
    public R gexingtuijian(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("gexingtuijian方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        CommonUtil.checkMap(params);
        List<YayiView> returnYayiViewList = new ArrayList<>();

        //查询订单
        Map<String, Object> params1 = new HashMap<>(params);params1.put("sort","id");params1.put("yonghuId",request.getSession().getAttribute("userId"));
        params1.put("shangxiaTypes",1);
        params1.put("yayiYesnoTypes",2);
        Integer limit = Integer.valueOf(String.valueOf(params.get("limit")));
        //正常查询出来商品,用于补全推荐缺少的数据
        PageUtils page = yayiService.queryPage(params);
        if(returnYayiViewList.size()<limit){//返回数量还是小于要求数量
            int toAddNum = limit - returnYayiViewList.size();//要添加的数量
            List<YayiView> yayiViewList =(List<YayiView>)page.getList();
            for(YayiView yayiView:yayiViewList){
                Boolean addFlag = true;
                for(YayiView returnYayiView:returnYayiViewList){
                    if(returnYayiView.getId().intValue() ==yayiView.getId().intValue()) addFlag=false;//返回的数据中已存在此商品
                }
                if(addFlag){
                    toAddNum=toAddNum-1;
                    returnYayiViewList.add(yayiView);
                    if(toAddNum==0) break;//够数量了
                }
            }
        }else {
            returnYayiViewList = returnYayiViewList.subList(0, limit);
        }

        for(YayiView c:returnYayiViewList)
            dictionaryService.dictionaryConvert(c, request);
        page.setList(returnYayiViewList);
        return R.ok().put("data", page);
    }

    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = yayiService.queryPage(params);

        //字典表数据转换
        List<YayiView> list =(List<YayiView>)page.getList();
        for(YayiView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        YayiEntity yayi = yayiService.selectById(id);
            if(yayi !=null){


                //entity转view
                YayiView view = new YayiView();
                BeanUtils.copyProperties( yayi , view );//把实体数据重构到view中

                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody YayiEntity yayi, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,yayi:{}",this.getClass().getName(),yayi.toString());
        Wrapper<YayiEntity> queryWrapper = new EntityWrapper<YayiEntity>()
            .eq("username", yayi.getUsername())
            .or()
            .eq("yayi_phone", yayi.getYayiPhone())
            .or()
            .eq("yayi_id_number", yayi.getYayiIdNumber())
//            .notIn("yayi_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YayiEntity yayiEntity = yayiService.selectOne(queryWrapper);
        if(yayiEntity==null){
            yayi.setCreateTime(new Date());
            yayi.setPassword("123456");
        yayiService.insert(yayi);

            return R.ok();
        }else {
            return R.error(511,"账户或者牙医手机号或者牙医身份证号已经被使用");
        }
    }

}

