package com.dao;

import com.entity.YayiOrderEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.YayiOrderView;

/**
 * 牙医挂号 Dao 接口
 *
 * @author 
 */
public interface YayiOrderDao extends BaseMapper<YayiOrderEntity> {

   List<YayiOrderView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
