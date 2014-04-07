<label for="secuencia">
		<g:message code="secflujoflujo.secuencia.label" default="Procesos" />
		<span class="required-indicator">*</span>
</label>

<select id="selectsecuencia" from="${list}" name="selectsecuencia" value="" multiple="true"  onchange="SeleccionMultiple (this)">
    <g:each var="l" in="${list}">
             <option value="${l.id}">${l}</option>
    </g:each>
</select>

<input id="arregloSecuencia" type="text" name="arregloSecuencia">
