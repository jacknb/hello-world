<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="scripts/jquery-1.4.4.min.js"></script>
<title>JS无级树树形菜单,json格式，数组格式通用</title>
<style type="text/css">
.menuTree {
	
}

.menuTree div {
	width: 180px;
	/*float:left;*/
}

.menuTree div ul {
	overflow: hidden;
	display: none;
	height: auto;
}

.menuTree span {
	display: block;
	height: 25px;
	line-height: 25px;
	padding-left: 5px;
	margin: 1px 0;
	cursor: pointer;
	border-bottom: 1px solid #CCC;
}

.menuTree span:hover {
	background-color: #e6e6e6;
	color: #cf0404;
}

.menuTree a {
	color: #333;
	text-decoration: none;
}

.menuTree a:hover {
	color: #06F;
}

.btn {
	height: 30px;
	margin-top: 10px;
	border-bottom: 1px solid #CCC;
}
</style>
</head>
<body>
	<div class="btn">
		<input name="" type="button" id="btn_open" value="全部展开" /> <input
			name="" type="button" id="btn_close" value="全部收缩" />
	</div>
	<div id="menuTree" class="menuTree"></div>
</body>
</html>
<script type="text/javascript">
	/*var json = {"navnums": 
	 { "0": "8051", 
	 "4": "4969", 
	 "8": "206", 
	 "5": "126", 
	 "9": "2174" 
	 }, 
	 "hotwords": "美食", 
	 "mvonline": [9, 8, [9, 8, 7, 6, 5, 4], 6, 5, 4], 
	 "district_online": "1", 
	 "zone_online": "1", 
	 "subway_online": "1", 
	 "city_online": "1" 
	 }; 
	 */
	var json = [ {
		"checked" : false,
		"children" : [
				{
					"checked" : false,
					"children" : [
							{
								"checked" : false,
								"children" : [
										{
											"checked" : false,
											"children" : [],
											"moduleId" : "tree1111",
											"nodeId" : "psrw_zhcx3",
											"nodeName" : "子树1111",
											"parentId" : "tree111",
											"state" : "open",
											"target" : "",
											"url" : "{$systemparams.basepath}report!reportList.action?typeGuid=f814df94-2db8-4544-bd7c-ca8f8a6425b6<subst>={$rwid}"
										},
										{
											"checked" : false,
											"children" : [],
											"moduleId" : "tree1112",
											"nodeId" : "report_XMXX",
											"nodeName" : "子树1112",
											"parentId" : "tree111",
											"state" : "open",
											"target" : "",
											"url" : "{$systemparams.basepath}report!reportList.action?typeGuid=d89e2b89-ae82-6159-1787-b06d30b93626"
										} ],
								"moduleId" : "tree111",
								"nodeId" : "rwgl_psrw_rwinfo",
								"nodeName" : "子树111",
								"parentId" : "tree11",
								"state" : "open",
								"target" : "",
								"url" : "{$systemparams.basepath}psrw!psRwInfoEdit.action?rwid={$rwid}"
							},
							{
								"checked" : false,
								"children" : [
										{
											"checked" : false,
											"children" : [],
											"moduleId" : "tree1121",
											"nodeId" : "report_TJFX",
											"nodeName" : "子树1121",
											"parentId" : "tree112",
											"state" : "open",
											"target" : "",
											"url" : "{$systemparams.basepath}report!reportList.action?typeGuid=ac0aae30-f6c3-4b1b-aaba-ddafde017590"
										},
										{
											"checked" : false,
											"children" : [],
											"moduleId" : "tree1122",
											"nodeId" : "report_SBSJ",
											"nodeName" : "子树1122",
											"parentId" : "tree112",
											"state" : "open",
											"target" : "",
											"url" : "{$systemparams.basepath}report!reportList.action?typeGuid=aae13201-f6c3-4b1b-aaba-afde01759103"
										} ],
								"moduleId" : "tree112",
								"nodeId" : "rwgl_psrw_psxm",
								"nodeName" : "子树112",
								"parentId" : "tree11",
								"state" : "open",
								"target" : "",
								"url" : "{$systemparams.basepath}psrw!psxmlist.action?rwid={$rwid}"
							} ],
					"moduleId" : "tree11",
					"nodeId" : "report_XMXX",
					"nodeName" : "子树11",
					"parentId" : "tree1",
					"state" : "open",
					"target" : "",
					"url" : "{$systemparams.basepath}report!reportList.action?typeGuid=d89e2b89-ae82-6159-1787-b06d30b93626"
				},
				{
					"checked" : false,
					"children" : [
							{
								"checked" : false,
								"children" : [
										{
											"checked" : false,
											"children" : [],
											"moduleId" : "tree1211",
											"nodeId" : "rwgl_psrw_rwinfo",
											"nodeName" : "子树1211",
											"parentId" : "tree121",
											"state" : "open",
											"target" : "",
											"url" : "{$systemparams.basepath}psrw!psRwInfoEdit.action?rwid={$rwid}"
										},
										{
											"checked" : false,
											"children" : [],
											"moduleId" : "tree1212",
											"nodeId" : "rwgl_psrw_psxm",
											"nodeName" : "子树1212",
											"parentId" : "tree121",
											"state" : "open",
											"target" : "",
											"url" : "{$systemparams.basepath}psrw!psxmlist.action?rwid={$rwid}"
										} ],
								"moduleId" : "tree121",
								"nodeId" : "psrw_zjfp3",
								"nodeName" : "子树121",
								"parentId" : "tree12",
								"state" : "open",
								"target" : "",
								"url" : "{$systemparams.zjfpurl}{$rwid}"
							},
							{
								"checked" : false,
								"children" : [],
								"moduleId" : "tree122",
								"nodeId" : "psrw_jghz3",
								"nodeName" : "子树122",
								"parentId" : "tree12",
								"state" : "open",
								"target" : "",
								"url" : "{$systemparams.basepath}psrw!psrwjghzlist.action?rwid={$rwid}"
							} ],
					"moduleId" : "tree12",
					"nodeId" : "report_TJFX",
					"nodeName" : "子树12",
					"parentId" : "tree1",
					"state" : "open",
					"target" : "",
					"url" : "{$systemparams.basepath}report!reportList.action?typeGuid=ac0aae30-f6c3-4b1b-aaba-ddafde017590"
				},
				{
					"checked" : false,
					"children" : [
							{
								"checked" : false,
								"children" : [],
								"moduleId" : "tree131",
								"nodeId" : "psrw_qrrwxm3",
								"nodeName" : "子树131",
								"parentId" : "tree13",
								"state" : "open",
								"target" : "",
								"url" : "{$systemparams.basepath}psrw!pschoosexmlist.action?rwid={$rwid}<subst>=4"
							},
							{
								"checked" : false,
								"children" : [],
								"moduleId" : "tree132",
								"nodeId" : "psrw_jggs3",
								"nodeName" : "子树132",
								"parentId" : "tree13",
								"state" : "open",
								"target" : "",
								"url" : "{$systemparams.basepath}psrw!psrwwlgslist.action?rwid={$rwid}"
							} ],
					"moduleId" : "tree13",
					"nodeId" : "report_SBSJ",
					"nodeName" : "子树13",
					"parentId" : "tree1",
					"state" : "open",
					"target" : "",
					"url" : "{$systemparams.basepath}report!reportList.action?typeGuid=aae13201-f6c3-4b1b-aaba-afde01759103"
				} ],
		"moduleId" : "tree1",
		"nodeId" : "report_XMXX",
		"nodeName" : "树1",
		"parentId" : "0",
		"state" : "open",
		"target" : "",
		"url" : "{$systemparams.basepath}report!reportList.action?typeGuid=d89e2b89-ae82-6159-1787-b06d30b93626"
	} ];
	var json1 = [ {
		"id" : "id1",
		"name" : "name1",
		"url" : "url1",
		"target" : "_blank",
		"nodes" : [ {
			"id" : "id11",
			"name" : "name11",
			"url" : "url11",
			"target" : "_blank",
			"nodes" : []
		}, {
			"id" : "id12",
			"name" : "name12",
			"url" : "url12",
			"nodes" : []
		} ]
	}, {
		"id" : "id2",
		"name" : "name2",
		"url" : "url2",
		"nodes" : [ {
			"id" : "id21",
			"name" : "name21",
			"url" : "url21",
			"nodes" : [ {
				"id" : "id211",
				"name" : "name211",
				"url" : "url211",
				"target" : "_blank",
				"nodes" : []
			} ]
		}, {
			"id" : "id22",
			"name" : "name22",
			"url" : "url22",
			"target" : "_blank",
			"nodes" : [ {
				"id" : "id221",
				"name" : "name221",
				"url" : "url221",
				"target" : "_blank",
				"nodes" : []
			} ]
		} ]
	}, {
		"id" : "id3",
		"name" : "name3",
		"url" : "url3",
		"target" : "",
		"nodes" : []
	} ];
	/*递归实现获取无级树数据并生成DOM结构*/
	var str = "";
	
	var forTree = function(o){
		var urlstr = "";
		for(var i=0;i < o.length;i++){
			if(o[i].children.length > 0){
				urlstr = "<div><span>"
					+ "<a href=\""+o[i].moduleId+"\" target=\""+o[i].target + "\">"
					+ o[i].nodeName + "</a></span><ul>";
			}else{
				urlstr = "<div><span>"
					+ "<a href=\""+o[i].moduleId+"\" target=\""+o[i].target + "\">"
					+ o[i].nodeName + "</a></span><ul>";
			}
			str+=urlstr;
			forTree(o[i].children);
			str+="</ul></div>"
		}
		return str;
	}
	
	var forTree1 = function(o) {
		var urlstr = "";
		for (var i = 0; i < o.length; i++) {
			//alert(root[i].id);
			//alert(o[i].id);	
			//
			if (o[i].nodes.length > 0) {
				urlstr = "<div><span>"
						+ "<a href=\""+o[i].url+"\" target=\""+o[i].target + "\">"
						+ o[i].name + "</a></span><ul>";
			} else {
				urlstr = "<div><span>"
						+ "<a href=\""+o[i].url+"\" target=\""+o[i].target + "\">"
						+ o[i].name + "</a></span><ul>";
			}
			str += urlstr;

			forTree(o[i].nodes);

			str += "</ul></div>";
		}
		return str;
	}
	/*添加无级树*/
	document.getElementById("menuTree").innerHTML = forTree(json);
	/*树形菜单*/
	var menuTree = function() {
		//给有子对象的元素加[+-] 
		$("#menuTree ul").each(function(index, element) {
			var ulContent = $(element).html();
			var spanContent = $(element).siblings("span").html();
			if (ulContent) {
				$(element).siblings("span").html("[+] " + spanContent)
			}
		});

		$("#menuTree").find("div span").click(function() {
			var ul = $(this).siblings("ul");
			var spanStr = $(this).html();
			var spanContent = spanStr.substr(3, spanStr.length);
			if (ul.find("div").html() != null) {
				if (ul.css("display") == "none") {
					ul.show(300);
					$(this).html("[-] " + spanContent);
				} else {
					ul.hide(300);
					$(this).html("[+] " + spanContent);
				}
			}
		})
	}();

	/*展开*/
	$("#btn_open").click(function() {
		$("#menuTree ul").show(300);
		curzt("-");
	})
	/*收缩*/
	$("#btn_close").click(function() {
		$("#menuTree ul").hide(300);
		curzt("+");
	})
	function curzt(v) {
		$("#menuTree span").each(function(index, element) {
			var ul = $(this).siblings("ul");
			var spanStr = $(this).html();
			var spanContent = spanStr.substr(3, spanStr.length);
			if (ul.find("div").html() != null) {
				$(this).html("[" + v + "] " + spanContent);
			}
		});
	}
</script>