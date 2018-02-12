package com.cnLive.serviceImpl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnLive.dao.BaseUserMapper;
import com.cnLive.pojo.BaseUser;
import com.cnLive.service.BaseUserService;

@Service
public class BaseUserServiceImpl implements BaseUserService{
	@Autowired
	private BaseUserMapper baseUserMapper;
	
	public List<BaseUser> selectByExample(HashMap<String, Object> map){
		return this.baseUserMapper.selectByExample(map);
	}
}
