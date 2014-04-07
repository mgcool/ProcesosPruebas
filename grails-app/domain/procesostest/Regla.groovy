package procesostest

import procesostest.*

class Regla {
    
    Integer  id
    Proceso pid
    String  descripcion
    Date    iniVig
    Date    finVig
    String  status
    String  objAfe1
    String  attrAfe1
    String  operador1
    String  valorAsignado1
    String  condicion
    String  objCond1
    String  attrCond1
    String  operadorCondicion
    String  valorCondicion1
    String  objCond2
    String  attrCond2
    String  valorCondicion2
    String  operadorEnlace
    String  condicionEnlazada
    String  sql
    
    static constraints = {
                    objAfe1(blank: true, nullable: true)
                    attrAfe1(blank: true, nullable: true)
                    operador1(blank: true, nullable: true)
                    valorAsignado1(blank: true, nullable: true)
                    condicion(blank: true, nullable: true)
                    objCond1(blank: true, nullable: true)
                    attrCond1(blank: true, nullable: true)
                    operadorCondicion(blank: true, nullable: true)
                    valorCondicion1(blank: true, nullable: true)
                    objCond2(blank: true, nullable: true)
                    attrCond2(blank: true, nullable: true)
                    valorCondicion2(blank: true, nullable: true)
                    operadorEnlace(blank: true, nullable: true)
                    condicionEnlazada(blank: true, nullable: true)
                    sql(blank: true, nullable: true)
    }
    
    /*String toString() {
        "$id - $nombcomp"
    }*/
    
}
