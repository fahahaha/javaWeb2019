function check(){
	if(form.cid.value==""){
		alert("�û���Ų���Ϊ�գ�");
		form.cid.focus();
		return false;
	}
	if(form.username.value==""){
		alert("�û�������Ϊ�գ�");
		form.username.focus();
		return false;
	}
	var regm=/^[a-z0-9]+$/;
	if(form.username.value!=""&&!form.username.value.match(regm)){
		alert("�û�����ʽ���ԣ��û���ֻ����Сд��ĸ��������ɣ�������������룡");
		form.username.focus();
		return false;
	}
	if(form.password1.value==""){
		alert("���������룡");
		form.password1.focus();
		return false;
	}
	if(form.password2.value==""){
		alert("���ٴ��������룡");
		form.password2.focus();
		return false;
	}
	if(form.password1.value!=form.password2.value){
		alert("������������벻һ�£�");
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
			alert("����ͬʱ�������ף�")
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
		if(confirm("��ȷ��Ԥ���˷�����")){
			
			location.href="UpdateCusEnrolment?f=pay&rid="+rId+"&cid="+cId;
		}
	}else{
		
		alert("������ѡ��һ����¼�����ܽ���Ԥ����")
	}
	
}

