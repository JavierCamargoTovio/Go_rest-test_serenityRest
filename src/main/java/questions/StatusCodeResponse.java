package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class StatusCodeResponse implements Question {

    private final int statusCode;


    public StatusCodeResponse(int statusCode) {
        this.statusCode = statusCode;
    }

    public static StatusCodeResponse is(int statusCode) {
        return new StatusCodeResponse(statusCode);
    }
    @Override
    public Boolean answeredBy(Actor actor) {
        actor.should(
                seeThatResponse("Service API response status code",
                        response -> response.statusCode(statusCode)
                )
        );
        return true;
    }
}
