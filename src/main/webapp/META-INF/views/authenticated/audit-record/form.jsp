<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="auditor.audit-record.form.label.title" path="title"/>
	<acme:form-textbox code="auditor.audit-record.form.label.status" path="status"/>
	<acme:form-moment code="auditor.audit-record.form.label.moment" path="moment"/>
	<acme:form-textarea code="auditor.audit-record.form.label.body" path="body"/>

  	<acme:form-return code="auditor.audit-record.form.button.return"/>
</acme:form>
