package interaction.services;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.rest.interactions.Delete;
import net.thucydides.core.annotations.Step;

public class ExecuteDelete implements Interaction {

    private final String resource;
    private final String id;

    public ExecuteDelete(String resource, String id) {
        this.resource = resource;
        this.id = id;
    }
    @Step("{0} executes a GET on the resource #resource with id #id")
    @Override
    public <T extends Actor> void performAs(T actor) {
        SerenityRest.reset();
        SerenityRest.useRelaxedHTTPSValidation();
        actor.attemptsTo(Delete.from(resource)
                .with(request -> request
                        .contentType(ContentType.JSON)
                        .pathParam("id", id)
                        .log()
                        .all()
                )
        );
    }
}
