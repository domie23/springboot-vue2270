
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
 * 牙医挂号
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/yayiOrder")
public class YayiOrderController {
    private static final Logger logger = LoggerFactory.getLogger(YayiOrderController.class);

    private static final String TABLE_NAME = "yayiOrder";

    @Autowired
    private YayiOrderService yayiOrderService;


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
    private YayiService yayiService;//牙医
    @Autowired
    private YayiCollectionService yayiCollectionService;//牙医收藏
    @Autowired
    private YayiCommentbackService yayiCommentbackService;//牙医评价
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
        PageUtils page = yayiOrderService.queryPage(params);

        //字典表数据转换
        List<YayiOrderView> list =(List<YayiOrderView>)page.getList();
        for(YayiOrderView c:list){
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
        YayiOrderEntity yayiOrder = yayiOrderService.selectById(id);
        if(yayiOrder !=null){
            //entity转view
            YayiOrderView view = new YayiOrderView();
            BeanUtils.copyProperties( yayiOrder , view );//把实体数据重构到view中
            //级联表 牙医
            //级联表
            YayiEntity yayi = yayiService.selectById(yayiOrder.getYayiId());
            if(yayi != null){
            BeanUtils.copyProperties( yayi , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"
, "yayiId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYayiId(yayi.getId());
            }
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(yayiOrder.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"
, "yayiId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
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
    public R save(@RequestBody YayiOrderEntity yayiOrder, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,yayiOrder:{}",this.getClass().getName(),yayiOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            yayiOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        else if("牙医".equals(role))
            yayiOrder.setYayiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        yayiOrder.setCreateTime(new Date());
        yayiOrder.setInsertTime(new Date());
        yayiOrderService.insert(yayiOrder);

        return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody YayiOrderEntity yayiOrder, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,yayiOrder:{}",this.getClass().getName(),yayiOrder.toString());
        YayiOrderEntity oldYayiOrderEntity = yayiOrderService.selectById(yayiOrder.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            yayiOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
//        else if("牙医".equals(role))
//            yayiOrder.setYayiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

            yayiOrderService.updateById(yayiOrder);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<YayiOrderEntity> oldYayiOrderList =yayiOrderService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        yayiOrderService.deleteBatchIds(Arrays.asList(ids));

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
            List<YayiOrderEntity> yayiOrderList = new ArrayList<>();//上传的东西
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
                            YayiOrderEntity yayiOrderEntity = new YayiOrderEntity();
//                            yayiOrderEntity.setYayiOrderUuidNumber(data.get(0));                    //订单编号 要改的
//                            yayiOrderEntity.setYayiId(Integer.valueOf(data.get(0)));   //牙医 要改的
//                            yayiOrderEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            yayiOrderEntity.setYayiOrderYuyueTypes(Integer.valueOf(data.get(0)));   //预约类型 要改的
//                            yayiOrderEntity.setInsertTime(date);//时间
//                            yayiOrderEntity.setYayiOrderTime(sdf.parse(data.get(0)));          //预约日期 要改的
//                            yayiOrderEntity.setYayiOrderTypes(Integer.valueOf(data.get(0)));   //预约状态 要改的
//                            yayiOrderEntity.setCreateTime(date);//时间
                            yayiOrderList.add(yayiOrderEntity);


                            //把要查询是否重复的字段放入map中
                                //订单编号
                                if(seachFields.containsKey("yayiOrderUuidNumber")){
                                    List<String> yayiOrderUuidNumber = seachFields.get("yayiOrderUuidNumber");
                                    yayiOrderUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> yayiOrderUuidNumber = new ArrayList<>();
                                    yayiOrderUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("yayiOrderUuidNumber",yayiOrderUuidNumber);
                                }
                        }

                        //查询是否重复
                         //订单编号
                        List<YayiOrderEntity> yayiOrderEntities_yayiOrderUuidNumber = yayiOrderService.selectList(new EntityWrapper<YayiOrderEntity>().in("yayi_order_uuid_number", seachFields.get("yayiOrderUuidNumber")));
                        if(yayiOrderEntities_yayiOrderUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(YayiOrderEntity s:yayiOrderEntities_yayiOrderUuidNumber){
                                repeatFields.add(s.getYayiOrderUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [订单编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        yayiOrderService.insertBatch(yayiOrderList);
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
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = yayiOrderService.queryPage(params);

        //字典表数据转换
        List<YayiOrderView> list =(List<YayiOrderView>)page.getList();
        for(YayiOrderView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        YayiOrderEntity yayiOrder = yayiOrderService.selectById(id);
            if(yayiOrder !=null){


                //entity转view
                YayiOrderView view = new YayiOrderView();
                BeanUtils.copyProperties( yayiOrder , view );//把实体数据重构到view中

                //级联表
                    YayiEntity yayi = yayiService.selectById(yayiOrder.getYayiId());
                if(yayi != null){
                    BeanUtils.copyProperties( yayi , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"
, "yayiId"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYayiId(yayi.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(yayiOrder.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"
, "yayiId"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
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
    public R add(@RequestBody YayiOrderEntity yayiOrder, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,yayiOrder:{}",this.getClass().getName(),yayiOrder.toString());
            YayiEntity yayiEntity = yayiService.selectById(yayiOrder.getYayiId());
            if(yayiEntity == null){
                return R.error(511,"查不到该牙医");
            }

            //计算所获得积分
            Double buyJifen =0.0;
            Integer userId = (Integer) request.getSession().getAttribute("userId");
            YonghuEntity yonghuEntity = yonghuService.selectById(userId);
            if(yonghuEntity == null)
                return R.error(511,"用户不能为空");
            if(yonghuEntity.getNewMoney() == null)
                return R.error(511,"用户金额不能为空");
            double balance = yonghuEntity.getNewMoney() - yayiEntity.getNewMoney();//余额
            if(balance<0)
                return R.error(511,"余额不够支付此次挂号");
            yayiOrder.setYayiOrderTypes(101); //设置订单状态为已预约
            yayiOrder.setYonghuId(userId); //设置订单支付人id
            yayiOrder.setYayiOrderUuidNumber(String.valueOf(new Date().getTime()));
            yayiOrder.setInsertTime(new Date());
            yayiOrder.setCreateTime(new Date());
                yayiOrderService.insert(yayiOrder);//新增订单
            //更新第一注册表
            yonghuEntity.setNewMoney(balance);//设置金额
            yonghuService.updateById(yonghuEntity);


            return R.ok();
    }


    /**
    * 取消预约
    */
    @RequestMapping("/refund")
    public R refund(Integer id, HttpServletRequest request){
        logger.debug("refund方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        String role = String.valueOf(request.getSession().getAttribute("role"));

            YayiOrderEntity yayiOrder = yayiOrderService.selectById(id);//当前表service
            Integer yayiId = yayiOrder.getYayiId();
            if(yayiId == null)
                return R.error(511,"查不到该牙医");
            YayiEntity yayiEntity = yayiService.selectById(yayiId);
            if(yayiEntity == null)
                return R.error(511,"查不到该牙医");

            Integer userId = (Integer) request.getSession().getAttribute("userId");
            YonghuEntity yonghuEntity = yonghuService.selectById(userId);
            if(yonghuEntity == null)
                return R.error(511,"用户不能为空");
            if(yonghuEntity.getNewMoney() == null)
            return R.error(511,"用户金额不能为空");
            Double zhekou = 1.0;

                //计算金额
                Double money = yayiEntity.getNewMoney() * 1  * zhekou;
                //计算所获得积分
                Double buyJifen = 0.0;
                yonghuEntity.setNewMoney(yonghuEntity.getNewMoney() + money); //设置金额




            yayiOrder.setYayiOrderTypes(102);//设置订单状态为已取消预约
            yayiOrderService.updateAllColumnById(yayiOrder);//根据id更新
            yonghuService.updateById(yonghuEntity);//更新用户信息
            yayiService.updateById(yayiEntity);//更新订单中牙医的信息

            return R.ok();
    }

    /**
    * 评价
    */
    @RequestMapping("/commentback")
    public R commentback(Integer id, String commentbackText, Integer yayiCommentbackPingfenNumber, HttpServletRequest request){
        logger.debug("commentback方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
            YayiOrderEntity yayiOrder = yayiOrderService.selectById(id);
        if(yayiOrder == null)
            return R.error(511,"查不到该订单");
        Integer yayiId = yayiOrder.getYayiId();
        if(yayiId == null)
            return R.error(511,"查不到该牙医");

        YayiCommentbackEntity yayiCommentbackEntity = new YayiCommentbackEntity();
            yayiCommentbackEntity.setId(id);
            yayiCommentbackEntity.setYayiId(yayiId);
            yayiCommentbackEntity.setYonghuId((Integer) request.getSession().getAttribute("userId"));
            yayiCommentbackEntity.setYayiCommentbackText(commentbackText);
            yayiCommentbackEntity.setInsertTime(new Date());
            yayiCommentbackEntity.setReplyText(null);
            yayiCommentbackEntity.setUpdateTime(null);
            yayiCommentbackEntity.setCreateTime(new Date());
            yayiCommentbackService.insert(yayiCommentbackEntity);

            yayiOrder.setYayiOrderTypes(105);//设置订单状态为已评价
            yayiOrderService.updateById(yayiOrder);//根据id更新
            return R.ok();
    }

    /**
     * 使用
     */
    @RequestMapping("/deliver")
    public R deliver(Integer id  , HttpServletRequest request){
        logger.debug("refund:,,Controller:{},,ids:{}",this.getClass().getName(),id.toString());
        YayiOrderEntity  yayiOrderEntity = yayiOrderService.selectById(id);
        yayiOrderEntity.setYayiOrderTypes(103);//设置订单状态为已使用
        yayiOrderService.updateById( yayiOrderEntity);

        return R.ok();
    }


}

