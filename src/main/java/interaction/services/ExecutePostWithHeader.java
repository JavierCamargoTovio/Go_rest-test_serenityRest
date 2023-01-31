package interaction.services;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.rest.interactions.Post;

import java.util.Map;

public class ExecutePostWithHeader implements Interaction {

    private String resource;
    private String body;
    private Map<String, Object> header;


    public ExecutePostWithHeader(String resource, String body, Map<String, Object> header) {
        this.resource = resource;
        this.body = body;
        this.header = header;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Post.to(resource)
                .with(request -> request
                        .contentType(ContentType.JSON)
                        .header((Header) header)
                        .body(body)
                        .log()
                        .all()
                )
        );

    }
}
