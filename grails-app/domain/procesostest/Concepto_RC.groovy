package procesostest

import procesostest.ReglaCalculo

class Concepto_RC{
    
    Integer         id
    String          descripcion
    String          valor
    
    
    static constraints = {
        valor(maxSize: 4000)
    }
}
