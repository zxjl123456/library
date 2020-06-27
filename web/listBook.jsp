<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
    <title>浏览书籍</title>
</head>
<body>
<hr>
<h2>登录用户:<s:property value="#session.user.userName"/></h2>
    <table border="1" width="800" style="font-size:16pt;">

        <tr align="center">
            <th>编号</th>
            <th>书名</th>
            <th>价格</th>
            <th>作者</th>
           <%-- <th>电话</th>
            <th>邮箱</th>--%>
            <th colspan="3" align="center">操作</th>
        </tr>
        <s:iterator value="books">
            <tr>

                <td><s:property value="id" /></td>
                <td><s:property value="title" /></td>
                <td><s:property value="price" /></td>
                <td><s:property value="author.name" /></td>
                <%--<td><s:property value="author.tel" /></td>
                <td><s:property value="author.email" /></td>--%>
                <s:if test="#session.user.userName=='admin'">
                <td><a href="<s:url action='delete'>
								<s:param name='book.id' value='id' />
							 </s:url>">
                    删除
                </a>
                </td>
                <td><a href="<s:url action='updateForm'>
								<s:param name='book.id' value='id' />
								<s:param name='book.title' value='title' />
								<s:param name='book.price' value='price' />
							 </s:url>">修改</a><br>
                </td>
                </s:if>
                <s:else>
                    <td><a href="<s:url action='lend'>
								<s:param name='lend.id' value='id' />
								<s:param name='lend.title' value='title' />
								<s:param name='lend.userName' value='#session.user.userName'></s:param>
							 </s:url>">借书</a><br>
                    </td>
                </s:else>
    <td><a href="<s:url action='readBookIntro' >
                <s:param name='book.id' value='id' />
									<s:param name='book.title' value='title'/>
									<s:param name='book.price' value='price' />
									<s:param name='book.intro' value='intro' />
								</s:url>">简介
    </a>
    </td>
            </tr>
        </s:iterator>
    </table>
    <br>
    <s:a href="main.jsp">返回主页</s:a><br>
</body>
</html>