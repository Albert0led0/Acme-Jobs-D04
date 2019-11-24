<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="administrator.investor-record.list.investor" path="investorName" width="40%"/>
	<acme:list-column code="administrator.investor-record.list.sector" path="sector" width="20%"/>
	<acme:list-column code="administrator.investor-record.list.statement" path="investingStatement" width="5%"/>
	<acme:list-column code="administrator.investor-record.list.stars" path="stars" width="5%"/>
</acme:list>