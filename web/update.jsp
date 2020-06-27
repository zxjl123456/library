<%--
  Created by IntelliJ IDEA.
  User: ZXJL
  Date: 2019/10/9
  Time: 19:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="utf-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>修改书籍</title>
</head>
<body>
<h1>修改书籍信息</h1>
<s:fielderror fieldName="book.title" />
<s:fielderror fieldName="book.price" />
<s:form action="update" method="post" enctype="multipart/form-data">
    <s:textfield name="book.id"   label="书号"  readonly= "true"/>
    <s:textfield name="book.title" label="书名" />
    <s:textfield name="book.price" label="价格" />
    <s:file name="bookIntro" label="简介" />
    <s:textfield name="book.author.name" label="作者姓名" />
    <s:textfield name="book.author.tel" label="作者电话" />
    <s:textfield name="book.author.email" label="作者邮件" />
    <s:submit value="修改" />
</s:form>
<%--<s:form action="updateBook" method="post" enctype="multipart/form-data">
    <s:textfield name="book.isbn" label="书号" readonly="true" />
    <s:textfield name="book.title" label="书名" />
    <s:textfield name="book.author" label="作者" />
    <s:textfield name="book.price" label="价格" />
    <s:file name="bookIntro" label="简介" />
    <s:submit value="修改" />
</s:form>--%>
<s:property value="book.bookMessage"></s:property>
<a href="list">浏览查询</a><br>
<a href="main.jsp">返回主页</a></h2>
</body>
</html>
