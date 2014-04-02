<%@ page import="procesostest.Concepto_RC" %>
<!--div class="fieldcontain ${hasErrors(bean: reglaCalculoInstance, field: 'formulaExplicita', 'error')} "-->
<label for="operadorInicial">
		<g:message code="reglaCalculo.operadorInicial.label" default="operadorInicial" />
		<span class="required-indicator">*</span>
</label>
   <g:select name="opIni" from="${['+', '-', '*', '/', '%', '^']}" value="" />
   <g:select name="opcional1" from="${['(', ')', '']}" value=""  />
   <label for="concepto">
		<g:message code="reglaCalculo.concepto.label" default="Concepto" />
		
    </label>
    <g:select id="cid" name="cid.id" from="${procesostest.Concepto_RC.list()}" 
            optionKey="valor" optionValue="descripcion" required="true" value="${reglaCalculoInstance?.formulaExplicita}"  
            noSelection="['null':'- Seleccione un CONCEPTO -']"
        />
    <g:select name="opcional2" from="${['(', ')', '']}" value=""  />
<!--/div-->   