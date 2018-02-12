package com.cnLive.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cnLive.pojo.BaseUser;
import com.cnLive.service.BaseUserService;



@Controller
@RequestMapping("/user")
public class UserController {
	private static final Logger logger = LoggerFactory
			.getLogger(UserController.class);
	
	@Autowired 
	private BaseUserService baseUserService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String user(){
		return "user/user";
	}
	
	@RequestMapping(value="/test" ,method = RequestMethod.POST)
	public void test(){
		logger.debug("我进来了");
	}
	
	@RequestMapping(value="/quickLogin" ,method = RequestMethod.POST)
	@ResponseBody
	public Object quickLogin(@RequestParam(value="", required = false) String spId,
			@RequestParam(value="", required = false) String plat,
			@RequestParam(value="", required = false) String userName,
			@RequestParam(value="", required = false) String frmId,
			HttpSession session, HttpServletRequest request){
		logger.debug("我进来了");
		logger.debug(spId);
		logger.debug(plat);
		logger.debug(userName);
		logger.debug(frmId);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("responseMsg", "true");
		
		HashMap<String, Object> queryMap = new HashMap<String, Object>();
		List<BaseUser> list = this.baseUserService.selectByExample(queryMap);
		map.put("result", list);
		return list;
	}
}
