
<%@ page language="java" contentType="text/html; charset=utf-8" import="java.util.List" import="java.util.Map"
pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=urf-8">
        <title>调度任务列表</title>
        <style type="text/css">@import url('<%=request.getContextPath()%>/styles/home.css');
        </style>
		 <script type="text/javascript" src="<%=request.getContextPath()%>/components/jquery/jquery-1.3.2.min.js">
        </script>
		<script type="text/javascript">
		function doCmd(state,triggerName,group,triggerState){
			if(state == 'pause' && triggerState=='PAUSED'){
				alert("该Trigger己经暂停！");
				return;
			}
			
		    if(state == 'resume' && triggerState != 'PAUSED'){
				alert("该Trigger正在运行中！");
				return;
			}
			
			//客户端两次编码，服务端再解码，否测中文乱码 
			triggerName = encodeURIComponent(encodeURIComponent(triggerName));
			group = encodeURIComponent(encodeURIComponent(group));
            $.ajax({
                url: '<%=request.getContextPath()%>/JobProcessServlet?jobtype=200&action='+state+'&triggerName='+triggerName+'&group='+group,
                type: 'post',
                //dataType: 'xml',
               // timeout: 3000,
                error: function(){
                   alert("执行失败！");		
                },
                success: function(xml){
					if (xml == 0) {
						alert("执行成功！");
						window.location.reload();
					}else{
						alert("执行失败！");	
					}		   
                }
            });
		}
		</script>
		<!-- Bootstrap -->
    <link href="http://cdn.bootcss.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
		
    </head>
    
    <body>
     <p><h3><a href="<%=request.getContextPath()%>/JobProcessServlet?jobtype=100&action=query">查询定时任务</a>
     &nbsp;&nbsp; &nbsp;&nbsp;
   <a href="<%=request.getContextPath()%>">新增定时任务</a></h3></p>
    <fieldset>
      <pre>
        <h1 align="center" ><strong>定时任务查询页</strong></h1>
      </pre>
    </fieldset>

    <br/><br/>
    	<table bgcolor="lightblue" width="1000" height="100" align="center" style="border-collapse: collapse;" border="1" bordercolor="#006699">

            <tr>
                <th nowrap>
                    Trigger 名称
                </th>
                <th nowrap>
                    Trigger 分组
                </th>
                <th nowrap>
                    下次执行时间
                </th>
                <th nowrap>
                    上次执行时间
                </th>
                <th nowrap>
                    优先级
                </th>
                <th nowrap>
                    Trigger 状态
                </th>
                <th nowrap>
                    Trigger 类型
                </th>
                <th nowrap>
                    开始时间
                </th>
                <th nowrap>
                    结束时间
                </th>
                <th nowrap>
                    动作命令
                </th>
            </tr>
            
            <%List list=(List)request.getAttribute("list"); 
            for(int i=0;i<list.size();i++)
            {
                Map map=(Map)list.get(i);%>
                            <tr>
                    <td nowrap>
                   <%=map.get("display_name") %> 
                    </td>
                    <td nowrap>
                     <%=map.get("trigger_group") %> 
                    </td>
                    <td nowrap>
                     <%=map.get("next_fire_time") %> 
                    </td>
                    <td nowrap>
                     <%=map.get("prev_fire_time") %> 
                    </td>
                    <td nowrap>
                    <%=map.get("priority") %> 
                    </td>
                    <td nowrap>
                      <%=map.get("trigger_state") %> 
                    </td>
                    <td nowrap>
                    <%=map.get("trigger_type") %> 
                    </td>
                    <td nowrap>
                     <%=map.get("start_time") %> 
                    </td>
                    <td nowrap>
                      <%=map.get("end_time") %> 
                    </td>
                    <td nowrap>
                    	<input type="button" id="pause" value="暂停" onclick="doCmd('pause','<%=map.get("trigger_name") %>' ,'<%=map.get("trigger_group") %>','<%=map.get("trigger_state")%>')">
                    	<input type="button" id="pause" value="恢复" onclick="doCmd('resume','<%=map.get("trigger_name") %>' ,'<%=map.get("trigger_group") %>','<%=map.get("trigger_state") %>')">
                    	<input type="button" id="pause" value="删除" onclick="doCmd('remove','<%=map.get("trigger_name") %>' ,'<%=map.get("trigger_group") %>','<%=map.get("trigger_state") %>')">
                    </td>
                </tr>
            <%} %>
<!--            <c:forEach var="map" items="${list}">-->
<!--                <tr>-->
<!--                    <td nowrap>-->
<!--                    	${map.display_name}-->
<!--                    </td>-->
<!--                    <td nowrap>-->
<!--                    	${map.trigger_group}-->
<!--                    </td>-->
<!--                    <td nowrap>-->
<!--                    	${map.next_fire_time}-->
<!--                    </td>-->
<!--                    <td nowrap>-->
<!--                    	${map.prev_fire_time}-->
<!--                    </td>-->
<!--                    <td nowrap>-->
<!--                    	${map.priority}-->
<!--                    </td>-->
<!--                    <td nowrap>-->
<!--                    	${map.statu}-->
<!--                    </td>-->
<!--                    <td nowrap>-->
<!--                    	${map.trigger_type}-->
<!--                    </td>-->
<!--                    <td nowrap>-->
<!--                    	${map.start_time}-->
<!--                    </td>-->
<!--                    <td nowrap>-->
<!--                    	${map.end_time}-->
<!--                    </td>-->
<!--                    <td nowrap>-->
<!--                    	<input type="button" id="pause" value="暂停" onclick="doCmd('pause','${map.trigger_name}','${map.trigger_group}','${map.trigger_state}')">-->
<!--						<input type="button" id="resume" value="恢复" onclick="doCmd('resume','${map.trigger_name}','${map.trigger_group}','${map.trigger_state}')">-->
<!--						<input type="button" id="remove" value="删除" onclick="doCmd('remove','${map.trigger_name}','${map.trigger_group}','${map.trigger_state}')">						-->
<!--                    </td>-->
<!--                </tr>-->
<!--            </c:forEach>-->

        </table>
    </body>
</html>
