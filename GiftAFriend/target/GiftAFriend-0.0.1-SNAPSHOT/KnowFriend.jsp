<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Secret Santa</title>
</head>
<body>
<label>Enter Your Good Name</label>
<form method="post" action="GetName">  
<input type="text" name="myName" id="myName"/>
<input type="submit" />
<input type="text" readonly="readOnly" id="whosmyfriendId" name="whosmyfriendId"></input>>
</form>
</body>
</html>