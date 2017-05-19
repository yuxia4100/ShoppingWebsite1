<%@ page language="java" import = "model.GoodBean" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	GoodBean gb = (GoodBean)request.getAttribute("goodInfo");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="Css/myCSS.css" rel="stylesheet" type="text/css">
<title>Insert title here</title>
<script type="text/javascript">
	function returnIndex() {
		window.open("Index.jsp","_self");
	}
	
	function addGoods(goodId) {
		window.open("ShoppingCartServlet?type=addGood&goodId=" + goodId,"_self");
	}
</script>
</head>

<body>
<table width="80%" border="1" class="abc" align="center">
  <tbody>
    <tr>
      <td width="80%" align="center">
      	<jsp:include page="head.jsp" flush="true"/>
      </td>
    </tr>
    <tr>
      <td width="80%" align="center"><table width="100%" border="1">
        <tbody>
          <tr align="center">
            <td colspan="2">&nbsp;</td>
            </tr>
          <tr>
            <td width="46%" rowspan="8" align="center"><img src= <%=gb.getBookPhoto() %> width="348" height="299" alt=""/></td>
            <td width="54%">&nbsp;</td>
          </tr>
          <tr>
            <td><%=gb.getBookName() %></td>
          </tr>
          <tr>
            <td><%=gb.getBookPrice() %></td>
          </tr>
          <tr>
            <td><%=gb.getBookPublisher() %></td>
          </tr>
          <tr>
            <td><%=gb.getBookType() %></td>
          </tr>
          <tr>
            <td></td>
          </tr>
          <tr>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td height="154"><%=gb.getBookInfo() %></td>
          </tr>
          <tr align="center">
            <td height="46" colspan="2" align="left"><input type="button" onclick= "addGoods(<%=gb.getBookId()%>)" name="buy" id="buy" value="Buy">
              <input type="button" name="return" id="return"  onclick="returnIndex()" value="Return"></td>
            </tr>
          <tr align="center">
            <td height="40" colspan="2">&nbsp;</td>
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