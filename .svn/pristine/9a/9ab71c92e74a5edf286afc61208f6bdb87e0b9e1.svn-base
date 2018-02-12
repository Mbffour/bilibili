package com.cnLive.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnLive.dao.sys_contentmainMapper;
import com.cnLive.pojo.sys_contentmain;
import com.cnLive.pojo.sys_contentmainExample;
import com.cnLive.service.SysContentService;

@Service
public class SysContentServiceImpl implements SysContentService{
	
	@Autowired
	sys_contentmainMapper contentmainMapper;

	@Override
	public int countByExample(sys_contentmainExample example) {
		return this.contentmainMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(sys_contentmainExample example) {
		return this.contentmainMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Integer contentid) {
		return this.contentmainMapper.deleteByPrimaryKey(contentid);
	}

	@Override
	public int insert(sys_contentmain record) {
		return this.contentmainMapper.insert(record);
	}

	@Override
	public int insertSelective(sys_contentmain record) {
		return this.contentmainMapper.insertSelective(record);
	}

	@Override
	public List<sys_contentmain> selectByExample(sys_contentmainExample example) {
		return this.contentmainMapper.selectByExample(example);
		
	}

	@Override
	public sys_contentmain selectByPrimaryKey(Integer contentid) {
		return this.contentmainMapper.selectByPrimaryKey(contentid);
	}

	@Override
	public int updateByExampleSelective(sys_contentmain record,
			sys_contentmainExample example) {
		return this.contentmainMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(sys_contentmain record,
			sys_contentmainExample example) {
		return this.contentmainMapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(sys_contentmain record) {
		return this.contentmainMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(sys_contentmain record) {
		return this.contentmainMapper.updateByPrimaryKey(record);
	}

}
