/* -----------H-ui前端框架-------------
 * H-ui.admin.js v3.0
 * http://www.h-ui.net/
 * Created & Modified by guojunhui
 * Date modified 2017.02.03
 * Licensed under MIT license.
 * http://opensource.org/licenses/MIT
 */
var num = 0, oUl = $("#min_title_list"), hide_nav = $("#Hui-tabNav");

/* 获取顶部选项卡总长度 */
function tabNavallwidth() {
	var taballwidth = 0, $tabNav = hide_nav.find(".acrossTab"), $tabNavWp = hide_nav
			.find(".Hui-tabNav-wp"), $tabNavitem = hide_nav
			.find(".acrossTab li"), $tabNavmore = hide_nav
			.find(".Hui-tabNav-more");
	if (!$tabNav[0]) {
		return
	}
	$tabNavitem.each(function(index, element) {
		taballwidth += Number(parseFloat($(this).width() + 60))
	});
	$tabNav.width(taballwidth + 25);
	var w = $tabNavWp.width();
	if (taballwidth + 25 > w) {
		$tabNavmore.show()
	} else {
		$tabNavmore.hide();
		$tabNav.css({
			left : 0
		})
	}
}

jQuery.i18n.properties({// 加载properties文件
    name:'warehouseUrl', // properties文件名称
    path:'../', // properties文件路径
    mode:'map', // 用 Map 的方式使用资源文件中的值
    callback: function() {// 加载成功后设置显示内容
        weburl=$.i18n.prop($(location).attr('hostname'));//其中isp_index为properties文件中需要查找到的数据的key值
    }
    //Warehouse_url
});

var getCheckVal = function(name) {
    var box = document.getElementsByName(name);
    var objArray = box.length;
    var chestr="";

    for(var i=0;i<objArray;i++){
        if(box[i].checked == true){
            chestr+=box[i].value+",";
        }
    }
    return(chestr);
};

//时间日期转换成string
var data_string=function(date) {
	var newtime=new Date(date);
	var year1 = newtime.getFullYear();
	var month1 = ("0" + (newtime.getMonth() + 1)).slice(-2);
	var day1 = ("0" + newtime.getDate()).slice(-2);
	var h1 = ("0" + newtime.getHours()).slice(-2);
	var m1 = ("0" + newtime.getMinutes()).slice(-2);
	var s1= ("0" + newtime.getSeconds()).slice(-2);
	return year1 + "/" + month1 + "/" + day1 + " " + h1 + ":" + m1 + ":" + s1;

};

//时间日期转换成string
var dateFormat=function(date) {
    var newtime=new Date(date);
    var year1 = newtime.getFullYear();
    var month1 = ("0" + (newtime.getMonth() + 1)).slice(-2);
    var day1 = ("0" + newtime.getDate()).slice(-2);
    var h1 = ("0" + newtime.getHours()).slice(-2);
    var m1 = ("0" + newtime.getMinutes()).slice(-2);
    var s1= ("0" + newtime.getSeconds()).slice(-2);
    return year1 + "-" + month1 + "-" + day1;
};


//时间日期转换成string
var dmyhms_string=function(date) {
	var newtime=new Date(date);
	var year1 = newtime.getFullYear();
	var month1 = ("0" + (newtime.getMonth() + 1)).slice(-2);
	var day1 = ("0" + newtime.getDate()).slice(-2);
	var h1 = ("0" + newtime.getHours()).slice(-2);
	var m1 = ("0" + newtime.getMinutes()).slice(-2);
	var s1= ("0" + newtime.getSeconds()).slice(-2);
	return day1 + "/" + month1 + "/" + year1 + " " + h1 + ":" + m1 + ":" + s1;

};

var dmy_string=function(date) {
	var newtime=new Date(date);
	var year1 = newtime.getFullYear();
	var month1 = ("0" + (newtime.getMonth() + 1)).slice(-2);
	var day1 = ("0" + newtime.getDate()).slice(-2);
	return day1 + "/" + month1 + "/" + year1;
};

