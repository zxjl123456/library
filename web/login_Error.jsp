<%@ page pageEncoding="utf-8" import="bean.User"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
    <title>用户登录错误</title>
</head>
<body>
<s:actionerror/>
<s:actionmessage />
${userMessage}，请重新<a href="login.jsp" >登录</a>！
<s:debug />
</body>
</html>