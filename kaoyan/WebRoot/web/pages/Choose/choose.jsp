<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<html>
<head id="Head1">
    <%@ include file="/web/common/common.jsp" %>
<script type="text/javascript">
$(function () {
    $('#grid1').datagrid({
        title: '测试题列表',
        nowrap: false,
        striped: true,
        fit: true,
        url: "<%=__APP__%>/Choose!getList?leixing=1",
        idField: 'id',
        pagination: true,
        rownumbers: true,
        pageSize: 10,
        pageNumber: 1,
        singleSelect: true,
        fitColumns: true,
        pageList: [10, 20, 50, 100, 200, 300, 500, 1000],
        sortName: 'id',
        sortOrder: 'desc',
        columns: [
            [
                //{field: 'ck', checkbox: true},
                {title: 'id', width: 10, field: 'id', sortable: true},
                {title: '题目', width: 100, field: 'title', sortable: true}
            ]
        ], toolbar: [
            {
                text: '新增',
                id: "tooladd",
                disabled: false,
                iconCls: 'icon-add',
                handler: function () {
                    $("#action").val("add");
                    $("#managerDialog").dialog('open');
                    managForm.reset();
                }
            },
            '-',
            {
                text: '修改',
                id: 'tooledit',
                disabled: false,
                iconCls: 'icon-edit',
                handler: function () {
                    $("#action").val("edit");
                    var selected = $('#grid1').datagrid('getSelected');
                    if (selected) {
                        edit(selected);
                    } else {
                        $.messager.alert("提示", "请选择一条记录进行操作");
                    }
                }
            },
            '-',
            {
                text: '图表',
                id: 'commit',
                iconCls: 'icon-save',
                handler: function () {
                    $("#action").val("edit");
                    var selected = $('#grid1').datagrid('getSelected');
                    if (selected) {
                        showChart(selected);
                        var index = $('#grid1').datagrid('getRowIndex', selected);

                    } else {
                        $.messager.alert("提示", "请选择一条记录进行操作");
                    }
                }
            },
            '-',
            {
                text: '删除',
                id: 'tooldel',
                disabled: false,
                iconCls: 'icon-remove',
                handler: function () {
                    var rows = $('#grid1').datagrid('getSelections');
                    if (rows.length) {
                        var ids = "";
                        for (var i = 0; i < rows.length; i++) {
                            ids += rows[i].id + ",";
                        }
                        ids = ids.substr(0, (ids.length - 1));
                        $.messager.confirm('提示', '确定要删除吗？', function (r) {
                            if (r) {
                                deleteItem(ids);
                            }
                        });
                    } else {
                        $.messager.alert("提示", "请选择一条记录进行操作");
                    }
                }
            }
        ]
    });

    document.onkeydown=function (e){
        e = e ? e : event;
        if(e.keyCode == 13){
            query();
        }
    }
    
    $("#typeid").combobox({
        method:"get",
        url:'<%=__APP__%>/Good!typeList',
        valueField: 'id',
        textField: 'title'
    });
    
});

function save() {
    $('#managForm').form('submit', {
        url: "<%=__APP__%>/Choose!add",
        onSubmit: function () {
            return inputCheck();
        },
        success: function (data) {
            closeBackGround();
            $.messager.alert("提示", data, "info", function () {
                closeFlush();
            });
        }
    });
}

function edit(obj) {
	var id = obj.id;
    $("#id").val(id);
    $("#title").val(obj.title);
    $("#img2").val(obj.img);
    $("#daan").combobox("setValue",obj.daan);
    $("#typeid").val(obj.typeid);
    $("#opa").val(obj.opa);
    $("#opc").val(obj.opc);
    $("#opb").val(obj.opb);
    $("#opd").val(obj.opd);
    $("#leixing").val(obj.leixing);
    $("#fenxi").val(obj.fenxi);
    $("#managerDialog").dialog('open');
}

function deleteItem(uuid) {
    openBackGround();
    $.post("<%=__APP__%>/Choose!deleteItem", {id: uuid}, function (data) {
        closeBackGround();
        closeFlush();
    });
}

