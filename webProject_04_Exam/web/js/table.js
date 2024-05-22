window.onload = init;
function fun1(){
    var domlist=document.getElementsByTagName("input");
    var flag=domlist[0].checked;
    for (var i = 1; i < domlist.length; i++) {
        domlist[i].checked=flag;
    }
}
function fun2(){
    var domlist=document.getElementsByTagName("input");
    var num=0;
    for (var i = 1; i < domlist.length; i++) {
        if (domlist[i].checked==false){
            num++;
            domlist[0].checked=false;
        }
    }
    if (!num){
        domlist[0].checked=true;
    }
}
function fun3(){
    this.style.color="red";
}
function fun4(){
    this.style.color="black";
}

function init(){
    var domlist=document.getElementsByTagName("input");
    domlist[0].onclick=fun1;
    for (var i = 1; i < domlist.length; i++) {
        if(dom.type=="checkbox"){
            domlist[i].onclick=fun2;
        }
    }
    domlist=document.getElementsByTagName("tr");
    for (var i = 1; i < domlist.length; i++) {
        domlist[i].onmouseover=fun3;
        domlist[i].onmouseout=fun4;
    }

}