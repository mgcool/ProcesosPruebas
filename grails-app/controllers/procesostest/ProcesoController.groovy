package procesostest



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ProcesoController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Proceso.list(params), model:[procesoInstanceCount: Proceso.count()]
    }

    def show(Proceso procesoInstance) {
        respond procesoInstance
    }

    def create() {
        respond new Proceso(params)
    }

    @Transactional
    def save(Proceso procesoInstance) {
        if (procesoInstance == null) {
            notFound()
            return
        }

        if (procesoInstance.hasErrors()) {
            respond procesoInstance.errors, view:'create'
            return
        }

        procesoInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'procesoInstance.label', default: 'Proceso'), procesoInstance.id])
                redirect procesoInstance
            }
            '*' { respond procesoInstance, [status: CREATED] }
        }
    }

    def edit(Proceso procesoInstance) {
        respond procesoInstance
    }

    @Transactional
    def update(Proceso procesoInstance) {
        if (procesoInstance == null) {
            notFound()
            return
        }

        if (procesoInstance.hasErrors()) {
            respond procesoInstance.errors, view:'edit'
            return
        }

        procesoInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Proceso.label', default: 'Proceso'), procesoInstance.id])
                redirect procesoInstance
            }
            '*'{ respond procesoInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Proceso procesoInstance) {

        if (procesoInstance == null) {
            notFound()
            return
        }

        procesoInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Proceso.label', default: 'Proceso'), procesoInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'procesoInstance.label', default: 'Proceso'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
