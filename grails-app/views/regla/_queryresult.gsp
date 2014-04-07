<%@ page import="procesostest.Regla" %>

<div id="resquery" class="fieldcontain ${hasErrors(bean: reglaInstance, field: 'sql', 'error')} required">
	<label for="sql">
		<g:message code="regla.finVig.label" default="Sql" />
		<span class="required-indicator">*</span>
	</label>
	<g:textArea name="sql"  value="${resquery}"  rows="5" cols="50"/>
</div>