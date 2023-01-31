package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class NameUserID implements Question {

    private final String name;

    public NameUserID(String name) {
        this.name = name;
    }
    public static NameUserID is(String name) {
        return new NameUserID(name);
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
