package interaction.services;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ExecutePostWithHeader implements Interaction {

    private String resource;
    private final String body;
    private String header;

    public static PostServiceBuilder service(String resource) {
        return new PostServiceBuilder(resource);
    }

    public ExecutePostWithHeader(String resource, String body, String header) {
        this.resource = resource;
        this.body = body;
        this.header = header;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Post.to(resource)
                .with(request -> request
                        .contentType(ContentType.JSON)
                        .header("Authorization", header)
                        .body(body)
                        .log()
                        .all()
                )
        );
        lastResponse().peek();

    }

    public static class PostServiceBuilder {
        private final String resource;

        public PostServiceBuilder(String resource) {
            this.resource = resource;
        }

        public Performable withParameter(String body, String header ) {
            return instrumented(ExecutePostWithHeader.class, resource,  body, header);
        }
    }
}
