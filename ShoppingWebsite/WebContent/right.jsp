<%@ page language="java"
	import="model.GoodBeanBo, model.GoodBean, java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	GoodBeanBo gbo = new GoodBeanBo();
	String pageNowString = (String)request.getAttribute("pageNow");
	int pageNow = 1;
	System.out.println(pageNowString);
	if (pageNowString != null) {
		pageNow = Integer.parseInt(pageNowString);
	} 
	List<GoodBean> res = gbo.getGoodsByPage(6, pageNow);
	int pageCount = gbo.getPageCount(6);
%>
<table width="100%" border="1">
	<tbody>
		<tr>
			<td height="45" colspan="3" align="center"><img
				src="Images/banner.png" width="200" height="85" alt="" /></td>
		</tr>
		<%
			int time = 0;
			for (int i = 0; i < 2; i++) {
		%>
		<tr>
			<%
				for (int j = 0; j < 3; j++) {
					GoodBean gb = new GoodBean();
					if(time >= res.size()) {
						gb.setBookId(0);
						gb.setBookInfo("No more book");
						gb.setBookPhoto("Goods/default.png");
						gb.setBookPrice(0.0f);
						gb.setBookName("No name");
						gb.setBookPublisher("No publisher");
						gb.setBookType("No type");
						
					} else {
						gb = res.get(time++);
					}
			%>
			<td width="173" height="169" align="left"><table width="256" border="1">
					<tbody>
						<tr>
							<td width="57%" rowspan="3"><img src=<%=gb.getBookPhoto()%>
								width="112" height="112" alt=""/></td>
							<td width="43%"><a
								href="ShowGoodServlet?type=showDetail&goodId=<%=gb.getBookId()%>"><%=gb.getBookName()%></a></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td><%=gb.getBookPrice()%></td>
						</tr>
						<tr>
							<td height="36" colspan="2"><%=gb.getBookInfo()%></td>
						</tr>
					</tbody>
				</table></td>

			<%
				}
			%>
		</tr>
		<%
		
		
		if (i == 0) {
			%>
				<tr>
					<td height="10" colspan="3" align="center" bgcolor="#FFCCCC">&nbsp;</td>
				</tr>
			<%
		} %>
		
		<%
			}
		%>
		<tr>
			<td height="30" colspan="3" align="center">
			<%
				for (int i = 1; i <= pageCount; i++) {
					%>
						<a href="ShowGoodServlet?type=fenye&pageNow=<%=i%>"><%=i%></a>
					<%
				}
			%>
			</td>
		</tr>
	</tbody>
</table>