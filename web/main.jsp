<%@ page pageEncoding="utf-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head><title>书籍管理系统主页</title></head>
<body>
<h1>当前登录用户：<s:property value="#session.user.userName" />[<a href="logout">注销</a>]</h1>
<hr>
<s:if test="#session.user.userName=='admin'">
<h2>
  1.<a href="AddBook.jsp">添加书籍</a><br/>
  2.<a href="SearchBook.jsp">查询书籍</a><br/>
  3.<a href="list.action">浏览书籍</a>
</h2>
</s:if>
<s:else>
	<h2><a href="list.action">浏览图书</a><br/>
    <a href="lendedList.action">已借图书</a></h2>


</s:else>
</body>
</html>