package procesostest



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class StatusProcesoController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond StatusProceso.list(params), model:[statusProcesoInstanceCount: StatusProceso.count()]
    }

    def show(StatusProceso statusProcesoInstance) {
        respond statusProcesoInstance
    }

    def create() {
        respond new StatusProceso(params)
    }

    @Transactional
    def save(StatusProceso statusProcesoInstance) {
        if (statusProcesoInstance == null) {
            notFound()
            return
        }

        if (statusProcesoInstance.hasErrors()) {
            respond statusProcesoInstance.errors, view:'create'
            return
        }

        statusProcesoInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'statusProcesoInstance.label', default: 'StatusProceso'), statusProcesoInstance.id])
                redirect statusProcesoInstance
            }
            '*' { respond statusProcesoInstance, [status: CREATED] }
        }
    }

    def edit(StatusProceso statusProcesoInstance) {
        respond statusProcesoInstance
    }

    @Transactional
    def update(StatusProceso statusProcesoInstance) {
        if (statusProcesoInstance == null) {
            notFound()
            return
        }

        if (statusProcesoInstance.hasErrors()) {
            respond statusProcesoInstance.errors, view:'edit'
            return
        }

        statusProcesoInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'StatusProceso.label', default: 'StatusProceso'), statusProcesoInstance.id])
                redirect statusProcesoInstance
            }
            '*'{ respond statusProcesoInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(StatusProceso statusProcesoInstance) {

        if (statusProcesoInstance == null) {
            notFound()
            return
        }

        statusProcesoInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'StatusProceso.label', default: 'StatusProceso'), statusProcesoInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'statusProcesoInstance.label', default: 'StatusProceso'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
