<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:message var="nostars" code="administrator.investor-record.form.nostars"/>
<acme:form>
	<acme:form-textbox code="administrator.investor-record.form.label.investor" path="investorName"/>
	<acme:form-textbox code="administrator.investor-record.form.label.sector" path="sector"/>
	<acme:form-money code="administrator.investor-record.form.label.statement" path="investingStatement" />
	<jstl:choose>
		<jstl:when test="${stars == null}">
			<acme:form-double code="administrator.investor-record.form.label.stars" path="stars" placeholder="${nostars}"/>
		</jstl:when>
		<jstl:otherwise>
			<acme:form-double code="administrator.investor-record.form.label.stars" path="stars" />
		</jstl:otherwise>
	</jstl:choose>

	<acme:form-submit test="${command == 'show'}" 
		code="administrator.investor-record.form.button.update"
		action="/administrator/investor-record/update" />
		
	<acme:form-submit test="${command == 'show'}" 
		code="administrator.investor-record.form.button.delete"
		action="/administrator/investor-record/delete" />
		
	<acme:form-submit test="${command == 'create'}" 
		code="administrator.investor-record.form.button.create"
		action="/administrator/investor-record/create" />
	
	<acme:form-submit test="${command == 'update'}" 
		code="administrator.investor-record.form.button.update"
		action="/administrator/investor-record/update" />
		
	<acme:form-submit test="${command == 'delete'}" 
		code="administrator.investor-record.form.button.delete"
		action="/administrator/investor-record/delete" />

	<acme:form-return code="administrator.investor-record.form.button.return"/>
</acme:form>