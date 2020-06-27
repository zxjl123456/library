<%@ page pageEncoding="utf-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head><title>成功查询书籍</title></head>
<body>
<h1>当前登录用户：<s:property value="#session..nuseuserName" /></h1>
<hr>
<h2>
    成功查询课程：<s:property value="book.title"/>（<s:property value="book.price"/>），${book.id}主键<p>
    <a href="main.jsp">返回主页</a>
</h2>
</body>
</html>