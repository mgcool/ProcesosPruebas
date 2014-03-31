package procesostest



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ReglaController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Regla.list(params), model:[reglaInstanceCount: Regla.count()]
    }

    def show(Regla reglaInstance) {
        respond reglaInstance
    }

    def create() {
        respond new Regla(params)
    }

    @Transactional
    def save(Regla reglaInstance) {
        
                    if (params.objAfe1 == null || params.objAfe1 == ''){
                        params.objAfe1 = ''
                    }else{
                        params.objAfe1 = params.objAfe1
                    }
                    
                    if (params.attrAfe1 == null || params.attrAfe1 == ''){
                        params.attrAfe1 = ''
                    }else{
                        params.attrAfe1 = params.attrAfe1
                    }
                    
                    if (params.operador1 == null || params.operador1 == ''){
                        params.operador1 = ''
                    }else{
                        params.operador1 = params.operador1
                    }
        
                    if (params.valorAsignado1 == null || params.valorAsignado1 == ''){
                        params.valorAsignado1 = ''
                    }else{
                        params.valorAsignado1 = params.valorAsignado1
                    }
                    
                    if (params.condicion == null || params.condicion == ''){
                        params.condicion = ''
                    }else{
                        params.condicion = params.condicion
                    }
                    
                    if (params.objCond1 == null || params.objCond1 == ''){
                        params.objCond1 = ''
                    }else{
                        params.objCond1 = params.objCond1
                    }
                    
                    if (params.attrCond1 == null || params.attrCond1 == ''){
                        params.attrCond1 = ''
                    }else{
                        params.attrCond1 = params.attrCond1
                    }
                    
                    if (params.operadorCondicion == null || params.operadorCondicion == ''){
                        params.operadorCondicion = ''
                    }else{
                        params.operadorCondicion = params.operadorCondicion
                    }
                    
                    if (params.valorCondicion1 == null || params.valorCondicion1 == ''){
                        params.valorCondicion1 = ''
                    }else{
                        params.valorCondicion1 = params.valorCondicion1
                    }
                    
                    if (params.objCond2 == null || params.objCond2 == ''){
                        params.objCond2 = ''
                    }else{
                        params.objCond2 = params.objCond2
                    }
                     
                    if (params.attrCond2 == null || params.attrCond2 == ''){
                        params.attrCond2 = ''
                    }else{
                        params.attrCond2 = params.attrCond2
                    }
                     
                    if (params.valorCondicion2 == null || params.valorCondicion2 == ''){
                        params.valorCondicion2 = ''
                    }else{
                        params.valorCondicion2 = params.valorCondicion2
                    }
                    
                    if (params.operadorEnlace == null || params.operadorEnlace == ''){
                        params.operadorEnlace = ''
                    }else{
                        params.operadorEnlace = params.operadorEnlace
                    }
                    
                    if (params.condicionEnlazada == null || params.condicionEnlazada == ''){
                        params.condicionEnlazada = ''
                    }else{
                        params.condicionEnlazada = params.condicionEnlazada
                    } 
        
        println(params)
        if (reglaInstance == null) {
            notFound()
            return
        }

        if (reglaInstance.hasErrors()) {
            respond reglaInstance.errors, view:'create'
            return
        }

        reglaInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'reglaInstance.label', default: 'Regla'), reglaInstance.id])
                redirect reglaInstance
            }
            '*' { respond reglaInstance, [status: CREATED] }
        }
    }

    def edit(Regla reglaInstance) {
        respond reglaInstance
    }

    @Transactional
    def update(Regla reglaInstance) {
        if (reglaInstance == null) {
            notFound()
            return
        }

        if (reglaInstance.hasErrors()) {
            respond reglaInstance.errors, view:'edit'
            return
        }

        reglaInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Regla.label', default: 'Regla'), reglaInstance.id])
                redirect reglaInstance
            }
            '*'{ respond reglaInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Regla reglaInstance) {

        if (reglaInstance == null) {
            notFound()
            return
        }

        reglaInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Regla.label', default: 'Regla'), reglaInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'reglaInstance.label', default: 'Regla'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
