<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% 
	String errorMessage = (String)request.getAttribute("loginError");
	String loginInfo = "Please Log in!";
	if (errorMessage != null) {
		loginInfo = errorMessage;
	}
	
	String registerInfo = (String)request.getAttribute("registerInfo");
	if (registerInfo != null) {
		loginInfo = registerInfo;
	}

%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome!</title>
<link href="Css/myCSS.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="showPhoto.js"></script> 
</head>
<body topmargin="0">
	<table width="100%" border="1">
  <tbody>
    <tr>
      <td width="80%" align="center"><jsp:include page="head.jsp" flush="true"/></td>
    </tr>
    <tr>
      <td width="80%" height="106" align="center"><%=loginInfo%><form id="form1" name="form1" action="LoginServlet" method="post">
        <table width="50%" border="1">
          <tbody>
            <tr>
              <td height="23" colspan="2" align="center" bgcolor="#DFE10C">User Login</td>
            </tr>
            <tr>
              <td width="49%" align="right">User Name:&nbsp;</td>
              <td width="51%"><label for="textfield">&nbsp;</label>
                <input name="userName" type="text" id="textfield" size="20" maxlength="20">                
                <label for="userName"></label></td>
            </tr>
            <tr>
              <td width="49%" align="right">Password:&nbsp;</td>
              <td><label for="textfield2">&nbsp;</label>
                <input name="password" type="text" id="textfield2" size="20" maxlength="20">                <label for="password"></label></td>
            </tr>
            <tr>
              <td colspan="2" align="center"><input name="login" type="submit" id="login" value="Login">
                &nbsp;&nbsp;&nbsp;
                <input name="register" type="submit" id="register"  value="Register" onclick = "form.action='RegisterServlet'"></td>
            </tr>
          </tbody>
        </table>
      </form></td>
    </tr>
    <tr>
      <td width="80%" align="center"><jsp:include page="tail.jsp" flush="true"/></td>
    </tr>
  </tbody>
</table>
</body>
</html>

