<%@ page pageEncoding="utf-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<html>
<head><title>添加书籍</title></head>
<body>
<s:fielderror fieldName="book.title" />
<s:fielderror fieldName="book.price" />
<form action="add" method="post">
    书名：<input type="text" name="book.title" size="20" /><br>
    价格：<input type="text" name="book.price" size="20" /><br>
    <input type="submit" value="添加" />
    <input type="reset" value="重置" />
</form>
</body>
</html>