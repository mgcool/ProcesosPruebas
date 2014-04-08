package procesostest

import procesostest.Proceso

class ReglaSeleccion {
    
    Integer id
    String  sqlQuery
    Proceso pid
    String  status
    Date    iniVig
    Date    finVig
   

    static constraints = {
        sqlQuery(maxSize: 4000)
        status(blank: true, nullable: true)
    }
}
