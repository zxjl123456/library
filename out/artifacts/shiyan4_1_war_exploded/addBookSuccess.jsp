<%@ page pageEncoding="utf-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head><title>成功添加图书</title></head>
<body>
<h1>当前登录用户：<s:property value="#session..user.userName" /></h1>
<hr>
<h2>
    成功添加课程：<br/>
    书名：<s:property value="title"/><br/>
    价格：<s:property value="price"/><p>
    <a href="main.jsp">返回主页</a>
</h2>
</body>
</html>