function cancel() {
    $.messager.confirm('提示', '是否要关闭？', function (r) {
        if (r) {
            closeFlush();
        }
    });
}

function query() {
    $('#grid1').datagrid('load', serializeObject($('#searchForm')));
}


function closeFlush() {
    managForm.reset();
    $("#managerDialog").dialog('close');
    $("#grid1").datagrid("reload");
}

function inputCheck() {
    if (!($("#managForm").form("validate"))) {
        return false;
    }
    openBackGround();
    return true;
}



function setNull(){
    searchForm.reset();
}

function showChart(obj){
    $("#chartdialog").dialog('open');
    refreshChart(obj);
    setInterval(function (){
        refreshChart(obj);
    },3000);

}

function refreshChart(obj){
    //$.post("<%=__APP__%>/Choose/getChoose",{id:obj.id},function(data){
        //data = JSON.parse(data);
        //obj = data;
        var o = obj;
        var data = obj;
        //obj.pac = (o.ac/(o.ac*1.00+ o.bc*1.00+ o.cc*1.00+ o.dc*1.00+ o.ec*1.00+ o.fc*1.00+ o.gc*1.00)).toFixed(2)*100;
        //obj.pbc = (o.bc/(o.ac*1.00+ o.bc*1.00+ o.cc*1.00+ o.dc*1.00+ o.ec*1.00+ o.fc*1.00+ o.gc*1.00)).toFixed(2)*100;
        //obj.pcc = (o.cc/(o.ac*1.00+ o.bc*1.00+ o.cc*1.00+ o.dc*1.00+ o.ec*1.00+ o.fc*1.00+ o.gc*1.00)).toFixed(2)*100;
        //obj.pdc = (o.dc/(o.ac*1.00+ o.bc*1.00+ o.cc*1.00+ o.dc*1.00+ o.ec*1.00+ o.fc*1.00+ o.gc*1.00)).toFixed(2)*100;


        var myChart = echarts.init(document.getElementById('mychat'));
        var option = {
            color: ['#3398DB'],
            tooltip : {
                trigger: 'axis',
                //formatter: "{a} <br/>{b}: {c} ({d}%)",
                axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                    type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                }
            },
            grid: {
                left: '3%',
                right: '4%',
                bottom: '3%',
                containLabel: true
            },
            xAxis : [
                {
                    type : 'category',
                    data : ['错误', '正确'],
                    axisTick: {
                        alignWithLabel: true
                    }
                }
            ],
            yAxis : [
                {
                    type : 'value'
                }
            ],
            series : [
                {
                    name:'正确率',
                    type:'bar',
                    barWidth: '60%',
                    data:[data.rc, data.wc]
                }
            ]
        };
        myChart.setOption(option);
    //});
}

</script>
</head>
<body class="easyui-layout">
<div region="north" border="false" style="height:3px;overflow: hidden"></div>
<div region="west" border="false" style="width:3px;"></div>
<div region="east" border="false" style="width:3px;"></div>
<div region="south" border="false" style="height:3px;overflow: hidden"></div>
<div region="center" border="false">
    <div id="main" class="easyui-layout" fit="true" style="width:100%;height:100%;">
        <div region="north" id="" style="height:100%;" class="" title="查询条件">
            <form action="" id="searchForm" name="searchForm" method="post">
                <table cellpadding="5" cellspacing="0" class="tb_search">
                    <tr>
                        <td width="10%">
                            <label for="sname">标题：</label>
                            <input type="text" id="stitle" name="stitle" width="100%" maxlength="32"/>
                        </td>
                        <td width="10%">
                            <a href="#" onclick="query();" id="querylink" class="easyui-linkbutton"
                               iconCls="icon-search">查询</a>
                            <a href="#" onclick="setNull();" class="easyui-linkbutton" iconCls="icon-redo">重置</a>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
        <div region="center" border="false" style="padding:3px 0px 0px 0px;overflow:hidden">

            <table id="grid1"></table>

        </div>
    </div>
</div>


