<%@ page language="java" import="java.util.*, model.GoodBean, model.userBean, model.ShoppingCartBo" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	List<GoodBean> goodList = (List)request.getAttribute("goodList");
	userBean ub = (userBean)session.getAttribute("loginUser");
	ShoppingCartBo scb = (ShoppingCartBo)session.getAttribute("ShoppingCart");
%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Untitled Document</title>
<link href="Css/myCSS.css" rel="stylesheet" type="text/css">
</head>

<body>
<table width="80%" border="1">
  <tbody>
    <tr>
      <td align="center"><span class="abc">
      	<jsp:include page="head.jsp" flush="true"/>
      </span></td>
    </tr>
    <tr>
      <td align="center"><table width="80%" border="1">
        <tbody>
          <tr>
            <td align="center"><span class="abc">picture</span></td>
          </tr>
          <tr>
            <td align="center"><table width="80%" border="1">
              <tbody>
                <tr>
                  <td colspan="2" align="center"><span class="abc">Customer Info</span></td>
                  </tr>
                <tr>
                  <td width="39%" align="center"><span class="abc">user name</span></td>
                  <td width="61%" align="center"><input name="userName" type="text" id="userName" value=<%=ub.getUserName() %>></td>
                </tr>
                <tr>
                  <td align="center"><span class="abc">first name</span></td>
                  <td align="center"><input name="firstName" type="text" id="firstName" value=<%=ub.getUserFirstName() %>></td>
                </tr>
                <tr>
                  <td align="center"><span class="abc">last name</span></td>
                  <td align="center"><input name="lastName" type="text" id="lastName" value=<%=ub.getUserLastName() %>></td>
                </tr>
                <tr>
                  <td align="center"><span class="abc">address</span></td>
                  <td align="center"><input name="address" type="text" id="address" value=<%=ub.getUserAddress() %>></td>
                </tr>
                <tr>
                  <td align="center"><span class="abc">postcode</span></td>
                  <td align="center"><input name="postcode" type="text" id="postcode" value=<%=ub.getUserPostcode() %>></td>
                </tr>
                <tr>
                  <td align="center"><span class="abc">email</span></td>
                  <td align="center"><input name="email" type="text" id="email" value=<%=ub.getUserEmail() %>></td>
                </tr>
                <tr>
                  <td align="center"><span class="abc">phone</span></td>
                  <td align="center"><input name="phone" type="text" id="phone" value=<%=ub.getUserPhone()%>></td>
                </tr>
                <tr>
                  <td align="center"><span class="abc">
                    <input name="confirm" type="button" class="abc" id="confirm" value="Confirm">
                  </span></td>
                  <td align="center"><span class="abc">
                    <input name="update" type="button" class="abc" id="update" value="Update ">
                  </span></td>
                </tr>
              </tbody>
            </table></td>
          </tr>
          <tr>
            <td align="center"><table width="80%" border="1">
              <tbody>
                <tr>
                  <td colspan="4" align="center"><span class="abc">My Shopping Cart</span></td>
                  </tr>
                <tr>
                  <td align="center"><span class="abc">No</span></td>
                  <td align="center"><span class="abc">name</span></td>
                  <td align="center"><span class="abc">price</span></td>
                  <td align="center"><span class="abc">amount</span></td>
                </tr>
                
                <%
                	for (int i = 0; i < goodList.size(); i++) {
                		GoodBean gb = goodList.get(i);
                		int amount = scb.getGoodAmountById(gb.getBookId());
                %>
                
                <tr>
                  <td align="center"><span class="abc"><%=gb.getBookId() %></span></td>
                  <td align="center"><span class="abc"><%=gb.getBookName() %></span></td>
                  <td align="center"><span class="abc"><%=gb.getBookPrice() %></span></td>
                  <td align="center"><span class="abc"><%=amount%></span></td>
                </tr>
                
               <% } %>
                
                <tr>
                  <td colspan="4" align="center"><span class="abc">total price <%=scb.getTotalPrice()%></span></td>
                  </tr>
                <tr>
                  <td colspan="4" align="center"><span class="abc">
                    <input name="button3" type="button" class="abc" id="button3" value="update shopping cart">
                  </span></td>
                  </tr>
              </tbody>
            </table></td>
          </tr>
          <tr>
            <td align="center"><a href="OrderDealServlet">next step</a></td>
          </tr>
          <tr>
            <td align="center"><span class="abc">picture2</span></td>
          </tr>
        </tbody>
      </table></td>
    </tr>
    <tr>
      <td align="center"><span class="abc">
      	<jsp:include page="tail.jsp" flush="true"/>
      </span></td>
    </tr>
  </tbody>
</table>
</body>
</html>
