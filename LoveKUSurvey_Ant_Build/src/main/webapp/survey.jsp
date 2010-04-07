<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>

	<head>
    <title>KU Survey</title>
    <s:head />
	</head>

	<body>
	
		<h3>Take The KU Survey</h3>
		
		<p>Select an answer and then click the submit button.</p>
		
		<s:form action="saveAnswer">
		    <p>Do you love KU? &nbsp;&nbsp;&nbsp;
			<s:radio name="answer" list="#{'3':'Yes', '2':'No', '1':'Not Sure'}"  /> </p>
			<s:submit />
		</s:form>
		
	</body>
	
</html>