<div id="managerDialog" class="easyui-dialog" title="测试题管理" style="width:450px;height:350px;" toolbar="#dlg-toolbar"
     buttons="#dlg-buttons2" resizable="true" modal="true" closed='true'>
    <form id="managForm" name="managForm" method="post" enctype="multipart/form-data">
        <input type="hidden" id="action" name="action"/>
        <input type="hidden" id="id" name="id"/>
        <input type="hidden" id="img2" name="choose.img"/>
        <input type="hidden" id="leixing" name="choose.leixing" value="1"/>
        <table cellpadding="1" cellspacing="1" class="tb_custom1">
            <tr>
                <th width="30%" align="right"><label>题目：</label></th>
                <td width="60%" colspan="1">
                    <input id="title" name="choose.title" class="easyui-validatebox"
                           style="width:300px;word-wrap: break-word;word-break:break-all;" type="text" required="true"
                           validType="length[0,100]"/>
                </td>
            </tr>
            
            <tr>
                <th width="30%" align="right"><label>图片视频：</label></th>
                <td width="60%" colspan="1">
                    <input id="img" name="img"
                           style="width:300px;word-wrap: break-word;word-break:break-all;" type="file" />
                </td>
            </tr>
			
            <tr>
                <th width="10%" align="right"><label>A：</label></th>
                <td width="30%">
                    <input  id="opa" name="choose.opa" class="easyui-validatebox"
                            style="width:200px;word-wrap: break-word;word-break:break-all;" type="text" required="true"
                            validType="length[0,50]"/>
                </td>
            </tr>
            <tr>
                <th width="10%" align="right"><label>B：</label></th>
                <td width="30%">
                    <input  id="opb" name="choose.opb" class="easyui-validatebox"
                            style="width:200px;word-wrap: break-word;word-break:break-all;" type="text" required="true"
                            validType="length[0,50]"/>
                </td>
            </tr>
            <tr>
                <th width="10%" align="right"><label>C：</label></th>
                <td width="30%">
                    <input  id="opc" name="choose.opc" class="easyui-validatebox"
                            style="width:200px;word-wrap: break-word;word-break:break-all;" type="text" required="true"
                            validType="length[0,50]"/>
                </td>
            </tr>
            <tr>
                <th width="10%" align="right"><label>D：</label></th>
                <td width="30%">
                    <input  id="opd" name="choose.opd" class="easyui-validatebox"
                            style="width:200px;word-wrap: break-word;word-break:break-all;" type="text" required="true"
                            validType="length[0,50]"/>
                </td>
            </tr>
            <tr>
                <th width="10%" align="right"><label>答案：</label></th>
                <td width="30%">
                    <select name="choose.daan" id="daan" class="easyui-combobox" panelHeight="200"
                            style="width:200px;word-wrap: break-word;word-break:break-all;" type="text" required="true"
                            validType="length[0,32]">
                        <option value="a" selected="selected">A</option>
                        <option value="b">B</option>
                        <option value="c">C</option>
                        <option value="d">D</option>
                    </select>
                </td>
            </tr>
            <tr>
            <th width="30%" align="right"><label>分类：</label></th>
                <td width="30%">                   	
                    <select id="typeid" name="choose.typeid" style="width:200px;word-wrap: break-word;word-break:break-all;" >
                    	<!-- <option value="1">科目1</option>
            
                    	<option value="4">科目4</option> -->
                    </select>
                </td>
            </tr>    
             
            <tr>
                <th width="10%" align="right"><label>分析：</label></th>
                <td width="30%">
                    <textarea id="fenxi" name="choose.fenxi" style="width:200px;">
                    	
                    </textarea>
                </td>
            </tr>
        </table>


    </form>
    <div id="dlg-buttons2">
        <a href="#" class="easyui-linkbutton" onclick="save();">保存</a>
        <a href="#" class="easyui-linkbutton" onclick="cancel();">取消</a>
    </div>
</div>


<div id="chartdialog" class="easyui-dialog" title="柱状图" style="width:650px;height:450px;" toolbar="#dlg-toolbar"
     resizable="true" modal="true" closed='true'>

    <div id="mychat" style="width: 600px;height:400px;"></div>
</div>
<script type="text/javascript" src="<%=__APP__ %>/web/public/js/echarts.min.js"></script>
</body>
</html>