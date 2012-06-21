<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
iframe{
left:5%;
right:5%;
height:50%;
}
</style>
<title>File and Audio Tools</title>
</head>
<body>
<div style="border:5px solid silver;">Convert file to audio: <br/>
<form enctype="multipart/form-data" id="form1" target="_blank" action="AudioStorage" method="post">
<input type="file" name="file1" id="file1"/><input type="submit"/><br/>
</form>
</div>
<br/>
<iframe id="frame1" name="frame1"  src="http://whatismyip.southkcgroup.org" ></iframe>
</body>
</html>