<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<script type="text/javascript" src="${ctx}/resources/loader/yepnope.min.js"></script>
<script type="text/javascript">
	pagesize=eval('(${fields.pagesize==null?"{}":fields.pagesize})');
	yepnope({
			load : [ 
					 //jquery
					 "${ctx}/resources/jquery/jquery-1.7.2.js", 
					 "${ctx}/resources/jquery/jquery.json-2.2-min.js", 
					 "${ctx}/resources/jquery/jquery.center-min.js",
			         "${ctx}/resources/css/default.css"
					 ],
			complete : function() {
				ctx = "${ctx}";
				}
			});
</script>