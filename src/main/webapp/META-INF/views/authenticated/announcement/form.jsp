<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="authenticated.announcement.form.label.title" path="title"/>
	<acme:form-moment code="authenticated.announcement.form.label.moment" path="moment"/>
	<acme:form-url code="authenticated.announcement.form.label.moreInfo" path="moreInfo"/>
	<acme:form-textarea code="authenticated.announcement.form.label.description" path="description"/>

  	<acme:form-return code="authenticated.announcement.form.button.return"/>
</acme:form>
