package test;

public class test {
	static String[] _$ = {"CuPlayerVideo Video Server 1.0", "", "CuPlayerVideo_video", "video/mp4", "video", "undefined", "probably", "maybe", "", "?rand=", "<link rel='stylesheet' type='text/css' href='", "'/>", "<video id='", "' controls='controls' width='", "'  height='460'  poster='", "'>", "<source src='", "' type='video/mp4' />", "</video>", "<video id='", "' controls='controls' width='100%' height='260' poster='", "'>", "<source src='", "' type='video/mp4' />", "</video>", "netstreambasepath=http%3A%2F%2Flocalhost%3A81%2FHLSprovider%2Fjwplayer5%2Findex58011.html&amp;id=player&amp;hls_debug=false&amp;hls_debug2=false&amp;hls_lowbufferlength=3&amp;hls_minbufferlength=-1&amp;hls_maxbufferlength=60&amp;hls_startfromlowestlevel=true&amp;hls_seekfromlowestlevel=true&amp;hls_live_flushurlcache=false&amp;hls_live_seekdurationthreshold=60&amp;hls_seekmode=ACCURATE&amp;provider=", "&amp;file=", "&amp;qualitymonitor.pluginmode=FLASH&amp;controlbar.position=over&amp;image=", "", "<object id='", "_object' width='", "' height='", "' classid='clsid:D27CDB6E-AE6D-11cf-96B8-444553540000'>", "<param name='movie' value='", "' />", "<param name='flashvars' value='", "' />", "<param name='allowFullScreen' value='true' />", "<param name='allowScriptAccess' value='always' />", "<embed id='", "_embed' src='", "' type='application/x-shockwave-flash' allowscriptaccess='always' allowfullscreen='true'  width='", "' height='", "' flashvars='", "'></embed>", "</object>", "jQuery", "#", "change.ctVideoServer", "_embed", "_object", "function"};
	int i = 0;
	
	
	public static void main(String[] args) {
		String vID        = "";
		String vWidth     = "100%";                //播放器宽度设置
		int vHeight    = 400;                   //播放器宽度设置
		String vPlayer    = "${ctx}/resources/HLSPlayer/HLSPlayer.swf"; //播放器文件
		String vHLSset    = "${ctx}/resources/HLSPlayer/HLS.swf";             //HLS配置
		String vPic       = "${ctx}/resources/HLSPlayer/images/start.jpg";    //视频缩略图
		String vCssurl    = "${ctx}/resources/HLSPlayer/images/mini.css";     //移动端CSS应用文件
		String videoId    = _$[2];

		//HLS(m3u8)地址,适配PC,安卓,iOS,WP
		String vHLSurl    = "http://cmcc.ips.cnlive.com/content/movie?contentId=617342677&amp;productid=2028593910&amp;ratelevel=2";

		System.out.println(_$[8] + vCssurl + _$[9] + Math.random());
		
		System.out.println(_$[12] + videoId + _$[13] + vWidth + _$[14] + vPic + _$[15] + _$[16] + vHLSurl + _$[17] + _$[18]);
		System.out.println(_$[19] + videoId + _$[20] + vPic + _$[21] + _$[22] + vHLSurl + _$[23] + _$[24]);
	}
}
