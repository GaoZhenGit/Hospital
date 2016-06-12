<%@page import="model.Registration"%>
<%@page import="model.*"%>
<%@page import="model.Doctor"%>
<%@page import="javax.print.Doc"%>
<%@page import="model.Department"%>
<%@page import="model.Hospital"%>
<%@ page import="model.Patient"%>
<%@ page import="hibernate.Dao"%>
<%@ page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>personal center</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/zhifu.css">
<script type="text/javascript" src="js/zhifu.js"></script>
<!-- <script src="http://libs.baidu.com/jquery/1.10.2/jquery.min.js"></script> -->
<script src="js/jquery.js"></script>
<script type="text/javascript">
  // function deletes(var ha) {
  //   alert(ha.val())
  //   alert($(this).parent().html());
  //   alert($(this).parent().parent().html());
  //   $(this).parent().parent().remove();
  // }
    function deRow(obj){
    var yse=window.confirm("您确认删除这个预约");
    //alert( $("#idsis").attr("value"));
    var id=$("#idsis").attr("value");
    if(yes==true){
    	$.post("/Hospital/DelectServlet", {
			id : id,
		},function(data, status) {
			if (status == 'success') {
				if (data == 'success') {
					alert("删除成功")
					window.location.href = "/Hospital/perchuse.jsp"
				} else {
					alert("删除失败，请重新尝试")
					window.location.href = "/Hospital/perchuse.jsp"

				}
			}
		})
    }
    //if(yse==true){
      //obj.parentNode.parentNode.parentNode.remove();}
    }
function delRow(obj){
    var yse=window.confirm("您确认支付预约");
    var id=$("#idsis").attr("value");
    if(yse==true)baga();
    if(yse==true){	
      //obj.parentNode.innerHTML="已支付";
      //obj.remove()
      // var html="<th >预约费用</th>";
      // obj.parentNode.parentNode.parentNode.remove();
    }
	function buafds(){
        var account = $("#txtName1").val();
        var password = $("#txtPwd").val();
        var id=$("#idsis").attr("value");
        //alert(txtName1+txtPwd);
        $.post("/Hospital/PayServlet", {
        	account : account,
        	password:password,
        	id : id
		},function(data, status) {
			if (status == 'success') {
				if (data == 'success') {
					alert("支付成功")
					window.location.href = "/Hospital/perchuse.jsp"
				} else {
					alert("支付失败，请重新尝试")
					window.location.href = "/Hospital/perchuse.jsp"
				}
			}
		})
		alert("支付成功");
        return false;
}

// var tr = this.getRowObj(obj);
// if(tr != null){
// tr.parentNode.removeChild(tr);
// }else{
// throw new Error("the given object is not contained by the table");
// }
}
</script>
</head>
<body>
<!--body start -->
<div id="body">
<!-- <a href="index.html"><img src="images/3423.png" alt="Iinfinite" title="Iinfinite" width="197" height="64" border="0" /></a> -->
<!--left panel start -->
<div id="left">
<div class="top_left" onclick="function() {
  window.location.href='/Hospital/guahao.jsp';
}">
      <a href="/Hospital/guahao.jsp">
      <img src="images/logo.jpg">
      <h2 class="top_h2">&nbsp;广州市预约挂号统一平台</h2>
      </a>
    </div>
<p class="leftTop"></p>
<ul class="menu2">
<li><a href="#">个人资料</a></li>
<li><a href="#">支持</a></li>
<li><a href="#">博客</a></li>
<li><a href="#">关于组织</a></li>
<li><a href="#">我们的工作</a></li>
<li class="noBdr"><a href="#">请联系</a></li>
</ul>
<p class="leftBot"></p>

<br class="spacer" />
</div>
<!--left panel end -->
<!--right panel start -->
<div id="right">

<!-- <h2 class="why">所有预约</h2> -->
              <div class="col-sm-7">
                    <div id="sdfsdf"><a href="/Hospital/perchuse.jsp" class="thumb-lg pull-left m-r">
                        <img src="images/a0.jpg" class="img-circle">
                      </a></div>
<%Patient patient=Dao.getById((String)request.getSession(true).getAttribute("patient"),Patient.class);   %>                  
                      <div class="clear m-b">
                        <div class="m-b m-t-sm">
                          <span class="h3 text-black"><%=patient.getName() %></span>
                          <small class="m-l">china</small>
                        </div>
                        <!-- <a href="" class="btn btn-sm btn-success btn-rounded">Follow</a> -->
                      </div>
                    </div>

