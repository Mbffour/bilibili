var _$ = ["CuPlayerVideo Video Server 1.0", '', 'CuPlayerVideo_video', 'video/mp4', 'video', 'undefined', 'probably', 'maybe', '', '?rand=', '<link rel="stylesheet" type="text/css" href="', '"/>', '<video id="', '" controls="controls" width="', '"  height="460"  poster="', '">', '<source src="', '" type="video/mp4" />', '</video>', '<video id="', '" controls="controls" width="100%" height="260" poster="', '">', '<source src="', '" type="video/mp4" />', '</video>', 'netstreambasepath=http%3A%2F%2Flocalhost%3A81%2FHLSprovider%2Fjwplayer5%2Findex58011.html&amp;id=player&amp;hls_debug=false&amp;hls_debug2=false&amp;hls_lowbufferlength=3&amp;hls_minbufferlength=-1&amp;hls_maxbufferlength=60&amp;hls_startfromlowestlevel=true&amp;hls_seekfromlowestlevel=true&amp;hls_live_flushurlcache=false&amp;hls_live_seekdurationthreshold=60&amp;hls_seekmode=ACCURATE&amp;provider=', '&amp;file=', '&amp;qualitymonitor.pluginmode=FLASH&amp;controlbar.position=over&amp;image=', '', '<object id="', '_object" width="', '" height="', '" classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000">', '<param name="movie" value="', '" />', '<param name="flashvars" value="', '" />', '<param name="allowFullScreen" value="true" />', '<param name="allowScriptAccess" value="always" />', '<embed id="', '_embed" src="', '" type="application/x-shockwave-flash" allowscriptaccess="always" allowfullscreen="true"  width="', '" height="', '" flashvars="', '"></embed>', '</object>', 'jQuery', '#', 'change.ctVideoServer', '_embed', '_object', "function"];
(function(window, b) {
	var document = window.document,
		c = window.navigator,
		d = window.location;
	var e = {
		name: _$[0],
		video: _$[1],
		videoId: _$[2],
		ishtml5: 0,
		video_type: _$[3],
		 
		isVideoCanPlay: function(k) {
			var l = document.createElement(_$[4]);
			if (typeof(l.canPlayType) == _$[5]) {
				return false
			};
			var m = l.canPlayType(k);
			if ((m == _$[6]) || (m == _$[7])) {
				return true
			};
			return false
		},
		isIpad: function() {
			var k = c.userAgent;
			if (/iPad/i.test(k) || /iPhone/i.test(k) || /android/i.test(k) || /Windows Phone/i.test(k) || /webOS/i.test(k) || /BlackBerry/i.test(k)) {
				return true
			} else if (/palm/i.test(k) || /webos/i.test(k)) {
				return true
			} else {
				return false
			}
		},
		isAndroid: function() {
			var k = c.userAgent;
			if (navigator.userAgent.match(/Android/i)) {
				return true
			} else{
				return false
			}
		},
		isIOS: function() {
			var k = c.userAgent;
			if (navigator.userAgent.match(/iPhone/i)) {
				return true
			} else{
				return false
			}
		},
		checkPlatform:function(){ 
//			alert("1");
		     var userAgentInfo = navigator.userAgent;  
//		     alert("userAgentInfo = " + userAgentInfo);
		     var Agents = new Array("Android", "iPhone", "SymbianOS", "Windows Phone", "iPad", "iPod","Windows NT");    
		     for (var v = 0; v < Agents.length; v++) {    
		         if (userAgentInfo.indexOf(Agents[v]) > 0) { alert(Agents[v]);return Agents[v];}    
		     }    
		     return "";    
		  }  ,
		resize: function() {
			if (this.ishtml5) {
				var k = this.videoId;
				var l = document.getElementById(k);
				l.height = l.videoHeight;
				return true
			}
		},
		render: function() {
			var P = this.checkPlatform();
			if (this.isIpad()) {
				var k = _$[8] + vCssurl + _$[9] + Math.random();
				document.writeln(_$[10] + k + _$[11]);
				var l = c.userAgent;
				if (/iPad/i.test(l)) {
					f = _$[12] + this.videoId + _$[13] + vWidth + _$[14] + vPic + _$[15] + _$[16] + vHLSurl + _$[17] + _$[18]
				} else {
					f = _$[19] + this.videoId + _$[20] + vPic + _$[21] + _$[22] + vHLSurl + _$[23] + _$[24]
				};
				this.ishtml5 = 1
			} else {
				var k = _$[25] + vHLSset + _$[26] + vHLSurl + _$[27] + vPic + _$[28];
				f = _$[29] + this.videoId + _$[30] + vWidth + _$[31] + vHeight + _$[32] + _$[33] + vPlayer + _$[34] + _$[35] + k + _$[36] + _$[37] + _$[38] + _$[39] + this.videoId + _$[40] + vPlayer + _$[41] + vWidth + _$[42] + vHeight + _$[43] + k + _$[44] + _$[45]
			};
			
			return f
		},
		init: function() {
			document.writeln(this.render());
		},
		renderAt: function(k) {
			var l = k && document.getElementById(k);
			if (!l) return false;
			l.innerHTML = this.render();
			(_$[46] in window) && jQuery(_$[47] + k).trigger(_$[48])
		},
		getMovie: function() {
			var k, l, m, n = [this.videoId + _$[49], this.videoId + _$[50], this.videoId];
			for (k in n) {
				m = n[k];
				l = document[m] ? document[m] : (window[m] ? window[m] : b);
				if (l) {
					if (typeof(l.playVideo) == _$[51]) break
				}
			};
			return l
		}
	};
	window.a = e
})(window);
a.init();