<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/views/commons/taglibs.jsp"%>
<head>
	<script type="text/javascript">
		yepnope({load:["${ctx}/resources/jquery/jquery-1.7.2.js", 
		               "${ctx}/resources/clappr/clappr.min.js",
		               "${ctx}/resources/underscore/underscore.js"]});
	</script>
</head>
<body>
<!-- <h2>Hello World!</h2> -->
<body>
  <div id="player"></div>
 
</body>
</body>
</html>
 --%>
 
 <!DOCTYPE HTML>
<html>
<body>
<form action="/example/HTML 5/demo_form.asp" method="get">
Webpage: <input type="url" list="url_list" name="link" />
<datalist id="url_list">
<option label="W3School" value="http://www.w3school.com.cn" />
<option label="Google" value="http://www.google.com" />
<option label="Microsoft" value="http://www.microsoft.com" />
</datalist>
<input type="submit" />
</form>
</body>
</html>