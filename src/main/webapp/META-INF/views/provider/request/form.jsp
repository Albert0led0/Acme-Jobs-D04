<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:message var="fecha" code="provider.request.form.placeholder.deadline"/>
<acme:form>
	<acme:form-textbox code="provider.request.form.label.title" path="title"/>
	<jstl:if test="${command != 'create'}">
	    <acme:form-moment 
	        code="provider.request.form.label.moment"
	        path="moment"
	        readonly="true"/>
	</jstl:if>
	<acme:form-moment code="provider.request.form.label.deadline" placeholder="${fecha}" path="deadline"/>
	<acme:form-textarea code="provider.request.form.label.description" path="description"/>
	<acme:form-money code="provider.request.form.label.reward" path="reward"/>
	<jstl:if test="${command != 'create'}">
		<acme:form-textbox
			code="provider.request.form.label.ticker1"
	        path="ticker"
	        placeholder="RXXXX-99999"/>
	</jstl:if>
	<jstl:if test="${command == 'create'}">
		<acme:form-textbox 
	        code="provider.request.form.label.ticker2"
	        path="ticker"
	        placeholder="RXXXX-99999"/>
		<acme:form-checkbox
	   		code="provider.request.form.button.checkbox"
	    	path="accept"/>
	</jstl:if>
	<acme:form-submit test="${command == 'create'}"
	    code="provider.request.form.button.create"
	    action="/provider/request/create"/>
  	<acme:form-return code="provider.request.form.button.return"/>
</acme:form>
