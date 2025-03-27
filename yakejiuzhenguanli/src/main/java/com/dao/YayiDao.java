package com.dao;

import com.entity.YayiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.YayiView;

/**
 * 牙医 Dao 接口
 *
 * @author 
 */
public interface YayiDao extends BaseMapper<YayiEntity> {

   List<YayiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
