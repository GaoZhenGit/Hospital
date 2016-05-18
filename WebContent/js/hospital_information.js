
$(document).ready(function() {
  $("#first").css("display","block");
});
$("#first").css("display","block");
$(function(){   
    //顶部导航切换
    $("#list li").click(function(){
        $("#list li.active").removeClass("active");
        $(this).addClass("active");
    })  

    $("#list li").click(function(){
        //alert($(this).children("a").children("label").html());
        $("#first").css("display","none");
        $("#div").css("display","none");
        $("#depart").css("display","none");
        $("#section").css("display","none");
        $("#password").css("display","none");
        if ($(this).children("a").children("label").html()=="医院资料") {$("#first").css("display","block");}
        if ($(this).children("a").children("label").html()=="医院信息") {$("#div").css("display","block");}
        if ($(this).children("a").children("label").html()=="医院部门") {$("#depart").css("display","block");}
        if ($(this).children("a").children("label").html()=="医院科室") {$("#section").css("display","block");}
        if ($(this).children("a").children("label").html()=="密码修改") {$("#password").css("display","block");}
    })

    $("")
})

function check() {
    // body...
    var a=document.getElementById('b1').value;
    var b=document.getElementById('b2').value;
    if (a!=b){alert("两次密码不同");return false;}
    else return true;
}

function add() {
        var trObj = document.createElement("tr");
        trObj.id = new Date().getTime();
        trObj.innerHTML = "<td><input required='required'></input></td><td><textarea required='required'> </textarea></td><td><button onClick='removeRow(this)'>删除</button></td>";   
        document.getElementById("department").appendChild(trObj);
    }

function sec_add() {
        var trObj = document.createElement("tr");
        trObj.id = new Date().getTime();
        trObj.innerHTML = "<td><input required='required' disabled='disabled'></input></td><td><textarea required='required' disabled='disabled'> </textarea></td><td><button onClick='removeRow(this)'>删除</button></td>";   
        document.getElementById("sec").appendChild(trObj);
    }

function deleteRow(tableID, obj) {//参数为表格ID，触发对象
    //获得触发对象的行号，parentElement的个数取决于触发对象为TR的第几级子项，input=>td=>tr，所以parentElement有两个
    var rowIndex = obj.parentElement.parentElement.rowIndex;
    //var table = document.getElementById(tableID).deleteRow(rowIndex);
    obj.parentElement.parentElement.parentElement.deleteRow(rowIndex); //再简化：省略tableID参数
}

function removeRow(inputobj)  
{  
    if(inputobj==null) return;  
    var parentTD = inputobj.parentNode;  
    var parentTR = parentTD.parentNode;  
    var parentTBODY = parentTR.parentNode;  
    parentTBODY.removeChild(parentTR);  
} 

function refresh()  
{  
    window.location.href='医院信息修改.html';
} 


//用于弹出表单var diag = new Dialog();

$(function ($) {
        //弹出登录
        $("#example").hover(function () {
            $(this).stop().animate({
                opacity: '1'
            }, 600);
        }, function () {
            $(this).stop().animate({
                opacity: '0.6'
            }, 1000);
        }).on('click', function () {
            $("body").append("<div id='mask'></div>");
            $("#mask").addClass("mask").fadeIn("slow");
            $("#LoginBox").fadeIn("slow");
        });
        //
        //按钮的透明度
        $("#loginbtn").hover(function () {
            $(this).stop().animate({
                opacity: '1'
            }, 600);
        }, function () {
            $(this).stop().animate({
                opacity: '0.8'
            }, 1000);
        });
        //文本框不允许为空---按钮触发
        $("#loginbtn").on('click', function () {
            var txtName = $("#txtName").val();
            var txtPwd = $("#txtPwd").val();
            if (txtName == "" || txtName == undefined || txtName == null) {
                if (txtPwd == "" || txtPwd == undefined || txtPwd == null) {
                    $(".warning").css({ display: 'block' });
                }
                else {
                    $("#warn").css({ display: 'block' });
                    $("#warn2").css({ display: 'none' });
                }
            }
            else {
                if (txtPwd == "" || txtPwd == undefined || txtPwd == null) {
                    $("#warn").css({ display: 'none' });
                    $(".warn2").css({ display: 'block' });
                }
                else {
                    $(".warning").css({ display: 'none' });
                }
            }
        });
        //文本框不允许为空---单个文本触发
        $("#txtName").on('blur', function () {
            var txtName = $("#txtName").val();
            if (txtName == "" || txtName == undefined || txtName == null) {
                $("#warn").css({ display: 'block' });
            }
            else {
                $("#warn").css({ display: 'none' });
            }
        });
        $("#txtName").on('focus', function () {
            $("#warn").css({ display: 'none' });
        });
        //
        $("#txtPwd").on('blur', function () {
            var txtName = $("#txtPwd").val();
            if (txtName == "" || txtName == undefined || txtName == null) {
                $("#warn2").css({ display: 'block' });
            }
            else {
                $("#warn2").css({ display: 'none' });
            }
        });
        $("#txtPwd").on('focus', function () {
            $("#warn2").css({ display: 'none' });
        });
        //关闭
        $(".close_btn").hover(function () { $(this).css({ color: 'black' }) }, function () { $(this).css({ color: '#999' }) }).on('click', function () {
            $("#LoginBox").fadeOut("fast");
            $("#mask").css({ display: 'none' });
        });
    });







$(function ($) {
        //弹出登录
        $("#example1").hover(function () {
            $(this).stop().animate({
                opacity: '1'
            }, 600);
        }, function () {
            $(this).stop().animate({
                opacity: '0.6'
            }, 1000);
        }).on('click', function () {
            $("body").append("<div id='mask'></div>");
            $("#mask").addClass("mask").fadeIn("slow");
            $("#LoginBox1").fadeIn("slow");
        });
        //
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
        $(".close_btn").hover(function () { $(this).css({ color: 'black' }) }, function () { $(this).css({ color: '#999' }) }).on('click', function () {
            $("#LoginBox1").fadeOut("fast");
            $("#mask").css({ display: 'none' });
        });
    });