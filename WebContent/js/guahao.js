$(document).ready(function(){
//    nav-li hover e
    $("#touch").hover(function(){
	$("#box").css("display","block");
	},function(){
	$("#box").css("display","none");
	});
    console.log("sss");
    var lit=$(".yi_c_span_w");
    console.log(lit.length);
    var hospitalId;
    for(var i=0;i<lit.length;i++){
    	$(lit[i]).click(function(){
    		hospitalId=$(this).attr("hospitalId");
    		console.log(hospitalId);
    		$.post("/Hospital/SelectDepartmentSevlet", {
    			hospitalId : hospitalId
    		},function(data, status) {
				if (status == 'success') {
					if (data == 'success') {
						window.location.href = "/Hospital/guahao1.jsp"
					} else {
						window.location.href = "/Hospital/guahao.jsp"
					}
				}
    		})
    	})
    }
    
    
});

