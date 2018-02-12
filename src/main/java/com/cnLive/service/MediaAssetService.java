package com.cnLive.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cnLive.pojo.mediaAsset;
import com.cnLive.pojo.mediaAssetExample;

public interface MediaAssetService {
    int countByExample(mediaAssetExample example);

    int deleteByExample(mediaAssetExample example);

    int deleteByPrimaryKey(String id);

    int insert(mediaAsset record);

    int insertSelective(mediaAsset record);

    List<mediaAsset> selectByExample(mediaAssetExample example);

    mediaAsset selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") mediaAsset record, @Param("example") mediaAssetExample example);

    int updateByExample(@Param("record") mediaAsset record, @Param("example") mediaAssetExample example);

    int updateByPrimaryKeySelective(mediaAsset record);

    int updateByPrimaryKey(mediaAsset record);
}
