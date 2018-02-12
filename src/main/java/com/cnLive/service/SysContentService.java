package com.cnLive.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cnLive.pojo.sys_contentmain;
import com.cnLive.pojo.sys_contentmainExample;

public interface SysContentService {

    int countByExample(sys_contentmainExample example);

    int deleteByExample(sys_contentmainExample example);

    int deleteByPrimaryKey(Integer contentid);

    int insert(sys_contentmain record);

    int insertSelective(sys_contentmain record);

    List<sys_contentmain> selectByExample(sys_contentmainExample example);

    sys_contentmain selectByPrimaryKey(Integer contentid);

    int updateByExampleSelective(@Param("record") sys_contentmain record, @Param("example") sys_contentmainExample example);

    int updateByExample(@Param("record") sys_contentmain record, @Param("example") sys_contentmainExample example);

    int updateByPrimaryKeySelective(sys_contentmain record);

    int updateByPrimaryKey(sys_contentmain record);

}
