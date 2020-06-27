<%@ page pageEncoding="utf-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head><title>成功查询书籍</title></head>
<body>
<h1>当前登录用户：<s:property value="#session..nuseuserName" /></h1>
<hr>
<h2>
    <%--成功查询课程：<s:property value="book.title"/>（<s:property value="book.price"/>），${book.id}主键<p>--%>

  <table>
      <tr>
          <th>书号</th><th>价格</th><th>简介</th><th>作者</th>
      </tr>
      <s:iterator value="books">
          <tr>
              <td><s:property value="id"></s:property> </td>
              <td><s:property value="title"></s:property> </td>
              <td><s:property value="intro"></s:property> </td>
              <td><s:property value="author.name"></s:property> </td>
          </tr>
      </s:iterator>
  </table>

    <a href="main.jsp">返回主页</a>
</h2>
</body>
</html>