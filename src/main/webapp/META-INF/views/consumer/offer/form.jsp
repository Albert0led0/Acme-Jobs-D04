<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:message var="fecha" code="consumer.offer.form.placeholder.deadline"/>
<acme:form>
	<acme:form-textbox code="consumer.offer.form.label.title" path="title"/>
	<jstl:if test="${command != 'create'}">
	    <acme:form-moment 
	        code="consumer.offer.form.label.moment"
	        path="moment"
	        readonly="true"/>
	</jstl:if>
	<acme:form-moment code="consumer.offer.form.label.deadline" placeholder="${fecha}" path="deadline"/>
	<acme:form-textarea code="consumer.offer.form.label.description" path="description"/>
	<acme:form-money code="consumer.offer.form.label.min-reward" path="minReward"/>
	<acme:form-money code="consumer.offer.form.label.max-reward" path="maxReward"/>
	<jstl:if test="${command != 'create'}">
		<acme:form-textbox code="consumer.offer.form.label.ticker1" path="ticker"/>
	</jstl:if>
	<jstl:if test="${command == 'create'}">
		<acme:form-textbox 
	        code="consumer.offer.form.label.ticker2"
	        path="ticker"
	        placeholder="OXXXX-99999"/>
		<acme:form-checkbox
	   		code="consumer.offer.form.button.checkbox"
	    	path="accept"/>
	</jstl:if>
	<acme:form-submit test="${command == 'create'}"
	    code="consumer.offer.form.button.create"
	    action="/consumer/offer/create"/>
  	<acme:form-return code="consumer.offer.form.button.return"/>
</acme:form>