var dataFmt_string=function(date) {
	var newtime=new Date(date);
	var year1 = newtime.getFullYear();
	var month1 = ("0" + (newtime.getMonth() + 1)).slice(-2);
	var day1 = ("0" + newtime.getDate()).slice(-2);
	return year1 + "/" + month1 + "/" + day1;
};

var fomat=function (t) {
	if(t.indexOf('T')!=-1){
		var y,h; //年份,时间
		var regH = /(T| )(\d\d:\d\d:\d\d)(\.\d+)?/;// 校验时间格式
		h = t.match(regH);
		h = h&&h[2]; //拿到时分秒
		y = t.slice(0,t.indexOf('T')+1); //截取年月日
		var timestamp = new Date(Date.parse(y.slice(0,-1)+' '+h)).getTime() / 1000;
		off = new Date().getTimezoneOffset() / 60; //当前时差
		timestamp -= off * 60 * 60;
		console.log(parseInt(timestamp) * 1000);
		return parseInt(timestamp) * 1000;
	}

	return new Date(t.replace(/-/g,'/'));
};

var set_select_checked=function(selectId, checkValue) {
    var select = document.getElementById(selectId);

    for (var i = 0; i < select.options.length; i++) {

        if (select.options[i].value == checkValue) {

            select.options[i].selected = true;

            break;
        }
    }
}

/*獲取url的值*/
function GetQueryString(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg);
	if (r != null)
		return unescape(r[2]);
	return null;
}

/* 左侧菜单响应式 */
function Huiasidedisplay() {
	if ($(window).width() >= 768) {
		$(".Hui-aside").show()
	}
}
/* 获取皮肤cookie */
function getskincookie() {
	var v = $.cookie("Huiskin");
	var hrefStr = $("#skin").attr("href");
	if (v == null || v == "") {
		v = "default";
	}
	if (hrefStr != undefined) {
		var hrefRes = hrefStr.substring(0, hrefStr.lastIndexOf('skin/'))
				+ 'skin/' + v + '/skin.css';
		$("#skin").attr("href", hrefRes);
	}
}
/* 菜单导航 */
function Hui_admin_tab(obj) {
	var bStop = false, bStopIndex = 0, href = $(obj).attr('data-href'), title = $(
			obj).attr("data-title"), topWindow = $(window.parent.document), show_navLi = topWindow
			.find("#min_title_list li"), iframe_box = topWindow
			.find("#iframe_box");
	// console.log(topWindow);
	if (!href || href == "") {
		alert("data-href不存在，v2.5版本之前用_href属性，升级后请改为data-href属性");
		return false;
	}
	if (!title) {
		alert("v2.5版本之后使用data-title属性");
		return false;
	}
	if (title == "") {
		alert("data-title属性不能为空");
		return false;
	}
	show_navLi.each(function() {
		if ($(this).find('span').attr("data-href") == href) {
			bStop = true;
			bStopIndex = show_navLi.index($(this));
			return false;
		}
	});
	if (!bStop) {
		creatIframe(href, title);
		min_titleList();
	} else {
		show_navLi.removeClass("active").eq(bStopIndex).addClass("active");
		iframe_box.find(".show_iframe").hide().eq(bStopIndex).show().find(
				"iframe").attr("src", href);
	}
}

/* 最新tab标题栏列表 */
function min_titleList() {
	var topWindow = $(window.parent.document), show_nav = topWindow
			.find("#min_title_list"), aLi = show_nav.find("li");
}

