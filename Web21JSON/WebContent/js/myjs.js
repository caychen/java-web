/**
 * 
 */

function loadBody() {
	setInterval(function() {
		var xhr = getXhr();
		xhr.open("get", "quoto.do", true);
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4) {
				var txt = xhr.responseText;

				//将json字符串转换成javascript组成的数组
				var arr = txt.evalJSON();

				//将数组中的数组取出来，添加到tbody
				var html = "";
				for (var i = 0; i < arr.length; ++i) {
					html += "<tr>" +
								"<td>" + arr[i].name + "</td>" + 
								"<td>" + arr[i].code + "</td>" +
								"<td>" + arr[i].price + "</td>" +
							"</tr>";
				}
				$("tb1").innerHTML = html;
			}
		}
		xhr.send(null);
	}, 3000);
}
