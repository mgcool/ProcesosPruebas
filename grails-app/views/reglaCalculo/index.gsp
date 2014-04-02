
<%@ page import="procesostest.ReglaCalculo" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'reglaCalculo.label', default: 'ReglaCalculo')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-reglaCalculo" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-reglaCalculo" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="attrAfe1" title="${message(code: 'reglaCalculo.attrAfe1.label', default: 'Attr Afe1')}" />
					
						<g:sortableColumn property="finVig" title="${message(code: 'reglaCalculo.finVig.label', default: 'Fin Vig')}" />
					
						<g:sortableColumn property="formulaConceptual" title="${message(code: 'reglaCalculo.formulaConceptual.label', default: 'Formula Conceptual')}" />
					
						<g:sortableColumn property="formulaExplicita" title="${message(code: 'reglaCalculo.formulaExplicita.label', default: 'Formula Explicita')}" />
					
						<g:sortableColumn property="iniVig" title="${message(code: 'reglaCalculo.iniVig.label', default: 'Ini Vig')}" />
					
						<g:sortableColumn property="numConceptos" title="${message(code: 'reglaCalculo.numConceptos.label', default: 'Num Conceptos')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${reglaCalculoInstanceList}" status="i" var="reglaCalculoInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${reglaCalculoInstance.id}">${fieldValue(bean: reglaCalculoInstance, field: "attrAfe1")}</g:link></td>
					
						<td><g:formatDate date="${reglaCalculoInstance.finVig}" /></td>
					
						<td>${fieldValue(bean: reglaCalculoInstance, field: "formulaConceptual")}</td>
					
						<td>${fieldValue(bean: reglaCalculoInstance, field: "formulaExplicita")}</td>
					
						<td><g:formatDate date="${reglaCalculoInstance.iniVig}" /></td>
					
						<td>${fieldValue(bean: reglaCalculoInstance, field: "numConceptos")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${reglaCalculoInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
