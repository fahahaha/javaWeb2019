/**
 * 
 */
//����ȫѡ
function allCheck(){
	var oCheck =document.getElementsByName('check');
	for (var i=0;i<oCheck.length;i++){
		oCheck[i].checked=true;
	}
}
//����ѡ
function allCheck1(){
	var oCheck =document.getElementsByName('check');
	for (var i=0;i<oCheck.length;i++){
		if(oCheck[i].checked)
			oCheck[i].checked=false;
			else
			oCheck[i].checked=true;
	}
}
//˫��ȫѡ
function allCheck2(){
	var oCheck1 =document.getElementsByName('check1');
	var oCheck2 =document.getElementsByName('check2');
	for (var i=0;i<oCheck1.length;i++){
		oCheck1[i].checked=true;
		oCheck2[i].checked=true;
	}
}
//˫��ѡ
function allCheck3(){
	var oCheck1 =document.getElementsByName('check1');
	var oCheck2 =document.getElementsByName('check2');
	for (var i=0;i<oCheck1.length;i++){
		if(oCheck1[i].checked)
		oCheck1[i].checked=false;
		else
		oCheck1[i].checked=true;
		if(oCheck2[i].checked)
			oCheck2[i].checked=false;
			else
			oCheck2[i].checked=true;
	}
}
function delAllCus(){
//	var oBtn1=document.getElementById('btn1');
	var allcid=new Array();
	var flag=false;
	var oCheck =document.getElementsByName('check');
	for (var i=0;i<oCheck.length;i++){
		if(oCheck[i].checked){
			allcid.push(oCheck[i].value);
			flag=true
		}
		
	}
	if(flag){
		if(confirm("��ȷ��Ҫɾ����Щ��¼��")){
			
			location.href="updateCus?f=delall&allcid="+allcid;
		}
	}else{
		alert("������ѡ��һ����¼�����ܽ�������ɾ����")
	}
	
	
	function send(){
	    var oBox=document.getElementById("box");
	    var oSpan=document.getElementById("span1");
	    var oText=document.getElementById("text1");
	    var oBtn=document.getElementById("Btn");
	    oBtn.onclick = function(){
	        oBox.innerHTML =oBox.innerHTML  + oSpan.innerHTML +  oText.value + "<br/>";
	        //oBox.innerHTML += oSpan.innerHTML + oText.value +  "<br/>";���Ǽ���д������js�� a=a+b ,��ôҲ��ͬ�� a+=b
	        oText.value=""
	    };
	}

}
function delAllRoom(){
//	var oBtn1=document.getElementById('btn1');
	var allrid=new Array();
	var flag=false;
	var oCheck =document.getElementsByName('check');
	for (var i=0;i<oCheck.length;i++){
		if(oCheck[i].checked){
			allrid.push(oCheck[i].value);
			flag=true
		}
		
	}
	if(flag){
		if(confirm("��ȷ��Ҫɾ����Щ��¼��")){
			
			location.href="updateRoom?f=delall&allrid="+allrid;
		}
	}else{
		alert("������ѡ��һ����¼�����ܽ�������ɾ����")
	}
	
}
function delAllEnrolment(){
//	var oBtn1=document.getElementById('btn1');
	var allcid=new Array();
	var allrid=new Array();
	var flag=false;
	var oCheck1 =document.getElementsByName('check1');
	var oCheck2 =document.getElementsByName('check2');
	for (var i=0;i<oCheck1.length;i++){
		if(oCheck1[i].checked==true&&oCheck2[i].checked==true){
			allcid.push(oCheck1[i].value);
			allrid.push(oCheck2[i].value);
			flag=true
		}
		
	}
	if(flag){
		if(confirm("��ȷ��Ҫɾ����Щ��¼��")){

			location.href="updateEnrolment?f=delall&allcid="+allcid+"&allrid="+allrid;
		}
	}else{
		
		alert("������ѡ��һ����¼�����ܽ�������ɾ����")
	}
	
}

