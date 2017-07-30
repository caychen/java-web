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