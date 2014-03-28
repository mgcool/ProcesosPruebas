package procesostest



import grails.test.mixin.*
import spock.lang.*

@TestFor(SecFlujoController)
@Mock(SecFlujo)
class SecFlujoControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.secFlujoInstanceList
            model.secFlujoInstanceCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.secFlujoInstance!= null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            request.contentType = FORM_CONTENT_TYPE
            def secFlujo = new SecFlujo()
            secFlujo.validate()
            controller.save(secFlujo)

        then:"The create view is rendered again with the correct model"
            model.secFlujoInstance!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            secFlujo = new SecFlujo(params)

            controller.save(secFlujo)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/secFlujo/show/1'
            controller.flash.message != null
            SecFlujo.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def secFlujo = new SecFlujo(params)
            controller.show(secFlujo)

        then:"A model is populated containing the domain instance"
            model.secFlujoInstance == secFlujo
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def secFlujo = new SecFlujo(params)
            controller.edit(secFlujo)

        then:"A model is populated containing the domain instance"
            model.secFlujoInstance == secFlujo
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            request.contentType = FORM_CONTENT_TYPE
            controller.update(null)

        then:"A 404 error is returned"
            response.redirectedUrl == '/secFlujo/index'
            flash.message != null


        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def secFlujo = new SecFlujo()
            secFlujo.validate()
            controller.update(secFlujo)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.secFlujoInstance == secFlujo

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            secFlujo = new SecFlujo(params).save(flush: true)
            controller.update(secFlujo)

        then:"A redirect is issues to the show action"
            response.redirectedUrl == "/secFlujo/show/$secFlujo.id"
            flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when:"The delete action is called for a null instance"
            request.contentType = FORM_CONTENT_TYPE
            controller.delete(null)

        then:"A 404 is returned"
            response.redirectedUrl == '/secFlujo/index'
            flash.message != null

        when:"A domain instance is created"
            response.reset()
            populateValidParams(params)
            def secFlujo = new SecFlujo(params).save(flush: true)

        then:"It exists"
            SecFlujo.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(secFlujo)

        then:"The instance is deleted"
            SecFlujo.count() == 0
            response.redirectedUrl == '/secFlujo/index'
            flash.message != null
    }
}
