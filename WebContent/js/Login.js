function check() {
	// body...
	var a=document.getElementById('b1').value;
	var b=document.getElementById('b2').value;
	if (a=="User Name"||b=="Password") {alert("请填写登录信息！");return false;}
	else return true;
}