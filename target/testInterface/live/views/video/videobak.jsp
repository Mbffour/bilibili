<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/views/commons/taglibs.jsp"%>
<html>

<!--HLSPlayer代码开始-->
<div class="video" id="HLSPlayer" >
<SCRIPT LANGUAGE=JavaScript>
<!--
/*
* HLSPlayer参数应用=======================
* @param {Object} vID        ID
* @param {Object} vWidth     播放器宽度设置
* @param {Object} vHeight    播放器宽度设置
* @param {Object} vPlayer    播放器文件
* @param {Object} vHLSset    HLS配置
* @param {Object} vPic       视频缩略图
* @param {Object} vCssurl    移动端CSS应用文件
* HLSPlayer参数应用=======================
* 提示1：本实例请在IIS/Apache等网站环境下测试
* 提示2：本实例仅支持hls(m3u8)/不支持flv,mp4,f4v
*/
var vID        = "";
var vWidth     = "100%";                //播放器宽度设置
var vHeight    = 400;                   //播放器宽度设置
var vPlayer    = "${ctx}/resources/HLSPlayer/HLSPlayer.swf"; //播放器文件
var vHLSset    = "${ctx}/resources/HLSPlayer/HLS.swf";             //HLS配置
var vPic       = "${ctx}/resources/HLSPlayer/images/start.jpg";    //视频缩略图
var vCssurl    = "${ctx}/resources/HLSPlayer/images/mini.css";     //移动端CSS应用文件

//HLS(m3u8)地址,适配PC,安卓,iOS,WP
var vHLSurl    = "http://cmcc.video.cnlive.com/619141997_1/619141997_1_e.m3u8";
/* var vHLSurl    = "http://cmcc.ips.cnlive.com/content/movie?contentId=611292627&productid=2028593910&ratelevel=4";
 *///-->
</SCRIPT>
<%-- <script type="text/javascript" src="${ctx}/resources/HLSPlayer/js/hls.min.js?rand=3396fsa778"></script>--%>
<script type="text/javascript" src="${ctx}/resources/HLSPlayer/js/hls.js?rand=3396fsa778"></script>

</div>
<!--HLSPlayer代码结束-->
</html>