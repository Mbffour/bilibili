<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<link rel="stylesheet" type="text/css" href="${ctx}/resources/js/extjs/resources/css/ext-all.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/resources/js/extjs/resources/css/yourtheme.css" />
<script type="text/javascript" src="${ctx}/resources/js/extjs/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/extjs/ext-all.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/extjs/ext-lang-zh_CN.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/common/common.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/Ext.ux.override.js"></script>


<script type="text/javascript">
	var ctx="${ctx}";
	Ext.BLANK_IMAGE_URL = '${ctx}/resources/js/extjs/resources/images/default/s.gif';
</script>
<style type="text/css">
.delete {
	background-image: url(${ctx}/resources/images/delete.png) !important;
}

.add {
	background-image: url(${ctx}/resources/images/add.png) !important;
}

.edit {
	background-image: url(${ctx}/resources/images/edit.png) !important;
}

.search {
	background-image: url(${ctx}/resources/images/search.png) !important;
}

.accept {
	background-image: url(${ctx}/resources/images/accept.png) !important;
}

.restart {
	background-image: url(${ctx}/resources/images/edit.png) !important;
}

.reset {
	background-image: url(${ctx}/resources/images/reset.gif) !important;
}

.cancel {
	background-image: url(${ctx}/resources/images/cancel.png) !important;
}

.disk {
	background-image: url(${ctx}/resources/images/disk.png) !important;
}

.noneIcon {
	display: none
}

.money {
	background-image: url(${ctx}/resources/images/money.png) !important;
}

.printer {
	background-image: url(${ctx}/resources/images/printer.png) !important;
}

.export {
	background-image: url(${ctx}/resources/images/excel.png) !important;
}

.x-tree-node div.feeds-node {
	background: #eee url(${ctx}/resources/images/cmp-bg.gif) repeat-x;
	margin-top: 1px;
	border-top: 1px solid #ddd;
	border-bottom: 1px solid #ccc;
	padding-top: 2px;
	padding-bottom: 1px;
}
.x-node-ctx {
    background:#eee !important;
    border:1px solid #ccc !important;
}
.feed {
    border:1px solid #fff;
    margin:3px;
}
</style>