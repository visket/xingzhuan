package com.kedu.xingzhuan.mapper.xs;

import com.kedu.xingzhuan.entity.xs.XspcEntity;

public interface XspcMapper {
    int deleteByPrimaryKey(String id);

    int insert(XspcEntity record);

    int insertSelective(XspcEntity record);

    XspcEntity selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(XspcEntity record);

    int updateByPrimaryKey(XspcEntity record);
}