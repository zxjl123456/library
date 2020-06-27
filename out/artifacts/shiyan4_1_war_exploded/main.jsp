<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="bean.User" %><%--
  Created by IntelliJ IDEA.
  User: ZXJL
  Date: 2019/9/21
  Time: 13:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
当前登录用户：<s:property value="#session.user.userName"/>
<hr/>
<a href="AddBook.jsp">添加图书</a>
<a href="SearchBook.jsp">查询图书</a>查询图书
</body>
</html>
