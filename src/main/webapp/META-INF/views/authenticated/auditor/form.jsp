<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="authenticated.auditor.auditor.form.label.firm" path="firm"/>
	<acme:form-textbox code="authenticated.auditor.auditor.form.label.responsibility-statement" path="responsibilityStatement"/>
	
	<acme:form-submit test="${command == 'create'}" code="authenticated.auditor.auditor.form.button.create" action="/authenticated/auditor/create"/>
	<acme:form-submit test="${command == 'update'}" code="authenticated.auditor.auditor.form.button.update" action="/authenticated/auditor/update"/>
	<acme:form-return code="authenticated.auditor.auditor.form.button.return"/>
</acme:form>
