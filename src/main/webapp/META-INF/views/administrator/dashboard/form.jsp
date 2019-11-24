	<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<style>
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
div.containerL{
display: inline-block;
width: 40%
}
div.containerR{
display: inline-block;
width: 40%}
</style>
<h1>
	<acme:message code="administrator.dashboard.form.title" />
</h1>
<table>
	<tr>
		<td>
			<acme:message code="administrator.dashboard.form.table.cell.number-announcements"/>
		</td>
		<td>
			<acme:print value="${ numberOfAnnouncements}"/>
		</td>
	</tr>
	<tr>
		<td>
			<acme:message code="administrator.dashboard.form.table.cell.number-companies"/>
		</td>
		<td>
			<acme:print value="${ numberOfCompanyRecords}"/>
		</td>
	</tr>
	<tr>
		<td>
			<acme:message code="administrator.dashboard.form.table.cell.number-investors"/>
		</td>
		<td>
			<acme:print value="${ numberOfInvestorRecords}"/>
		</td>
	</tr>
</table>
<br />
<br />
<table>
	<tr>
		<th colspan="2">
			<acme:message code="administrator.dashboard.form.table.title.rewards-active-requests"/>
		</th>
	</tr>
	<tr>
		<td>
			<acme:message code="administrator.dashboard.form.table.cell.stats.min"/>
		</td>
		<td>
			<acme:print value="${ minimumRewardActiveRequests}"/>
		</td>
	</tr>
	<tr>
		<td>
			<acme:message code="administrator.dashboard.form.table.cell.stats.max"/>
		</td>
		<td>
			<acme:print value="${ maximumRewardActiveRequests}"/>
		</td>
	</tr>
	<tr>
		<td>
			<acme:message code="administrator.dashboard.form.table.cell.stats.avg"/>	
		</td>
		<td>
			<acme:print value="${ averageRewardActiveRequests}"/>
		</td>
	</tr>
	<tr>
		<td>
			<acme:message code="administrator.dashboard.form.table.cell.stats.stddev"/>
		</td>
		<td>
			<acme:print value="${ stddevRewardActiveRequests}"/>
		</td>
	</tr>
</table>
<br />
<br />
<table>
	<tr>
		<th colspan="2">
			<acme:message code="administrator.dashboard.form.table.title.min-rewards-active-offers"/>
		</th>
	</tr>
	<tr>
		<td>
			<acme:message code="administrator.dashboard.form.table.cell.stats.min"/>
		</td>
		<td>
			<acme:print value="${ minimumMinRewardActiveOffers}"/>
		</td>
	</tr>
	<tr>
		<td>
			<acme:message code="administrator.dashboard.form.table.cell.stats.max"/>
		</td>
		<td>
			<acme:print value="${ maximumMinRewardActiveOffers}"/>
		</td>
	</tr>
	<tr>
		<td>
			<acme:message code="administrator.dashboard.form.table.cell.stats.avg"/>	
		</td>
		<td>
			<acme:print value="${ averageMinRewardActiveOffers}"/>
		</td>
	</tr>
	<tr>
		<td>
			<acme:message code="administrator.dashboard.form.table.cell.stats.stddev"/>
		</td>
		<td>
			<acme:print value="${ stddevMinRewardActiveOffers}"/>
		</td>
	</tr>
</table>
<br />
<br />
<table>
	<tr>
		<th colspan="2">
			<acme:message code="administrator.dashboard.form.table.title.max-rewards-active-offers"/>
		</th>
	</tr>
	<tr>
		<td>
			<acme:message code="administrator.dashboard.form.table.cell.stats.min"/>
		</td>
		<td>
			<acme:print value="${ minimumMaxRewardActiveOffers}"/>
		</td>
	</tr>
	<tr>
		<td>
			<acme:message code="administrator.dashboard.form.table.cell.stats.max"/>
		</td>
		<td>
			<acme:print value="${ maximumMaxRewardActiveOffers}"/>
		</td>
	</tr>
	<tr>
		<td>
			<acme:message code="administrator.dashboard.form.table.cell.stats.avg"/>	
		</td>
		<td>
			<acme:print value="${ averageMaxRewardActiveOffers}"/>
		</td>
	</tr>
	<tr>
		<td>
			<acme:message code="administrator.dashboard.form.table.cell.stats.stddev"/>
		</td>
		<td>
			<acme:print value="${ stddevMaxRewardActiveOffers}"/>
		</td>
	</tr>
