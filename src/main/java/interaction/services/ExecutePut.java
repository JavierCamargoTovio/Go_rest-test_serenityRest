package interaction.services;

import io.restassured.http.ContentType;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.rest.interactions.Put;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class ExecutePut implements Interaction {

    private final String resource;
    private final String id;
    private final String body;

    public ExecutePut(String resource, String id, String body) {
        this.resource = resource;
        this.id = id;
        this.body = body;
    }
    @Step("{0} executes a PUT on the resource #resource with id #id")
    @Override
    public <T extends Actor> void performAs(T actor) {
        SerenityRest.reset();
        SerenityRest.useRelaxedHTTPSValidation();
        actor.attemptsTo(Put.to(resource)
                .with(request -> request
                        .contentType(ContentType.JSON)
                        .pathParam("id", id)
                        .body(body)
                        .log()
                        .all()
                )
        );
        lastResponse().peek();
    }
    public static ExecutePut service(String resource, String id, String body) {
        return new ExecutePut(resource, id, body);
    }


}
