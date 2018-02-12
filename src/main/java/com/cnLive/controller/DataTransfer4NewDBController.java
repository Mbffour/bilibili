package com.cnLive.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cnLive.common.utils.CheckEmpty;
import com.cnLive.constant.DataTypeConst;
import com.cnLive.dto.CatIDAndCatName;
import com.cnLive.pojo.CmsVideo;
import com.cnLive.pojo.CmsContent;
import com.cnLive.pojo.mediaAsset;
import com.cnLive.pojo.mediaAssetExample;
import com.cnLive.service.CmsContentService;
import com.cnLive.service.CmsVideoService;
import com.cnLive.service.MediaAssetService;

@Controller
@RequestMapping("/dataTransfer4NewDB")
public class DataTransfer4NewDBController {
	@Autowired
	CmsContentService cmsContentService;
	
	@Autowired
	CmsVideoService cmsVideoService;
	
	@Autowired
	MediaAssetService mediaAssetService;
	
	@RequestMapping(value="/run" ,method = RequestMethod.GET)
	@ResponseBody
	public Object run(){
		int pageSize = 1000;
		int number = 1;
		int count = this.mediaAssetService.countByExample(new mediaAssetExample());
		
		int pageMax = count / pageSize + 1;
//		int pageMax = 3;
		mediaAssetExample example = new mediaAssetExample();
		for(int pageNo = 1;pageNo <= pageMax;pageNo++){
			example.setDistinct(true);
			example.getPage().setBegin((pageNo - 1) * pageSize);
			example.getPage().setLength(pageSize);
			
			List<mediaAsset> list = this.mediaAssetService.selectByExample(example);
			int i=1;
			
			for(mediaAsset entity:list){
				CmsContent contentsEntity = new CmsContent();
				CmsVideo contentVideoEntity = new CmsVideo();
				CatIDAndCatName mainCat = getCatId(entity.getId(),entity.getMaincategory());
				contentsEntity.setCatid(mainCat.getCatId());// 栏目ID
				contentsEntity.setCatname("原始数据");// 栏目名称
				contentsEntity.setGrade(0);// 评分
				String pathIds = "0,"+mainCat.getCatId()+",";
				contentsEntity
						.setPathids(pathIds);
				contentsEntity.setClassify("4");
				contentsEntity.setModelid("4");

				contentsEntity.setSiteId("1"); 
				contentVideoEntity.setSiteId("1");

				contentsEntity.setId(entity.getId());// 主键ID
				
				UUID uuid = UUID.randomUUID();
				
				contentVideoEntity.setId(uuid.toString().replace("-", ""));
				contentVideoEntity.setContentid(entity.getId());

				contentVideoEntity.setIsPositive(entity.getMediaType().toString());// 媒资类型

				contentVideoEntity.setMediaColumn(entity.getMediaIdRelated());// 预告片和花絮对应的电影

				int status = entity.getMediaStatus();
				if (status == 0) {
					contentsEntity
							.setConstants("40");// 媒资状态---待发
				} else if (status == 1) {
					contentsEntity
							.setConstants("50");// 媒资状态---已发
				} else if (status == 2) {
					contentsEntity.setConstants("60");// 媒资状态---已撤
				} else if (status == 3) {
					contentsEntity.setConstants("70");// 媒资状态---已删除
				}

				contentsEntity.setTitle(entity.getName());// 片名(院线名称) //标题

				// 别名

				// 英文名

				contentsEntity.setSubtitle(entity.getSubtitle());// 副标题

				contentsEntity.setDigest(entity.getBrief());// 剧情简介

				contentVideoEntity.setKeyword(entity.getKeyword());// 关键字

				contentVideoEntity.setDirector(entity.getDirector());// 导演

				contentVideoEntity.setToStar(entity.getActor());// 演员表

				// 编剧

				// 制片人

				contentVideoEntity.setReleaseTime(entity.getShowtime());// 上映时间(date)
				contentVideoEntity.setReleaseYear(entity.getShowyear());// 上映时间(int)

				contentVideoEntity.setTime(entity.getDuration() + "");// 播放时长

				contentVideoEntity
						.setCountriesAndRegions(entity.getMovieArea());// 电影产地

				contentVideoEntity.setFilmType(entity.getMovieType());// 电影分类

				contentVideoEntity.setFilmLevel(entity.getMovieLevel() + "");// 电影分级

				contentsEntity.setImg1(entity.getImageHBanner());// 大横图-BANNER
				contentsEntity.setImg3(entity.getImageHSmall());// 小横图
				contentsEntity.setImg4(entity.getImageVSmall());// 小竖图

				contentVideoEntity.setSmoothUrl(entity.getVideoPlayUrlLow());// m3u8播放地址
				contentVideoEntity.setSdUrl(entity.getVideoPlayUrlSd());
				contentVideoEntity.setHdUrl(entity.getVideoPlayUrlHd());
				contentVideoEntity
						.setUltraClearUrl(entity.getVideoPlayUrlUhd());// MP4下载地址

				contentVideoEntity.setCopyright(entity.getCopyright() + "");// copyright
				contentVideoEntity.setProgramSource(entity.getProgramSource());// 节目来源
				contentVideoEntity.setCopyrightSource(entity
						.getCopyrightSource() + "");// 版权来源（版权方）
				contentVideoEntity.setCopyrightBegindate(entity
						.getCopyrightBegindate());// 版权有效期开始时间
				contentVideoEntity.setCopyrightEnddate(entity
						.getCopyrightEnddate());// 版权有效期结束时间

				contentsEntity.setChargeSign(entity.getCharge() + "");// 电影收费标志
				contentsEntity.setWeight(entity.getWeight());// 节目权重
 
				contentsEntity.setCreatedby(entity.getCreator());// 创建者
				contentsEntity.setCreated(entity.getCreateTime());// 创建时间

				contentsEntity.setPublishedby(entity.getAuditor());// 审核员
				contentsEntity.setPublished(entity.getAuditTime());// 审核时间
				CatIDAndCatName catName = getCatId(contentsEntity.getId(),entity.getCategorys());
				
				contentsEntity.setSubcatId(catName.getCatId());
				contentsEntity.setSubcatName(catName.getCatName());
				
				contentsEntity.setEditor("admin");// 发布人

				System.out.println(entity.getId());
				this.cmsVideoService.insertSelective(contentVideoEntity);
				this.cmsContentService.insertSelective(contentsEntity);
				System.err.println("dataNum=" + number);
				
				
				String[] catagorys = catName.getCatId().split(",");
				if(catagorys.length>0){
					for(int j=0;j<catagorys.length;j++){
						CmsContent cmsContent = new CmsContent();
						String catagory = catagorys[j];
						if(CheckEmpty.isEmpty(catagorys[j])){
							System.err.println("empty");
							continue;
						}
						UUID uuid4Id = UUID.randomUUID();
						cmsContent.setId(uuid4Id.toString().replace("-", ""));
						String pathids = "0,"+catagory+",";
						cmsContent.setPathids(pathids);
						cmsContent.setModelid("3");
						
						cmsContent.setCatid(contentsEntity.getCatid());
						cmsContent.setTitle(contentsEntity.getTitle());
						cmsContent.setSiteId(contentsEntity.getSiteId());
						cmsContent.setConstants(contentsEntity.getConstants());
						
						cmsContent.setClassify("3");
						
						cmsContent.setCreatedby(entity.getCreator());// 创建者
						cmsContent.setCreated(entity.getCreateTime());// 创建时间

						cmsContent.setPublishedby(entity.getAuditor());// 审核员
						cmsContent.setPublished(entity.getAuditTime());// 审核时间
						
						
						cmsContent.setEditor("admin");// 发布人
						
						cmsContent.setLinkcontentId(entity.getId());
						this.cmsContentService.insertSelective(cmsContent);
					}
				}
				number++;
				i++;
				
			}
		}
		return null;
	}
	private CatIDAndCatName getCatId(String mediaId,String oldId) {
		CatIDAndCatName result = new CatIDAndCatName();
		String newId = "";
		String newName = "";
		String[] params = {};
		if(CheckEmpty.isNotEmpty(oldId)){
			params=oldId.split(",");
		}
		if(params.length>0){
			for(int i=0;i<params.length;i++){
				String id = params[i]; 
				if(id.equals("app_5.0/")){
					newId = newId+DataTypeConst.app_5+",";
					newName = newName+"手机电影5.0"+",";
				}else if(id.equals("appstore/")){
					newId = newId+DataTypeConst.appstore+",";
					newName = newName+"应用商店"+",";
				}else if(id.equals("cainixihuan/")){
					newId = newId+DataTypeConst.cainixihuan+",";
					newName = newName+"猜你喜欢"+",";
				}else if(id.equals("ceshipianku/")){
					newId = newId+DataTypeConst.ceshipianku+",";
					newName = newName+"测试片库"+",";
				}else if(id.equals("dakajuchang/")){
					newId = newId+DataTypeConst.dakajuchang+",";
					newName = newName+"大咖剧场"+",";
				}else if(id.equals("dianshizhibo/")){
					newId = newId+DataTypeConst.dianshizhibo+",";
					newName = newName+"电视直播"+",";
				}else if(id.equals("freeblock/")){
					newId = newId+DataTypeConst.freeblock+",";
					newName = newName+"免费专区"+",";
				}else if(id.equals("h5/")){
					newId = newId+DataTypeConst.h5+",";
					newName = newName+"H5页面"+",";
				}else if(id.equals("haolaiwu/")){
					newId = newId+DataTypeConst.haolaiwu+",";
					newName = newName+"好莱坞影院"+",";
				}else if(id.equals("jijiangshangying/")){
					newId = newId+DataTypeConst.jijiangshangying+",";
					newName = newName+"即将上映"+",";
				}else if(id.equals("jingcaituijian/")){
					newId = newId+DataTypeConst.jingcaituijian+",";
					newName = newName+"精彩推荐"+",";
				}else if(id.equals("jingdianyongheng/")){
					newId = newId+DataTypeConst.jingdianyongheng+",";
					newName = newName+"经典永恒"+",";
				}else if(id.equals("rementuijian/")){
					newId = newId+DataTypeConst.rementuijian+",";
					newName = newName+"本周热播"+",";
				}else if(id.equals("reyingjijin/")){
					newId = newId+DataTypeConst.reyingjijin+",";
					newName = newName+"热映集锦"+",";
				}else if(id.equals("rihanjingxuan/")){
					newId = newId+DataTypeConst.rihanjingxuan+",";
					newName = newName+"日韩精选"+",";
				}else if(id.equals("viptuijian/")){
					newId = newId+DataTypeConst.viptuijian+",";
					newName = newName+"VIP推荐"+",";
				}else if(id.equals("wangluodadiany/")){
					newId = newId+DataTypeConst.wangluodadiany+",";
					newName = newName+"网络大电影"+",";
				}else if(id.equals("weidianying/")){
					newId = newId+DataTypeConst.weidianying+",";
					newName = newName+"微电影"+",";
				}else if(id.equals("weidianyingxinpian/")){
					newId = newId+DataTypeConst.weidianyingxinpian+",";
					newName = newName+"微电影新片"+",";
				}else if(id.equals("wuyejuchang/")){
					newId = newId+DataTypeConst.wuyejuchang+",";
					newName = newName+"午夜剧场"+",";
				}else if(id.equals("xinpianruku/")){
					newId = newId+DataTypeConst.xinpianruku+",";
					newName = newName+"新片入库"+",";
				}else if(id.equals("xinpiansudi/")){
					newId = newId+DataTypeConst.xinpiansudi+",";
					newName = newName+"新片速递"+",";
				}else if(id.equals("yingpianyugao/")){
					newId = newId+DataTypeConst.yingpianyugao+",";
					newName = newName+"影片预告"+",";
				}else if(id.equals("zhuanticehua/")){
					newId = newId+DataTypeConst.zhuanticehua+",";
					newName = newName+"专题策划"+",";
				}else if(id.equals("zixunguanli/")){
					newId = newId+DataTypeConst.zixunguanli+",";
					newName = newName+"资讯管理"+",";
				}else {
					try{
					System.err.println("报错数据为："+id+"，视频ID为:"+mediaId);
					File file =new File("C:/data.txt");
					if(!file.exists()){
					       file.createNewFile();
					      }
					BufferedWriter out = new  BufferedWriter( new  OutputStreamWriter(  
		                    new  FileOutputStream(file,  true )));   
					String data = "报错数据为："+id+"，视频ID为:"+mediaId+"\n";
					out.write(data); 
					out.close();
					}
					catch (Exception e) {
						e.printStackTrace();
					}
					
				}
			}
		}
		if(CheckEmpty.isNotEmpty(newId)){
			newId = newId.substring(0, newId.length()-1);
		}
		if(CheckEmpty.isNotEmpty(newName)){
			newName = newName.substring(0,newName.length()-1);
		}
		result.setCatId(newId);
		result.setCatName(newName);
		
		return result;
	}
}
