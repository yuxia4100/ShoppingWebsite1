<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome!</title>
<link href="Css/myCSS.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="showPhoto.js"></script> 
</head>
<body topmargin="0">
	<table width="80%" border="0" align="center">
  <tbody>
    <tr>
      <td height="102" colspan="2" align="center">
      	<jsp:include page = "head.jsp" flush = "true"/>
      </td>
    </tr>
    <tr>
      <td width="20%"  height="222" valign = "top" align="center">
      	<jsp:include page = "left.jsp" flush = "true"/>
      </td>
      <td width="80%" align="center" valign = "top">
      	<jsp:include page = "right.jsp" flush = "true"/>
      </td>
    </tr>
    <tr>
      <td height="97" colspan="2" align="center">
      	<jsp:include page = "tail.jsp" flush = "true"/>
      </td>
    </tr>
  </tbody>
</table>
</body>
</html>