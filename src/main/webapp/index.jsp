<%--
  Created by IntelliJ IDEA.
  User: F117-FPplus
  Date: 2020/7/2
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>SpringMVC封装请求数据，封装数据到对象，对象关联的对象，对象关联的集合</h3>
<form action="/spring04_mvc01_war_exploded/save4.do" method="post">
    用户名：<input type="text" name="name">             <br>
    省份：<input type="text" name="address.province">   <br>
    城市：<input type="text" name="address.city">   <br>

    省份list：<input type="text" name="list[0].province">   <br>
    城市list：<input type="text" name="list[0].city">   <br>

    省份map：<input type="text" name="map['one'].province">   <br>
    城市map：<input type="text" name="map['one'].city">   <br>

    <input type="submit" value="测试">
</form>

<h3>测试@RequestBody获取请求体</h3>
<form action="/spring04_mvc01_war_exploded/requestBody.do" method="post">
    用户名：<input type="text" name="name">             <br>
    省份：<input type="text" name="address">    <br>

    <input type="submit" value="测试">
</form>
</body>
</html>
