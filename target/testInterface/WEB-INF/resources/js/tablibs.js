//设置页面时间格式显示
function getDateValue(value)
{
	if (value == null || "" == value){
		return "";
	}
	var now=new Date();
	now.setTime(value);
	var months=now.getMonth()+1;
	if(months<10)
    {
		months='0'+months;
    }
	var day;
	if(now.getDate()<10)
    {
		day='0'+now.getDate();
    }
	else
    {
		day=now.getDate();
    }
	var hours=now.getHours();
	if(hours<10)
    {
		hours='0'+hours;
    }
    var minutes=now.getMinutes();
    if(minutes<10)
    {
    	minutes='0'+minutes;
    }
    var seconds=now.getSeconds();
    if(seconds<10)
    {
    	seconds='0'+seconds;
    }
	var dateValue=now.getFullYear()+'-'+months+'-'+day+' '+hours+':'+minutes+':'+seconds;
	return dateValue;

}

//设置页面时间格式显示
function getDayValue(value){
	if (value == null || "" == value){
		return "";
	}
	var now=new Date();
	now.setTime(value);
	var months=now.getMonth()+1;
	if(months<10)
    {
		months='0'+months;
    }
	var day;
	if(now.getDate()<10)
    {
		day='0'+now.getDate();
    }
	else
    {
		day=now.getDate();
    }
	var dateValue=now.getFullYear()+'-'+months+'-'+day;
	return dateValue;

}

//js错误
function SlyarErrors() {
	return false;
}

//验证图片格式
function validateImageFormat(imageName) {
	var index = imageName.indexOf(".");
	if (index < 0) {
		return false;
	}
	var suffix = imageName.substring(index+1, imageName.length);
	if ('jpg' == suffix || 'JPG' == suffix || 'png' == suffix || 'PNG' == suffix) {
		return true;
	} else {
		return false;
	}
}
