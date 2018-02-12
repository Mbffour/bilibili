package com.cnLive.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnLive.dao.CmsVideoMapper;
import com.cnLive.pojo.CmsVideo;
import com.cnLive.pojo.CmsVideoExample;
import com.cnLive.service.CmsVideoService;

@Service
public class CmsVideoServiceImpl implements CmsVideoService{
	@Autowired
	CmsVideoMapper cmsVideoMapper;

	@Override
	public int countByExample(CmsVideoExample example) {
		return this.cmsVideoMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(CmsVideoExample example) {
		return this.cmsVideoMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(String id) {
		return this.cmsVideoMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(CmsVideo record) {
		return this.cmsVideoMapper.insert(record);
	}

	@Override
	public int insertSelective(CmsVideo record) {
		return this.cmsVideoMapper.insertSelective(record);
	}

	@Override
	public List<CmsVideo> selectByExample(CmsVideoExample example) {
		return this.cmsVideoMapper.selectByExample(example);
	}

	@Override
	public CmsVideo selectByPrimaryKey(String id) {
		return this.cmsVideoMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByExampleSelective(CmsVideo record, CmsVideoExample example) {
		return this.cmsVideoMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(CmsVideo record, CmsVideoExample example) {
		return this.cmsVideoMapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(CmsVideo record) {
		return this.cmsVideoMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(CmsVideo record) {
		return this.cmsVideoMapper.updateByPrimaryKey(record);
	}

}
