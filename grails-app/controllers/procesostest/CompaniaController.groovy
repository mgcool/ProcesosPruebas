package procesostest



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class CompaniaController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Compania.list(params), model:[companiaInstanceCount: Compania.count()]
    }

    def show(Compania companiaInstance) {
        respond companiaInstance
    }

    def create() {
        respond new Compania(params)
    }

    @Transactional
    def save(Compania companiaInstance) {
        if (companiaInstance == null) {
            notFound()
            return
        }

        if (companiaInstance.hasErrors()) {
            respond companiaInstance.errors, view:'create'
            return
        }

        companiaInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'companiaInstance.label', default: 'Compania'), companiaInstance.id])
                redirect companiaInstance
            }
            '*' { respond companiaInstance, [status: CREATED] }
        }
    }

    def edit(Compania companiaInstance) {
        respond companiaInstance
    }

    @Transactional
    def update(Compania companiaInstance) {
        if (companiaInstance == null) {
            notFound()
            return
        }

        if (companiaInstance.hasErrors()) {
            respond companiaInstance.errors, view:'edit'
            return
        }

        companiaInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Compania.label', default: 'Compania'), companiaInstance.id])
                redirect companiaInstance
            }
            '*'{ respond companiaInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Compania companiaInstance) {

        if (companiaInstance == null) {
            notFound()
            return
        }

        companiaInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Compania.label', default: 'Compania'), companiaInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'companiaInstance.label', default: 'Compania'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
