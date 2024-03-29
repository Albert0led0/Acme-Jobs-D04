<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<acme:form readonly="true">
	<acme:form-textbox code="worker.application.form.label.referenceNumber" path="referenceNumber"/>
	<acme:form-moment code="worker.application.form.label.moment" path="moment"/>
	<acme:form-textbox code="worker.application.form.label.status" path="status"/>
	<acme:form-textbox code="worker.application.form.label.statement" path="statement"/>
	<acme:form-textbox code="worker.application.form.label.skills" path="skills"/>
	<acme:form-textbox code="worker.application.form.label.qualifications" path="qualifications"/>
	
	<acme:form-return code="worker.application.form.button.return"/>
</acme:form>