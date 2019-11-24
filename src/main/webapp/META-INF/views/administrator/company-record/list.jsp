<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="administrator.company-record.list.company" path="companyIncName" width="40%"/>
	<acme:list-column code="administrator.company-record.list.sector" path="sector" width="20%"/>
	<acme:list-column code="administrator.company-record.list.ceoname" path="ceoName" width="20%"/>
	<acme:list-column code="administrator.company-record.list.stars" path="stars" width="5%"/>
</acme:list>