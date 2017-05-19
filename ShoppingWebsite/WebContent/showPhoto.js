// JavaScript Document
var curIndex=0;
//时间间隔(单位毫秒)，每秒钟显示一张，数组共有5张图片放在Photos文件夹下。图片路径可以是绝对路径或者相对路径
var timeInterval=1000; //时间1秒
var arr=new Array();
arr[0]="photos/1.png";
arr[1]="photos/2.png";
//arr[2]="photos/3.jpg";
//arr[3]="photos/4.jpg";
//arr[4]="photos/5.jpg";
setInterval(changeImg,timeInterval);
function changeImg()
{
    var obj=document.getElementById("newGood");
    if (curIndex==arr.length-1) 
    {
        curIndex=0;
    }
    else
    {
        curIndex+=1;
    }
    newGood.src=arr[curIndex];
}