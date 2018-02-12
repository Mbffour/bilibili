<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/views/commons/taglibs.jsp"%>

<table>
 　　<tbody>
 　　　<tr>
 		<td>开发者：</td>
 		<td><input type="text" id = "sp_id" name = "sp_id"/></td>
 	</tr>
 	<tr>
 		<td>客户端平台：</td>
 		<td><input type="text" id = "plat" name = "plat"/></td>
 	</tr>
 	<tr>
 		<td>手机号：</td>
 		<td><input type="text" id = "username" name = "username"/></td>
 	</tr>
 	<tr>
 		<td>渠道：</td>
 		<td><input type="text" id = "frmId" name = "frmId"/></td>
 	</tr>
 　　<tbody>
</table>
<script type="text/javascript">
	yepnope("${ctx}/resources/js/user/user.js");
</script>

<button type="button" onClick="submitTest()">Click Me!</button>