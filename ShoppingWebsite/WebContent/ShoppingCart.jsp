<%@ page language="java" import="model.GoodBean, java.util.*,model.ShoppingCartBo"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	List<GoodBean> res = (List)request.getAttribute("ShoppingCartInfo");
	ShoppingCartBo scb = (ShoppingCartBo)session.getAttribute("ShoppingCart");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Untitled Document</title>
<link href="Css/myCSS.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
	function returnIndex() {
		window.open("Index.jsp","_self");
	}
	
	function deleteAll() {
		window.open("ShoppingCartServlet?type=deleteAll","_self");
	}
</script>
</head>

<body>
	<table width="100%" border="1">
		<tbody>
			<tr>
				<td width="80%" align="center"><span class="abc"> <jsp:include
							page="head.jsp" flush="true" />
				</span></td>
			</tr>
			<tr>
				<td width="80%" align="center">
				<form action="ShoppingCartServlet?type=updateGoods" method="POST">
				<table width="99%" border="1">
						<tbody>
							<tr>
								<td colspan="4" align="center"><span class="abc">image</span></td>
							</tr>
							<tr>
								<td width="10%" align="center"><span class="abc">No</span></td>
								<td width="33%" align="center"><span class="abc">Name</span></td>
								<td width="33%" align="center"><span class="abc">Price</span></td>
								<td width="33%" align="center"><span class="abc">Amount</span></td>
							</tr>
							<%
								for (int i = 0; i < res.size(); i++) {
									GoodBean gb = res.get(i);
							%>
							<tr>
								<td align="center"><span class="abc"><%=gb.getBookId()%></span></td>
								<td align="center"><span class="abc"><%=gb.getBookName() %></span></td>
								<td align="center"><span class="abc"><%=gb.getBookPrice()%></span></td>
								<td align="center"><table width="100%" border="1">
										<tbody>
											<tr>
												<td width="33%" align="center"><span class="abc"><input name="goodId" type="hidden" value="<%=gb.getBookId()%>"><input name="newAmount" type="text" size="10" value="<%=scb.getGoodAmountById(gb.getBookId())%>"/></span></td>
												<td width="33%" align="center"><span class="abc"><a href="ShoppingCartServlet?type=delete&goodId=<%=gb.getBookId()%>">delete</a></span></td>
												<td width="33%" align="center"><span class="abc"><a href="ShowGoodServlet?type=showDetail&goodId=<%=gb.getBookId()%>">detail</a></span></td>
											</tr>
										</tbody>
									</table></td>
							</tr>
							<%
								}
							%>

							<tr>
								<td align="center">&nbsp;</td>
								<td align="center"><span class="abc"> <input
										type="button" name="deleteAll" id="deleteAll"
										value="delete all books" onclick="deleteAll()">
								</span></td>
								<td align="center"><span class="abc"> <input
										type="submit"  name="changeAmount" id="changeAmount"
										value="change amount">
								</span></td>
								<td align="center">&nbsp;</td>
							</tr>
							<tr>
								<td colspan="4" align="center">&nbsp;</td>
							</tr>
							<tr>
								<td colspan="4" align="center"><table width="100%"
										border="1">
										<tbody>
											<tr>
												<td width="50%"><span class="abc">Your total price is <%=scb.getTotalPrice()%><input type="button" name="return" id="return"  onclick="returnIndex()" value="Return"></td></span></td>
												<td width="50%" align="right"><span class="abc"><a href="LoginNeedServlet">next step</a></span></td>
											</tr>
										</tbody>
									</table></td>
							</tr>
						</tbody>
					</table></form></td>
			</tr>
			<tr>
				<td width="80%" align="center"><span class="abc"> <jsp:include
							page="tail.jsp" flush="true" />
				</span></td>
			</tr>
		</tbody>
	</table>
</body>
</html>
