package procesostest



import grails.test.mixin.*
import spock.lang.*

@TestFor(FlujoController)
@Mock(Flujo)
class FlujoControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.flujoInstanceList
            model.flujoInstanceCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.flujoInstance!= null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            request.contentType = FORM_CONTENT_TYPE
            def flujo = new Flujo()
            flujo.validate()
            controller.save(flujo)

        then:"The create view is rendered again with the correct model"
            model.flujoInstance!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            flujo = new Flujo(params)

            controller.save(flujo)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/flujo/show/1'
            controller.flash.message != null
            Flujo.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def flujo = new Flujo(params)
            controller.show(flujo)

        then:"A model is populated containing the domain instance"
            model.flujoInstance == flujo
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def flujo = new Flujo(params)
            controller.edit(flujo)

        then:"A model is populated containing the domain instance"
            model.flujoInstance == flujo
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            request.contentType = FORM_CONTENT_TYPE
            controller.update(null)

        then:"A 404 error is returned"
            response.redirectedUrl == '/flujo/index'
            flash.message != null


        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def flujo = new Flujo()
            flujo.validate()
            controller.update(flujo)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.flujoInstance == flujo

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            flujo = new Flujo(params).save(flush: true)
            controller.update(flujo)

        then:"A redirect is issues to the show action"
            response.redirectedUrl == "/flujo/show/$flujo.id"
            flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when:"The delete action is called for a null instance"
            request.contentType = FORM_CONTENT_TYPE
            controller.delete(null)

        then:"A 404 is returned"
            response.redirectedUrl == '/flujo/index'
            flash.message != null

        when:"A domain instance is created"
            response.reset()
            populateValidParams(params)
            def flujo = new Flujo(params).save(flush: true)

        then:"It exists"
            Flujo.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(flujo)

        then:"The instance is deleted"
            Flujo.count() == 0
            response.redirectedUrl == '/flujo/index'
            flash.message != null
    }
}