/* 创建iframe */
function creatIframe(href, titleName) {
	var topWindow = $(window.parent.document), show_nav = topWindow
			.find('#min_title_list'), iframe_box = topWindow
			.find('#iframe_box'), iframeBox = iframe_box.find('.show_iframe'), $tabNav = topWindow
			.find(".acrossTab"), $tabNavWp = topWindow.find(".Hui-tabNav-wp"), $tabNavmore = topWindow
			.find(".Hui-tabNav-more");
	var taballwidth = 0;

	show_nav.find('li').removeClass("active");
	show_nav.append('<li class="active"><span data-href="' + href + '">'
			+ titleName + '</span><i></i><em></em></li>');
	if ('function' == typeof $('#min_title_list li').contextMenu) {
		$("#min_title_list li").contextMenu('Huiadminmenu', {
			bindings : {
				'closethis' : function(t) {
					var $t = $(t);
					if ($t.find("i")) {
						$t.find("i").trigger("click");
					}
				},
				'closeall' : function(t) {
					$("#min_title_list li i").trigger("click");
				},
			}
		});
	} else {

	}
	var $tabNavitem = topWindow.find(".acrossTab li");
	if (!$tabNav[0]) {
		return
	}
	$tabNavitem.each(function(index, element) {
		taballwidth += Number(parseFloat($(this).width() + 60))
	});
	$tabNav.width(taballwidth + 25);
	var w = $tabNavWp.width();
	if (taballwidth + 25 > w) {
		$tabNavmore.show()
	} else {
		$tabNavmore.hide();
		$tabNav.css({
			left : 0
		})
	}
	iframeBox.hide();
	iframe_box
			.append('<div class="show_iframe"><div class="loading"></div><iframe frameborder="0" src='
					+ href + '></iframe></div>');
	var showBox = iframe_box.find('.show_iframe:visible');
	showBox.find('iframe').load(function() {
		showBox.find('.loading').hide();
	});
}

/* 关闭iframe */
function removeIframe() {
	var topWindow = $(window.parent.document), iframe = topWindow
			.find('#iframe_box .show_iframe'), tab = topWindow
			.find(".acrossTab li"), showTab = topWindow
			.find(".acrossTab li.active"), showBox = topWindow
			.find('.show_iframe:visible'), i = showTab.index();
	tab.eq(i - 1).addClass("active");
	tab.eq(i).remove();
	iframe.eq(i - 1).show();
	iframe.eq(i).remove();
}

/* 关闭所有iframe */
function removeIframeAll() {
	var topWindow = $(window.parent.document), iframe = topWindow
			.find('#iframe_box .show_iframe'), tab = topWindow
			.find(".acrossTab li");
	for (var i = 0; i < tab.length; i++) {
		if (tab.eq(i).find("i").length > 0) {
			tab.eq(i).remove();
			iframe.eq(i).remove();
		}
	}
}

/* 弹出层 */
/*
 * 参数解释： title 标题 url 请求的url id 需要操作的数据id w 弹出层宽度（缺省调默认值） h 弹出层高度（缺省调默认值）
 */
function layer_show(title, url, w, h) {
	if (title == null || title == '') {
		title = false;
	}
	;
	if (url == null || url == '') {
		url = "404.html";
	}
	;
	if (w == null || w == '') {
		w = 800;
	}
	;
	if (h == null || h == '') {
		h = ($(window).height() - 50);
	}
	;
	layer.open({
		type : 2,
		area : [ w + 'px', h + 'px' ],
		fix : false, // 不固定
		maxmin : true,
		shade : 0.4,
		title : title,
		content : url
	});
}

/* 弹出层 */
function layer_open(title, url, w, h) {
	if (w == null || w == '') {
		w = ($(window).width() - 20);
	}
	;
	if (h == null || h == '') {
		h = ($(window).height() - 5);
	}
	;
	if (title == null || title == '') {
		title = false;
	}
	;
	if (url == null || url == '') {
		url = "404.html";
	}
	;
	layer.open({
		type : 2,
		area : [ w + 'px', h + 'px' ],
		fix : false, // 不固定
		maxmin : true,
		shade : 0.4,
		title : title,
		content : url
	});
}
/* 关闭弹出框口 */
function layer_close() {
	var index = parent.layer.getFrameIndex(window.name);
	parent.layer.close(index);
}

