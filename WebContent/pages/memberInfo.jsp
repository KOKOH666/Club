<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Авто Клуб Новые Дома</title>
        <link href="css/style_index.css" rel="stylesheet" type="text/css">
</head>
 <body>  
 <div id="container">
<jsp:include page="/pages/include/header.jsp"/>
<jsp:include page="/pages/include/menu.jsp"/>
	<div id="content">
    <table class="fig3">
        <tr>
      	<th> </th>
    	<th>BRAND</th> 
    	<th>MODEL</th>
   		<th>ENGINE</th>
  		<th>YEAR</th>
  		 </tr>
		<c:forEach var="car" items="${member.cars}">
		<tr> 
		<td> </td>
        <td>${car.brand}</td> 
        <td>${car.model}</td> 
 		<td>${car.engine}</td>        
		<td>${car.year}</td> 
		</tr>
		</c:forEach>
        </table>
         </div> 
  <jsp:include page="/pages/include/footer.jsp"/>


</div> 
 </body>
</html>
 