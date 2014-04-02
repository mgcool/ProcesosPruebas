package procesostest



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ReglaCalculoController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond ReglaCalculo.list(params), model:[reglaCalculoInstanceCount: ReglaCalculo.count()]
    }

    def show(ReglaCalculo reglaCalculoInstance) {
        respond reglaCalculoInstance
    }

    def create() {
        respond new ReglaCalculo(params)
    }

    def getConceptos(){
        def numConceptos = params.cvalue
        int noConceptos = Integer.parseInt(numConceptos)
        println("hola "+ noConceptos)
        
        for(int cont=0;cont<noConceptos;cont++){
            
            println("hola"+cont)
            //render(template:"concept")
            render("<div id='concept"+cont+"'>concept"+cont+"<br></div>")
        }
        
    }
    
    @Transactional
    def save(ReglaCalculo reglaCalculoInstance) {
        if (reglaCalculoInstance == null) {
            notFound()
            return
        }

        if (reglaCalculoInstance.hasErrors()) {
            respond reglaCalculoInstance.errors, view:'create'
            return
        }

        reglaCalculoInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'reglaCalculoInstance.label', default: 'ReglaCalculo'), reglaCalculoInstance.id])
                redirect reglaCalculoInstance
            }
            '*' { respond reglaCalculoInstance, [status: CREATED] }
        }
    }

    def edit(ReglaCalculo reglaCalculoInstance) {
        respond reglaCalculoInstance
    }

    @Transactional
    def update(ReglaCalculo reglaCalculoInstance) {
        if (reglaCalculoInstance == null) {
            notFound()
            return
        }

        if (reglaCalculoInstance.hasErrors()) {
            respond reglaCalculoInstance.errors, view:'edit'
            return
        }

        reglaCalculoInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'ReglaCalculo.label', default: 'ReglaCalculo'), reglaCalculoInstance.id])
                redirect reglaCalculoInstance
            }
            '*'{ respond reglaCalculoInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(ReglaCalculo reglaCalculoInstance) {

        if (reglaCalculoInstance == null) {
            notFound()
            return
        }

        reglaCalculoInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'ReglaCalculo.label', default: 'ReglaCalculo'), reglaCalculoInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'reglaCalculoInstance.label', default: 'ReglaCalculo'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
