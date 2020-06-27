<%@ page pageEncoding="utf-8" import="bean.User"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
    <title>用户登录</title>
</head>
<body>
<s:fielderror fieldName="user.userName" />
<s:fielderror fieldName="user.passWord" />
<form action="login.action" method="post">
    用户名：<input type="text" name="user.userName"  size="20" /><br>
    密码：<input type="password" name="user.passWord" size="20" /><br>
    <input type="submit" value="登录" />
    <input type="reset" value="重置" />
</form>
</body>
</html>