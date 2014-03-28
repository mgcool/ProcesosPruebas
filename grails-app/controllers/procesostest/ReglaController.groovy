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
