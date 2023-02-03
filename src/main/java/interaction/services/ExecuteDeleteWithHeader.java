package interaction.services;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.rest.interactions.Delete;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ExecuteDeleteWithHeader implements Interaction {

    private final String resource;
    private final String id;
    private final String header;

    public ExecuteDeleteWithHeader(String resource, String id, String header) {
        this.resource = resource;
        this.id = id;
        this.header = header;
    }
    public static ExecuteDeleteWithHeader service(String resource, String id, String header) {
        return instrumented(ExecuteDeleteWithHeader.class, resource, id, header);
    }


    @Step("{0} executes a GET on the resource #resource with id #id")
    @Override
    public <T extends Actor> void performAs(T actor) {
        SerenityRest.reset();
        SerenityRest.useRelaxedHTTPSValidation();
        actor.attemptsTo(Delete.from(resource + "{id}")
                .with(request -> request
                        .contentType(ContentType.JSON)
                        .header("Authorization", header)
                        .pathParam("id", id)
                        .log()
                        .all()
                )
        );
        lastResponse().peek();
    }
}
