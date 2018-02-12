package com.cnLive.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cnLive.pojo.mediaAsset;
import com.cnLive.pojo.sys_contentmain;
import com.cnLive.pojo.sys_contentmainExample;
import com.cnLive.service.MediaAssetService;
import com.cnLive.service.SysContentService;

@Controller
@RequestMapping("/dataTransfer")
public class DataTransferController {
	
	@Autowired
	MediaAssetService mediaAssetService;
	@Autowired
	SysContentService sysContentService;

	@RequestMapping(value="/run" ,method = RequestMethod.GET)
	@ResponseBody
	public Object run(){
		int pageSize = 1000;
		
		int count = this.sysContentService.countByExample(new sys_contentmainExample());
		int pageMax = count / pageSize + 1;
//		int pageMax = 1;
		sys_contentmainExample example = new sys_contentmainExample();
		for (int pageNo = 1; pageNo <= pageMax; pageNo++) {
		example.setDistinct(true);
		example.getPage().setBegin((pageNo - 1) * pageSize);
		example.getPage().setLength(pageSize);
		
		
		List<sys_contentmain> list = this.sysContentService.selectByExample(example);
		int i = 1;
		
		for(sys_contentmain rs:list){
			mediaAsset dt = new mediaAsset();
			
			dt.setId(rs.getUuid());//ID
			
//			System.out.println("id" + rs.getString(1));// 片名(院线名称)
//			String id = rs.getString(1);
			
			dt.setName(rs.getTitle());
			dt.setTitle(rs.getTitle());// 片名(院线名称)

			dt.setSubtitle(rs.getSubtitle());// 副标题
			
			dt.setMediaStatus(rs.getStatus());// 媒资状态
			
			
			String uuid = rs.getUuid();
			String migu_contentid = "";
			if(uuid!=null&&!uuid.equals("")){
			String[] uuidStrings = uuid.split("_");
			if(uuidStrings.length>1&&uuidStrings[0].equals("CMCC")){
				migu_contentid=uuidStrings[uuidStrings.length-1];
			}
			}
			dt.setMiguContentid(migu_contentid);
			
			dt.setMovieLevel(rs.getMovielevel());

			dt.setMediaType(rs.getMovietype());// 媒资类型

			dt.setCharge(rs.getVipflag());// 电影收费标志
			
			String airTime = rs.getAirtime();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日");
			
			int showYear = 0;
			Date date = new Date();
			try{
				date = sdf.parse(airTime);
			}catch (Exception e) {
				System.out.println(e.getMessage());
				try{
					SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
					date = sdf1.parse(airTime);
				}catch (Exception e1) {
					System.out.println(e1.getMessage());
					if(airTime==null||airTime.equals("")){
						showYear = -1;
					}else if("200+".equals(airTime)){
						showYear = 2009;
					}else if("更早".equals(airTime)){
						showYear = -2;
					}
						else if("年代".equals(airTime.substring(airTime.length()-2, airTime.length()))){
						airTime = airTime.substring(0, 2);
						if("00".equals(airTime)||"10".equals(airTime)){
							showYear = Integer.parseInt("20"+airTime);
						}else{
							showYear = Integer.parseInt("19"+airTime);
						}
					}else if("年".equals(airTime.substring(airTime.length()-1, airTime.length()))){
						showYear = Integer.parseInt(airTime.substring(0,4));
					}else{
						showYear = Integer.parseInt(airTime);
					}
				}
			}
			if(showYear==0){
				dt.setShowtime(date);
			}else if(showYear == -2){
				dt.setShowyear(0);
			}else if(showYear!=-1){
				dt.setShowyear(showYear);
			}
			

			dt.setMovieType(rs.getVideotype());// 电影分类

			dt.setKeyword(rs.getTags());// 关键字

			dt.setMovieArea(rs.getArea());// 电影产地
			
			dt.setActor(rs.getActors());// 演员表

			dt.setDirector(rs.getDirector());// 导演

			dt.setCreateTime(rs.getCreatedate());// 创建时间

			dt.setCreator("admin");// 创建者

			dt.setBrief(rs.getDescription());// 剧情简介
			
			dt.setDuration(rs.getDuration());// 播放时长
			
			
			dt.setMaincategory(rs.getMaincategory());
			
			dt.setCategorys(rs.getCategorys());


			dt.setAuditTime(rs.getPublishdate());// 审核时间

			dt.setImageHSmall(rs.getTitleimage());// 小横图

			dt.setWeight(rs.getWeight());// 节目权重

			dt.setImageHBanner(rs.getImgbig());// 大横图-BANNER

			dt.setImageVSmall(rs.getImgsmall());// 小竖图

			dt.setVideoPlayUrlLow(rs.getVideolurl());// m3u8播放地址

			dt.setVideoPlayUrlSd(rs.getVideourl());
			
			dt.setVideoPlayUrlHd(rs.getVideohurl());

			dt.setVideoPlayUrlUhd(rs.getVideouhurl());
			
			this.mediaAssetService.insertSelective(dt);
				
			int number = (pageNo - 1) * pageSize + i;
			System.err.println("dataNum=" + number);
			i++;
		}
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", "success");
		return map;
	}
}
