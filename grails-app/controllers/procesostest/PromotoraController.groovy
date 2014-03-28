package procesostest



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class PromotoraController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Promotora.list(params), model:[promotoraInstanceCount: Promotora.count()]
    }

    def show(Promotora promotoraInstance) {
        respond promotoraInstance
    }

    def create() {
        respond new Promotora(params)
    }

    @Transactional
    def save(Promotora promotoraInstance) {
        if (promotoraInstance == null) {
            notFound()
            return
        }

        if (promotoraInstance.hasErrors()) {
            respond promotoraInstance.errors, view:'create'
            return
        }

        promotoraInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'promotoraInstance.label', default: 'Promotora'), promotoraInstance.id])
                redirect promotoraInstance
            }
            '*' { respond promotoraInstance, [status: CREATED] }
        }
    }

    def edit(Promotora promotoraInstance) {
        respond promotoraInstance
    }

    @Transactional
    def update(Promotora promotoraInstance) {
        if (promotoraInstance == null) {
            notFound()
            return
        }

        if (promotoraInstance.hasErrors()) {
            respond promotoraInstance.errors, view:'edit'
            return
        }

        promotoraInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Promotora.label', default: 'Promotora'), promotoraInstance.id])
                redirect promotoraInstance
            }
            '*'{ respond promotoraInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Promotora promotoraInstance) {

        if (promotoraInstance == null) {
            notFound()
            return
        }

        promotoraInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Promotora.label', default: 'Promotora'), promotoraInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'promotoraInstance.label', default: 'Promotora'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
