<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="authenticated.thread.form.label.title" path="title"/>
	<acme:form-moment code="authenticated.thread.form.label.moment" path="moment"/>
	<acme:menu-suboption code="authenticated.thread.form.label.message" action="/authenticated/message/list-thread"/>
	
  	<acme:form-return code="authenticated.thread.form.button.return"/>
</acme:form>
