/**
 * 
 */
var timer;

function startTimer()
{
	timer = window.setInterval(function()
		{
			var t = document.getElementById("minutes").innerHTML;
			if(t == 0)
			{
				location.replace("ListEmpFromDB");
				return;
			}
			t--;
			document.getElementById("minutes").innerHTML = t;
		}, 1000);
}

function endTimer()
{
	clearInterval(timer);
}