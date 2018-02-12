package com.cnLive.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnLive.dao.CmsContentMapper;
import com.cnLive.pojo.CmsContent;
import com.cnLive.pojo.CmsContentExample;
import com.cnLive.service.CmsContentService;

@Service
public class CmsContentServiceImpl implements CmsContentService{
	@Autowired
	CmsContentMapper cmsContentMapper;

	@Override
	public int countByExample(CmsContentExample example) {
		return this.cmsContentMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(CmsContentExample example) {
		return this.cmsContentMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(String id) {
		return this.cmsContentMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(CmsContent record) {
		return this.cmsContentMapper.insert(record);
	}

	@Override
	public int insertSelective(CmsContent record) {
		return this.cmsContentMapper.insertSelective(record);
	}

	@Override
	public List<CmsContent> selectByExampleWithBLOBs(CmsContentExample example) {
		return this.cmsContentMapper.selectByExampleWithBLOBs(example);
	}

	@Override
	public List<CmsContent> selectByExample(CmsContentExample example) {
		return this.cmsContentMapper.selectByExample(example);
	}

	@Override
	public CmsContent selectByPrimaryKey(String id) {
		return this.cmsContentMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByExampleSelective(CmsContent record,
			CmsContentExample example) {
		return this.cmsContentMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExampleWithBLOBs(CmsContent record,
			CmsContentExample example) {
		return this.cmsContentMapper.updateByExampleWithBLOBs(record, example);
	}

	@Override
	public int updateByExample(CmsContent record, CmsContentExample example) {
		return this.cmsContentMapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(CmsContent record) {
		return this.cmsContentMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKeyWithBLOBs(CmsContent record) {
		return this.cmsContentMapper.updateByPrimaryKeyWithBLOBs(record);
	}

	@Override
	public int updateByPrimaryKey(CmsContent record) {
		return this.cmsContentMapper.updateByPrimaryKey(record);
	}

}
