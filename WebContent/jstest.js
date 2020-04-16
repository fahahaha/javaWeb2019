function send(){
    var oBox=document.getElementById("box");
    var oSpan=document.getElementById("span1");
    var oText=document.getElementById("text1");
    var oBtn=document.getElementById("Btn");
    oBtn.onclick = function(){
        oBox.innerHTML =oBox.innerHTML  + oSpan.innerHTML +  oText.value + "<br/>";
        //oBox.innerHTML += oSpan.innerHTML + oText.value +  "<br/>";这是简便的写法，在js中 a=a+b ,那么也等同于 a+=b
        oText.value=""
    };
}
function displayDate(){
	document.getElementById("demo").innerHTML=Date();
	alert('lalala');
	setTimeout("demo()",5000);
	document.getElementById("demo").innerHTML="1234";
	//setTimeout("demo",5000); 这样是执行不了滴
}
function date(){
	document.getElementById("demo1").innerHTML=Date();
}

function demo(){
  alert('asc');
}

