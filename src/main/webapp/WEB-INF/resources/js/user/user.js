function submitTest() {
	alert('im comming!');
	var sp_id = $("#sp_id").val();
	var plat = $("#plat").val();
	var userName = $("#username").val();
	var frmId = $("#frmId").val();
	$.ajax({
		url : ctx+'/user/quickLogin',// 跳转到 action
		data : {
			spId : sp_id,
			plat : plat,
			userName : userName,
			frmId : frmId
		},
		type : 'post',
		cache : false,
		dataType : 'json',
		success : function(data) {
				alert("修改成功！");
		},
		error : function() {
			// view("异常！");
			alert("异常！");
		}
	});
}