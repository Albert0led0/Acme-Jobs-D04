<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:message var="nostars" code="anonymous.investor-record.form.nostars"/>
<acme:form readonly="true">
	<acme:form-textbox code="anonymous.investor-record.form.label.investor" path="investorName"/>
	<acme:form-textbox code="anonymous.investor-record.form.label.sector" path="sector"/>
	<acme:form-money code="anonymous.investor-record.form.label.statement" path="investingStatement" />
	<jstl:choose>
		<jstl:when test="${stars == null}">
			<acme:form-double code="anonymous.investor-record.form.label.stars" path="stars" placeholder="${nostars}"/>
		</jstl:when>
		<jstl:otherwise>
			<acme:form-double code="anonymous.investor-record.form.label.stars" path="stars" />
		</jstl:otherwise>
	</jstl:choose>
	
	<acme:form-return code="anonymous.investor-record.form.button.return"/>
</acme:form>