package interaction.services;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ExecuteGetParameters implements Interaction {
    private final String resource;
    private final String id;

    public ExecuteGetParameters(String resource, String id) {
        this.resource = resource;
        this.id = id;
    }

    public static ExecuteGetParameters withParameter(String resource, String id) {
        return instrumented(ExecuteGetParameters.class, resource, id);
    }

    @Step("{0} executes a GET on the resource #resource with id #id")
    @Override
    public <T extends Actor> void performAs(T actor) {
        SerenityRest.reset();
        SerenityRest.useRelaxedHTTPSValidation();
        actor.attemptsTo(Get.resource(resource +"{id}")
                .with(request -> request
                        .contentType(ContentType.JSON)
                        .pathParam("id", id)
                        .log()
                        .all()
                )
        );
        lastResponse().peek();
    }
    }