/* 时间 */
function getHTMLDate(obj) {
	var d = new Date();
	var weekday = new Array(7);
	var _mm = "";
	var _dd = "";
	var _ww = "";
	weekday[0] = "星期日";
	weekday[1] = "星期一";
	weekday[2] = "星期二";
	weekday[3] = "星期三";
	weekday[4] = "星期四";
	weekday[5] = "星期五";
	weekday[6] = "星期六";
	_yy = d.getFullYear();
	_mm = d.getMonth() + 1;
	_dd = d.getDate();
	_ww = weekday[d.getDay()];
	obj.html(_yy + "年" + _mm + "月" + _dd + "日 " + _ww);
};

$(function() {
	getHTMLDate($("#top_time"));
	getskincookie();
	// layer.config({extend: 'extend/layer.ext.js'});
	Huiasidedisplay();
	var resizeID;
	$(window).resize(function() {
		clearTimeout(resizeID);
		resizeID = setTimeout(function() {
			Huiasidedisplay();
		}, 500);
	});

	$(".nav-toggle").click(function() {
		$(".Hui-aside").slideToggle();
	});
	$(".Hui-aside").on("click", ".menu_dropdown dd li a", function() {
		if ($(window).width() < 768) {
			$(".Hui-aside").slideToggle();
		}
	});
	/* 左侧菜单 */
	$.Huifold(".menu_dropdown dl dt", ".menu_dropdown dl dd", "fast", 1,
			"click");

	/* 选项卡导航 */
	$(".Hui-aside").on("click", ".menu_dropdown a", function() {
		Hui_admin_tab(this);
	});

	$(document).on(
			"click",
			"#min_title_list li",
			function() {
				var bStopIndex = $(this).index();
				var iframe_box = $("#iframe_box");
				$("#min_title_list li").removeClass("active").eq(bStopIndex)
						.addClass("active");
				iframe_box.find(".show_iframe").hide().eq(bStopIndex).show();
			});
	$(document).on("click", "#min_title_list li i", function() {
		var aCloseIndex = $(this).parents("li").index();
		$(this).parent().remove();
		$('#iframe_box').find('.show_iframe').eq(aCloseIndex).remove();
		num == 0 ? num = 0 : num--;
		tabNavallwidth();
	});
	$(document).on(
			"dblclick",
			"#min_title_list li",
			function() {
				var aCloseIndex = $(this).index();
				var iframe_box = $("#iframe_box");
				if (aCloseIndex > 0) {
					$(this).remove();
					$('#iframe_box').find('.show_iframe').eq(aCloseIndex)
							.remove();
					num == 0 ? num = 0 : num--;
					$("#min_title_list li").removeClass("active").eq(
							aCloseIndex - 1).addClass("active");
					iframe_box.find(".show_iframe").hide().eq(aCloseIndex - 1)
							.show();
					tabNavallwidth();
				} else {
					return false;
				}
			});
	tabNavallwidth();

	$('#js-tabNav-next')
			.click(
					function() {
						num == oUl.find('li').length - 1 ? num = oUl.find('li').length - 1
								: num++;
						toNavPos();
					});
	$('#js-tabNav-prev').click(function() {
		num == 0 ? num = 0 : num--;
		toNavPos();
	});

	function toNavPos() {
		oUl.stop().animate({
			'left' : -num * 100
		}, 100);
	}

	/*换肤*/
	$("#Hui-skin .dropDown-menu a").click(
			function() {
				var v = $(this).attr("data-val");
				$.cookie("Huiskin", v);
				var hrefStr = $("#skin").attr("href");
				var hrefRes = hrefStr
						.substring(0, hrefStr.lastIndexOf('skin/'))
						+ 'skin/' + v + '/skin.css';
				alert(hrefRes)
				$(window.frames.document).contents().find("#skin").attr("href",
						hrefRes);
			});
});