<div id="hahaha">
  <table class="bought-table-mod__table___279Jf table-head-mod__table___3CnjL" >
  <colgroup >
  <col class="bought-table-mod__col1___16ixq" >
  <col class="bought-table-mod__col2___1wHsS" >
  <col class="bought-table-mod__col3___3DK6P" >
  <col class="bought-table-mod" >
  <col class="bought-table-mod__col4___30FH7" >
  </colgroup>
  <tbody ><tr >
  <th id="yiyuanjia">医院简介</th>
  <th >预约科室</th>
  <th >预约日期</th>
  <th >预约费用</th>
  <th >操作</th>
  </tr>
  </tbody>
  </table>
  <div>
    <div>
      <div>
        <div id="hahaha">
  <table class="bought-table-mod__table___279Jf table-head-mod__table___3CnjL" >
  <colgroup >
  <col class="bought-table-mod__col1___16ixq" >
  <col class="ddd" >
  <col class="bought-table-mod__col3___3DK6P" >
   <col class="bought-table-mod" >
  <col class="bought-table-mod__col4___30FH7" >
  </colgroup>
  <%List<Registration> registrations=new ArrayList<Registration>();
  registrations=Dao.getRegistrations(null, patient, null);
  int length=registrations.size();
  for(int i=0;i<length;i++){%>
  <tbody ><tr >
  <th id="yiyuanjia">
<div class="yiyuan_content_1">
          <dl class="yiyuan_co_dl">
            <dt class="yiyuan_co_dt">
              <a href="/hp/appoint/215.htm">
                <img src="images/pic.jpg" width="200px" height="150px">
              </a>
            </dt>
            <dd class="yiyuan_co_dd">
              <p class="yiyuan_co_titl">
                <b ><%=registrations.get(i).getDoctor().getDepartment().getHospital().getName() %></b>
                <span class="yiyuan_co_ddsp"><%=registrations.get(i).getDoctor().getDepartment().getHospital().getDescription() %></span>
              </p>
              <div class="yiyuan_co_dd_div xixix">
                <p><b class="yiyuan_telico"></b>400-686-8861</p>
                <p><b class="yiyuan_telico1"></b><%=registrations.get(i).getDoctor().getDepartment().getHospital().getAddress() %></p>
              </div>
            </dd>
          </dl>
        </div>
  </th>
  <th ><%=registrations.get(i).getDoctor().getDepartment().getName() %></th>
  <th ><%=registrations.get(i).getTimeQuantum().toString() %></th>
  <th ><%=registrations.get(i).getDoctor().getTitle().getFee() %> 元</th>
  <th id="idsis" value=<%=registrations.get(i).getId() %>><%if(!registrations.get(i).isHasPay()){ %><button  class="were" value="'dsfs"  onclick="delRow(this)" id="example">支付</button><%} %>
       <button  class="were" value="'dsfs"  onclick="deRow(this)">删除</button>
  </th>
  </tr>
  </tbody>
  <%} %>
  </table>
  <div>
    </div>
  </div>
      </div>

</div>
</div>
<!--right panel end -->
<br class="spacer" />
</div>
<!--body end -->
<!--footer start -->
<div id="footerMain">
  <div id="footer"> 
    <ul>
      <li><a href="#">Latest Profiles</a>|</li>
      <li><a href="#">Support</a>|</li>
      <li><a href="#">More About Depertment</a>|</li>
      <li><a href="#">Blog</a>|</li>
      <li><a href="#">Cliet Testimonials</a>|</li>
      <li><a href="#">About Organigation</a>|</li>
      <li><a href="#">Our Work</a>|</li>
      <li><a href="#">Make Contact</a></li>
    </ul>
    <p class="copyright">Copyright ?infinite extend 20XX. All Rights Reserved.</p>
    
  </div>
</div>
<div id="LoginBox1">
      <form action="" method="" charset="utf8">
        <div class="row1">
            支付窗口<a href="" title="关闭窗口" class="close_btn" id="closeBtn1">×</a>
        </div>
        <div class="row">
            银行卡号： <span class="inputBox">
                <input type="text" id="txtName1" required="required" placeholder="银行卡号" name="name" />
            </span><a href="javascript:void(0)" title="提示" class="warning" id="warn1"></a>
        </div>
        <div class="row">
            <label> &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp密码：</label> 
            <span class="inputBox">
             <input type="password" id="txtPwd" required="required" placeholder="password" name="name" />
        </div>
        <div class="row">
             <button type="submit" id="loginbtn" onclick="return buafds()">确认<tton>
       <button onclick="busasd()">取消<tton>
        </div>

        </form>

    </div>
<!--footer end -->
<!-- <div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div> -->
</body>
</html>
