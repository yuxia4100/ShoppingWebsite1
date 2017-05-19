<%@ page language="java" import="model.OrderFullInfoBean" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%
 	OrderFullInfoBean ofib = (OrderFullInfoBean)request.getAttribute("OrderFullInfo");
 %>   
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Untitled Document</title>
</head>

<body>
<table width="80%" border="1">
  <tbody>
    <tr>
      <td width="80%" align="center">
      	<jsp:include page="head.jsp" flush="true"/>
      </td>
    </tr>
    <tr>
      <td width="80%" align="center"><table width="100%" border="1">
        <tbody>
          <tr>
            <td colspan="9" align="center">picture</td>
            </tr>
          <tr>
            <td colspan="9" align="center">order detail</td>
            </tr>
          <tr>
            <td align="center">Order No</td>
            <td align="center">Receiver</td>
            <td align="center">Address</td>
            <td align="center">Postcode</td>
            <td align="center">Phone</td>
            <td align="center">Price</td>
            <td align="center">User name</td>
            <td align="center">Email</td>
            <td align="center">&nbsp;</td>
          </tr>
          <tr>
            <td align="center"><%=ofib.getOrderId() %></td>
            <td align="center"><%=ofib.getUserFirstName()%>&nbsp;<%=ofib.getUserLastName()%></td>
            <td align="center"><%=ofib.getUserAddress() %></td>
            <td align="center"><%=ofib.getUserPostcode() %></td>
            <td align="center"><%=ofib.getUserPhone()%></td>
            <td align="center"><%=ofib.getOrderTotalPrice()%></td>
            <td align="center"><%=ofib.getUserName()%></td>
            <td align="center"><%=ofib.getUserEmail()%></td>
            <td align="center"><a href="#">check detail</a></td>
          </tr>
          <tr>
            <td align="center">&nbsp;</td>
          </tr>
        </tbody>
      </table></td>
    </tr>
    <tr>
      <td width="80%" align="center">
      	<jsp:include page="tail.jsp" flush="true"/>
      </td>
    </tr>
  </tbody>
</table>
</body>
</html>