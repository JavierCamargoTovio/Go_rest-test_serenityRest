package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.equalTo;

public class NameUserResponse implements Question {

    private final String name;

    public NameUserResponse(String name) {
        this.name = name;
    }
    public static NameUserResponse is(String name) {
        return new NameUserResponse(name);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.should(
                seeThatResponse("Service API name user",
                        response -> response.body("name", equalTo(name)))
        );

        return true;
    }
}
