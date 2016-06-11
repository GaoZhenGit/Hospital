function check() {
	// body...
	var a = document.getElementById("p1").value;
	var b = document.getElementById("p2").value;
	if (a != b) {
		alert("两次密码不一致");
		return false;
	} else {
		return true;
	}
}
$(document).ready(function() {
	$("#submit").click(function() {
		if(check()){
		var a = document.getElementById('b1').value;            //用户名
		var b = document.getElementById('b2').value.toString();            //年龄
		//性别
		var obj=document.getElementById('select');
		var index = obj.selectedIndex;   // 选中索引
		var c = obj.options[index].value; // 选中值
		//密码
		var d=document.getElementById('p1').value;              
		$.post("/Hospital/PatientRegisterServlet", {
				name : a,
				age : b,
				sex : c,
				password:d
			}, function(data, status) {
				if (status == 'success') {
					if (data == 'success') {
						window.location.href = "/Hospital/guahao.html"
						//alert("注册成功");
					} else {
						alert("注册失败");
					}
				}
			});
		
		}else{
			window.location.href = "/Hospital/register.html"
		}
	})
});