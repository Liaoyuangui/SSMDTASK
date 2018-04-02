/**
 * 
 */
var page = 1;
var fenye = {};
fenye.init = function(options,fuc) {
	fenye.setFenye(options);
	fenye.click(options,fuc);
};
fenye.setFenye = function(options) {
	var color = options.color?option.color:"#ffffff";
	var bgColor = options.bgColor?options.bgColor:"blue";
	var numColor = options.numColor?options.numColor:"#8e3306";
	var totalPage = options.totalPages?options.totalPages:"1";
	var nowPage = options.nowPage?options.nowPage:"1";
	var contentPage = options.contentPage; //必传
	var pageHtml='<button class="click" id="firstPage" style="color:'+color+';background:'+bgColor+';border:0;width:60px;height:25px;">首页</button>'+
		'<button class="click" id="prePage" style="color:'+color+';background:'+bgColor+';border:0;width:60px;height:25px;margin-left:5px;">上一页</button>'+
		'<button class="click" id="nextPage" style="color:'+color+';background:'+bgColor+';border:0;width:60px;height:25px;margin-left:5px;">下一页</button>'+
		'<button class="click" id="lastPage" style="color:'+color+';background:'+bgColor+';border:0;width:60px;height:25px;margin-left:5px;">尾页</button>'+
		'<input class="inputpage" id="inputpage" maxlength="5" style="width: 40px;height: 21px;border: 1px solid #6b5b5b;margin-left:5px;">'+
		'<button class="click" id="jumpPage" style="color:'+color+';background:'+bgColor+';margin-left:5px;">跳转</button>'+
		'<label style="color: #4c3d3d;background: white;margin-left:5px;">当前第<span class="nowPage" id="nowPage" style="color:'+numColor+'">'+page+'</span>页/共<span class="totalPage" id="totalPage" style="color:'+numColor+'">'+totalPage+'</span>页</label>';
	var parent = document.getElementById(contentPage);
	parent.innerHTML =  pageHtml;
};

fenye.click = function(options,fuc) {
	document.getElementById('firstPage').onclick = function(){
		page = 1;
		fuc.call(fuc,page);
	}
	document.getElementById('lastPage').onclick=function(){
		page = document.getElementById("totalPage").innerText; 
		fuc.call(fuc,page);
	}
	document.getElementById('prePage').onclick=function(){
		if(page <= 1 ){
			page = 1;
		}else{
			page--;
		}
		fuc.call(fuc,page);
	}
	document.getElementById('nextPage').onclick=function(){
		if(page >= document.getElementById("totalPage").innerText || options.lastPage){
			page = document.getElementById("totalPage").innerText;
		}else{
			page++;
		}
		fuc.call(fuc,page);
	}
	document.getElementById('jumpPage').onclick=function(){
		page=document.getElementById("inputPage").value;
		var parrern=/^[0-9]+$/;
		var reg=page.match(parrern);
		if(reg==null){
			alert("页数请输入数字");
			return;
		}
		if(page <= 1){
			page = 1;
		}
		if(page >= document.getElementById("totalPage").innerText){
			page = document.getElementById("totalPage").innerText;
		}
		fuc.call(fuc,page);
	}
	
};