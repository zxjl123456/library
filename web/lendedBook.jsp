<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: ZXJL
  Date: 2019/11/12
  Time: 20:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>已借阅的图书</title>
</head>
<body>
<table border="1" width="800" style="font-size:16pt;">

<tr align="center">
    <th>编号</th>
    <th>借书者</th>
    <th>书名</th>
    <th>借书日期</th>
    <th colspan="3" align="center">操作</th>
</tr>
<s:iterator value="lends">
    <tr>

    <td><s:property value="id" /></td>
    <td><s:property value="userName" /></td>
    <td><s:property value="title" /></td>
    <td><s:property value="ltime" /></td>
        <td><a href="<s:url action='returnBook'>
								<s:param name='lend.id' value='id' />
							 </s:url>">
            还书
        </a>
    </tr>
    </s:iterator>
</table>
</body>
</html>
