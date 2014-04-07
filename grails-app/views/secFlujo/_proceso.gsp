<head>
                                        <script type="text/javascript">
                                                        function dimePropiedades(){
    var texto
    texto = "El numero de opciones del select: " + document.secuencia.length
    var indice = document.secuencia.selectedIndex
    texto += "nIndice de la opcion escogida: " + indice
    var valor = document.secuencia.options[indice].value
    texto += "nValor de la opcion escogida: " + valor
    var textoEscogido = document.secuencia.options[indice].text
    texto += "nTexto de la opcion escogida: " + textoEscogido
    alert(texto) }       
                                     </script>   
</head>    

<label for="secuencia">
		<g:message code="secflujoflujo.secuencia.label" default="Procesos" />
		<span class="required-indicator">*</span>
</label>

<select id="secuencia" from="${list}" name="secuencia" value="" multiple="true" onchange="dimePropiedades()">
    <g:each var="l" in="${list}">
             <option value="${l.id}">${l}</option>
    </g:each>
</select>