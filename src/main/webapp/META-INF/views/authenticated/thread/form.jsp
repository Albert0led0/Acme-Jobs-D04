<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="authenticated.thread.form.label.title" path="title"/>
	<acme:form-moment code="authenticated.thread.form.label.moment" path="moment"/>
	
	<acme:form-submit code="authenticated.thread.form.label.message" method="get" action="/authenticated/message/list?threadId=${id}"/>
	
  	<acme:form-return code="authenticated.thread.form.button.return"/>
</acme:form>
