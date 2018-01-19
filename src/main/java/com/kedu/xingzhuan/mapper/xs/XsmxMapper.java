package com.kedu.xingzhuan.mapper.xs;

import com.kedu.xingzhuan.entity.xs.XsmxEntity;

public interface XsmxMapper {
    int deleteByPrimaryKey(String id);

    int insert(XsmxEntity record);

    int insertSelective(XsmxEntity record);

    XsmxEntity selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(XsmxEntity record);

    int updateByPrimaryKey(XsmxEntity record);
}