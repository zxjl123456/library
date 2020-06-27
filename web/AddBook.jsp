<%@ page pageEncoding="utf-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<html>
<head><title>添加书籍0990</title></head>
<body>
<s:form action="add" method="post" enctype="multipart/form-data">
    <s:textfield id="book.id" name="book.id"   label="书号" ></s:textfield>
    <s:textfield id="book.title" name="book.title" label="书名" ></s:textfield>
    <s:textfield id="book.price" name="book.price" label="价格"></s:textfield>
    <s:file name="bookIntro" label="简介"></s:file>
    <s:textfield name="book.author.name" label="作者姓名" ></s:textfield>
    <s:textfield name="book.author.tel" label="作者电话" ></s:textfield>
    <s:textfield name="book.author.email" label="作者邮件" ></s:textfield>
    <s:submit value="添加" /><s:reset value="重置"/>
</s:form>
<s:property  value="bookMessage"></s:property>
<s:debug></s:debug>
</body>
</html>