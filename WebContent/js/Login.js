function check() {
	// body...
	var a = document.getElementById('b1').value;
	var b = document.getElementById('b2').value;
	if (a == "User Name" || b == "Password") {
		alert("请填写登录信息！");
		return false;
	} else
		return true;
}
function login() {
	if (check()) {
		alert("hi");
	}
}
$(document).ready(function() {
	$("#loginBtn").click(function() {
		var isAdmin = document.getElementById('check').checked;
		if (isAdmin) {
			var a = document.getElementById('b1').value;
			var b = document.getElementById('b2').value;
			$.post("/Hospital/HospitalLogin", {
				account : a,
				password : b
			}, function(data, status) {
				if (status == 'success') {
					if (data == 'success') {
						window.location.href = "/Hospital/HospitalPage.jsp"
					} else {
						alert("密码错误");
					}
				}
			});
		} else {
			alert('apt');
		}
	})
});