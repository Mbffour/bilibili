package com.cnLive.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cnLive.common.utils.CheckEmpty;
import com.cnLive.pojo.sys_contentmain;
import com.cnLive.pojo.sys_contentmainExample;
import com.cnLive.service.DownloadFromURLService;
import com.cnLive.service.SysContentService;

@Controller
@RequestMapping("/movieDownload")
public class MovieDownloadController {
	@Autowired
	SysContentService sysContentService;
	@Autowired
	DownloadFromURLService downloadFromURLService;

	private String movieBaseDir = "E:/movie/";
	
	

	@RequestMapping(value = "/run", method = RequestMethod.GET)
	@ResponseBody
	public Object run() throws UnsupportedEncodingException,
			FileNotFoundException {
		String listPath = movieBaseDir + "reDown.txt";
		System.out.println(listPath);
		sys_contentmain contentmain = new sys_contentmain();
		File file = new File(listPath);
		if (file.isFile() && file.exists()) { // 判断文件是否存在
			InputStreamReader read = new InputStreamReader(new FileInputStream(
					file), "GBK");
			BufferedReader bufferedReader = new BufferedReader(read);
			String lineTxt = null;
			try {
				while ((lineTxt = bufferedReader.readLine()) != null) {
					if (CheckEmpty.isNotEmpty(lineTxt)) {
						System.out.println(lineTxt);
						String[] strs = lineTxt.split("%%");
						String id = strs[1];
						String name = strs[0];
						contentmain = this.sysContentService
								.selectByPrimaryKey(Integer.valueOf(id));
						if(contentmain==null){
							errorRecord(name, 1);
							continue;
						}
						if (!name.equals(contentmain.getTitle())) {
							System.err.println("数据影片名为：" + name);
							System.err.println("数据库标题为："
									+ contentmain.getTitle());
							throw new NullPointerException("影片名称不匹配！！");
						}
						String m3u8URL = "";
						if (CheckEmpty.isNotEmpty(contentmain.getVideohurl())) {
							m3u8URL = contentmain.getVideohurl();
						} else if (CheckEmpty.isNotEmpty(contentmain
								.getVideourl())) {
							m3u8URL = contentmain.getVideourl();
						} else if (CheckEmpty.isNotEmpty(contentmain
								.getVideouhurl())) {
							m3u8URL = contentmain.getVideouhurl();
						}
						System.err.println("m3u8URL = " + m3u8URL);
						try{
						downloadFromURLService.downLoadFromUrl(m3u8URL, name
								+ ".m3u8", movieBaseDir + name);
						}catch (Exception e) {
							e.printStackTrace();
							errorRecord(name, 2);
							continue;
						}
						downloadTS(movieBaseDir + name ,name+ ".m3u8");
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.err.println("去你妈的 文件不存在！！！");
		}
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("result", contentmain);
		return map;
	}
	
	@RequestMapping(value = "/run4get", method = RequestMethod.GET)
	@ResponseBody
	public Object run4get() throws UnsupportedEncodingException,
			FileNotFoundException {
		String listPath = movieBaseDir + "reDown.txt";
		System.out.println(listPath);
		sys_contentmain contentmain = new sys_contentmain();
		File file = new File(listPath);
		if (file.isFile() && file.exists()) { // 判断文件是否存在
			InputStreamReader read = new InputStreamReader(new FileInputStream(
					file), "GBK");
			BufferedReader bufferedReader = new BufferedReader(read);
			String lineTxt = null;
			try {
				while ((lineTxt = bufferedReader.readLine()) != null) {
					if (CheckEmpty.isNotEmpty(lineTxt)) {
						if(lineTxt.startsWith("http://")){
							String[] strs = lineTxt.split(";name:");
							String m3u8URL = strs[0];
							String name = strs[1];
							System.err.println("m3u8URL = " + m3u8URL);
							try{
							downloadFromURLService.downLoadFromUrl(m3u8URL, name
									+ ".m3u8", movieBaseDir + name);
							}catch (Exception e) {
								e.printStackTrace();
							}
							downloadTS(movieBaseDir + name ,name+ ".m3u8");
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.err.println("去你妈的 文件不存在！！！");
		}
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("result", contentmain);
		return map;
	}

	private void downloadTS(String m3u8Path,String m3u8Name) throws UnsupportedEncodingException, FileNotFoundException {
		System.out.println(m3u8Path);
		File file = new File(m3u8Path+File.separator + m3u8Name);
		if (file.isFile() && file.exists()) { // 判断文件是否存在
			InputStreamReader read = new InputStreamReader(new FileInputStream(
					file), "GBK");
			BufferedReader bufferedReader = new BufferedReader(read);
			String lineTxt = null;
			try {
				while ((lineTxt = bufferedReader.readLine()) != null) {
					if(lineTxt.contains("ts")&&lineTxt.contains("mp4")){
						System.out.println("lineTXT for m3u8 = " + lineTxt);
						if(lineTxt.startsWith("http://")){
							String[] strs = lineTxt.split("[?]")[0].split("/"); 
							String tsFileName = strs[strs.length-1];
							System.out.println("tsFileName = " + tsFileName);
							this.downloadFromURLService.downLoadFromUrl(lineTxt, tsFileName, m3u8Path);
						}else{
							System.out.println("error m3u8 is " + m3u8Path+File.separator + m3u8Name);
							errorRecord(m3u8Name, 3);
							return;
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	void errorRecord(String mediaName,int errorType){
		File fileRecord =new File("E:/movie/errorRecord.txt");
		String errorMsg = "";
		try{
			System.err.println("报错数据为："+mediaName);
			errorMsg = "报错数据为："+mediaName;
			if(!fileRecord.exists()){
				fileRecord.createNewFile();
			      }
			BufferedWriter out = new  BufferedWriter( new  OutputStreamWriter(  
                    new  FileOutputStream(fileRecord,  true )));   
			if(errorType == 1){
				errorMsg = errorMsg + "报错原因：数据不存在"+"\n";
			}if(errorType == 2){
				errorMsg = errorMsg + "报错原因：M3U8文件下载失败"+"\n";
			}if(errorType == 3){
				errorMsg = errorMsg + "TS码流地址有误"+"\n";
			}
			out.write(errorMsg); 
			out.close();
			}
			catch (Exception e1) {
				e1.printStackTrace();
			}
	}
}
