<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:message var="nostars" code="anonymous.company-record.form.nostars"/>
<acme:form readonly="true">
	<acme:form-textbox code="anonymous.company-record.form.label.company" path="companyIncName"/>
	<acme:form-textbox code="anonymous.company-record.form.label.sector" path="sector"/>
	<acme:form-textbox code="anonymous.company-record.form.label.ceoname" path="ceoName"/>
	<acme:form-textarea code="anonymous.company-record.form.label.description" path="description"/>
	<acme:form-textbox code="anonymous.company-record.form.label.website" path="webSite"/>
	<acme:form-textbox code="anonymous.company-record.form.label.phone" path="phoneNumber"/>
	<acme:form-textbox code="anonymous.company-record.form.label.email" path="email"/>
	<jstl:choose>
		<jstl:when test="${stars == null}">
			<acme:form-double code="anonymous.company-record.form.label.stars" path="stars" placeholder="${nostars}"/>
		</jstl:when>
		<jstl:otherwise>
			<acme:form-double code="anonymous.company-record.form.label.stars" path="stars" />
		</jstl:otherwise>
	</jstl:choose>
	
	<acme:form-return code="anonymous.company-record.form.button.return"/>
</acme:form>