</table>
<br />
<h2></h2>
<div class="containerL">
	<b><acme:message code="administrator.dashboard.form.chart.title.companies-by-sector"/></b>
	<canvas id="chart-area"></canvas>
</div>

<div class="containerR">
	<b><acme:message code="administrator.dashboard.form.chart.title.investors-by-sector"/></b>
	<canvas id="chart-area2" ></canvas>
</div>
	
<script type="text/javascript">
	$(document).ready(function() {
		var data = {
			labels : [
				<jstl:forEach var="sector" items="${cSectors}" varStatus="loop">
					"<jstl:out value="${sector}"/>"
					<jstl:if test="${!loop.last}"> ,</jstl:if>
				</jstl:forEach>		
			],
			datasets: [
				{
					data: [
						<jstl:forEach var="companiesNum" items="${companiesBySector}" varStatus="loop">
							<jstl:out value="${companiesNum}"/>
							<jstl:if test="${!loop.last}"> ,</jstl:if>
							
						</jstl:forEach>
					],
					backgroundColor : [
						<jstl:forEach var="companiesNum" items="${companiesBySector}" varStatus="loop">
							<jstl:choose>
								<jstl:when test="${loop.count % 3 == 1}">
									'rgba(50,0,200,1)'
								</jstl:when>
								
								<jstl:when test="${loop.count % 3 == 2}">
									'rgba(200, 50, 0, 1)'
								</jstl:when>
								
								<jstl:otherwise>
									'rgba(0, 200, 50, 1)'
								</jstl:otherwise>
							</jstl:choose>
							<jstl:if test="${!loop.last}"> ,</jstl:if>
						</jstl:forEach>
					]
				}
			]
		};
		var options = {
				responsive : true
			};
		var canvas, context;
		
		canvas = document.getElementById("chart-area");
		context = canvas.getContext("2d");
		new Chart(context, {
			type : "pie",
			data : data,
			options : options
		});
	});
</script>

<script type="text/javascript">
	$(document).ready(function() {
		var data = {
			labels : [
				<jstl:forEach var="sector" items="${iSectors}" varStatus="loop">
					"<jstl:out value="${sector}"/>"
					<jstl:if test="${!loop.last}"> ,</jstl:if>
				</jstl:forEach>		
			],
			datasets: [
				{
					data: [
						<jstl:forEach var="investorsNum" items="${investorsBySector}" varStatus="loop">
							<jstl:out value="${investorsNum}"/>
							<jstl:if test="${!loop.last}"> ,</jstl:if>
							
						</jstl:forEach>
					],
					backgroundColor : [
						<jstl:forEach var="investorsNum" items="${investorsBySector}" varStatus="loop">
							<jstl:choose>
								<jstl:when test="${loop.count % 3 == 1}">
									'rgba(50,0,200,1)'
								</jstl:when>
								
								<jstl:when test="${loop.count % 3 == 2}">
									'rgba(200, 50, 0, 1)'
								</jstl:when>
								
								<jstl:otherwise>
									'rgba(0, 200, 50, 1)'
								</jstl:otherwise>
							</jstl:choose>
							<jstl:if test="${!loop.last}"> ,</jstl:if>
						</jstl:forEach>
					]
				}
			]
		};
		var options = {
				responsive : true
			};
		var canvas, context;
		
		canvas = document.getElementById("chart-area2");
		context = canvas.getContext("2d");
		new Chart(context, {
			type : "pie",
			data : data,
			options : options
		});
	});
</script>
