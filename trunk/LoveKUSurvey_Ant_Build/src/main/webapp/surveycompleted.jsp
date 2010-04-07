<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>

	<head>
    <title>KU Survey Completed</title>
	</head>

	<body>
	
		<h3>Survey Completed</h3>
		
		<p>Thank you for taking the survey.  The results including your
		answer are below.</p>
		<p>The question was "Do you love KU".</p>
		<div style="margin-left:15px">
        <p><s:property value="yesPercentage" />% answered Yes</p>
        <p><s:property value="noPercentage" />% answered No</p>
        <p><s:property value="notSurePercentage" />% answered Not Sure</p>
        </div>
		
        <p>Cheat and <a href='<s:url action="index" />'>take the survey again</a>.</p>
		
	</body>
	
</html>
