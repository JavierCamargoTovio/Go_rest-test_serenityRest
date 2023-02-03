package interaction.services;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.rest.interactions.Put;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class ExecutePutWithHeader implements Interaction {

    private final String resource;
    private final String id;
    private final String body;

    private final String header;

    public ExecutePutWithHeader(String resource, String id, String body, String header) {
        this.resource = resource;
        this.id = id;
        this.body = body;
        this.header = header;
    }
    @Step("{0} executes a PUT on the resource #resource with id #id")
    @Override
    public <T extends Actor> void performAs(T actor) {
        SerenityRest.reset();
        SerenityRest.useRelaxedHTTPSValidation();
        actor.attemptsTo(Put.to(resource+"{id}")
                .with(request -> request
                        .contentType(ContentType.JSON)
                        .pathParam("id", id)
                        .header("Authorization", header)
                        .body(body)
                        .log()
                        .all()
                )
        );
        lastResponse().peek();
    }
    public static ExecutePutWithHeader service(String resource, String id, String body, String header) {
        return new ExecutePutWithHeader(resource, id, body, header);
    }


}
