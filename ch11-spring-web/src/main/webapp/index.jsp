<%--
  Created by IntelliJ IDEA.
  User: z-y-l
  Date: 2020/11/1
  Time: 11:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
     <p>注册学生</p>
     <form action="registerServlet" method="post">
         <table>
             <tr>
                 <td>id</td>
                 <td><input type="text" name="id"></td>
             </tr>
             <tr>
                 <td>姓名:</td>
                 <td><input type="text" name="name"></td>
             </tr>
             <tr>
                 <td>email:</td>
                 <td><input type="text" name="email"></td>
             </tr>
             <tr>
                 <td>年龄:</td>
                 <td><input type="text" name="age"></td>
             </tr>
             <tr>
                 <td></td>
                 <td><input type="submit" name="注册学生"></td>
             </tr>
         </table>
     </form>
</body>
</html>
