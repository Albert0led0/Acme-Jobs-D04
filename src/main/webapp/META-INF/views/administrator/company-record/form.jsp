<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:message var="nostars" code="authenticated.company-record.form.nostars"/>
<acme:form>
	<acme:form-textbox code="authenticated.company-record.form.label.company" path="company"/>
	<acme:form-checkbox code="authenticated.company-record.form.label.incorporated" path="incorporated"/>
	<acme:form-textbox code="authenticated.company-record.form.label.sector" path="sector"/>
	<acme:form-textbox code="authenticated.company-record.form.label.ceoname" path="ceoName"/>
	<acme:form-textarea code="authenticated.company-record.form.label.description" path="description"/>
	<acme:form-textbox code="authenticated.company-record.form.label.website" path="webSite"/>
	<acme:form-textbox code="authenticated.company-record.form.label.phone" path="phoneNumber"/>
	<acme:form-textbox code="authenticated.company-record.form.label.email" path="email"/>
	<jstl:choose>
		<jstl:when test="${stars == null}">
			<acme:form-double code="authenticated.company-record.form.label.stars" path="stars" placeholder="${nostars}"/>
		</jstl:when>
		<jstl:otherwise>
			<acme:form-double code="authenticated.company-record.form.label.stars" path="stars" />
		</jstl:otherwise>
	</jstl:choose>
	
	<acme:form-submit test="${command == 'show'}" 
		code="administrator.company-record.form.button.update"
		action="update"/>
	<acme:form-submit test="${command == 'show'}" 
		code="administrator.company-record.form.button.delete"
		action="delete"/>
	<acme:form-submit test="${command == 'create'}" 
		code="administrator.company-record.form.button.create"
		action="create"/>
	<acme:form-submit test="${command == 'update'}" 
		code="administrator.company-record.form.button.update"
		action="update"/>
	<acme:form-submit test="${command == 'delete'}" 
		code="administrator.company-record.form.button.delete"
		action="delete"/>
				
	<acme:form-return code="authenticated.company-record.form.button.return"/>
</acme:form>