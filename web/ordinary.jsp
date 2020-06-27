<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: ZXJL
  Date: 2019/11/12
  Time: 20:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>普通用户页面</title>
</head>
<body>
<h1>当前登录用户：<s:property value="#session.user.userName" />[<a href="logout">注销</a>]</h1>
<hr/>
<a href="list.action">查阅图书</a>
<a href="lendedBook.jsp">已借阅图书</a>
</body>
</html>
