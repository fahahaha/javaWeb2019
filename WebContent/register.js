function check(){
	if(form.cid.value==""){
		alert("用户编号不能为空！");
		form.cid.focus();
		return false;
	}
	if(form.username.value==""){
		alert("用户名不能为空！");
		form.username.focus();
		return false;
	}
	var regm=/^[a-z0-9]+$/;
	if(form.username.value!=""&&!form.username.value.match(regm)){
		alert("用户名格式不对，用户名只能由小写字母与数字组成，请检查后重新输入！");
		form.username.focus();
		return false;
	}
	if(form.password1.value==""){
		alert("请输入密码！");
		form.password1.focus();
		return false;
	}
	if(form.password2.value==""){
		alert("请再次输入密码！");
		form.password2.focus();
		return false;
	}
	if(form.password1.value!=form.password2.value){
		alert("两次输入的密码不一致！");
		form.password2.focus();
		return false;
	}
	
	
}
function checkroom(){
	var oCheck1 =document.getElementsByName('check');
	var count=0;
	for (var i=0;i<oCheck1.length;i++){
		{
		if(oCheck1[i].checked)
		count++;
		if(count>1)
			{
			alert("不能同时购买两套！")
			oCheck1[i].checked=false;
			count--;
			
			}
		}
	}
	
}
function pay(){
    var cId = document.getElementById('a').value;

	var rId;
	var flag=false;
	var oCheck1 =document.getElementsByName('check');
	
	for (var i=0;i<oCheck1.length;i++){
		if(oCheck1[i].checked){
			rId=oCheck1[i].value;
			flag=true
		}
		
	}
	
	if(flag){
		if(confirm("您确定预定此房间吗？")){
			
			location.href="UpdateCusEnrolment?f=pay&rid="+rId+"&cid="+cId;
		}
	}else{
		
		alert("您至少选择一条记录，才能进行预定！")
	}
	
}

