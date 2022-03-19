<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>

<%@ page import="javax.security.auth.message.callback.PrivateKeyCallback" %>
<%@ page import="com.neuron.etl.util.*" %><%--
  Created by IntelliJ IDEA.
  User: FengJie
  Date: 2021/4/13
  Time: 0:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String[] x={"星期一","星期二","星期三","星期四","星期五","星期六","星期天"};
    String[] d={"上午","下午","晚上"};
    String[] v={"第一大节","第二大节","第三大节","第四大节","第五大节"};
    String[] k={"one","two","three","four","five"};
    String[] l={"第1节","第2节","第3节","第4节","第5节","第6节","第7节","第8节","第9节"};
    String[] cs= publicData.JSP_COURSE;
    int cos=-1;
    int i=0;
    int a=0;
%>
<html>
<head>
    <title>课表</title>
    <link href="css\inpus.css" type="text/css" rel="stylesheet"/>
</head>

<body>
      <%
          String u= request.getParameter("user_son");
          String p=request.getParameter("user_pass");
          if (u==null||p==null){
              u="0";
              p="0";
          }
          String[] strings={u,p};
          Map<String,Object> jsonObject= Jpyhton.transimtData(publicData.P,strings);
          System.out.println(jsonObject);
      %>
    <div class="tbs">
        <table border="1" class="course">
            <tr>
                <th><span>时间</span></th>
                <th><%=x[i++]%></th>
                <th><%=x[i++]%></th>
                <th><%=x[i++]%></th>
                <th><%=x[i++]%></th>
                <th><%=x[i++]%></th>
                <th><%=x[i++]%></th>
                <th><%=x[i++]%></th>
            </tr>
            <tr>
                <th><%=v[a++]%></th>
                <td><%=jsonObject.get(cs[++cos])%></td>
                <td><%=jsonObject.get(cs[++cos])%></td>
                <td><%=jsonObject.get(cs[++cos])%></td>
                <td><%=jsonObject.get(cs[++cos])%></td>
                <td><%=jsonObject.get(cs[++cos])%></td>
                <td><%=jsonObject.get(cs[++cos])%></td>
                <td><%=jsonObject.get(cs[++cos])%></td>
            </tr>
            <tr>
                <th><%=v[a++]%></th>
                <td><%=jsonObject.get(cs[++cos])%></td>
                <td><%=jsonObject.get(cs[++cos])%></td>
                <td><%=jsonObject.get(cs[++cos])%></td>
                <td><%=jsonObject.get(cs[++cos])%></td>
                <td><%=jsonObject.get(cs[++cos])%></td>
                <td><%=jsonObject.get(cs[++cos])%></td>
                <td><%=jsonObject.get(cs[++cos])%></td>
            </tr>
            <tr>
                <th><%=v[a++]%></th>
                <td><%=jsonObject.get(cs[++cos])%></td>
                <td><%=jsonObject.get(cs[++cos])%></td>
                <td><%=jsonObject.get(cs[++cos])%></td>
                <td><%=jsonObject.get(cs[++cos])%></td>
                <td><%=jsonObject.get(cs[++cos])%></td>
                <td><%=jsonObject.get(cs[++cos])%></td>
                <td><%=jsonObject.get(cs[++cos])%></td>
            </tr>
            <tr>
                <th><%=v[a++]%></th>
                <td><%=jsonObject.get(cs[++cos])%></td>
                <td><%=jsonObject.get(cs[++cos])%></td>
                <td><%=jsonObject.get(cs[++cos])%></td>
                <td><%=jsonObject.get(cs[++cos])%></td>
                <td><%=jsonObject.get(cs[++cos])%></td>
                <td><%=jsonObject.get(cs[++cos])%></td>
                <td><%=jsonObject.get(cs[++cos])%></td>
            </tr>
            <tr>
                <th><%=v[a++]%></th>
                <td><%=jsonObject.get(cs[++cos])%></td>
                <td><%=jsonObject.get(cs[++cos])%></td>
                <td><%=jsonObject.get(cs[++cos])%></td>
                <td><%=jsonObject.get(cs[++cos])%></td>
                <td><%=jsonObject.get(cs[++cos])%></td>
                <td><%=jsonObject.get(cs[++cos])%></td>
                <td><%=jsonObject.get(cs[++cos])%></td>
            </tr>
            <tr>

            </tr>
        </table>
    </div>
</body>
</html>
