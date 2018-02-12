package com.cnLive.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnLive.dao.mediaAssetMapper;
import com.cnLive.pojo.mediaAsset;
import com.cnLive.pojo.mediaAssetExample;
import com.cnLive.service.MediaAssetService;

@Service
public class MediaAssetServiceImpl implements MediaAssetService{
	@Autowired
	mediaAssetMapper mediaAssetMapper;
	
	@Override
	public int countByExample(mediaAssetExample example) {
		return this.mediaAssetMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(mediaAssetExample example) {
		return this.mediaAssetMapper.countByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(String id) {
		return this.mediaAssetMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(mediaAsset record) {
		return this.mediaAssetMapper.insert(record);
	}

	@Override
	public int insertSelective(mediaAsset record) {
		return this.mediaAssetMapper.insertSelective(record);
	}

	@Override
	public List<mediaAsset> selectByExample(mediaAssetExample example) {
		return this.mediaAssetMapper.selectByExample(example);
	}

	@Override
	public mediaAsset selectByPrimaryKey(String id) {
		return this.mediaAssetMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByExampleSelective(mediaAsset record,
			mediaAssetExample example) {
		return this.mediaAssetMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(mediaAsset record, mediaAssetExample example) {
		return this.mediaAssetMapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(mediaAsset record) {
		return this.mediaAssetMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(mediaAsset record) {
		return this.mediaAssetMapper.updateByPrimaryKey(record);
	}

}
