<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list readonly="true">
	<acme:list-column code="anonymous.toledo-bulletin.list.moment" path="moment" width="20%"/>
	<acme:list-column code="anonymous.toledo-bulletin.list.author" path="author" width="20%"/>
	<acme:list-column code="anonymous.toledo-bulletin.list.email" path="email" width="20%"/>
	<acme:list-column code="anonymous.toledo-bulletin.list.text" path="text" width="60%"/>
</acme:list>