<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<acme:form readonly="true">
	<acme:form-textbox code="authenticated.challenge.form.label.title" path="title"/>
	<acme:form-textbox code="authenticated.challenge.form.label.deadline" path="deadline"/>
	<acme:form-textarea code="authenticated.challenge.form.label.description" path="description" />
	<acme:form-money code="authenticated.challenge.form.label.gold" path="goldReward"/>
	<acme:form-money code="authenticated.challenge.form.label.silver" path="silverReward"/>
	<acme:form-money code="authenticated.challenge.form.label.bronze" path="bronzeReward"/>
	
	<acme:form-return code="authenticated.challenge.form.button.return"/>
</acme:form>