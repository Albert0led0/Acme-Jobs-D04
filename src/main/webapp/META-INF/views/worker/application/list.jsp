<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="worker.application.list.referenceNumber" path="referenceNumber" width="20%"/>
	<acme:list-column code="worker.application.list.moment" path="moment" width="10%"/>
	<acme:list-column code="worker.application.list.status" path="status" width="10%"/>
</acme:list>