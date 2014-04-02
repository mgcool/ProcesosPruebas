<%@ page import="procesostest.Concepto_RC" %>



<div class="fieldcontain ${hasErrors(bean: concepto_RCInstance, field: 'valor', 'error')} ">
	<label for="valor">
		<g:message code="concepto_RC.valor.label" default="Valor" />
		
	</label>
	<g:textArea name="valor" cols="40" rows="5" maxlength="4000" value="${concepto_RCInstance?.valor}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: concepto_RCInstance, field: 'descripcion', 'error')} ">
	<label for="descripcion">
		<g:message code="concepto_RC.descripcion.label" default="Descripcion" />
		
	</label>
	<g:textField name="descripcion" value="${concepto_RCInstance?.descripcion}"/>

</div>

