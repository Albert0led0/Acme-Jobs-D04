<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="administrator.commercial-banner.list.label.picture-url" path="pictureURL" width="20%"/>
	<acme:list-column code="administrator.commercial-banner.list.label.slogan" path="slogan" width="20%"/>	
	<acme:list-column code="administrator.commercial-banner.list.label.target-url" path="targetURL" width="20%"/>		
</acme:list> 