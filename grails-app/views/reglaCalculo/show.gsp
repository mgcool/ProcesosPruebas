
<%@ page import="procesostest.ReglaCalculo" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'reglaCalculo.label', default: 'ReglaCalculo')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-reglaCalculo" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-reglaCalculo" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list reglaCalculo">
			
				<g:if test="${reglaCalculoInstance?.attrAfe1}">
				<li class="fieldcontain">
					<span id="attrAfe1-label" class="property-label"><g:message code="reglaCalculo.attrAfe1.label" default="Attr Afe1" /></span>
					
						<span class="property-value" aria-labelledby="attrAfe1-label"><g:fieldValue bean="${reglaCalculoInstance}" field="attrAfe1"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${reglaCalculoInstance?.finVig}">
				<li class="fieldcontain">
					<span id="finVig-label" class="property-label"><g:message code="reglaCalculo.finVig.label" default="Fin Vig" /></span>
					
						<span class="property-value" aria-labelledby="finVig-label"><g:formatDate date="${reglaCalculoInstance?.finVig}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${reglaCalculoInstance?.formulaConceptual}">
				<li class="fieldcontain">
					<span id="formulaConceptual-label" class="property-label"><g:message code="reglaCalculo.formulaConceptual.label" default="Formula Conceptual" /></span>
					
						<span class="property-value" aria-labelledby="formulaConceptual-label"><g:fieldValue bean="${reglaCalculoInstance}" field="formulaConceptual"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${reglaCalculoInstance?.formulaExplicita}">
				<li class="fieldcontain">
					<span id="formulaExplicita-label" class="property-label"><g:message code="reglaCalculo.formulaExplicita.label" default="Formula Explicita" /></span>
					
						<span class="property-value" aria-labelledby="formulaExplicita-label"><g:fieldValue bean="${reglaCalculoInstance}" field="formulaExplicita"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${reglaCalculoInstance?.iniVig}">
				<li class="fieldcontain">
					<span id="iniVig-label" class="property-label"><g:message code="reglaCalculo.iniVig.label" default="Ini Vig" /></span>
					
						<span class="property-value" aria-labelledby="iniVig-label"><g:formatDate date="${reglaCalculoInstance?.iniVig}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${reglaCalculoInstance?.numConceptos}">
				<li class="fieldcontain">
					<span id="numConceptos-label" class="property-label"><g:message code="reglaCalculo.numConceptos.label" default="Num Conceptos" /></span>
					
						<span class="property-value" aria-labelledby="numConceptos-label"><g:fieldValue bean="${reglaCalculoInstance}" field="numConceptos"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${reglaCalculoInstance?.objAfe1}">
				<li class="fieldcontain">
					<span id="objAfe1-label" class="property-label"><g:message code="reglaCalculo.objAfe1.label" default="Obj Afe1" /></span>
					
						<span class="property-value" aria-labelledby="objAfe1-label"><g:fieldValue bean="${reglaCalculoInstance}" field="objAfe1"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${reglaCalculoInstance?.pid}">
				<li class="fieldcontain">
					<span id="pid-label" class="property-label"><g:message code="reglaCalculo.pid.label" default="Pid" /></span>
					
						<span class="property-value" aria-labelledby="pid-label"><g:link controller="proceso" action="show" id="${reglaCalculoInstance?.pid?.id}">${reglaCalculoInstance?.pid?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${reglaCalculoInstance?.valorAsignado1}">
				<li class="fieldcontain">
					<span id="valorAsignado1-label" class="property-label"><g:message code="reglaCalculo.valorAsignado1.label" default="Valor Asignado1" /></span>
					
						<span class="property-value" aria-labelledby="valorAsignado1-label"><g:fieldValue bean="${reglaCalculoInstance}" field="valorAsignado1"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:reglaCalculoInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${reglaCalculoInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
