<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>
<!-- "referenceNumber", "title", "deadline" -->
<acme:list>
	<acme:list-column code="authenticated.job.list.referenceNumber" path="referenceNumber" width="20%"/>
	<acme:list-column code="authenticated.job.list.title" path="title" width="20%"/>
	<acme:list-column code="authenticated.job.list.deadline" path="deadline" width="20%"/>
</acme:list>