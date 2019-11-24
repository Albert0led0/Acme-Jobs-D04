<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>


<acme:list>
	<acme:list-column code="authenticated.challenge.list.title" path="title" width="40%"/>
	<acme:list-column code="authenticated.challenge.list.deadline" path="deadline" width="20%"/>
	<acme:list-column code="authenticated.challenge.list.description" path="description" width="60%"/>
</acme:list>