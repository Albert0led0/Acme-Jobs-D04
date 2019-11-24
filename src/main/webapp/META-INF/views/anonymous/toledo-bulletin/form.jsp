<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="anonymous.toledo-bulletin.form.label.author" path="author"/>
	<acme:form-textbox code="anonymous.toledo-bulletin.form.label.email" path="email"/>
	<acme:form-textarea code="anonymous.toledo-bulletin.form.label.text" path="text"/>
	<acme:form-submit code="anonymous.toledo-bulletin.form.button.create" action="/anonymous/toledo-bulletin/create"/>
	<acme:form-return code="anonymous.toledo-bulletin.form.button.return"/>
</acme:form>
