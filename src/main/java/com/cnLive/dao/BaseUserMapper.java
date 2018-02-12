package com.cnLive.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cnLive.pojo.BaseUser;

@Repository
public interface BaseUserMapper {
	public List<BaseUser> selectByExample(HashMap<String, Object> map);
}
