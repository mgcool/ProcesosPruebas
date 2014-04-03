<%@ page import="procesostest.Concepto_RC" %>
<g:hiddenField name="contador" value="contador"/><!--IMPORTANTE para no repetir el ciclo infinitamente recuperamos el último valor del contador, de lo contrario se reinicializa-->
<!--div class="fieldcontain ${hasErrors(bean: reglaCalculoInstance, field: 'formulaExplicita', 'error')} "-->
<br>
<label for="operadorInicial">
		<g:message code="reglaCalculo.operadorInicial.label" default="Op.Ini." />
		<span class="required-indicator">*</span>
</label>
   <g:select name="opIni${contador}" from="${['+', '-', '*', '/', '%', '^']}" value="" />
   <g:select name="opcional1${contador}" from="${['(', ')', '']}" value=""  />
   <label for="cid${contador}">
		<g:message code="reglaCalculo.concepto.label" default="Concepto" />	
    </label>
    <g:select id="cid${contador}" name="cid.id" from="${procesostest.Concepto_RC.list()}" 
            optionKey="valor" optionValue="descripcion" required="true" value="${reglaCalculoInstance?.formulaExplicita}"  
            noSelection="['null':'- Seleccione un CONCEPTO -']"
        />
    <g:select name="opcional2${contador}" from="${['(', ')', '']}" value=""  />
<br>
<!--/div-->   
