<%@ page pageEncoding="utf-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head><title>添加图书失败</title></head>
<body>
<h1>当前登录用户：<s:property value="#session.user.userName" /></h1>
<hr>
<h2>
    添加书籍失败！<p>
    <a href="main.jsp">返回主页</a>
</h2>
</body>
</html>