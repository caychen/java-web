$(function() {//window.onload()
	$('[id]').click(function() {//document.getElementById('d1').onclick()
		//this代表绑定了该事件的dom对象
		
		//使用dom对象
		//this.innerHTML = 'Hello Java';

		//使用jQuery对象
		$(this).html('Hello Java');
	});
});