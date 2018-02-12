<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<link rel="stylesheet" type="text/css" href="${ctx}/resources/extjs/resources/css/ext-all.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/resources/css/default.css" />
<%-- <link id="theme" rel="stylesheet" type="text/css" href="${ctx}/resources/extjs/resources/css/xtheme-gray.css" /> --%>
<script type="text/javascript" src="${ctx}/resources/loader/LAB.min.js"></script>
<script type="text/javascript" >
pagesize=eval('(${fields.pagesize==null?"{}":fields.pagesize})');
ctx = "${ctx}";
$LAB.script("${ctx}/resources/extjs/adapter/ext/ext-base.js").wait()
	.script("${ctx}/resources/extjs/ext-all.js").wait()
	.script("${ctx}/resources/extjs/ext-lang-zh_CN.js")
	.script("${ctx}/resources/extjs/ux/ExtMD5.js")
	.script("${ctx}/resources/extjs/ux/TabCloseMenu.js")
	.script("${ctx}/resources/extjs/ux/SearchField.js")
	.script("${ctx}/resources/extjs/ux/ProgressBarPager.js")
	.script("${ctx}/resources/js/Ext.ux.override.js").wait()
	.script("${ctx}/resources/js/share.js")
	.script("${ctx}/resources/jquery/jquery-1.7.2.min.js").wait()
	.script("${ctx}/resources/jquery/jquery.json-2.2-min.js")
	.script("${ctx}/resources/jquery/jquery.center-min.js")
	.wait(function () {
		Ext.QuickTips.init();
		Ext.form.Field.prototype.msgTarget = 'title';//qtip,title,under,side
		Ext.state.Manager.setProvider(new Ext.state.CookieProvider());
		Ext.BLANK_IMAGE_URL = '${ctx}/resources/extjs/resources/images/default/s.gif';
		})
	.script("${ctx}/resources/js/login.js");
</script>