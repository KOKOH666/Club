<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Авто Клуб Новые Дома Да !</title>
        <link href="css/style_index.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="container">
<jsp:include page="/pages/include/header.jsp"/>
<jsp:include page="/pages/include/menu.jsp"/>
<div id="content">
<h3>${LoggerClass.runMe("mkyong")}</h3>
</div>
<jsp:include page="/pages/include/footer.jsp"/>
</div> 
</body>
</html>