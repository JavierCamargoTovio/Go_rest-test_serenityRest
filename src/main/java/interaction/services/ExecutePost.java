package interaction.services;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.lastResponse;


public class ExecutePost implements Interaction {
    private String resource;
    private String body;


    public ExecutePost(String resource, String body){
        this.resource = resource;
        this.body = body;
    }

    @Step("{0} executes a POST on the resource #resource")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Post.to(resource)
                .with(request -> request
                        .contentType(ContentType.JSON)
                        .body(body)
                        .log()
                        .all()
                )
        );
        lastResponse().peek();
    }
}
