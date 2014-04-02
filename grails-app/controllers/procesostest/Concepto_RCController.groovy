package procesostest



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class Concepto_RCController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Concepto_RC.list(params), model:[concepto_RCInstanceCount: Concepto_RC.count()]
    }

    def show(Concepto_RC concepto_RCInstance) {
        respond concepto_RCInstance
    }

    def create() {
        respond new Concepto_RC(params)
    }

    @Transactional
    def save(Concepto_RC concepto_RCInstance) {
        if (concepto_RCInstance == null) {
            notFound()
            return
        }

        if (concepto_RCInstance.hasErrors()) {
            respond concepto_RCInstance.errors, view:'create'
            return
        }

        concepto_RCInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'concepto_RCInstance.label', default: 'Concepto_RC'), concepto_RCInstance.id])
                redirect concepto_RCInstance
            }
            '*' { respond concepto_RCInstance, [status: CREATED] }
        }
    }

    def edit(Concepto_RC concepto_RCInstance) {
        respond concepto_RCInstance
    }

    @Transactional
    def update(Concepto_RC concepto_RCInstance) {
        if (concepto_RCInstance == null) {
            notFound()
            return
        }

        if (concepto_RCInstance.hasErrors()) {
            respond concepto_RCInstance.errors, view:'edit'
            return
        }

        concepto_RCInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Concepto_RC.label', default: 'Concepto_RC'), concepto_RCInstance.id])
                redirect concepto_RCInstance
            }
            '*'{ respond concepto_RCInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Concepto_RC concepto_RCInstance) {

        if (concepto_RCInstance == null) {
            notFound()
            return
        }

        concepto_RCInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Concepto_RC.label', default: 'Concepto_RC'), concepto_RCInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'concepto_RCInstance.label', default: 'Concepto_RC'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
