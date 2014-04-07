package procesostest

class CommonController {

        def common(){
                                                            
                                                            String q = ("UPDATE $params.objAfe1 SET $params.attrAfe1 $params.operador1 $params.valorAsignado1 $params.condicion WHERE $params.objCond1.$params.attrCond1 $params.operadorCondicion $params.objCond2$params.attrCond2$params.valorCondicion2 $params.operadorEnlace ") 
                                                            String q2
                                
                                                            while(params.operadorEnlace != null){
                                                                    println "Entrando al metodo de comprobacion de reglas"
                                                                    Regla rid = Regla.get(params.condicionEnlazada)
                                                                    q2 = ("$rid.objCond1.$rid.attrCond1 $rid.operadorCondicion $rid.objCond2$rid.attrCond2$rid.valorCondicion2 $rid.operadorEnlace ")
                                                                    q+=q2
                                                                    params.operadorEnlace = rid.operadorEnlace
                                                                    params.condicionEnlazada = rid.condicionEnlazada
                                                            } 
                                                             
                                                           String query = q.replaceAll("null", '')
                                                           render(template: "queryresult",  model:[resquery: query])     
                                                         
                                                         
                                                         
          }
}
        
