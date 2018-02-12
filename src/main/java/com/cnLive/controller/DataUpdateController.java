package com.cnLive.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cnLive.pojo.CmsContentExample;
import com.cnLive.pojo.CmsVideo;
import com.cnLive.pojo.CmsVideoExample;
import com.cnLive.service.CmsContentService;
import com.cnLive.service.CmsVideoService;

@Controller
@RequestMapping("/dataUpdate")
public class DataUpdateController {
	@Autowired
	private CmsContentService cmsContentService;
	@Autowired
	private CmsVideoService cmsVideoService;
	
	@RequestMapping(value="/updateReleaseYear" ,method = RequestMethod.GET)
	@ResponseBody
	public void run(){
		CmsVideoExample example = new CmsVideoExample();
		example.createCriteria().andReleaseTimeIsNotNull();
		List<CmsVideo> list = this.cmsVideoService.selectByExample(example);
		for(CmsVideo entity:list){
			Date date = entity.getReleaseTime();
			String year = new SimpleDateFormat("yyyy").format(date);
			entity.setReleaseYear(Integer.valueOf(year));
			this.cmsVideoService.updateByPrimaryKeySelective(entity);
		}
	}
}
