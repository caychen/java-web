//依据id，返回dom节点
function $(id){
	return document.getElementById(id);
}

//返回id对应的dom节点的value值
function $F(id){
	return $(id).value;
}

function getXhr(){
	var xhr = null;
	if(window.XMLHttpRequest){
		//非IE浏览器
		xhr = new XMLHttpRequest();
	}else{
		//IE浏览器
		xhr = new ActiveXObject("Microsoft.XMLHttp");
	}
	return xhr;
}