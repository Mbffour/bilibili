package com.cnLive.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cnLive.pojo.CmsVideo;
import com.cnLive.pojo.CmsVideoExample;

public interface CmsVideoService {
    int countByExample(CmsVideoExample example);

    int deleteByExample(CmsVideoExample example);

    int deleteByPrimaryKey(String id);

    int insert(CmsVideo record);

    int insertSelective(CmsVideo record);

    List<CmsVideo> selectByExample(CmsVideoExample example);

    CmsVideo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CmsVideo record, @Param("example") CmsVideoExample example);

    int updateByExample(@Param("record") CmsVideo record, @Param("example") CmsVideoExample example);

    int updateByPrimaryKeySelective(CmsVideo record);

    int updateByPrimaryKey(CmsVideo record);
}
