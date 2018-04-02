/**
 *分页插件封装
 *使用：
 *1.引入该fenye.js
 *2.调用
 *  fenye.init(参数options,回调函数fun);
 *  options参数说明如下:  
 *   option:{
 *    'contentPage'选择将分页加在哪
 *    'color'字体颜色
 *    'bgColor'块的颜色
 *    'numColor'数字的颜色
 *    'function'跳转
 * 	  'totalPages' 总共有多少页
 * 	  'nowPage' 当前页数
 * 	  'firstPage' 是否是首页
 * 	  'lastPage' 是否是最后一页
 *   }
 *  回调函数fun:即查询时执行的函数。
 */
var fenye = {};var page = 1;
fenye.init = function(options,fuc) {
	fenye.setFenye(options);
	fenye.click(options,fuc);
};
fenye.setFenye = function(options) {
	var color = options.color?option.color:"#ffffff";
	var bgColor = options.bgColor?options.bgColor:"#2E87CB";
	var numColor = options.numColor?options.numColor:"#8e3306";
	var totalPage = options.totalPages?options.totalPages:"1";
	var nowPage = options.nowPage?options.nowPage:"1";
	var contentPage = options.contentPage?options.contentPage:"body"; //不传放到body里
	var pageHtml='<button class="firstPage click" style="color:'+color+';background:'+bgColor+';border:0;width:60px;height:25px;">首页</button>'+
		'<button class="prePage click" style="color:'+color+';background:'+bgColor+';border:0;width:60px;height:25px;margin-left:5px;">上一页</button>'+
		'<button class="nextPage click" style="color:'+color+';background:'+bgColor+';border:0;width:60px;height:25px;margin-left:5px;">下一页</button>'+
		'<button class="lastPage click" style="color:'+color+';background:'+bgColor+';border:0;width:60px;height:25px;margin-left:5px;">尾页</button>'+
		'<input class="inputpage" maxlength="5" style="width: 40px;height: 21px;border: 1px solid #6b5b5b;margin-left:5px;">'+
		'<button class="jumpPage click" style="color:'+color+';background:'+bgColor+';margin-left:5px;">跳转</button>'+
		'<label style="color: #4c3d3d;background: white;margin-left:5px;">当前第<span class="nowPage"style="color:'+numColor+'">'+page+'</span>页/共<span class="totalPage" style="color:'+numColor+'">'+totalPage+'</span>页</label>';
	$(contentPage).html(pageHtml);
};
fenye.click = function(options,fuc) {
	$(".firstPage").click(function(){
		page = 1;
		fuc.call(fuc,page);
	});
	$(".lastPage").click(function(){
		page = $(".totalPage").text();
		fuc.call(fuc,page);
	})
	$(".prePage").click(function(){
		if(page <= 1 ){
			page = 1;
		}else{
			page--;
		}
		fuc.call(fuc,page);
	})
	$(".nextPage").click(function(){
		if(page >= $(".totalPage").text() || options.lastPage){
			page = $(".totalPage").text();
		}else{
			page++;
		}
		fuc.call(fuc,page);
	})
	$(".jumpPage").click(function(){
		page = $(".inputpage").val();
		var parrern=/^[0-9]+$/;
		if(!parrern.test(page)){
			alert("页数请输入数字");
			return;
		}
		if(page <= 1){
			page = 1;
		}
		if(page >= $(".totalPage").text()){
			page = $(".totalPage").text();
		}
		fuc.call(fuc,page);
	})
};
			
	