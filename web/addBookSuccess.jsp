<%@ page pageEncoding="utf-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head><title>成功添加图书</title></head>
<body>
<h1>当前登录用户：<s:property value="#session.user.userName" /></h1>
<hr>
<h2>
    成功添加图书：<br/>
    书名：<s:property value="book.title"/><br/>
    价格：<s:property value="book.price"/><br/>
    文件名：<s:property value="bookIntroFileName"/>
    <a href="main.jsp">返回主页</a>
</h2>
</body>
</html>