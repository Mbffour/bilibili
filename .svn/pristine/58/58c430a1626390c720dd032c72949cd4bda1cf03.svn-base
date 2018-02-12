package com.cnLive.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cnLive.pojo.CmsContent;
import com.cnLive.pojo.CmsContentExample;

public interface CmsContentService {

    int countByExample(CmsContentExample example);

    int deleteByExample(CmsContentExample example);

    int deleteByPrimaryKey(String id);

    int insert(CmsContent record);

    int insertSelective(CmsContent record);

    List<CmsContent> selectByExampleWithBLOBs(CmsContentExample example);

    List<CmsContent> selectByExample(CmsContentExample example);

    CmsContent selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CmsContent record, @Param("example") CmsContentExample example);

    int updateByExampleWithBLOBs(@Param("record") CmsContent record, @Param("example") CmsContentExample example);

    int updateByExample(@Param("record") CmsContent record, @Param("example") CmsContentExample example);

    int updateByPrimaryKeySelective(CmsContent record);

    int updateByPrimaryKeyWithBLOBs(CmsContent record);

    int updateByPrimaryKey(CmsContent record);

}
