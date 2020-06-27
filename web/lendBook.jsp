<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
    <title>借阅书籍</title>
</head>
<body>
<h2>借阅书籍</h2>
<s:form action=" " method="post" theme="simple">
    搜索条件：<s:textfield name="condition" />
    <s:hidden name="user.userName" value="%{#session.usr.name}" />
    <s:hidden name="message" value=""/>
    <s:submit value="查询" />
</s:form>
<table border="0" width="500">
    <tr align="left">
        <th>图书编号</th>
        <th>图书名称</th>
        <th>图书价格</th>
        <th>作者姓名</th>
        <th colspan="2" align="center">操作</th>
    </tr>
    <s:iterator value="books">
        <tr>
            <td><s:property value="isbn" /></td>
            <td><s:property value="title" /></td>
            <td><s:property value="price" /></td>
            <td><s:property value="author.name" /></td>
            <td><a href="<s:url action='readBookIntroByReader' >
									<s:param name='book.intro' value='intro' />
								</s:url>">简介
            </a>
            </td>
            <td><a href="<s:url action='lend' >
									<s:param name='book.id' value='isbn' />
									<s:param name='book.title' value='title' />
									<s:param name='book.intro' value='intro' />
									<s:param name='user.userName' value='#session.user.userName' />
									<s:param name='condition' />
									<s:param name='message' />
								</s:url>">借书
            </a>
            </td>
        </tr>
    </s:iterator>
</table>
<p>
<s:property value="message" /><p>
    <a href="<s:url action=' ' >
					<s:param name='user.userName' value='#session.user.userName' />
					<s:param name='condition' />
					<s:param name='message' />
			 </s:url>">查询全部
    </a>
    &nbsp;&nbsp;
    <s:a href="main.jsp">返回主页</s:a>
</body>
</html>