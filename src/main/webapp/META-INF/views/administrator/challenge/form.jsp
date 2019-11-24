<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:message var="fecha" code="administrator.challenge.form.placeholder.deadline"/>

<acme:form>
	<acme:form-textbox code="administrator.challenge.form.label.title" path="title"/>
	<acme:form-moment code="administrator.challenge.form.label.deadline" placeholder="${fecha}" path="deadline"/>
	<acme:form-textarea code="administrator.challenge.form.label.description" path="description" />
	<acme:form-money code="administrator.challenge.form.label.gold-reward" path="goldReward"/>
	<acme:form-money code="administrator.challenge.form.label.silver-reward" path="silverReward"/>
	<acme:form-money code="administrator.challenge.form.label.bronze-reward" path="bronzeReward"/>
	
	<acme:form-submit test="${command == 'show'}" 
		code="administrator.challenge.form.button.update" 
		action="/administrator/challenge/update"/>
	<acme:form-submit test="${command == 'show'}" 
		code="administrator.challenge.form.button.delete" 
		action="/administrator/challenge/delete"/>
	<acme:form-submit test="${command == 'create'}" 
		code="administrator.challenge.form.button.create" 
		action="/administrator/challenge/create"/>
	<acme:form-submit test="${command == 'update'}" 
		code="administrator.challenge.form.button.update" 
		action="/administrator/challenge/update"/>
	<acme:form-submit test="${command == 'delete'}" 
		code="administrator.challenge.form.button.delete" 
		action="/administrator/challenge/delete"/>
	<acme:form-return code="authenticated.challenge.form.button.return"/>
</acme:form>