function busasd(){
            $("#LoginBox1").fadeOut("fast");
            $("#mask").css({ display: 'none' });
}

function baga() {
        //弹出登录
            $("body").append("<div id='mask'></div>");
            $("#mask").addClass("mask").fadeIn("slow");
            $("#LoginBox1").fadeIn("slow");
            $(".close_btn").hover(function () { $(this).css({ color: 'black' }) }, function () 
            { $(this).css({ color: '#999' }) }).on('click', function () {
            $("#LoginBox1").fadeOut("fast");
            $("#mask").css({ display: 'none' });
        });

            $("#quexiaos").click(function () {
            $("#LoginBox1").fadeOut("fast");
            $("#mask").css({ display: 'none' });
        });


        //按钮的透明度
        $("#loginbtn1").hover(function () {
            $(this).stop().animate({
                opacity: '1'
            }, 600);
        }, function () {
            $(this).stop().animate({
                opacity: '0.8'
            }, 1000);
        });
        //文本框不允许为空---按钮触发
        $("#loginbtn1").on('click', function () {
            var txtName1 = $("#txtName1").val();
            var txtPwd = $("#txtPwd").val();
            if (txtName1 == "" || txtName1 == undefined || txtName1 == null) {
                if (txtPwd == "" || txtPwd == undefined || txtPwd == null) {
                    $(".warn1ing").css({ display: 'block' });
                }
                else {
                    $("#warn1").css({ display: 'block' });
                    $("#warn12").css({ display: 'none' });
                }
            }
            else {
                if (txtPwd == "" || txtPwd == undefined || txtPwd == null) {
                    $("#warn1").css({ display: 'none' });
                    $(".warn12").css({ display: 'block' });
                }
                else {
                    $(".warn1ing").css({ display: 'none' });
                }
            }
        });
        //文本框不允许为空---单个文本触发
        $("#txtName1").on('blur', function () {
            var txtName1 = $("#txtName1").val();
            if (txtName1 == "" || txtName1 == undefined || txtName1 == null) {
                $("#warn1").css({ display: 'block' });
            }
            else {
                $("#warn1").css({ display: 'none' });
            }
        });
        $("#txtName1").on('focus', function () {
            $("#warn1").css({ display: 'none' });
        });
        //
        $("#txtPwd").on('blur', function () {
            var txtName1 = $("#txtPwd").val();
            if (txtName1 == "" || txtName1 == undefined || txtName1 == null) {
                $("#warn12").css({ display: 'block' });
            }
            else {
                $("#warn12").css({ display: 'none' });
            }
        });
        $("#txtPwd").on('focus', function () {
            $("#warn12").css({ display: 'none' });
        });
        //关闭

}