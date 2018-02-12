package com.cnLive.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class VideoController {
	@RequestMapping(value="/video",method = RequestMethod.GET)
	public String video(){
		return "video/video";
	}
	
	@RequestMapping(value="/videoTest",method = RequestMethod.GET)
	public String videoTest(){
		return "videoTest/videoTest";
	}
}
