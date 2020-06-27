<%@ page pageEncoding="utf-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<html>
<head><title>查询图书</title></head>
<body>
<form action="find" method="post">
    书名：<input type="text" name="book.title" size="20" /><br>
    <input type="submit" value="查询" />
    <input type="reset" value="重置" />
</form>
</body>
</html>