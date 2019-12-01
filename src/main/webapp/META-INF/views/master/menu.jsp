<%--
- menu.jsp
-
- Copyright (c) 2019 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java" import="acme.framework.helpers.PrincipalHelper,acme.entities.roles.Provider,acme.entities.roles.Consumer,acme.entities.roles.Auditor"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:menu-bar code="master.menu.home">
	<acme:menu-left>
		<acme:menu-option code="master.menu.anonymous" access="isAnonymous()">
		    <acme:menu-suboption code="master.menu.anonymous.alebarmor-link" action="https://twitter.com/LordKelvin2099/"/>
		    <acme:menu-suboption code="master.menu.anonymous.luca-link" action="https://www.linkedin.com/in/luca-bonacini-a6b650173/"/>
     	    <acme:menu-suboption code="master.menu.anonymous.miguel-link" action="http://www.pccomponentes.com/"/>
   		  	<acme:menu-suboption code="master.menu.anonymous.alberto-link" action="https://www.linkedin.com/in/alberto-toledo-mayorga-072419173/"/>
          	<acme:menu-suboption code="master.menu.anonymous.listar-barba-bulletin" action="/anonymous/barba-bulletin/list"/>
          	<acme:menu-suboption code="master.menu.anonymous.crear-barba-bulletin" action="/anonymous/barba-bulletin/create"/>
    	  	<acme:menu-suboption code="master.menu.anonymous.bonacini-bulletin-list" action="/anonymous/bonacini-bulletin/list"/>
		    <acme:menu-suboption code="master.menu.anonymous.bonacini-bulletin-create" action="/anonymous/bonacini-bulletin/create"/>
          	<acme:menu-suboption code="master.menu.anonymous.listar-paton-bulletin" action="/anonymous/paton-bulletin/list/"/>
          	<acme:menu-suboption code="master.menu.anonymous.crear-paton-bulletin" action="/anonymous/paton-bulletin/create/"/>
          	<acme:menu-suboption code="master.menu.anonymous.listar-toledo-bulletin" action="/anonymous/toledo-bulletin/list"/>
			<acme:menu-suboption code="master.menu.anonymous.crear-toledo-bulletin" action="/anonymous/toledo-bulletin/create"/>
		</acme:menu-option>
		
		<acme:menu-option code="master.menu.announcement" access="isAnonymous()">
			<acme:menu-suboption code="master.menu.announcement.monthly" action="/anonymous/announcement/list-monthly"/>
    	</acme:menu-option>

		<acme:menu-option code="master.menu.company-record" access="isAnonymous()">
			<acme:menu-suboption code="master.menu.company-record.list" action="/anonymous/company-record/list"/>
			<acme:menu-suboption code="master.menu.company-record.list-top" action="/anonymous/company-record/list-top"/>
		</acme:menu-option>
		
		<acme:menu-option code="master.menu.investor-record" access="isAnonymous()">
			<acme:menu-suboption code="master.menu.investor-record.list" action="/anonymous/investor-record/list"/>
			<acme:menu-suboption code="master.menu.investor-record.list-top" action="/anonymous/investor-record/list-top"/>
		</acme:menu-option>
		
		<acme:menu-option code="master.menu.announcement" access="isAuthenticated()">
			<acme:menu-suboption code="master.menu.announcement.monthly" action="/authenticated/announcement/list-monthly"/>
			<acme:menu-suboption code="master.menu.announcement.all" action="/administrator/announcement/list" access="hasRole('Administrator')"/>
			<acme:menu-suboption code="master.menu.announcement.create" action="/administrator/announcement/create" access="hasRole('Administrator')"/>
		</acme:menu-option>
		
		<acme:menu-option code="master.menu.offer" access="isAuthenticated()">
			<acme:menu-suboption code="master.menu.offer.active-offers" action="/authenticated/offer/list-active" access="!hasRole('Consumer')"/>
			<acme:menu-suboption code="master.menu.offer.active-offers" action="/consumer/offer/list-active" access="hasRole('Consumer')"	/>
			<acme:menu-suboption code="master.menu.offer.create" action="/consumer/offer/create" access="hasRole('Consumer')"/>
    	</acme:menu-option>
    
        <acme:menu-option code="master.menu.request" access="isAuthenticated()">
			<acme:menu-suboption code="master.menu.request.active-requests" action="/authenticated/request/list-active" access="!hasRole('Provider')"/>
			<acme:menu-suboption code="master.menu.request.active-requests" action="/provider/request/list-active" access="hasRole('Provider')"/>
			<acme:menu-suboption code="master.menu.request.create" action="/provider/request/create" access="hasRole('Provider')"/>
    	</acme:menu-option>

		<acme:menu-option code="master.menu.company-record" access="isAuthenticated()">
			<acme:menu-suboption access="!hasRole('Administrator')" code="master.menu.company-record.list" action="/authenticated/company-record/list"/>
			<acme:menu-suboption access="hasRole('Administrator')" code="master.menu.company-record.list" action="/administrator/company-record/list"/>
			<acme:menu-suboption access="hasRole('Administrator')" code="master.menu.company-record.create" action="/administrator/company-record/create"/>
		</acme:menu-option>
		
		<acme:menu-option code="master.menu.investor-record" access="isAuthenticated()">
			<acme:menu-suboption access="!hasRole('Administrator')" code="master.menu.investor-record.list" action="/authenticated/investor-record/list"/>
			<acme:menu-suboption access="hasRole('Administrator')" code="master.menu.investor-record.list" action="/administrator/investor-record/list"/>
			<acme:menu-suboption access="hasRole('Administrator')" code="master.menu.investor-record.create" action="/administrator/investor-record/create"/>
		</acme:menu-option>
		
		<acme:menu-option code="master.menu.challenge" access="isAuthenticated()">
			<acme:menu-suboption code="master.menu.challenge.list-active" action="/authenticated/challenge/list-active" access="!hasRole('Administrator')" />
			<acme:menu-suboption code="master.menu.challenge.list-active" action="/administrator/challenge/list-active" access="hasRole('Administrator')"/>
			<acme:menu-suboption code="master.menu.challenge.list" action="/administrator/challenge/list" access="hasRole('Administrator')"/>		
			<acme:menu-suboption code="master.menu.challenge.create" action="/administrator/challenge/create" access="hasRole('Administrator')"/>
		</acme:menu-option>
		
		<acme:menu-option code="master.menu.banner" access="hasRole('Administrator')">
			<acme:menu-suboption code="master.menu.commercial-banner.list" action="/administrator/commercial-banner/list"/>
			<acme:menu-suboption code="master.menu.non-commercial-banner.list" action="/administrator/non-commercial-banner/list"/>
			<acme:menu-suboption code="master.menu.commercial-banner.create" action="/administrator/commercial-banner/create"/>
			<acme:menu-suboption code="master.menu.non-commercial-banner.create" action="/administrator/non-commercial-banner/create"/>
		</acme:menu-option>
	</acme:menu-left>
	

	<acme:menu-right>
		
		<acme:menu-option code="master.menu.sign-up" action="/anonymous/user-account/create" access="isAnonymous()"/>
		<acme:menu-option code="master.menu.sign-in" action="/master/sign-in" access="isAnonymous()"/>
	
		<acme:menu-option code="master.menu.administrator" access="hasRole('Administrator')">
			<acme:menu-suboption code="master.menu.administrator.user-accounts" action="/administrator/user-account/list"/>
			<acme:menu-suboption code="master.menu.administrator.dashboard" action="/administrator/dashboard/show"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.administrator.configuration" action="/administrator/configuration/display"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.administrator.shutdown" action="/master/shutdown"/>
		</acme:menu-option>

		<acme:menu-option code="master.menu.provider" access="hasRole('Provider')">
			<acme:menu-suboption code="master.menu.provider.favourite-link" action="http://www.example.com/"/>
		</acme:menu-option>

		<acme:menu-option code="master.menu.consumer" access="hasRole('Consumer')">
			<acme:menu-suboption code="master.menu.consumer.favourite-link" action="http://www.example.com/"/>
		</acme:menu-option>	

		<acme:menu-option code="master.menu.user-account" access="isAuthenticated()">
			<acme:menu-suboption code="master.menu.user-account.general-data" action="/authenticated/user-account/update"/>
			<acme:menu-suboption code="master.menu.user-account.become-provider" action="/authenticated/provider/create" access="!hasRole('Provider')"/>
			<acme:menu-suboption code="master.menu.user-account.provider" action="/authenticated/provider/update" access="hasRole('Provider')"/>
			<acme:menu-suboption code="master.menu.user-account.become-consumer" action="/authenticated/consumer/create" access="!hasRole('Consumer')"/>
			<acme:menu-suboption code="master.menu.user-account.consumer" action="/authenticated/consumer/update" access="hasRole('Consumer')"/>
			<acme:menu-suboption code="master.menu.user-account.become-auditor" action="/authenticated/auditor/create" access="!hasRole('Auditor')"/>
			<acme:menu-suboption code="master.menu.user-account.auditor" action="/authenticated/auditor/update" access="hasRole('Auditor')"/>
		</acme:menu-option>
		
		<acme:menu-option code="master.menu.audit-record" access="hasRole('Auditor')">
			<acme:menu-suboption code="master.menu.audit-record-mine" action="/auditor/audit-record/list-written"/>
		</acme:menu-option>

		<acme:menu-option code="master.menu.sign-out" action="/master/sign-out" access="isAuthenticated()"/>
	</acme:menu-right>
</acme:menu-bar>

