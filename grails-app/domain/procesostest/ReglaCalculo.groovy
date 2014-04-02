package procesostest

import procesostest.Proceso

class ReglaCalculo {

    Integer id
    Integer numConceptos
    String  formulaConceptual
    String  formulaExplicita
    Date    iniVig
    Date    finVig
    Proceso pid
    String  objAfe1
    String  attrAfe1
    String  valorAsignado1
    
    static constraints = {
    }
}