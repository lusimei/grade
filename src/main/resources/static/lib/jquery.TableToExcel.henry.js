/*-----------H-ui前端框架-------------
 * jquery.TableToExcel.henry v1.0
 * Created & henry 
 * Date modified s2018-01-11 
 *
 */

var idTmr;

function getExplorer() {
	var explorer = window.navigator.userAgent;
	if (explorer.indexOf("Firefox") >= 0) {
		return 'Firefox';
	}
	//Chrome
	else if (explorer.indexOf("Chrome") >= 0) {
		return 'Chrome';
	}
	//Opera
	else if (explorer.indexOf("Opera") >= 0) {
		return 'Opera';
	}
	//Safari
	else if (explorer.indexOf("Safari") >= 0) {
		return 'Safari';
	} else {
		return 'ie';
	}
}

function tableToExcel(tableid, tablename) { //整个表格拷贝到EXCEL中
	if (tablename == null) {
		tablename = "報表";
	}
	var curTbl = document.getElementById(tableid);
	if (getExplorer() == 'ie') {
		var oXL;
		try {
			oXL = new ActiveXObject("Excel.Application");
		} catch (e) { //IE安全级别未设置将出现错误 （ Automation 服务器不能创建对象 ） 
			/* 
		如果是Scripting.FileSystemObject (FSO 文本文件读写)被关闭了，开启FSO功能即可，在“运行”中执行regsvr32 scrrun.dll即可 
		*/
			alert("無法啟動Excel!\n\n如果您確信您的電腦中已經安裝了Excel，" + "那麼請調整IE的安全級別。\n\n具體操作：\n\n" + "工具 → Internet選項 → 安全 → 自訂級別 → 對沒有標記為安全的ActiveX進行初始化和腳本運行 → 啟用");
			return false;
		}

		//创建AX对象excel
		var oWB = oXL.Workbooks.Add();
		//获取workbook对象
		var xlsheet = oWB.Worksheets(1);
		//激活当前sheet
		var sel = document.body.createTextRange();
		sel.moveToElementText(curTbl);
		//把表格中的内容移到TextRange中
		sel.select;
		//全选TextRange中内容
		sel.execCommand("Copy");
		//复制TextRange中内容
		xlsheet.Paste();
		//粘贴到活动的EXCEL中
		oXL.Visible = true;
		//设置excel可见属性

		try {
			var fname = oXL.Application.GetSaveAsFilename(tablename + ".xls", "Excel Spreadsheets (*.xls), *.xls");
		} catch (e) {
			print("Nested catch caught " + e);
		} finally {
			oWB.SaveAs(fname);

			oWB.Close(savechanges = false);
			//xls.visible = false;
			oXL.Quit();
			oXL = null;
			//结束excel进程，退出完成
			//window.setInterval("Cleanup();",1);
			idTmr = window.setInterval("Cleanup();", 1);
		}
	} else {
		table2excel(tableid, tablename);
	}
}

function Cleanup() {
	window.clearInterval(idTmr);
	CollectGarbage();
}

var table2excel = (function() {
	var uri = 'data:text/xls;charset=utf-8,\ufeff,',
		template = '<html xmlns:o="urn:schemas-microsoft-com:office:office" xmlns:x="urn:schemas-microsoft-com:office:excel" xmlns="http://www.w3.org/TR/REC-html40"><head><!--[if gte mso 9]><xml><x:ExcelWorkbook><x:ExcelWorksheets><x:ExcelWorksheet><x:Name>{worksheet}</x:Name><x:WorksheetOptions><x:DisplayGridlines/></x:WorksheetOptions></x:ExcelWorksheet></x:ExcelWorksheets></x:ExcelWorkbook></xml><![endif]--></head><body><table>{table}</table></body></html>',
		base64 = function(s) {
			return window.btoa(encodeURIComponent(s))
		},
		format = function(s, c) {
			return s.replace(/{(\w+)}/g,
				function(m, p) {
					return c[p];
				}
			)
		}
	return function(table, name) {
		if (!table.nodeType)
			table = document.getElementById(table)
		var ctx = {
				worksheet: "sheet1" || 'Worksheet',
				table: table.innerHTML
			}
			//window.location.href = uri + base64(format(template, ctx))

		var downloadLink = document.createElement("a");
		downloadLink.href = uri + format(template, ctx);
		downloadLink.download = name + '.xls';
		document.body.appendChild(downloadLink);
		downloadLink.click();
		document.body.removeChild(downloadLink);
	}
})()